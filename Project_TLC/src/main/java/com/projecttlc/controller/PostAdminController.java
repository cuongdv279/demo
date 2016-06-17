package com.projecttlc.controller;

import com.projecttlc.model.Categories;
import com.projecttlc.model.Posts;
import com.projecttlc.model.Posts_Local;
import com.projecttlc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by CHIP_IT_DVC on 17/03/2016.
 */
@Controller
@SessionAttributes("sessionUser")
@RequestMapping("/post-event")
public class PostAdminController {
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

    @RequestMapping(value = "post")
    public ModelAndView getListPostLocal(){
        ModelAndView modelAndView = new ModelAndView();
        int page = 0;
        int num_page = 0;
        int elementOfPage = 2;

        List<Categories> allCategories = categoriesService.getAllCategories();
        List<Posts_Local> allPostLocal = postLocalService.getAllPosts_LocalStatus(1);
        List<Posts_Local> listPostLocal = postLocalService.getAllPosts_LocalStatus(1,page,elementOfPage);
        List<Posts_Local> listLatestPostLocal = postLocalService.getAllPosts_LocalStatus(1,0,3);
        if((allPostLocal.size()%elementOfPage) != 0) {
            num_page = (allPostLocal.size()/elementOfPage) + 1;
        } else {
            num_page = (allPostLocal.size()/elementOfPage);
        }
        modelAndView.addObject("num_page",num_page);
        modelAndView.addObject("page",(page + 1));
        modelAndView.addObject("pre",(page - 1));
        modelAndView.addObject("next",(page + 1));
        modelAndView.addObject("last",(num_page - 1));
        modelAndView.addObject("allCategories",allCategories);
        modelAndView.addObject("allPostLocal",allPostLocal);
        modelAndView.addObject("listPostLocal",listPostLocal);
        modelAndView.addObject("listLatestPostLocal",listLatestPostLocal);
        modelAndView.setViewName("client/listpost");
        return modelAndView;
    }

