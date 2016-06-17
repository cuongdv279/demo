package com.projecttlc.model;

public class PostLocal_Post {

    private Posts_Local postLocal_ID;
    private Posts post_ID;
    private int status;
    public PostLocal_Post() {
        super();
        // TODO Auto-generated constructor stub
    }
    public PostLocal_Post(Posts_Local postLocal_ID, Posts post_ID, int status) {
        super();
        this.postLocal_ID = postLocal_ID;
        this.post_ID = post_ID;
        this.status = status;
    }
    public Posts_Local getPostLocal_ID() {
        return postLocal_ID;
    }
    public void setPostLocal_ID(Posts_Local postLocal_ID) {
        this.postLocal_ID = postLocal_ID;
    }
    public Posts getPost_ID() {
        return post_ID;
    }
    public void setPost_ID(Posts post_ID) {
        this.post_ID = post_ID;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
