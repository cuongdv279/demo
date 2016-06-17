package com.projecttlc.service;

import com.projecttlc.dao.PostLocalDAO;
import com.projecttlc.model.Posts;
import com.projecttlc.model.Posts_Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by CHIP_IT_DVC on 23/02/2016.
 */
@Service
public class PostLocalService {

    @Autowired
    PostLocalDAO postLocalDAO;

    public List<Posts_Local> getAllPostLocal(){
        return postLocalDAO.getAllPostLocal();
    }
    public List<Posts_Local> getAllPostLocal(int numPage, int pageOne){
        return postLocalDAO.getAllPostLocal(numPage,pageOne);
    }

    public List<Posts_Local> getAllPosts_LocalStatus(int status) {
        return postLocalDAO.getAllPosts_LocalStatus(status);
    }
    public List<Posts_Local> getAllPosts_LocalStatus(int status, int numPage, int pageOne){
        return postLocalDAO.getAllPosts_LocalStatus(status,numPage,pageOne);
    }

    public List<Posts_Local> getAllPosts_LocalCate(int cate_ID,int status, int numPage, int pageOne){
        return postLocalDAO.getAllPosts_LocalCate(cate_ID,status,numPage,pageOne);
    }
    public List<Posts_Local> getAllPosts_LocalCate(int cate_ID,int status){
        return postLocalDAO.getAllPosts_LocalCate(cate_ID,status);
    }

    public Posts_Local getPostLocal(int postLocal_ID){
        return postLocalDAO.getPostLocal(postLocal_ID);
    }

    public void saveOrUpdatePostsLocal(Posts_Local postLocal){
        postLocalDAO.saveOrUpdatePostsLocal(postLocal);

    }
    public void countViews(int postID, int countViews) {
        postLocalDAO.countViews(postID,countViews);
    }
    public void deletePostsLocal(int postLocal_ID){
        postLocalDAO.deletePostsLocal(postLocal_ID);
    }

}