    @RequestMapping(value = "post/{page}", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView getListPostLocal(@PathVariable("page") String Page){
        ModelAndView modelAndView = new ModelAndView();
        int page = 0;
        int num_page = 0;
        int elementOfPage = 2;
        if(Page != null) {
            page = Math.abs(Integer.parseInt(Page));

        }
        List<Categories> allCategories = categoriesService.getAllCategories();
        List<Posts_Local> allPostLocal = postLocalService.getAllPosts_LocalStatus(1);
        List<Posts_Local> listPostLocal = postLocalService.getAllPosts_LocalStatus(1,page,elementOfPage);
        List<Posts_Local> listLatestPostLocal = postLocalService.getAllPosts_LocalStatus(1,0,3);
        if((allPostLocal.size()%elementOfPage) != 0) {
            num_page = (allPostLocal.size()/elementOfPage) + 1;
        } else {
            num_page = (allPostLocal.size()/elementOfPage);
        }
        modelAndView.addObject("num_page",num_page);
        modelAndView.addObject("page",(page + 1));
        modelAndView.addObject("pre",(page - 1));
        modelAndView.addObject("next",(page + 1));
        modelAndView.addObject("last",(num_page - 1));
        modelAndView.addObject("allCategories",allCategories);
        modelAndView.addObject("allPostLocal",allPostLocal);
        modelAndView.addObject("listPostLocal",listPostLocal);
        modelAndView.addObject("listLatestPostLocal",listLatestPostLocal);
        modelAndView.setViewName("client/listpost");
        return modelAndView;
    }

    @RequestMapping(value = "post/fl/categories/{cateId}/page/{page}", method = {RequestMethod.GET,RequestMethod.POST})
    public  ModelAndView getAllPostLocalCategories(@PathVariable("cateId")int cateID,
                                                   @PathVariable("page") String Page){
        ModelAndView modelAndView = new ModelAndView();
        int page = 0;
        int num_page = 0;
        int elementOfPage = 2;
        if(Page != null) {
            page = Math.abs(Integer.parseInt(Page));
        }
        List<Categories> allCategories = categoriesService.getAllCategories();
        List<Posts_Local> allPostLocal = postLocalService.getAllPosts_LocalCate(cateID,1);
        List<Posts_Local> listPostLocal = postLocalService.getAllPosts_LocalCate(cateID,1,page,elementOfPage);
        List<Posts_Local> listLatestPostLocal = postLocalService.getAllPosts_LocalStatus(1,0,3);
        if((allPostLocal.size()%elementOfPage) != 0) {
            num_page = (allPostLocal.size()/elementOfPage) + 1;
        } else {
            num_page = (allPostLocal.size()/elementOfPage);
        }
        modelAndView.addObject("num_page",num_page);
        modelAndView.addObject("page",(page + 1));
        modelAndView.addObject("pre",(page - 1));
        modelAndView.addObject("next",(page + 1));
        modelAndView.addObject("last",(num_page - 1));
        modelAndView.addObject("cateID",cateID);
        modelAndView.addObject("allCategories",allCategories);
        modelAndView.addObject("allPostLocal",allPostLocal);
        modelAndView.addObject("listPostLocal",listPostLocal);
        modelAndView.addObject("listLatestPostLocal",listLatestPostLocal);
        if(allPostLocal.size() <= 0){
            modelAndView.setViewName("client/listpost_no_found");
            return modelAndView;
        }
        modelAndView.setViewName("client/listpost_cate");
        return modelAndView;
    }

    @RequestMapping(value = "info-post/{id_post}",method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView getAllPostLocal(@PathVariable("id_post") int postLocal_ID){
        ModelAndView modelAndView = new ModelAndView();
        Posts_Local posts_local = postLocalService.getPostLocal(postLocal_ID);
        if(posts_local.getStatus() == 0 || posts_local == null || posts_local.getStatus() == 3){
            modelAndView.addObject("msg","A Post was already deleted or disabled !");
            modelAndView.setViewName("redirect:/");
        } else {
            int page = 0;
            int num_page = 0;
            int elementOfPage = 5;
            List<Posts> allPostInPostLocal = postTopicService.getAllPostPostLocal(postLocal_ID);
            List<Posts> listPostInPostLocal = postTopicService.getAllPostPostLocal(postLocal_ID,page,elementOfPage);
            if((allPostInPostLocal.size()%elementOfPage) != 0) {
                num_page = (allPostInPostLocal.size()/elementOfPage) + 1;
            } else {
                num_page = (allPostInPostLocal.size()/elementOfPage);
            }
            modelAndView.addObject("num_page",num_page);
            modelAndView.addObject("page",(page + 1));
            modelAndView.addObject("pre",(page - 1));
            modelAndView.addObject("next",(page + 1));
            modelAndView.addObject("last",(num_page - 1));
            modelAndView.addObject("allPostInPostLocal",allPostInPostLocal);
            modelAndView.addObject("listPostInPostLocal",listPostInPostLocal);
            postLocalService.countViews(postLocal_ID,(posts_local.getNum_View()+1));
            modelAndView.addObject("posts_local",posts_local);
            modelAndView.setViewName("client/inforpost");
        }
        return  modelAndView;
    }

    @RequestMapping(value = "info-post/{id_post}/page/{Page}",method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView getInforPostLocal(@PathVariable("id_post") int postLocal_ID,
                                          @PathVariable("Page") String Page){
        ModelAndView modelAndView = new ModelAndView();
        Posts_Local posts_local = postLocalService.getPostLocal(postLocal_ID);
        if(posts_local.getStatus() == 0 || posts_local.getStatus() == 3 || posts_local == null){
            modelAndView.addObject("msg","A Post was already deleted or disabled !");
            modelAndView.setViewName("redirect:/");
        } else {
            int page = 0;
            int num_page = 0;
            int elementOfPage = 5;
            if(Page != null) {
                page = Math.abs(Integer.parseInt(Page));

            }
            List<Posts> allPostInPostLocal = postTopicService.getAllPostPostLocal(postLocal_ID);
            List<Posts> listPostInPostLocal = postTopicService.getAllPostPostLocal(postLocal_ID,page,elementOfPage);
            if((allPostInPostLocal.size()%elementOfPage) != 0) {
                num_page = (allPostInPostLocal.size()/elementOfPage) + 1;
            } else {
                num_page = (allPostInPostLocal.size()/elementOfPage);
            }
            modelAndView.addObject("num_page",num_page);
            modelAndView.addObject("page",(page + 1));
            modelAndView.addObject("pre",(page - 1));
            modelAndView.addObject("next",(page + 1));
            modelAndView.addObject("last",(num_page - 1));
            modelAndView.addObject("allPostInPostLocal",allPostInPostLocal);
            modelAndView.addObject("listPostInPostLocal",listPostInPostLocal);
            modelAndView.addObject("posts_local",posts_local);
            modelAndView.setViewName("client/inforpost");
        }

        return  modelAndView;
    }

}
