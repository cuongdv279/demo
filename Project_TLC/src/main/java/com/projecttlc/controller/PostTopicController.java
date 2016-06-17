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
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by CHIP_IT_DVC on 17/03/2016.
 */
@Controller
@SessionAttributes("sessionUser")
@RequestMapping("/post-user")
public class PostTopicController {
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

    @RequestMapping(value = "post-topic")
    public ModelAndView getListPostTopic(){
        ModelAndView modelAndView = new ModelAndView();
        int page = 0;
        int num_page = 0;
        int elementOfPage = 6;
        List<Categories> allCategories = categoriesService.getAllCategories();
        List<Posts> allPostTopic = postTopicService.getAllPostStatus(1);
        List<Posts> listPostTopic = postTopicService.getAllPostStatus(1,page,elementOfPage);
        List<Posts> listLatestPostTopic = postTopicService.getAllPostStatus(1,0,5);
        for(int i = 0 ; i < listLatestPostTopic.size(); i++){
            Date dateSql = listLatestPostTopic.get(i).getPublic_Date();
            java.util.Date utilDate = new java.util.Date(dateSql.getTime());
            DateFormat sdf = new SimpleDateFormat("MMM-dd-yyyy");
            String reportDate = sdf.format(utilDate);
            String[] arrDate = reportDate.split("-");

            listLatestPostTopic.get(i).setDate(arrDate[1]);
            listLatestPostTopic.get(i).setMonth(arrDate[0]);
            listLatestPostTopic.get(i).setYear(arrDate[2]);
        }
        if((allPostTopic.size()%elementOfPage) != 0) {
            num_page = (allPostTopic.size()/elementOfPage) + 1;
        } else {
            num_page = (allPostTopic.size()/elementOfPage);
        }
        modelAndView.addObject("num_page",num_page);
        modelAndView.addObject("page",(page + 1));
        modelAndView.addObject("pre",(page - 1));
        modelAndView.addObject("next",(page + 1));
        modelAndView.addObject("last",(num_page - 1));
        modelAndView.addObject("allCategories",allCategories);
        modelAndView.addObject("allPostTopic",allPostTopic);
        modelAndView.addObject("listPostTopic",listPostTopic);
        modelAndView.addObject("listLatestPostTopic",listLatestPostTopic);
        if(listPostTopic.size() <= 0){
            modelAndView.setViewName("client/notfound");
            return modelAndView;
        }
        modelAndView.setViewName("client/service");
        return modelAndView;
    }

