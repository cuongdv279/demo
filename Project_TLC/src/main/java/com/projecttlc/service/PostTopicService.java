package com.projecttlc.service;

import com.projecttlc.dao.PostDAO;
import com.projecttlc.model.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by CHIP_IT_DVC on 24/02/2016.
 */
@Service
public class PostTopicService {
    @Autowired
    PostDAO postDAO;

    public List<Posts> getAllPost(){
        return postDAO.getAllPost();
    }
    public List<Posts> getAllPost(int numPage, int pageOne){
        return postDAO.getAllPost(numPage,pageOne);
    }

    public List<Posts> getAllPostStatus(int status){
        return  postDAO.getAllPostStatus(status);
    }
    public List<Posts> getAllPostStatus(int status, int numPage, int pageOne){
        return postDAO.getAllPostStatus(status,numPage,pageOne);
    }

    public List<Posts> getAllPostDateEnd(){
        return postDAO.getAllPostDateEnd();
    }

    public List<Posts> getAllPostCate(int cate_ID,int status){
        return postDAO.getAllPostCate(cate_ID,status);
    }
    public List<Posts> getAllPostCate(int cate_ID,int status, int numPage, int pageOne){
        return postDAO.getAllPostCate(cate_ID,status,numPage,pageOne);
    }

    public Posts getPost(int post_ID){
        return postDAO.getPost(post_ID);
    }

    public List<Posts> getAllPostPostLocal(int postLocal_ID){
        return postDAO.getAllPostPostLocal(postLocal_ID);
    }
    public List<Posts> getAllPostPostLocal(int postLocal_ID, int numPage, int pageOne){
        return postDAO.getAllPostPostLocal(postLocal_ID,numPage,pageOne);
    }

    public List<Posts> getAllPostWithUserID(int userID){
        return postDAO.getAllPostWithUserID(userID);
    }
    public List<Posts> getAllPostWithUserID(int userID,int numPage, int pageOne){
        return postDAO.getAllPostWithUserID(userID,numPage,pageOne);
    }
    public List<Posts> getAllPostStatus(int userID, int status) {
        return postDAO.getAllPostStatus(userID,status);
    }

    public void saveOrUpdatePost(Posts post){
        postDAO.saveOrUpdatePost(post);
    }
    public void editStatusPost(int post_ID, int status) {
        postDAO.editStatusPost(post_ID,status);
    }
    public void editPublicPost(int post_ID, String pubicDate, int status) {
        postDAO.editPublicPost(post_ID,pubicDate,status);
    }
    public void increaseNumView(int post_ID,int numview) {
        postDAO.increaseNumView(post_ID,numview);
    }
    public void  deletePost(int post_ID){
        postDAO.deletePost(post_ID);
    }
}
