package com.projecttlc.dao;

import java.util.List;

import com.projecttlc.model.Posts;
import com.projecttlc.model.Posts_Local;

public interface PostLocalDAO {

    List<Posts_Local> getAllPostLocal();
    List<Posts_Local> getAllPostLocal(int numPage, int pageOne);

//    List<Posts_Local> getAllPostLocal(int status);
//    List<Posts_Local> getAllPostLocal(int status,int numPage, int pageOne);

    List<Posts_Local> getAllPosts_LocalStatus(int status);
    List<Posts_Local> getAllPosts_LocalStatus(int status, int numPage, int pageOne);

    List<Posts_Local> getAllPosts_LocalCate(int cate_ID,int status);
    List<Posts_Local> getAllPosts_LocalCate(int cate_ID,int status, int numPage, int pageOne);

    Posts_Local getPostLocal(int postLocal_ID);
    
    void saveOrUpdatePostsLocal(Posts_Local postLocal);

    void countViews(int postID, int countViews);
    
    void deletePostsLocal(int postLocal_ID);
}
