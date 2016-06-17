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
 * Created by CHIP_IT_DVC on 17/03/2016.
 */
@Controller
@SessionAttributes("sessionUser")
@RequestMapping("/manage-user")
public class ManageUserController {
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

    @RequestMapping(value = "/{userID}")
    public ModelAndView ManageUser(HttpSession session,
                                   @PathVariable("userID") int userID){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null ){
            Users user = userService.getUser(userID);
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if(sessionUser != null){
                if(user.getUser_ID() != sessionUser.getUser_ID()){
                    modelAndView.addObject("msgerror","Date process wrong!");
                    modelAndView.setViewName("redirect:/");
                } else {
                    if(user == null){
                        modelAndView.addObject("msgerror","Please Sign In Or Register");
                        modelAndView.setViewName("client/login");
                    } else {
                        if(user.getStatus() == 0){
                            modelAndView.addObject("msgerror","Please confirm Email !");
                            modelAndView.setViewName("redirect:/");
                        } else {

                            List<Posts> posts_List_Approval = postTopicService.getAllPostStatus(userID,0);
                            List<Posts> posts_List_Closed = postTopicService.getAllPostStatus(userID,3);
                            List<Topic_User> topic_User_List = topicUserService.getAllUserJoinTopic(userID,0);
                            List<Message_Recevier> messageRecevierList = messageRecevierService.getAllMessageRecevierWithUserID(userID,0);
                            int count_posts_approval = posts_List_Approval.size();
                            int count_posts_closed = posts_List_Closed.size();
                            int count_post_users_acception = topic_User_List.size();
                            int count_new_messages = messageRecevierList.size();
                            modelAndView.addObject("count_posts_approval",count_posts_approval);
                            modelAndView.addObject("count_posts_closed",count_posts_closed);
                            modelAndView.addObject("count_post_users_acception",count_post_users_acception);
                            modelAndView.addObject("count_new_messages",count_new_messages);
                            modelAndView.addObject("user",user);
                            modelAndView.setViewName("client/managedashboard");
                        }
                    }
                }
            } else {
                modelAndView.addObject("msgerror","Date process wrong!");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Date process wrong!");
            modelAndView.setViewName("redirect:/");
        }

        return  modelAndView;
    }
    @RequestMapping(value = "profile/{userID}")
    public ModelAndView ManageUserProfile(HttpSession session,
                                   @PathVariable("userID") int userID){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null ){
            Users user = userService.getUser(userID);
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if(sessionUser != null){
                if(user.getUser_ID() != sessionUser.getUser_ID()){
                    modelAndView.addObject("msgerror","Date process wrong!");
//                modelAndView.setViewName("client/error");
                    modelAndView.setViewName("redirect:/");
                } else {
                    if(user == null){
                        modelAndView.addObject("msgerror","Please Sign In Or Register");
                        modelAndView.setViewName("client/login");
                    } else {
                        if(user.getStatus() == 0){
                            modelAndView.addObject("msgerror","Please confirm Email !");
                            modelAndView.setViewName("redirect:/");
                        } else {
                            modelAndView.addObject("user",user);
                            modelAndView.setViewName("client/manageuser");
                        }
                    }
                }
            } else {
                modelAndView.addObject("msgerror","Date process wrong!");
//                modelAndView.setViewName("client/error");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Date process wrong!");
//            modelAndView.setViewName("client/error");
            modelAndView.setViewName("redirect:/");
        }

        return  modelAndView;
    }
    @RequestMapping(value = "manage-post-topic/{userID}/page/{Page}")
    public ModelAndView manageUserPostTopic(HttpServletRequest request, HttpSession session,
                                            @PathVariable("userID") int userID,
                                            @PathVariable("Page") String Page){
        ModelAndView modelAndView = new ModelAndView();

        if(session != null){
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if(sessionUser != null){
                Users user = userService.getUser(userID);
                if(sessionUser.getUser_ID() != user.getUser_ID() || user.getStatus() == 0|| user == null){
                    modelAndView.addObject("msgerror","Data process wrong !");
//            modelAndView.setViewName("client/error");
                    modelAndView.setViewName("redirect:/");
                } else{
                    int page = 0;
                    int num_page = 0;
                    int elementOfPage = 5;
                    if(Page != null) {
                        if(isNumeric(Page)){
                            page = Math.abs(Integer.parseInt(Page));
                        } else {
                            modelAndView.setViewName("redirect:/");
                            return modelAndView;
                        }
                    }
                    List<Posts> allPostWithUserID = postTopicService.getAllPostWithUserID(userID);
                    List<Posts> listPost = postTopicService.getAllPostWithUserID(userID,page,elementOfPage);
                    if((allPostWithUserID.size()%elementOfPage) != 0) {
                        num_page = (allPostWithUserID.size()/elementOfPage) + 1;
                    } else {
                        num_page = (allPostWithUserID.size()/elementOfPage);
                    }
                    modelAndView.addObject("num_page",num_page);
                    modelAndView.addObject("page",(page + 1));
                    modelAndView.addObject("pre",(page - 1));
                    modelAndView.addObject("next",(page + 1));
                    modelAndView.addObject("last",(num_page - 1));
                    modelAndView.addObject("allPostWithUserID",allPostWithUserID);
                    modelAndView.addObject("listPost",listPost);
                    modelAndView.setViewName("client/managepost");
                }
            } else {
                modelAndView.addObject("msgerror","Data process wrong !");
//            modelAndView.setViewName("client/error");
                modelAndView.setViewName("redirect:/");
            }

        }

        return modelAndView;
    }

