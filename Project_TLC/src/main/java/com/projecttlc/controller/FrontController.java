package com.projecttlc.controller;

import com.projecttlc.dao.MailMail;
import com.projecttlc.model.Message_Recevier;
import com.projecttlc.model.Posts;
import com.projecttlc.model.Posts_Local;
import com.projecttlc.model.Users;
import com.projecttlc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by CHIP_IT_DVC on 17/03/2016.
 */
@Controller
@RequestMapping("/")
@SessionAttributes("sessionUser")
public class FrontController {
    @Autowired
    LoginService loginService;
    @Autowired
    PostLocalService postLocalService;
    @Autowired
    PostTopicService postTopicService;
    @Autowired
    CategoriesService categoriesService;
    @Autowired
    UserService userService;
    @Autowired
    TopicUserService topicUserService;
    @Autowired
    MessageService messageService;
    @Autowired
    MessageRecevierService messageRecevierService;

    Md5PasswordEncoder encodeMD5 = new Md5PasswordEncoder();

    private static Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public boolean validate(final String hex) {

        matcher = pattern.matcher(hex);
        return matcher.matches();

    }

    @RequestMapping(value = {"","welcome"}, method = RequestMethod.GET)
    public ModelAndView indexClient(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        if (session != null){
            Users user = (Users) session.getAttribute("sessionUser");
            if(user!=null){
                if(user.getUser_Role().equals("ROLE_ADMIN")){
                    List<Posts> postsList = postTopicService.getAllPostStatus(0);
                    List<Posts_Local> postsLocalList = postLocalService.getAllPosts_LocalStatus(0);
                    List<Users> usersList = userService.getAllUserWithStatus(0);
                    List<Message_Recevier> messageRecevierList = messageRecevierService.getAllMessageRecevierWithUserID(user.getUser_ID(),0);
                    int countPostTopicDraft = postsList.size();
                    int countPostLocal = postsLocalList.size();
                    int countNewMember = usersList.size();
                    int countNewMessages = messageRecevierList.size();
                    modelAndView.addObject("countPostTopicDraft",countPostTopicDraft);
                    modelAndView.addObject("countPostLocal",countPostLocal);
                    modelAndView.addObject("countNewMember",countNewMember);
                    modelAndView.addObject("countNewMessages",countNewMessages);
                    modelAndView.setViewName("admin/index");
                } else {
                    modelAndView.setViewName("client/index");
                }
            } else {
                modelAndView.setViewName("client/index");
            }
        } else {
            modelAndView.setViewName("client/index");
        }

        return modelAndView;
    }

    @RequestMapping(value = "login")
    public ModelAndView logIn(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        Users sessionUser = (Users) session.getAttribute("sessionUser");
        if(sessionUser != null){
            modelAndView.setViewName("redirect:/");
        } else {
            modelAndView.setViewName("client/login");
        }
        return modelAndView;
    }

    @RequestMapping(value = "checklogin", method = RequestMethod.POST)
    public ModelAndView checkLogIn(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        pattern = Pattern.compile(EMAIL_PATTERN);
        if(!validate(request.getParameter("email").toString().replaceAll("\\<.*?>",""))){
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        }
        String email = request.getParameter("email");
        String pass = encodeMD5.encodePassword(request.getParameter("password"),email);
        Users user = loginService.checkLogIn(email,pass);
        if( user != null){
            if(user.getStatus() == 0 || user.getStatus() == 3){
                modelAndView.addObject("msgerror","Please confirm email or Account had been block !");
                modelAndView.setViewName("client/login");
            } else {
                if(user.getUser_Role().equals("ROLE_ADMIN")){
                    modelAndView.addObject("sessionUser",user);
                    modelAndView.setViewName("redirect:/");
                } else{
                    modelAndView.addObject("sessionUser",user);
                    modelAndView.setViewName("redirect:/");
                }
            }

        } else {
            modelAndView.addObject("msgerror","Email or password wrong!");
            modelAndView.setViewName("client/login");
        }
        return modelAndView;
    }

    @RequestMapping(value = "logout", method = {RequestMethod.POST,RequestMethod.GET})
    public String logOut(SessionStatus sessionStatus){
        sessionStatus.setComplete();
        return "redirect:/";
    }


    @RequestMapping(value = "signup")
    public ModelAndView SignUp(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        Users sessionUser = (Users) session.getAttribute("sessionUser");
        if(sessionUser != null){
            modelAndView.setViewName("redirect:/");
        } else {
            modelAndView.setViewName("client/signup");
        }
        return  modelAndView;
    }

