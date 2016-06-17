package com.projecttlc.dao;

import java.util.List;

import com.projecttlc.model.Posts;

public interface PostDAO {

    List<Posts> getAllPost();
    List<Posts> getAllPost(int numPage, int pageOne);

    List<Posts> getAllPostStatus(int status);
    List<Posts> getAllPostStatus(int status, int numPage, int pageOne);

    List<Posts> getAllPostStatus(int userID,int status);
    List<Posts> getAllPostStatus(int userID,int status, int numPage, int pageOne);
    
    List<Posts> getAllPostDateEnd();

    List<Posts> getAllPostCate(int cate_ID,int status);
    List<Posts> getAllPostCate(int cate_ID,int status, int numPage, int pageOne);

    List<Posts> getAllPostPostLocal(int postLocal_ID);
    List<Posts> getAllPostPostLocal(int postLocal_ID, int numPage, int pageOne);

    List<Posts> getAllPostWithUserID(int userID);
    List<Posts> getAllPostWithUserID(int userID,int numPage, int pageOne);

    Posts getPost(int post_ID);
    
    void saveOrUpdatePost(Posts post);
    void increaseNumView(int post_ID, int numview);
    void editStatusPost(int post_ID,int status);
    void editPublicPost(int post_ID,String pubicDate,int status);
    void deletePost(int post_ID);
}