    @RequestMapping(value = "edit-post-topic/{post_ID}")
    public ModelAndView manageUserEditPost(HttpSession session,
                                           @PathVariable("post_ID") int postID){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null){
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if(sessionUser != null){
                Posts postEdit = postTopicService.getPost(postID);
                if(sessionUser.getUser_ID() != postEdit.getUser_ID().getUser_ID() || postEdit == null){
                    modelAndView.addObject("msgerror","Data process wrong !");
                    modelAndView.setViewName("redirect:/");
                } else {
                    List<Categories> categoriesList = categoriesService.getAllCategories();
                    modelAndView.addObject("postEdit",postEdit);
                    modelAndView.addObject("categoriesList",categoriesList);
                    modelAndView.setViewName("client/updatepost");
                }
            } else {
                modelAndView.addObject("msgerror","Data process wrong !");
                modelAndView.setViewName("redirect:/");
            }

        }else {
            modelAndView.addObject("msgerror","Data process wrong !");
            modelAndView.setViewName("redirect:/");
        }

        return modelAndView;
    }

    @RequestMapping(value = "edit-post-topic/{userID}/edit", method = RequestMethod.POST)
    public ModelAndView editTopic(HttpServletRequest request,HttpSession session,
                                  @RequestParam("file") MultipartFile[] files,
                                  @PathVariable("userID") int userID) {
        ModelAndView modelAndView = new ModelAndView();
        // Root Directory.
        if(session != null){
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if(sessionUser != null && sessionUser.getUser_ID() == userID){
                String uploadRootPath = "/var/lib/openshift/56fa35ca0c1e66de350000cc/app-root/runtime/dependencies/jbossews/webapps/ROOT/resources/upload/avatar";
//                String uploadRootPath = "D:/MY DATA/JAVA_SOFTWAVE/JSP/apache-tomcat-6.0.41/webapps/ROOT/resources/upload/imgPostTopic";
                String linkImagePostTopic ="";
                if(files.length > 0){
                    File uploadRootDir = new File(uploadRootPath);
                    // Create directory if it not exists.
                    if (!uploadRootDir.exists()) {
                        uploadRootDir.mkdirs();
                    }

                    List<File> uploadedFiles = new ArrayList<File>();
                    for (int i = 0; i < files.length; i++) {
                        MultipartFile file = files[i];

                        // Client File Name
                        String name = file.getOriginalFilename();
                        linkImagePostTopic = name;
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
                                System.out.println("Write file: " + serverFile);
                            } catch (Exception e) {
                                System.out.println("Error Write file: " + name);
                            }
                        }
                    }
                }

                int post_ID = Integer.parseInt(request.getParameter("post_ID"));
                String titleTopic = request.getParameter("titleTopic");
                int cate_ID = Integer.parseInt(request.getParameter("categories"));
                Categories categories = categoriesService.getCategories(cate_ID);
                String checkIn = request.getParameter("checkIn");
                String checkOut = request.getParameter("checkOut");
                String description = request.getParameter("description");
//                System.out.println("Link lay dc: " + linkImagePostTopic);

                String rules = request.getParameter("rules");
                Users users = userService.getUser(Integer.parseInt(request.getParameter("user_ID")));
                Posts_Local posts_local;
                if (request.getParameter("postLocal_ID").equals("")){
                    posts_local = new Posts_Local();
                } else {
                    posts_local = postLocalService.getPostLocal(Integer.parseInt(request.getParameter("postLocal_ID")));
                }
                //        Convert date util -> date sql -> String
                Calendar currenttime = Calendar.getInstance();
                Date sqldate = new Date((currenttime.getTime()).getTime());
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String lastEditDate = df.format(sqldate);
                Posts posts = new Posts();
                posts.setPost_ID(post_ID);
                posts.setPost_Name(titleTopic);
                posts.setCate_ID(categories);
                posts.setDate_Start(checkIn);
                posts.setDate_End(checkOut);
                posts.setImage(linkImagePostTopic);
                posts.setPost_Content(description);
                posts.setRule(rules);
                posts.setUser_ID(users);
                posts.setPostLocal(posts_local);
                posts.setLast_Edit(lastEditDate);
                posts.setPublic_Date(null);

                postTopicService.saveOrUpdatePost(posts);
                modelAndView.setViewName("redirect:/manage-user/"+userID);
            } else {
                modelAndView.addObject("msgerror","Error System !");
                modelAndView.setViewName("redirect:/");
            }
        }else {
            modelAndView.addObject("msgerror","Error System !");
            modelAndView.setViewName("redirect:/");
        }
        return modelAndView;
    }

    @RequestMapping(value = "delete-post-topic/{userID}/delete/{postTopic_ID}/del", method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView deleteTopic(HttpSession session,
                                    @PathVariable("userID") int userID,
                                    @PathVariable("postTopic_ID") int postTopic_ID){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null){
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            Users user = userService.getUser(userID);
            Posts post = postTopicService.getPost(postTopic_ID);
            if(sessionUser != null){
                if(sessionUser.getUser_ID() != user.getUser_ID() || user == null || user.getUser_ID() != post.getUser_ID().getUser_ID()){
                    modelAndView.addObject("msgerror","Data process wrong!");
                    modelAndView.setViewName("redirect:/");
                } else {
                    postTopicService.deletePost(postTopic_ID);
                    modelAndView.addObject("msgsuccess","Delete Topic Successfully !");
                    modelAndView.setViewName("redirect:/manage-user/"+userID);
                }
            } else {
                modelAndView.addObject("msgerror","Data process wrong!");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Data process wrong!");
            modelAndView.setViewName("redirect:/");
        }

        return modelAndView;
    }

    @RequestMapping(value = "edit-profile/{user_ID}", method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView editprofile(HttpSession session,
                                    @PathVariable("user_ID") int user_ID){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null){
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            Users user = userService.getUser(user_ID);
            if(sessionUser != null){
                if(sessionUser.getUser_ID() != user.getUser_ID()){
                    modelAndView.addObject("msgerror","Data process wrong!");
//                modelAndView.setViewName("client/error");
                    modelAndView.setViewName("redirect:/");
                } else {
                    modelAndView.addObject("userEdit",user);
                    modelAndView.setViewName("client/updateprofile");
                }
            } else {
                modelAndView.addObject("msgerror","Data process wrong!");
//            modelAndView.setViewName("client/error");
                modelAndView.setViewName("redirect:/");
            }

        } else {
            modelAndView.addObject("msgerror","Data process wrong!");
//            modelAndView.setViewName("client/error");
            modelAndView.setViewName("redirect:/");
        }

        return modelAndView;
    }

    @RequestMapping(value = "edit-profile/edit", method = RequestMethod.POST)
    public ModelAndView EditUser(HttpServletRequest request,HttpSession session,
                                 @RequestParam("file") MultipartFile[] files) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        if(session != null){
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if(sessionUser != null){
                // Root Directory.
                String uploadRootPath = "/var/lib/openshift/56fa35ca0c1e66de350000cc/app-root/runtime/dependencies/jbossews/webapps/ROOT/resources/upload/avatar";
//                String uploadRootPath = "D:/MY DATA/JAVA_SOFTWAVE/JSP/apache-tomcat-6.0.41/webapps/ROOT/resources/upload/avatar";
                String linkAvatar ="";
                if(files.length > 0){
                    File uploadRootDir = new File(uploadRootPath);
                    // Create directory if it not exists.
                    if (!uploadRootDir.exists()) {
                        uploadRootDir.mkdirs();
                    }
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

                Users user = new Users();
                user.setUser_ID(userID);
                user.setFirst_Name(firstName);
                user.setCountry(country);
                user.setJob(job);
                user.setPhone_Number(numberPhone);
//        user.setActivation_Date(activeDate);
                user.setAddress(address);
                user.setAvatar(linkAvatar);
                user.setBirthday(birthday);
                user.setGender(gender);
//        user.setEmail(email);
//        user.setPassword(password);
                user.setLast_Name(lastName);
                user.setWebsite(website);
                user.setStatus(1);
//        user.setUser_Role("ROLE_USER");

                userService.saveOrUpdateUser(user);
                modelAndView.addObject("msgsuccess","Change profile successfully !");
                modelAndView.setViewName("redirect:/manage-user/"+userID);
            } else {
                modelAndView.addObject("msgerror","Error System !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Error System !");
            modelAndView.setViewName("redirect:/");
        }

        return  modelAndView;
    }
    @RequestMapping(value = "change-password/{userID}", method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView renderChangePw(HttpSession session
            ,@PathVariable("userID") int userID){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null){
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            Users user = userService.getUser(userID);
            if(sessionUser != null){
                if(sessionUser.getUser_ID() != user.getUser_ID()){
                    modelAndView.addObject("msg","Data process wrong!");
//                modelAndView.setViewName("client/error");
                    modelAndView.setViewName("redirect:/");
                } else {
                    modelAndView.addObject("user",user);
                    modelAndView.setViewName("client/updatepassword");
                }
            } else {
                modelAndView.addObject("msg","Data process wrong!");
//            modelAndView.setViewName("client/error");
                modelAndView.setViewName("redirect:/");
            }

        } else {
            modelAndView.addObject("msg","Data process wrong!");
//            modelAndView.setViewName("client/error");
            modelAndView.setViewName("redirect:/");
        }

        return modelAndView;
    }

    @RequestMapping(value = "change-password/{user_ID}/chpw",method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView changepw(HttpServletRequest request,HttpSession session,
                                 @PathVariable("user_ID") int userID){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null){
            Users user = userService.getUser(userID);
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if(sessionUser != null){
                if(sessionUser != null){
                    if(sessionUser.getUser_ID() != user.getUser_ID()){
                        modelAndView.addObject("msg","Data process wrong!");
//                modelAndView.setViewName("client/error");
                        modelAndView.setViewName("redirect:/");
                    } else {
                        String cur_pw = encodeMD5.encodePassword(request.getParameter("cur_pass"),user.getEmail());
                        String pw = encodeMD5.encodePassword(request.getParameter("new_pass"),user.getEmail());
                        String repw = encodeMD5.encodePassword(request.getParameter("renew_pass"),user.getEmail());
                        if(userService.logIn(user.getEmail(),cur_pw) != null) {
                            if(pw.equals(repw) && !pw.equals(cur_pw)){
                                userService.updatePassword(userID,pw);
                                modelAndView.addObject("msgsuccess","Change password successfully");
                                modelAndView.setViewName("redirect:/manage-user/"+userID);
                            } else {
                                modelAndView.addObject("msgerror","New password and re-new password don't identical");
                                modelAndView.setViewName("client/updatepassword");
                            }
                        } else {
                            modelAndView.addObject("msgerror","Current password wrong !");
                            modelAndView.setViewName("client/updatepassword");
                        }
                    }
                } else {
                    modelAndView.addObject("msgerror","Data process wrong!");
//            modelAndView.setViewName("client/error");
                    modelAndView.setViewName("redirect:/");
                }
            } else {
                modelAndView.addObject("msgerror","Data process wrong!");
//                modelAndView.setViewName("client/error");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Data process wrong!");
//            modelAndView.setViewName("client/error");
            modelAndView.setViewName("redirect:/");
        }

        return modelAndView;
    }

    @RequestMapping(value = "list-user-join-topic/{post_ID}", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView renderListUserJoinTopic(HttpSession session,
                                                @PathVariable("post_ID") int postID){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null){
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if(sessionUser != null){
                List<Topic_User> topicUserList = topicUserService.getAllUserJoinTopicWithPostID(postID);
                Posts posts = postTopicService.getPost(postID);
                modelAndView.addObject("posts",posts);
                modelAndView.addObject("topicUserList",topicUserList);
                modelAndView.setViewName("client/managelistuerjoin");
            } else {
                modelAndView.addObject("msgerror","Error System !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Error System !");
            modelAndView.setViewName("redirect:/");
        }
        return modelAndView;
    }

    @RequestMapping(value = "list-user-join-topic/{post_ID}/{user_ID}/{varStatus}",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView processUserJoinTopic(HttpSession session,
                                             @PathVariable("post_ID")int postID,
                                             @PathVariable("user_ID")int userID,
                                             @PathVariable("varStatus") String status){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null){
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if (sessionUser != null){
                if(status.equals("accept")){
                    topicUserService.updateTopicUser(userID,postID,1);
                    modelAndView.setViewName("redirect:/manage-user/list-user-join-topic/"+postID);
                } else if(status.equals("pending")){
                    topicUserService.updateTopicUser(userID,postID,0);
                    modelAndView.setViewName("redirect:/manage-user/list-user-join-topic/"+postID);
                } else {
                    topicUserService.updateTopicUser(userID,postID,3);
                    modelAndView.setViewName("redirect:/manage-user/list-user-join-topic/"+postID);
                }
            } else {
                modelAndView.addObject("msgerror","Error System !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Error System !");
            modelAndView.setViewName("redirect:/");
        }
        return modelAndView;
    }

    @RequestMapping(value = "list-topic/{user_ID}")
    public ModelAndView renderListTopicUserJoin(HttpSession session,
                                                @PathVariable("user_ID")int userID){
        ModelAndView modelAndView = new ModelAndView();
        if (session != null){
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if (sessionUser != null && sessionUser.getUser_ID() == userID){
                int page = 0;
                int num_page = 0;
                int elementOfPage = 5;
                List<Topic_User> allTopicUserList = topicUserService.getTopicWithUser(userID);
                List<Topic_User> topicUserList = topicUserService.getTopicWithUser(userID,num_page,elementOfPage);
                if((allTopicUserList.size()%elementOfPage) != 0) {
                    num_page = (allTopicUserList.size()/elementOfPage) + 1;
                } else {
                    num_page = (allTopicUserList.size()/elementOfPage);
                }
                modelAndView.addObject("num_page",num_page);
                modelAndView.addObject("page",(page + 1));
                modelAndView.addObject("pre",(page - 1));
                modelAndView.addObject("next",(page + 1));
                modelAndView.addObject("last",(num_page - 1));
                modelAndView.addObject("allTopicUserList",allTopicUserList);
                modelAndView.addObject("topicUserList",topicUserList);
                modelAndView.setViewName("client/managetopicjoin");
            } else {
                modelAndView.addObject("msgerror","Error System !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Error System !");
            modelAndView.setViewName("redirect:/");
        }
        return modelAndView;
    }

    @RequestMapping(value = "list-topic/{user_ID}/page/{Page}")
    public ModelAndView renderListTopicUserJoin(HttpSession session,
                                                @PathVariable("user_ID")int userID,
                                                @PathVariable("Page") String Page){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null) {
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if(sessionUser != null){
                int page = 0;
                int num_page = 0;
                int elementOfPage = 5;
                if(Page != null) {
                    page = Math.abs(Integer.parseInt(Page));

                }
                List<Topic_User> allTopicUserList = topicUserService.getTopicWithUser(userID);
                List<Topic_User> topicUserList = topicUserService.getTopicWithUser(userID,num_page,elementOfPage);
                if((allTopicUserList.size()%elementOfPage) != 0) {
                    num_page = (allTopicUserList.size()/elementOfPage) + 1;
                } else {
                    num_page = (allTopicUserList.size()/elementOfPage);
                }
                modelAndView.addObject("num_page",num_page);
                modelAndView.addObject("page",(page + 1));
                modelAndView.addObject("pre",(page - 1));
                modelAndView.addObject("next",(page + 1));
                modelAndView.addObject("last",(num_page - 1));
                modelAndView.addObject("allTopicUserList",allTopicUserList);
                modelAndView.addObject("topicUserList",topicUserList);
                modelAndView.setViewName("client/managetopicjoin");
            } else {
                modelAndView.addObject("msgerror","Error System !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Error System !");
            modelAndView.setViewName("redirect:/");
        }
        return modelAndView;
    }

    @RequestMapping(value = "list-topic-join/{post_ID}/delete/{user_ID}")
    public ModelAndView deteleTopicJoin(HttpSession session,
                                        @PathVariable("post_ID") int postID,
                                        @PathVariable("user_ID") int userID){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null){
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if(sessionUser != null){
                topicUserService.deelteTopicUser(userID,postID);
                modelAndView.addObject("msgsuccess","Cancellation successfully!");
                modelAndView.setViewName("redirect:/manage-user/list-topic/"+userID);
            } else {
                modelAndView.addObject("msgerror","Error System !");
                modelAndView.setViewName("redirect:/");
            }
        } else {
            modelAndView.addObject("msgerror","Error System !");
            modelAndView.setViewName("redirect:/");
        }
        return modelAndView;
    }

    @RequestMapping(value = "list-message/{userID}", method = RequestMethod.GET)
    public ModelAndView getAllMessageUser(HttpSession session,@PathVariable("userID") int userID){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null){
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if(sessionUser != null){
                if(sessionUser.getUser_ID() == userID){
                    List<Message_Recevier> messageRecevierListRecevie = messageRecevierService.getAllMessageRecevierWithUserID(userID,0);
                    List<Message_Recevier> messageRecevierListSeen = messageRecevierService.getAllMessageRecevierWithUserID(userID,1);
                    List<Message> messageListSend = messageService.getAllMessageOfUserSend(userID);
                    modelAndView.addObject("messageRecevierListRecevie",messageRecevierListRecevie);
                    modelAndView.addObject("messageRecevierListSeen",messageRecevierListSeen);
                    modelAndView.addObject("messageListSend",messageListSend);
                    modelAndView.setViewName("client/managemessage");
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
    public boolean isNumeric(String s) {
        return s.matches("[+-]?(?:\\d+(?:\\.\\d*)?|\\.\\d+)");
    }
}