    @RequestMapping(value = "signup/add", method = RequestMethod.POST)
    public ModelAndView AddUser(HttpServletRequest request,HttpSession session,
                                @RequestParam("avatar") MultipartFile[] files){

        ModelAndView modelAndView = new ModelAndView();
            Users user = (Users) session.getAttribute("sessionUser");
            if(user == null){
                // Root Directory.
                String uploadRootPath = "/var/lib/openshift/56fa35ca0c1e66de350000cc/app-root/runtime/dependencies/jbossews/webapps/ROOT/resources/upload/avatar";
//        String uploadRootPath = "D:/MY DATA/JAVA_SOFTWAVE/JSP/apache-tomcat-6.0.41/webapps/ROOT/resources/upload/avatar";
                String linkAvatar ="";
                pattern = Pattern.compile(EMAIL_PATTERN);
                if(!validate(request.getParameter("signupemail").toString().replaceAll("\\<.*?>",""))){
                    modelAndView.setViewName("redirect:/");
                    return modelAndView;
                }
                String email = request.getParameter("signupemail");
                if(userService.getUser(email) == null){
                    if(files.length > 0){
                        File uploadRootDir = new File(uploadRootPath);
                        // Create directory if it not exists.
                        if (!uploadRootDir.exists()) {
                            uploadRootDir.mkdirs();
                        }
                        //
                        List<File> uploadedFiles = new ArrayList<File>();
                        for (int i = 0; i < files.length; i++) {
                            MultipartFile file = files[i];

                            // Client File Name
                            String name = file.getOriginalFilename();
                            linkAvatar = name;
                            if (name != null && name.length() > 0) {
                                try {
                                    byte[] bytes = file.getBytes();

                                    // Create the file on server
                                    File serverFile = new File(uploadRootDir.getAbsolutePath()
                                            + File.separator + name);

                                    // Stream to write data to file in server.
                                    BufferedOutputStream stream = new BufferedOutputStream(
                                            new FileOutputStream(serverFile));
                                    stream.write(bytes);
                                    stream.close();
                                    //
                                    uploadedFiles.add(serverFile);
                                } catch (Exception e) {
                                    System.out.println("Error Write file: " + name);
                                }
                            }
                        }
                    }

                    String password = encodeMD5.encodePassword(request.getParameter("signuppasswork"),email);
                    String re_password = encodeMD5.encodePassword(request.getParameter("signuprepasswork"),email);
                    if(!password.equals(re_password)){
                        modelAndView.addObject("msgerror","Password and Re-password Wrong!");
                        modelAndView.setViewName("client/signup");
                        return  modelAndView;
                    }
                    String firstName = request.getParameter("signupfirstname").toString().replaceAll("\\<.*?>","");
                    String lastName = request.getParameter("signuplastname").toString().replaceAll("\\<.*?>","");
                    String address = request.getParameter("signupaddress").toString().replaceAll("\\<.*?>","");
                    String numberPhone = request.getParameter("signupcontactnumber").toString().replaceAll("\\<.*?>","");
                    int gender = Integer.parseInt(request.getParameter("gender").toString().replaceAll("\\<.*?>",""));
                    String birthday = request.getParameter("signupbirthday").toString().replaceAll("\\<.*?>","");
                    if(isNumeric(request.getParameter("signupjob").toString().replaceAll("\\<.*?>",""))){
                        modelAndView.setViewName("redirect:/");
                        return modelAndView;
                    }
                    pattern = Pattern.compile(".*\\D.*");
                    if(!validate(request.getParameter("signupjob").toString().replaceAll("\\<.*?>",""))){
                        modelAndView.setViewName("redirect:/");
                        return modelAndView;
                    }
                    String job = request.getParameter("signupjob").toString().replaceAll("\\<.*?>","");

                    String country = request.getParameter("signupcountry").toString().replaceAll("\\<.*?>","");
                    String website = request.getParameter("signupwebsite");

                    Calendar currenttime = Calendar.getInstance();
                    Date sqldate = new Date((currenttime.getTime()).getTime());
                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    String activeDate = df.format(sqldate);

                    Users user1 = new Users();
                    user1.setFirst_Name(firstName);
                    user1.setCountry(country);
                    user1.setJob(job);
                    user1.setPhone_Number(numberPhone);
                    user1.setActivation_Date(activeDate);
                    user1.setAddress(address);
                    user1.setAvatar(linkAvatar);
                    user1.setBirthday(birthday);
                    user1.setGender(gender);
                    user1.setEmail(email);
                    user1.setPassword(password);
                    user1.setLast_Name(lastName);
                    user1.setWebsite(website);
                    user1.setStatus(0);
                    user1.setUser_Role("ROLE_USER");

                    userService.saveOrUpdateUser(user1);
                    Users userNew = userService.logIn(user1.getEmail(),user1.getPassword());
                    modelAndView.addObject("userNewID",userNew.getUser_ID());
                    modelAndView.addObject("userNewEmail",userNew.getEmail());

                    ApplicationContext context = new ClassPathXmlApplicationContext("spring-servlet.xml");
                    MailMail mm = (MailMail) context.getBean("mailMail");
                    mm.sendMail("wnw.vietnam@gmail.com",
                            ""+userNew.getEmail()+"",
                            "Confirm Sign Up Account",
                            "https://wnwapp-wnw.rhcloud.com/confirmemail/user/"+userNew.getUser_ID()+"/confirm.html");
                    modelAndView.addObject("msginfo","Please check Email to confirm account!");
                    modelAndView.setViewName("client/login");
                } else {
                    modelAndView.addObject("msgerror","Email already exits !");
                    modelAndView.setViewName("client/signup");
                }
            } else {
                modelAndView.addObject("msgerror","System Error !");
                modelAndView.setViewName("redirect:/");
            }
        return  modelAndView;
    }
    public boolean isNumeric(String s) {
        return s.matches("[+-]?(?:\\d+(?:\\.\\d*)?|\\.\\d+)");
    }
}
