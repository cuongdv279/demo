package com.projecttlc.dao;

import com.projecttlc.model.PostLocal_Post;

import java.util.List;
/**
 * Created by CHIP_IT_DVC on 19/02/2016.
 */
public interface PostLocalPostDAO {
    List<PostLocal_Post> getAllPostLocalPost();
    List<PostLocal_Post> getAllPostLocalPost(int numPage, int pageOne);
    List<PostLocal_Post> getAllPostLocalPost(int postLocal_ID, int numPage, int pageOne);

    List<PostLocal_Post> getAllPostStatus(int status);

    List<PostLocal_Post> getAllPostLocalPostWithPostLocal_ID(int postLocal_ID);

    void saveOrUpdatePostLocalPost(PostLocal_Post postLocalPost);

}
