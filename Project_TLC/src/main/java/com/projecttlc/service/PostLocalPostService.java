package com.projecttlc.service;

import com.projecttlc.dao.PostLocalPostDAO;
import com.projecttlc.model.PostLocal_Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by CHIP_IT_DVC on 24/02/2016.
 */
@Service
public class PostLocalPostService {
    @Autowired
    PostLocalPostDAO postLocalPostDAO;

    public List<PostLocal_Post> getAllPostLocalPost(){
        return postLocalPostDAO.getAllPostLocalPost();
    }
    public List<PostLocal_Post> getAllPostLocalPost(int numPage, int pageOne){
        return postLocalPostDAO.getAllPostLocalPost(numPage,pageOne);
    }
    public List<PostLocal_Post> getAllPostLocalPost(int postLocal_ID, int numPage, int pageOne){
        return postLocalPostDAO.getAllPostLocalPost(postLocal_ID,numPage,pageOne);
    }

    public List<PostLocal_Post> getAllPostStatus(int status){
        return postLocalPostDAO.getAllPostStatus(status);
    }

    public List<PostLocal_Post> getAllPostLocalPostWithPostLocal_ID(int postLocal_ID){
        return postLocalPostDAO.getAllPostLocalPostWithPostLocal_ID(postLocal_ID);
    }

    public void saveOrUpdatePostLocalPost(PostLocal_Post postLocalPost){

    }
}