    @RequestMapping(value = "post-topic/{Page}", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView getListPostTopic(@PathVariable("Page") String Page){
        ModelAndView modelAndView = new ModelAndView();
        int page = 0;
        int num_page = 0;
        int elementOfPage = 6;
        if(Page != null) {
            if(isNumeric(Page)){
                page = Math.abs(Integer.parseInt(Page));
            } else {
                modelAndView.setViewName("redirect:/post-user/post-topic");
                return modelAndView;
            }
        }
        List<Categories> allCategories = categoriesService.getAllCategories();
        List<Posts> allPostTopic = postTopicService.getAllPostStatus(1);
        List<Posts> listPostTopic = postTopicService.getAllPostStatus(1,page,elementOfPage);
        List<Posts> listLatestPostTopic = postTopicService.getAllPostStatus(1,0,5);
        for(int i = 0 ; i < listLatestPostTopic.size(); i++){
            Date dateSql = listLatestPostTopic.get(i).getPublic_Date();
            java.util.Date utilDate = new java.util.Date(dateSql.getTime());
            DateFormat sdf = new SimpleDateFormat("MMM-dd-yyyy");
            String reportDate = sdf.format(utilDate);
            String[] arrDate = reportDate.split("-");

            listLatestPostTopic.get(i).setDate(arrDate[1]);
            listLatestPostTopic.get(i).setMonth(arrDate[0]);
            listLatestPostTopic.get(i).setYear(arrDate[2]);
        }
        if((allPostTopic.size()%elementOfPage) != 0) {
            num_page = (allPostTopic.size()/elementOfPage) + 1;
        } else {
            num_page = (allPostTopic.size()/elementOfPage);
        }
        modelAndView.addObject("num_page",num_page);
        modelAndView.addObject("page",(page + 1));
        modelAndView.addObject("pre",(page - 1));
        modelAndView.addObject("next",(page + 1));
        modelAndView.addObject("last",(num_page - 1));
        modelAndView.addObject("allCategories",allCategories);
        modelAndView.addObject("allPostTopic",allPostTopic);
        modelAndView.addObject("listPostTopic",listPostTopic);
        modelAndView.addObject("listLatestPostTopic",listLatestPostTopic);
        if(listPostTopic.size() <= 0){
            modelAndView.setViewName("redirect:/post-user/post-topic");
            return modelAndView;
        }
        modelAndView.setViewName("client/service");
        return modelAndView;
    }
    @RequestMapping(value = "post-topic/search",method = RequestMethod.POST)
    public ModelAndView getAllPostTopicSearch(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        int cateId = Integer.parseInt(request.getParameter("cateID").toString().replaceAll("\\<.*?>",""));
        int page = 0;
        int num_page = 0;
        int elementOfPage = 6;
        List<Categories> allCategories = categoriesService.getAllCategories();
        List<Posts> allPostTopic = postTopicService.getAllPostCate(cateId,1);
        List<Posts> listPostTopic = postTopicService.getAllPostCate(cateId,1,page,elementOfPage);
        List<Posts> listLatestPostTopic = postTopicService.getAllPostStatus(1,0,5);
        if((allPostTopic.size()%elementOfPage) != 0) {
            num_page = (allPostTopic.size()/elementOfPage) + 1;
        } else {
            num_page = (allPostTopic.size()/elementOfPage);
        }
        modelAndView.addObject("num_page",num_page);
        modelAndView.addObject("page",(page + 1));
        modelAndView.addObject("pre",(page - 1));
        modelAndView.addObject("next",(page + 1));
        modelAndView.addObject("last",(num_page - 1));
        modelAndView.addObject("cateId",cateId);
        modelAndView.addObject("allCategories",allCategories);
        modelAndView.addObject("allPostTopic",allPostTopic);
        modelAndView.addObject("listPostTopic",listPostTopic);
        modelAndView.addObject("listLatestPostTopic",listLatestPostTopic);
        if(allPostTopic.size() <= 0){
            modelAndView.setViewName("client/notfound");
            return modelAndView;
        }
        modelAndView.setViewName("client/service_cate");
        return modelAndView;
    }
    @RequestMapping(value = "post-topic/search/{cateId}/page/{Page}", method = RequestMethod.GET)
    public ModelAndView getAllPostTopicSearch(@PathVariable("Page") String Page,
                                              @PathVariable("cateId") int cateId){
        ModelAndView modelAndView = new ModelAndView();
        int page = 0;
        int num_page = 0;
        int elementOfPage = 6;
        if(Page != null) {
            if(isNumeric(Page)){
                page = Math.abs(Integer.parseInt(Page));
            } else {
                modelAndView.setViewName("redirect:/");
                return modelAndView;
            }
        }
        List<Categories> allCategories = categoriesService.getAllCategories();
        List<Posts> allPostTopic = postTopicService.getAllPostCate(cateId,1);
        List<Posts> listPostTopic = postTopicService.getAllPostCate(cateId,1,page,elementOfPage);
        List<Posts> listLatestPostTopic = postTopicService.getAllPostStatus(1,0,5);
        if((allPostTopic.size()%elementOfPage) != 0) {
            num_page = (allPostTopic.size()/elementOfPage) + 1;
        } else {
            num_page = (allPostTopic.size()/elementOfPage);
        }
        modelAndView.addObject("num_page",num_page);
        modelAndView.addObject("page",(page + 1));
        modelAndView.addObject("pre",(page - 1));
        modelAndView.addObject("next",(page + 1));
        modelAndView.addObject("last",(num_page - 1));
        modelAndView.addObject("cateId",cateId);
        modelAndView.addObject("allCategories",allCategories);
        modelAndView.addObject("allPostTopic",allPostTopic);
        modelAndView.addObject("listPostTopic",listPostTopic);
        modelAndView.addObject("listLatestPostTopic",listLatestPostTopic);
        if(listPostTopic.size() <= 0){
            modelAndView.setViewName("client/notfound");
            return modelAndView;
        }
        modelAndView.setViewName("client/service_cate");
        return modelAndView;
    }
//    @RequestMapping(value = "infor-post-topic",method = RequestMethod.POST)
//    public ModelAndView getInforPostTopic(HttpServletRequest request){
//        ModelAndView modelAndView = new ModelAndView();
//        int postTopic_ID = Integer.parseInt(request.getParameter("postTopic_ID"));
//        Posts postsTopic = postTopicService.getPost(postTopic_ID);
//        List<Topic_User> listUserJoined = topicUserService.getAllUserJoinTopicWithPostID(postTopic_ID,1);
//        modelAndView.addObject("postsTopic",postsTopic);
//        modelAndView.addObject("listUserJoined",listUserJoined);
//        modelAndView.setViewName("client/inforservice");
//        return  modelAndView;
//    }

    @RequestMapping(value = "infor-post-topic/{postTopic_ID}",method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView getInforPostTopicInPostLocal(@PathVariable("postTopic_ID") String postTopic_IDGET){
        ModelAndView modelAndView = new ModelAndView();
        postTopic_IDGET = postTopic_IDGET.toString().replaceAll("\\<.*?>","");
        if(isNumeric(postTopic_IDGET)){
            int postTopic_ID = Integer.parseInt(postTopic_IDGET);
            Posts postsTopic = postTopicService.getPost(postTopic_ID);
            postTopicService.increaseNumView(postTopic_ID,(postsTopic.getNum_View()+1));
            List<Topic_User> listUserJoined = topicUserService.getAllUserJoinTopicWithPostID(postTopic_ID,1);
            if(postsTopic.getStatus() == 0 || postsTopic == null){
                modelAndView.addObject("msgerror","A Post was already deleted or disabled !");
                modelAndView.setViewName("redirect:/");
            } else {
                modelAndView.addObject("listUserJoined",listUserJoined);
                modelAndView.addObject("postsTopic",postsTopic);
                modelAndView.setViewName("client/inforservice");
            }
        } else {
            modelAndView.setViewName("redirect:/");
        }

        return  modelAndView;
    }

    @RequestMapping(value = "create-topic-join/{postLocal_ID}/add-topic/{session}",method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView CreateTopicJoin(HttpSession session,
                                        @PathVariable("postLocal_ID") int postLocal_ID,
                                        @PathVariable("session") String sessionUserID){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null){
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if(sessionUser != null){
                sessionUserID = sessionUserID.toString().replaceAll("\\<.*?>","");
                if(isNumeric(sessionUserID)){
                    Users user = userService.getUser(Integer.parseInt(sessionUserID));
                    if(sessionUser.getUser_ID() != user.getUser_ID()){
                        modelAndView.addObject("msgerror","Data process wrong!");
                        modelAndView.setViewName("redirect:/");
                    } else {
                        if(sessionUserID.equals("none")){
                            modelAndView.addObject("msgerror","Please Sign In Or Register");
                            modelAndView.setViewName("client/login");
                        }else {
                            Posts_Local posts_local = postLocalService.getPostLocal(postLocal_ID);
                            if(posts_local == null || posts_local.getStatus() == 0){
                                modelAndView.addObject("msgerror","A Post was already deleted or disabled !");
                                modelAndView.setViewName("redirect:/");
                            } else {
                                List<Categories> categoriesList = categoriesService.getAllCategories();
                                modelAndView.addObject("posts_local",posts_local);
                                modelAndView.addObject("categoriesList",categoriesList);
                                modelAndView.setViewName("client/createtopic");
                            }
                        }
                    }
                } else {
                    modelAndView.setViewName("redirect:/");
                    return  modelAndView;
                }
            } else {
                modelAndView.addObject("msgerror","Please Sign In Or Register");
                modelAndView.setViewName("client/login");
            }
        } else {
            modelAndView.addObject("msgerror","Please Sign In Or Register");
            modelAndView.setViewName("client/login");
        }
        return  modelAndView;
    }

    @RequestMapping(value = "create-topic")
    public ModelAndView CreateTopicJoin(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        if(session != null){
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if(sessionUser != null){
                List<Categories> categoriesList = categoriesService.getAllCategories();
                modelAndView.addObject("categoriesList",categoriesList);
                modelAndView.setViewName("client/createtopic");
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

    @RequestMapping(value = "add-post-topic", method = RequestMethod.POST)
    public ModelAndView addTopic(HttpServletRequest request,
                                 HttpSession session,
                                 @RequestParam("file") MultipartFile[] files) {
        ModelAndView modelAndView = new ModelAndView();
        if(session != null) {
            Users sessionUser = (Users) session.getAttribute("sessionUser");
            if(sessionUser != null){
                // Root Directory.
                String uploadRootPath = "/var/lib/openshift/56fa35ca0c1e66de350000cc/app-root/runtime/dependencies/jbossews/webapps/ROOT/resources/upload/imgPostTopic";
//                String uploadRootPath = "D:/MY DATA/JAVA_SOFTWAVE/JSP/apache-tomcat-6.0.41/webapps/ROOT/resources/upload/imgPostTopic";
                String linkImagePostTopic ="";
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
                    linkImagePostTopic = name;
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

                String titleTopic = request.getParameter("titleTopic").toString().replaceAll("\\<.*?>","");
                int cate_ID = Integer.parseInt(request.getParameter("categories"));
                Categories categories = categoriesService.getCategories(cate_ID);
                String checkIn = request.getParameter("checkIn").toString().replaceAll("\\<.*?>","");
                String checkOut = request.getParameter("checkOut").toString().replaceAll("\\<.*?>","");
                String description = request.getParameter("editor1").toString().replaceAll("\\<.*?>","");
                String rules = request.getParameter("rules").toString().replaceAll("\\<.*?>","");
                String user_ID = request.getParameter("user_ID").toString().replaceAll("\\<.*?>","");
                if(!isNumeric(user_ID)){
                    modelAndView.setViewName("redirect:/");
                    return modelAndView;
                }
                Users users = userService.getUser(Integer.parseInt(user_ID));
                Posts_Local posts_local;
                if (request.getParameter("postLocal_ID").equals("null")){
                    posts_local = new Posts_Local();
                } else {
                    String postlocal  = request.getParameter("postLocal_ID").toString().replaceAll("\\<.*?>","");
                    if(!isNumeric(postlocal)){
                        modelAndView.setViewName("redirect:/");
                        return modelAndView;
                    }
                    posts_local = postLocalService.getPostLocal(Integer.parseInt(request.getParameter("postLocal_ID")));
                }
//        Convert date util -> date sql -> String
                Calendar currenttime = Calendar.getInstance();
                Date sqldate = new Date((currenttime.getTime()).getTime());
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String lastEditDate = df.format(sqldate);
                Posts posts = new Posts();
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
                posts.setNum_View(0);
                posts.setPublic_Date(null);
                posts.setStatus(0);
                postTopicService.saveOrUpdatePost(posts);
                modelAndView.addObject("msgsuccess","Create topic successfully!");
                modelAndView.setViewName("redirect:/post-user/post-topic");
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

    @RequestMapping(value = "add-topic-join/{post_ID}/{user_ID}", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView addUserJoinTopic(HttpSession session,
                                         @PathVariable("user_ID") String userID,
                                         @PathVariable("post_ID") int postID){
        ModelAndView modelAndView = new ModelAndView();

        if(userID.equals("none")){
            modelAndView.addObject("msgerror","Login to join the topic ");
            modelAndView.setViewName("redirect:/login");
        } else {
            userID = userID.toString().replaceAll("\\<.*?>","");
            if(!isNumeric(userID)){
                modelAndView.setViewName("redirect:/");
                return modelAndView;
            }
            int user_ID = Integer.parseInt(userID);
            if (session != null) {
                Users sessionUser = (Users) session.getAttribute("sessionUser");
                if (sessionUser != null && sessionUser.getUser_ID() == user_ID) {
                    Posts posts = postTopicService.getPost(postID);
                    if (sessionUser.getUser_ID() != posts.getUser_ID().getUser_ID()){
                        Topic_User topic_user = topicUserService.getTopicUserWithPostIdUserId(postID,user_ID);
                        if(topic_user == null){
                            Calendar currenttime = Calendar.getInstance();
                            Date sqldate = new Date((currenttime.getTime()).getTime());
                            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                            String datejoin = df.format(sqldate);

                            topicUserService.saveAndUpdateTopicUser(user_ID,postID,datejoin,0);
                            modelAndView.setViewName("redirect:/manage-user/list-topic/"+userID);
                        } else {
                            modelAndView.addObject("msgerror","You can't ask to join to your topic!");
                            modelAndView.setViewName("redirect:/");
                        }

                    } else {
                        modelAndView.addObject("msgerror","You can't ask to join to your topic!");
                        modelAndView.setViewName("redirect:/");
                    }
                } else {
                    modelAndView.addObject("msgerror","Error System !");
                    modelAndView.setViewName("redirect:/");
                }
            } else {
                modelAndView.addObject("msgerror","Error System !");
                modelAndView.setViewName("redirect:/");
            }
        }
        return modelAndView;
    }

    public boolean isNumeric(String s) {
        Pattern p = Pattern.compile("[+-]?(?:\\d+(?:\\.\\d*)?|\\.\\d+)");
        if (p.matcher(s).matches()) {
            return true;
        }
        return false;
    }

}
