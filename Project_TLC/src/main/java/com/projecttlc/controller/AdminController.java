package com.projecttlc.controller;

import com.projecttlc.model.*;
import com.projecttlc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by CHIP_IT_DVC on 02/03/2016.
 */
@Controller
public class AdminController {
    @Autowired
    PostLocalService postLocalService;
    @Autowired
    PostTopicService postTopicService;
    @Autowired
    CategoriesService categoriesService;
    @Autowired
    UserService userService;
    @Autowired
    MessageService messageService;
    @Autowired
    MessageRecevierService messageRecevierService;

    Md5PasswordEncoder encodeMD5 = new Md5PasswordEncoder();
//    ===================== POST TOPIC DRAFT============================================================================
    @RequestMapping(value = "/admin/listtopic/draft")
    public ModelAndView listPostDraft(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null){
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if(sessionUser != null && sessionUser.getUser_Role().equals("ROLE_ADMIN")){
                List<Posts> listPostDraft = postTopicService.getAllPostStatus(0);
                modelAndView.addObject("listPostDraft",listPostDraft);
                modelAndView.setViewName("admin/allPostUserDraft");
            } else {
                modelAndView.addObject("msgerror","Access denied !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Access denied !");
            modelAndView.setViewName("redirect:/");
        }
        return modelAndView;
    }
//    =======================RENDER POST TOPIC DRAFT EDIT=====================================================================
    @RequestMapping(value = "/admin/listtopic/draft/{postID}",method = RequestMethod.GET)
    public ModelAndView renderEditPostDraft(HttpSession session,
                                            @PathVariable("postID") int postID){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null) {
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if (sessionUser != null && sessionUser.getUser_Role().equals("ROLE_ADMIN")) {
                Posts post = postTopicService.getPost(postID);
                modelAndView.addObject("post",post);
                modelAndView.setViewName("admin/editPostUser");
            } else {
                modelAndView.addObject("msgerror","Access denied !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Access denied !");
            modelAndView.setViewName("redirect:/");
        }

        return modelAndView;
    }
//    ========================= EDIT POST TOPIC DRAFT ========================================================================
    @RequestMapping(value = "/admin/listtopic/draft/{postID}/edit",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView editPostDraft(HttpServletRequest request,HttpSession session,
                                      @PathVariable("postID")int postID){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null) {
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if (sessionUser != null && sessionUser.getUser_Role().equals("ROLE_ADMIN")) {
                int status = Integer.parseInt(request.getParameter("status"));
                Calendar currenttime = Calendar.getInstance();
                Date sqldate = new Date((currenttime.getTime()).getTime());
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String publicDate = df.format(sqldate);
                if(status == 1){
                    modelAndView.addObject("msgsucess","Edit post successfully !");
                    postTopicService.editPublicPost(postID,publicDate,status);
                } else {
                    modelAndView.addObject("msgsucess","Edit post successfully !");
                    postTopicService.editStatusPost(postID,status);
                }
                modelAndView.setViewName("redirect:/admin/listtopic/draft");
            } else {
                modelAndView.addObject("msgerror","Access denied !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Access denied !");
            modelAndView.setViewName("redirect:/");
        }
        return modelAndView;
    }
//    ======================== DELETE POST TOPIC DRAFT =================================================================
    @RequestMapping(value = "/admin/listtopic/draft/{postID}/delete",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView deletePostDraft(HttpSession session,
                                      @PathVariable("postID")int postID){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null) {
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if (sessionUser != null && sessionUser.getUser_Role().equals("ROLE_ADMIN")) {
                postTopicService.deletePost(postID);
                modelAndView.addObject("msgsucess","Delete post successfully !");
                modelAndView.setViewName("redirect:/admin/listtopic/draft");
            } else {
                modelAndView.addObject("msgerror","Access denied !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Access denied !");
            modelAndView.setViewName("redirect:/");
        }
        return modelAndView;
    }
//    ===================== POST TOPIC ALL==============================================================================
    @RequestMapping(value = "/admin/all/topicuser", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView allTopicUser(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null) {
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if (sessionUser != null && sessionUser.getUser_Role().equals("ROLE_ADMIN")) {
                List<Posts> allTopicUser = postTopicService.getAllPost();
                modelAndView.addObject("allTopicUser",allTopicUser);
                modelAndView.setViewName("admin/allPostUser");
            } else {
                modelAndView.addObject("msgerror","Access denied !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Access denied !");
            modelAndView.setViewName("redirect:/");
        }
        return modelAndView;
    }
//    ======================== ALL POST TOPIC ==========================================================================
    @RequestMapping(value = "/admin/all/topicuser/{post_ID}", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView renderEditallTopicUser(HttpSession session,
                                               @PathVariable("post_ID")int post_ID){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null) {
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if (sessionUser != null && sessionUser.getUser_Role().equals("ROLE_ADMIN")) {
                Posts post = postTopicService.getPost(post_ID);
                modelAndView.addObject("post",post);
                modelAndView.setViewName("admin/editAllPostUser");
            } else {
                modelAndView.addObject("msgerror","Access denied !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Access denied !");
            modelAndView.setViewName("redirect:/");
        }
        return modelAndView;
    }
//    ========================== EDIT POST TOPIC =======================================================================
    @RequestMapping(value = "/admin/all/topicuser/{post_ID}/edit", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView editallTopicUser(HttpServletRequest request, HttpSession session,
                                         @PathVariable("post_ID")int post_ID){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null) {
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if (sessionUser != null && sessionUser.getUser_Role().equals("ROLE_ADMIN")) {
                int status = Integer.parseInt(request.getParameter("status"));
                postTopicService.editStatusPost(post_ID,status);
                modelAndView.addObject("msgsucess","Eidit post successfully !");
                modelAndView.setViewName("redirect:/admin/all/topicuser");
            } else {
                modelAndView.addObject("msgerror","Access denied !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Access denied !");
            modelAndView.setViewName("redirect:/");
        }
        return modelAndView;
    }
//    ========================== DELETE POST TOPIC =====================================================================
    @RequestMapping(value = "/admin/all/topicuser/{post_ID}/delete", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView deleteallTopicUser(HttpSession session,
                                           @PathVariable("post_ID")int post_ID){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null) {
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if (sessionUser != null && sessionUser.getUser_Role().equals("ROLE_ADMIN")) {
                postTopicService.deletePost(post_ID);
                modelAndView.addObject("msgsucess","Delete post successfully !");
                modelAndView.setViewName("redirect:/admin/all/topicuser");
            } else {
                modelAndView.addObject("msgerror","Access denied !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Access denied !");
            modelAndView.setViewName("redirect:/");
        }
        return modelAndView;
    }
//    ===================== POST TOPIC PUBLIC===========================================================================
    @RequestMapping(value = "/admin/publicTopic/topicuser", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView allTopicPublicUser(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null) {
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if (sessionUser != null && sessionUser.getUser_Role().equals("ROLE_ADMIN")) {
                List<Posts> allTopicPublicUser = postTopicService.getAllPostStatus(1);
                modelAndView.addObject("allTopicPublicUser",allTopicPublicUser);
                modelAndView.setViewName("admin/allPostUserEnable");
            } else {
                modelAndView.addObject("msgerror","Access denied !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Access denied !");
            modelAndView.setViewName("redirect:/");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/admin/publicTopic/topicuser/{post_ID}", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView renderEditailTopicPublicUser(HttpSession session,
                                                     @PathVariable("post_ID")int post_ID){
        ModelAndView modelAndView = new ModelAndView();
        Users sessionUser = (Users) session.getAttribute("sessionUser");
        if(session != null) {
             if(sessionUser != null && sessionUser.getUser_Role().equals("ROLE_ADMIN") ){
                 Posts post = postTopicService.getPost(post_ID);
                 modelAndView.addObject("post",post);
                 modelAndView.setViewName("admin/editPostPublicUser");
             }else {
                 modelAndView.addObject("msgerror","Access denied !");
                 modelAndView.setViewName("redirect:/");
             }
        } else{
            modelAndView.addObject("msgerror","Access denied !");
            modelAndView.setViewName("redirect:/");
        }

        return modelAndView;
    }
    @RequestMapping(value = "/admin/publicTopic/topicuser/{post_ID}/edit", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView editTopicPublicUser(HttpServletRequest request,HttpSession session,
                                         @PathVariable("post_ID")int post_ID){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null) {
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if (sessionUser != null && sessionUser.getUser_Role().equals("ROLE_ADMIN")) {
                int status = Integer.parseInt(request.getParameter("status"));
                postTopicService.editStatusPost(post_ID,status);
                modelAndView.addObject("msgsucess","Eidit post successfully !");
                modelAndView.setViewName("redirect:/admin/all/topicuser");
            } else {
                modelAndView.addObject("msgerror","Access denied !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Access denied !");
            modelAndView.setViewName("redirect:/");
        }
        return modelAndView;
    }
    @RequestMapping(value = "/admin/publicTopic/topicuser/{post_ID}/delete", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView deleteTopicPublicUser(HttpSession session,
                                              @PathVariable("post_ID")int post_ID){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null) {
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if (sessionUser != null && sessionUser.getUser_Role().equals("ROLE_ADMIN")) {
                postTopicService.deletePost(post_ID);
                modelAndView.addObject("msgsucess","Delete post successfully !");
                modelAndView.setViewName("redirect:/admin/publicTopic/topicuser");
            } else {
                modelAndView.addObject("msgerror","Access denied !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Access denied !");
            modelAndView.setViewName("redirect:/");
        }

        return modelAndView;
    }

//    ================= POST TOPIC BIN==================================================================================
    @RequestMapping(value = "/admin/binTopic/topicuser", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView binTopicPublicUser(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null) {
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if (sessionUser != null && sessionUser.getUser_Role().equals("ROLE_ADMIN")) {
                List<Posts> allTopicBinUser = postTopicService.getAllPostStatus(3);
                modelAndView.addObject("allTopicBinUser",allTopicBinUser);
                modelAndView.setViewName("admin/allPostUserDisable");
            } else {
                modelAndView.addObject("msgerror","Access denied !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Access denied !");
            modelAndView.setViewName("redirect:/");
        }

        return modelAndView;
    }
    @RequestMapping(value = "/admin/binTopic/topicuser/{post_ID}", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView renderEditBinTopicPublicUser(HttpSession session,
                                                     @PathVariable("post_ID")int post_ID){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null) {
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if (sessionUser != null && sessionUser.getUser_Role().equals("ROLE_ADMIN")) {
                Posts post = postTopicService.getPost(post_ID);
                modelAndView.addObject("post",post);
                modelAndView.setViewName("admin/editBinPostUser");
            } else {
                modelAndView.addObject("msgerror","Access denied !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Access denied !");
            modelAndView.setViewName("redirect:/");
        }

        return modelAndView;
    }
    @RequestMapping(value = "/admin/binTopic/topicuser/{post_ID}/edit", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView editTopicBinUser(HttpServletRequest request,HttpSession session,
                                            @PathVariable("post_ID")int post_ID){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null) {
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if (sessionUser != null && sessionUser.getUser_Role().equals("ROLE_ADMIN")) {
                int status = Integer.parseInt(request.getParameter("status"));
                postTopicService.editStatusPost(post_ID,status);
                modelAndView.addObject("msgsucess","Eidit post successfully !");
                modelAndView.setViewName("redirect:/admin/binTopic/topicuser");
            } else {
                modelAndView.addObject("msgerror","Access denied !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Access denied !");
            modelAndView.setViewName("redirect:/");
        }

        return modelAndView;
    }
    @RequestMapping(value = "/admin/binTopic/topicuser/{post_ID}/delete", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView deleteTopicBinUser(HttpSession session,
                                           @PathVariable("post_ID")int post_ID){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null) {
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if (sessionUser != null && sessionUser.getUser_Role().equals("ROLE_ADMIN")) {
                postTopicService.deletePost(post_ID);
                modelAndView.addObject("msgsucess","Delete post successfully !");
                modelAndView.setViewName("redirect:/admin/binTopic/topicuser");
            } else {
                modelAndView.addObject("msgerror","Access denied !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Access denied !");
            modelAndView.setViewName("redirect:/");
        }

        return modelAndView;
    }
//  =================================== USER ALL =======================================================================
    @RequestMapping(value = "/admin/all/user", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView renderAllUser(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null) {
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if (sessionUser != null && sessionUser.getUser_Role().equals("ROLE_ADMIN")) {
                List<Users> allUser = userService.getAllUser();
                modelAndView.addObject("allUser",allUser);
                modelAndView.setViewName("admin/listUser");
            } else {
                modelAndView.addObject("msgerror","Access denied !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Access denied !");
            modelAndView.setViewName("redirect:/");
        }

        return modelAndView;
    }
    @RequestMapping(value = "/admin/all/user/{userID}", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView renderEditAllUser(HttpSession session,
                                    @PathVariable("userID")int userID){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null) {
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if (sessionUser != null && sessionUser.getUser_Role().equals("ROLE_ADMIN")) {
                Users user1 = userService.getUser(userID);
                modelAndView.addObject("user",user1);
                modelAndView.setViewName("admin/editUser");
            } else {
                modelAndView.addObject("msgerror","Access denied !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Access denied !");
            modelAndView.setViewName("redirect:/");
        }

        return modelAndView;
    }
    @RequestMapping(value = "/admin/all/user/{userID}/edit", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView editAllUser(HttpServletRequest request, HttpSession session,
                                    @PathVariable("userID")int userID){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null) {
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if (sessionUser != null && sessionUser.getUser_Role().equals("ROLE_ADMIN")) {
                String role = request.getParameter("role");
                int status = Integer.parseInt(request.getParameter("status"));
                userService.updateStatusAndRoleUser(userID,role,status);
                modelAndView.addObject("msgsucess","Eidit post successfully !");
                modelAndView.setViewName("redirect:/admin/all/user");
            } else {
                modelAndView.addObject("msgerror","Access denied !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Access denied !");
            modelAndView.setViewName("redirect:/");
        }

        return modelAndView;
    }
//   ============================================= USER ENABLE =========================================================
    @RequestMapping(value = "/admin/all/user/enable", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView renderUserEnable(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null) {
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if (sessionUser != null && sessionUser.getUser_Role().equals("ROLE_ADMIN")) {
                List<Users> allUser = userService.getAllUserWithStatus(1);
                modelAndView.addObject("allUser",allUser);
                modelAndView.setViewName("admin/listUserEnable");
            } else {
                modelAndView.addObject("msgerror","Access denied !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Access denied !");
            modelAndView.setViewName("redirect:/");
        }

        return modelAndView;
    }
//   ============================================= USER DISABLE ========================================================
    @RequestMapping(value = "/admin/all/user/disable", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView renderUserDisable(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null) {
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if (sessionUser != null && sessionUser.getUser_Role().equals("ROLE_ADMIN")) {
                List<Users> allUser = userService.getAllUserWithStatus(3);
                modelAndView.addObject("allUser",allUser);
                modelAndView.setViewName("admin/listUserDisable");
            } else {
                modelAndView.addObject("msgerror","Access denied !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Access denied !");
            modelAndView.setViewName("redirect:/");
        }


        return modelAndView;
    }
//   ============================================= USER DISABLE ========================================================
    @RequestMapping(value = "/admin/all/user/createuser", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView renderCreateUser(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null) {
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if (sessionUser != null && sessionUser.getUser_Role().equals("ROLE_ADMIN")) {
                List<Users> allUser = userService.getAllUserWithStatus(3);
                modelAndView.addObject("allUser",allUser);
                modelAndView.setViewName("admin/addUser");
            } else {
                modelAndView.addObject("msgerror","Access denied !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Access denied !");
            modelAndView.setViewName("redirect:/");
        }

        return modelAndView;
    }
//  ============================================= CREATE USER ========================================================
    @RequestMapping(value = "/admin/all/user/createuser/add", method = RequestMethod.POST)
    public ModelAndView addUser(HttpServletRequest request, HttpSession session,
                                @RequestParam("avatar") MultipartFile[] files){

        ModelAndView modelAndView = new ModelAndView();
        if(session != null) {
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if (sessionUser != null && sessionUser.getUser_Role().equals("ROLE_ADMIN")) {
// Root Directory.
                String uploadRootPath = "/var/lib/openshift/56fa35ca0c1e66de350000cc/app-root/runtime/dependencies/jbossews/webapps/ROOT/resources/upload/avatar";
//        String uploadRootPath = "D:/MY DATA/JAVA_SOFTWAVE/JSP/apache-tomcat-6.0.41/webapps/ROOT/resources/upload/avatar";
                System.out.println("uploadRootPath=" + uploadRootPath);
                String linkAvatar ="";
                String email = request.getParameter("email");
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

                    String password = encodeMD5.encodePassword(request.getParameter("password"),email);
                    String re_password = encodeMD5.encodePassword(request.getParameter("repassword"),email);
                    if(!password.equals(re_password)){
                        modelAndView.addObject("msgerror","Password and Re-password Wrong!");
                        modelAndView.setViewName("admin/addUser");
                        return  modelAndView;
                    }
                    String firstName = request.getParameter("firsName");
                    String lastName = request.getParameter("lastName");
                    String address = request.getParameter("address");
                    String numberPhone = request.getParameter("phonenumber");
                    int gender = Integer.parseInt(request.getParameter("gender"));
                    String birthday = request.getParameter("birthday");
                    String job = request.getParameter("job");
                    String country = request.getParameter("country");
                    String website = request.getParameter("website");

                    Calendar currenttime = Calendar.getInstance();
                    Date sqldate = new Date((currenttime.getTime()).getTime());
                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    String activeDate = df.format(sqldate);

                    Users user = new Users();
                    user.setFirst_Name(firstName);
                    user.setCountry(country);
                    user.setJob(job);
                    user.setPhone_Number(numberPhone);
                    user.setActivation_Date(activeDate);
                    user.setAddress(address);
                    user.setAvatar(linkAvatar);
                    user.setBirthday(birthday);
                    user.setGender(gender);
                    user.setEmail(email);
                    user.setPassword(password);
                    user.setLast_Name(lastName);
                    user.setWebsite(website);
                    user.setStatus(Integer.parseInt(request.getParameter("status")));
                    user.setUser_Role(request.getParameter("role"));

                    userService.saveOrUpdateUser(user);
                    Users userNew = userService.logIn(user.getEmail(),user.getPassword());
                    modelAndView.addObject("userNewID",userNew.getUser_ID());
                    modelAndView.addObject("userNewEmail",userNew.getEmail());
                    modelAndView.setViewName("redirect:/admin/all/user");
                } else {
                    modelAndView.addObject("msgerror","Email already exits !");
                    modelAndView.setViewName("admin/addUser");
                }
            } else {
                modelAndView.addObject("msgerror","Access denied !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Access denied !");
            modelAndView.setViewName("redirect:/");
        }
        return  modelAndView;
    }
//    ================= POST LOCAL ALL==================================================================================
    @RequestMapping(value = "/admin/all/allpost", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView allPostAdmin(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null) {
            Users user = (Users) session.getAttribute("sessionUser");
            if (user != null && user.getUser_Role().equals("ROLE_ADMIN")) {
                List<Posts_Local> listPostLocal = postLocalService.getAllPostLocal();
                modelAndView.addObject("listPostLocal",listPostLocal);
                modelAndView.setViewName("admin/allPostAdmin");
            } else {
                modelAndView.addObject("msgerror","Access denied !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Access denied !");
            modelAndView.setViewName("redirect:/");
        }
        return modelAndView;
    }
//    ================== POST LOCAL VIEW ===============================================================================
    @RequestMapping(value = "/admin/all/allpost/{post_ID}/view", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView renderViewAllPostLocal(HttpSession session,
                                               @PathVariable("post_ID")int post_ID){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null) {
            Users user = (Users) session.getAttribute("sessionUser");
            if (user != null && user.getUser_Role().equals("ROLE_ADMIN")) {
                Posts_Local postsLocal = postLocalService.getPostLocal(post_ID);
                modelAndView.addObject("postsLocal",postsLocal);
                modelAndView.setViewName("admin/viewPostAdmin");
            } else {
                modelAndView.addObject("msgerror","Access denied !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Access denied !");
            modelAndView.setViewName("redirect:/");
        }

        return modelAndView;
    }
//    ==================== POST LOCAL RENDER EDIT ======================================================================
    @RequestMapping(value = "/admin/all/allpost/{post_ID}", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView renderEditAllPostLocal(HttpSession session,
                                               @PathVariable("post_ID")int post_ID){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null) {
            Users user = (Users) session.getAttribute("sessionUser");
            if (user != null && user.getUser_Role().equals("ROLE_ADMIN")) {
                Posts_Local postsLocal = postLocalService.getPostLocal(post_ID);
                List<Categories> categoriesList = categoriesService.getAllCategories();
                modelAndView.addObject("categoriesList",categoriesList);
                modelAndView.addObject("postsLocal",postsLocal);
                modelAndView.setViewName("admin/editPostAdmin");
            } else {
                modelAndView.addObject("msgerror","Access denied !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Access denied !");
            modelAndView.setViewName("redirect:/");
        }
        return modelAndView;
    }
//    ==================== POST LOCAL EDIT =============================================================================
    @RequestMapping(value = "/admin/all/allpost/edit", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView editallPostLocal(HttpServletRequest request, HttpSession session,
                                         @RequestParam("file") MultipartFile[] files){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null) {
            Users user = (Users) session.getAttribute("sessionUser");
            if (user != null && user.getUser_Role().equals("ROLE_ADMIN")) {
                String uploadRootPath = "/var/lib/openshift/56fa35ca0c1e66de350000cc/app-root/runtime/dependencies/jbossews/webapps/ROOT/resources/upload/imgPostLocal";
//        String uploadRootPath = "D:/MY DATA/JAVA_SOFTWAVE/JSP/apache-tomcat-6.0.41/webapps/ROOT/resources/upload/imgPostLocal";
                String image ="";
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
                        image = name;
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
                Posts_Local postsLocal = new Posts_Local();
                int status = Integer.parseInt(request.getParameter("status"));
                int post_ID = Integer.parseInt(request.getParameter("postID"));
                String postName = request.getParameter("postName");
                int cateID = Integer.parseInt(request.getParameter("categories"));
                Categories categories = categoriesService.getCategories(cateID);
                String postContent = request.getParameter("description");

                postsLocal.setPost_ID(post_ID);
                postsLocal.setPost_Name(postName);
                postsLocal.setPost_Content(postContent);
                postsLocal.setCate_ID(categories);
                postsLocal.setImage(image);
                postsLocal.setStatus(status);
//        Convert date util -> date sql -> String
                Calendar currenttime = Calendar.getInstance();
                Date sqldate = new Date((currenttime.getTime()).getTime());
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String lastEditDate = df.format(sqldate);
                postsLocal.setLast_Edit(lastEditDate);
                if(status == 1){
                    postsLocal.setPublic_Date(lastEditDate);
                }
                postLocalService.saveOrUpdatePostsLocal(postsLocal);
                modelAndView.addObject("msgsucess","Edit post successfully !");
                modelAndView.setViewName("redirect:/admin/all/allpost/"+post_ID+"/view");
            } else {
                modelAndView.addObject("msgerror","Access denied !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Access denied !");
            modelAndView.setViewName("redirect:/");
        }

        return modelAndView;
    }
//  ============================= POST LOCAL CREATE ====================================================================
    @RequestMapping(value = "/admin/all/allpost/createpost",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView renderCreatePost(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null) {
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if (sessionUser != null && sessionUser.getUser_Role().equals("ROLE_ADMIN")) {
                List<Categories> categoriesList = categoriesService.getAllCategories();
                modelAndView.addObject("categoriesList",categoriesList);
                modelAndView.setViewName("admin/createPostAdmin");
            } else {
                modelAndView.addObject("msgerror","Access denied !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Access denied !");
            modelAndView.setViewName("redirect:/");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/admin/all/allpost/create", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView createPostLocal(HttpServletRequest request, HttpSession session,
                                         @RequestParam("file") MultipartFile[] files){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null) {
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if (sessionUser != null && sessionUser.getUser_Role().equals("ROLE_ADMIN")) {
                String uploadRootPath = "/var/lib/openshift/56fa35ca0c1e66de350000cc/app-root/runtime/dependencies/jbossews/webapps/ROOT/resources/upload/imgPostLocal";
//        String uploadRootPath = "D:/MY DATA/JAVA_SOFTWAVE/JSP/apache-tomcat-6.0.41/webapps/ROOT/resources/upload/imgPostLocal";
                String image ="";
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
                        image = name;
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
                Posts_Local postsLocal = new Posts_Local();
                int status = Integer.parseInt(request.getParameter("status"));
                int userID = Integer.parseInt(request.getParameter("userID"));
                Users user = userService.getUser(userID);
                String postName = request.getParameter("titlePost");
                int cateID = Integer.parseInt(request.getParameter("categories"));
                Categories categories = categoriesService.getCategories(cateID);
                String postContent = request.getParameter("description");

                postsLocal.setUser_ID(user);
                postsLocal.setPost_Name(postName);
                postsLocal.setPost_Content(postContent);
                postsLocal.setCate_ID(categories);
                if(image.equals("")){
                    postsLocal.setImage("imgTitle.jpg");
                } else {
                    postsLocal.setImage(image);
                }

                postsLocal.setStatus(status);
//        Convert date util -> date sql -> String
                Calendar currenttime = Calendar.getInstance();
                Date sqldate = new Date((currenttime.getTime()).getTime());
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String lastEditDate = df.format(sqldate);
                postsLocal.setLast_Edit(lastEditDate);
                if(status == 1){
                    postsLocal.setPublic_Date(lastEditDate);
                } else {
                    postsLocal.setPublic_Date(null);
                }
                postsLocal.setNum_View(0);
                postLocalService.saveOrUpdatePostsLocal(postsLocal);
                modelAndView.addObject("msgsucess","Create post successfully !");
                modelAndView.setViewName("redirect:/admin/all/allpost");
            } else {
                modelAndView.addObject("msgerror","Access denied !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Access denied !");
            modelAndView.setViewName("redirect:/");
        }

        return modelAndView;
    }

//  ========================= POST LOCAL DELETE ========================================================================
    @RequestMapping(value = "/admin/all/allpost/{post_ID}/delete", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView deletePostLocal(HttpSession session,
                                        @PathVariable("post_ID")int post_ID){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null) {
            Users user = (Users) session.getAttribute("sessionUser");
            if (user != null && user.getUser_Role().equals("ROLE_ADMIN")) {
                postLocalService.deletePostsLocal(post_ID);
                modelAndView.addObject("msgsucess","Delete post successfully !");
                modelAndView.setViewName("redirect:/admin/all/allpost");
            } else {
                modelAndView.addObject("msgerror","Access denied !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Access denied !");
            modelAndView.setViewName("redirect:/");
        }

        return modelAndView;
    }
//    ======================= ALL POST LOCAL ENABLE ====================================================================
    @RequestMapping(value = "/admin/all/allpost/enable", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView allPostEnableAdmin(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null) {
            Users user = (Users) session.getAttribute("sessionUser");
            if (user != null && user.getUser_Role().equals("ROLE_ADMIN")) {
                List<Posts_Local> listPostLocal = postLocalService.getAllPosts_LocalStatus(1);
                modelAndView.addObject("listPostLocal",listPostLocal);
                modelAndView.setViewName("admin/allPostAdmin");
            } else {
                modelAndView.addObject("msgerror","Access denied !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Access denied !");
            modelAndView.setViewName("redirect:/");
        }

        return modelAndView;
    }
//    ======================= ALL POST LOCAL DISABLE ===================================================================
    @RequestMapping(value = "/admin/all/allpost/disable", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView allPostDisableAdmin(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null) {
            Users user = (Users) session.getAttribute("sessionUser");
            if (user != null && user.getUser_Role().equals("ROLE_ADMIN")) {
                List<Posts_Local> listPostLocal = postLocalService.getAllPosts_LocalStatus(3);
                modelAndView.addObject("listPostLocal",listPostLocal);
                modelAndView.setViewName("admin/allPostAdmin");
            } else {
                modelAndView.addObject("msgerror","Access denied !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Access denied !");
            modelAndView.setViewName("redirect:/");
        }

        return modelAndView;
    }
//    ======================= ALL POST LOCAL DRAFT =====================================================================
    @RequestMapping(value = "/admin/all/allpost/draft", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView allPostDraftAdmin(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null) {
            Users user = (Users) session.getAttribute("sessionUser");
            if (user != null && user.getUser_Role().equals("ROLE_ADMIN")) {
                List<Posts_Local> listPostLocal = postLocalService.getAllPosts_LocalStatus(0);
                modelAndView.addObject("listPostLocal",listPostLocal);
                modelAndView.setViewName("admin/allPostAdmin");
            } else {
                modelAndView.addObject("msgerror","Access denied !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Access denied !");
            modelAndView.setViewName("redirect:/");
        }

        return modelAndView;
    }
//    ======================== GET PROFILE USER ========================================================================
    @RequestMapping(value = "/admin/profile/user/{userID}",method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView getProfileUser(HttpSession session,
                                       @PathVariable("userID")int useID){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null) {
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if (sessionUser != null && sessionUser.getUser_Role().equals("ROLE_ADMIN")) {
                Users user = userService.getUser(useID);
                modelAndView.addObject("user",user);
                modelAndView.setViewName("admin/profileUser");
            } else {
                modelAndView.addObject("msgerror","Access denied !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Access denied !");
            modelAndView.setViewName("redirect:/");
        }

        return modelAndView;
    }
//    ====================== EDIT PROFILE USER =========================================================================
    @RequestMapping(value = "/admin/profile/user/{userID}/detail", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView renderEditUser(HttpServletRequest request,HttpSession session,
                                          @PathVariable("userID")int userID){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null) {
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if (sessionUser != null && sessionUser.getUser_Role().equals("ROLE_ADMIN")) {
                if(userID == sessionUser.getUser_ID()){
                    Users user = userService.getUser(userID);
                    modelAndView.addObject("user",user);
                    modelAndView.setViewName("admin/editProfileAdmin");
                } else {
                    Users user = userService.getUser(userID);
                    modelAndView.addObject("user",user);
                    modelAndView.setViewName("admin/editUser");
                }
            } else {
                modelAndView.addObject("msgerror","Access denied !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Access denied !");
            modelAndView.setViewName("redirect:/");
        }

        return modelAndView;
    }
//    ======================== EDIT FPROFLE ADMIN ======================================================================
    @RequestMapping(value = "/admin/profile/admin/edit",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView editprofileAdmin(HttpServletRequest request,HttpSession session,
                                         @RequestParam("file") MultipartFile[] files){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null) {
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if (sessionUser != null && sessionUser.getUser_Role().equals("ROLE_ADMIN")) {
                // Root Directory.
                String uploadRootPath = "/var/lib/openshift/56fa35ca0c1e66de350000cc/app-root/runtime/dependencies/jbossews/webapps/ROOT/resources/upload/avatar";
//        String uploadRootPath = "https://wnwapp-wnw.rhcloud.com/webapps/ROOT/resources/upload/avatar";
//        String uploadRootPath = "D:/MY DATA/JAVA_SOFTWAVE/JSP/apache-tomcat-6.0.41/webapps/ROOT/resources/upload/avatar";
                String linkAvatar ="";
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
                        System.out.println("Client File Name = " + name);

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



                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String address = request.getParameter("address");
                String numberPhone = request.getParameter("numberPhone");
                int gender = Integer.parseInt(request.getParameter("gender"));
                String birthday = request.getParameter("birthday");
                String job = request.getParameter("job");
                String country = request.getParameter("country");
                String website = request.getParameter("website");
                int userID = Integer.parseInt(request.getParameter("userID"));
                String role = request.getParameter("role");
                int status = Integer.parseInt(request.getParameter("status"));

//        Calendar currenttime = Calendar.getInstance();
//        Date sqldate = new Date((currenttime.getTime()).getTime());
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        String activeDate = df.format(sqldate);

                Users user = new Users();
                user.setUser_ID(userID);
                user.setFirst_Name(firstName);
                user.setCountry(country);
                user.setJob(job);
                user.setPhone_Number(numberPhone);
                user.setAddress(address);
                user.setAvatar(linkAvatar);
                user.setBirthday(birthday);
                user.setGender(gender);
                user.setLast_Name(lastName);
                user.setWebsite(website);
                user.setStatus(status);
                user.setUser_Role(role);

                userService.updateProfileAdmin(user);
                modelAndView.addObject("msgsucess","Eidit post successfully !");
                modelAndView.setViewName("redirect:/admin/profile/user/"+user.getUser_ID());
            } else {
                modelAndView.addObject("msgerror","Access denied !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Access denied !");
            modelAndView.setViewName("redirect:/");
        }

        return  modelAndView;
    }
//    ======================== CREATE CATE =============================================================================
    @RequestMapping(value = "/admin/listCate")
    public ModelAndView getAllCate(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null) {
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if (sessionUser != null && sessionUser.getUser_Role().equals("ROLE_ADMIN")) {
                int page = 0;
                int num_page = 0;
                int elementOfPage = 5;
                List<Categories> listCate = categoriesService.getAllCategories();
                List<Categories> listCateWithPage = categoriesService.getAllCategories(page,elementOfPage);
                if((listCate.size()%elementOfPage) != 0) {
                    num_page = (listCate.size()/elementOfPage) + 1;
                } else {
                    num_page = (listCate.size()/elementOfPage);
                }
                modelAndView.addObject("num_page",num_page);
                modelAndView.addObject("page",(page + 1));
                modelAndView.addObject("pre",(page - 1));
                modelAndView.addObject("next",(page + 1));
                modelAndView.addObject("last",(num_page - 1));
                modelAndView.addObject("listCate",listCate);
                modelAndView.addObject("listCateWithPage",listCateWithPage);
                modelAndView.setViewName("admin/listCate");
            } else {
                modelAndView.addObject("msgerror","Access denied !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Access denied !");
            modelAndView.setViewName("redirect:/");
        }

        return modelAndView;
    }
    @RequestMapping(value = "/admin/listCate/{page}",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView getAllCate(HttpSession session,
                                   @PathVariable("page") String Page){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null) {
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if (sessionUser != null && sessionUser.getUser_Role().equals("ROLE_ADMIN")) {
                int page = 0;
                int num_page = 0;
                int elementOfPage = 5;
                if(Page != null) {
                    page = Math.abs(Integer.parseInt(Page));

                }
                List<Categories> listCate = categoriesService.getAllCategories();
                List<Categories> listCateWithPage = categoriesService.getAllCategories(page,elementOfPage);
                if((listCate.size()%elementOfPage) != 0) {
                    num_page = (listCate.size()/elementOfPage) + 1;
                } else {
                    num_page = (listCate.size()/elementOfPage);
                }
                modelAndView.addObject("num_page",num_page);
                modelAndView.addObject("page",(page + 1));
                modelAndView.addObject("pre",(page - 1));
                modelAndView.addObject("next",(page + 1));
                modelAndView.addObject("last",(num_page - 1));
                modelAndView.addObject("listCate",listCate);
                modelAndView.addObject("listCateWithPage",listCateWithPage);
                modelAndView.setViewName("admin/listCate");
            } else {
                modelAndView.addObject("msgerror","Access denied !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Access denied !");
            modelAndView.setViewName("redirect:/");
        }

        return modelAndView;
    }

    @RequestMapping(value = "/admin/cate/create", method = RequestMethod.GET)
    public ModelAndView renderCreateCate(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null) {
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if (sessionUser != null && sessionUser.getUser_Role().equals("ROLE_ADMIN")) {
                modelAndView.setViewName("/admin/createCategories");
            } else {
                modelAndView.addObject("msgerror","Access denied !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Access denied !");
            modelAndView.setViewName("redirect:/");
        }

        return modelAndView;
    }
    @RequestMapping(value = "/admin/cate/create/add", method = RequestMethod.POST)
    public ModelAndView createCate(HttpServletRequest request,HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null) {
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if (sessionUser != null && sessionUser.getUser_Role().equals("ROLE_ADMIN")) {
                String cateName = request.getParameter("cateName");
                String des = request.getParameter("description");
                Categories categories = new Categories();
                categories.setCateId(0);
                categories.setCateName(cateName);
                categories.setCateDesc(des);
                categoriesService.saveAndUpdate(categories);
                modelAndView.addObject("msgsucess","Add category successfully !");
                modelAndView.setViewName("redirect:/admin/listCate");
            } else {
                modelAndView.addObject("msgerror","Access denied !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Access denied !");
            modelAndView.setViewName("redirect:/");
        }

        return modelAndView;
    }
    @RequestMapping(value = "/admin/cate/edit/{cateID}", method = RequestMethod.GET)
    public ModelAndView renderEditCate(HttpSession session,
                                       @PathVariable("cateID")int cateID){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null) {
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if (sessionUser != null && sessionUser.getUser_Role().equals("ROLE_ADMIN")) {
                Categories cate = categoriesService.getCategories(cateID);
                modelAndView.addObject("cate",cate);
                modelAndView.setViewName("admin/editCate");
            } else {
                modelAndView.addObject("msgerror","Access denied !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Access denied !");
            modelAndView.setViewName("redirect:/");
        }

        return modelAndView;
    }
    @RequestMapping(value = "/admin/cate/edit", method = RequestMethod.POST)
    public ModelAndView editCate(HttpServletRequest request,HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null) {
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if (sessionUser != null && sessionUser.getUser_Role().equals("ROLE_ADMIN")) {
                int cateID = Integer.parseInt(request.getParameter("cateID"));
                String cateName = request.getParameter("cateName");
                String des = request.getParameter("description");
                Categories categories = new Categories();
                categories.setCateId(cateID);
                categories.setCateName(cateName);
                categories.setCateDesc(des);
                categoriesService.saveAndUpdate(categories);
                modelAndView.addObject("msgsucess","Eidit category successfully !");
                modelAndView.setViewName("redirect:/admin/listCate");
            } else {
                modelAndView.addObject("msgerror","Access denied !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Access denied !");
            modelAndView.setViewName("redirect:/");
        }

        return modelAndView;
    }

    @RequestMapping(value = "admin/all/new-messages/{userId}",method = RequestMethod.GET)
    public ModelAndView getAllMessages(HttpSession session,
                                       @PathVariable(value = "userId")int userId){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null){
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if(sessionUser != null && sessionUser.getUser_Role().equals("ROLE_ADMIN")){
                if(sessionUser.getUser_ID() == userId){
                    List<Message_Recevier> messageRecevierListRecevie = messageRecevierService.getAllMessageRecevierWithUserID(userId,0);
                    modelAndView.addObject("messageRecevierListRecevie",messageRecevierListRecevie);
                    modelAndView.setViewName("admin/listMessages");
                } else {
                    modelAndView.addObject("msgerror","Error System !");
                    modelAndView.setViewName("redirect:/");
                }
            }else {
                modelAndView.addObject("msgerror","Error System !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Error System !");
            modelAndView.setViewName("redirect:/");
        }
        return modelAndView;
    }
    @RequestMapping(value = "admin/all/seen-messages/{userId}",method = RequestMethod.GET)
    public ModelAndView getAllSeenMessages(HttpSession session,
                                       @PathVariable(value = "userId")int userId){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null){
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if(sessionUser != null && sessionUser.getUser_Role().equals("ROLE_ADMIN")){
                if(sessionUser.getUser_ID() == userId){
                    List<Message_Recevier> messageRecevierListSeen = messageRecevierService.getAllMessageRecevierWithUserID(userId,1);
                    modelAndView.addObject("messageRecevierListSeen",messageRecevierListSeen);
                    modelAndView.setViewName("admin/listSeenMessages");
                } else {
                    modelAndView.addObject("msgerror","Error System !");
                    modelAndView.setViewName("redirect:/");
                }
            }else {
                modelAndView.addObject("msgerror","Error System !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Error System !");
            modelAndView.setViewName("redirect:/");
        }
        return modelAndView;
    }
    @RequestMapping(value = "admin/all/sent-messages/{userId}",method = RequestMethod.GET)
    public ModelAndView getAllSentMessages(HttpSession session,
                                       @PathVariable(value = "userId")int userId){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null){
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if(sessionUser != null && sessionUser.getUser_Role().equals("ROLE_ADMIN")){
                if(sessionUser.getUser_ID() == userId){
                    List<Message> messageListSend = messageService.getAllMessageOfUserSend(userId);
                    modelAndView.addObject("messageListSend",messageListSend);
                    modelAndView.setViewName("admin/listSentMessages");
                } else {
                    modelAndView.addObject("msgerror","Error System !");
                    modelAndView.setViewName("redirect:/");
                }
            }else {
                modelAndView.addObject("msgerror","Error System !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Error System !");
            modelAndView.setViewName("redirect:/");
        }
        return modelAndView;
    }

    @RequestMapping(value = "admin/detail-message/msg/{messageID}", method = RequestMethod.GET)
    public ModelAndView detailMessage(HttpSession session,
                                      @PathVariable("messageID")int messageID){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null){
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if(sessionUser != null && sessionUser.getUser_Role().equals("ROLE_ADMIN")){
                Message_Recevier messageRecevier = messageRecevierService.getMessageRecevierWithMessageID(messageID);
                if(sessionUser.getUser_ID() == messageRecevier.getRecevier_ID().getUser_ID()){
                    messageRecevier.setIs_read(1);
                    messageRecevierService.saveAndUpdate(messageRecevier);
                    modelAndView.addObject("messageRecevier",messageRecevier);
                    modelAndView.setViewName("admin/detailMessage");
                } else {
                    modelAndView.addObject("msgerror","Error system!");
                    modelAndView.setViewName("redirect:/");
                }

            } else {
                modelAndView.addObject("msgerror","Error system!");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Error system!");
            modelAndView.setViewName("redirect:/");
        }
        return modelAndView;
    }

    @RequestMapping(value = "admin/detail-message-sent/msg/{messageID}", method = RequestMethod.GET)
    public ModelAndView detailMessageSent(HttpSession session,
                                          @PathVariable("messageID")int messageID){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null){
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if(sessionUser != null&& sessionUser.getUser_Role().equals("ROLE_ADMIN")){
                Message message = messageService.getMessageWithMsgID(messageID);
                if(sessionUser.getUser_ID() == message.getFromUserID().getUser_ID()){
                    modelAndView.addObject("message",message);
                    modelAndView.setViewName("admin/detailSentMessage");
                } else {
                    modelAndView.addObject("msgerror","Error system!");
                    modelAndView.setViewName("redirect:/");
                }

            } else {
                modelAndView.addObject("msgerror","Error system!");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Error system!");
            modelAndView.setViewName("redirect:/");
        }
        return modelAndView;
    }

}
