package com.projecttlc.service;

import com.projecttlc.dao.TopicUserDAO;
import com.projecttlc.model.Topic_User;
import com.projecttlc.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by CHIP_IT_DVC on 09/03/2016.
 */
@Service
public class TopicUserService {
    @Autowired
    TopicUserDAO topicUserDAO;
    public List<Topic_User> getAllUserJoinTopicWithPostID(int postID,int status){
        return topicUserDAO.getAllUserJoinTopicWithPostID( postID, status);
    }
    public List<Topic_User> getAllUserJoinTopicWithPostID(int postID){
        return topicUserDAO.getAllUserJoinTopicWithPostID( postID);
    }
    public void updateTopicUser(int userID, int postID, int status) {
        topicUserDAO.updateTopicUser(userID,postID,status);
    }
    public List<Topic_User> getTopicWithUser(int userID) {
        return topicUserDAO.getTopicWithUser(userID);
    }
    public List<Topic_User> getTopicWithUser(int userID, int numPage, int pageOne) {
        return topicUserDAO.getTopicWithUser(userID,numPage,pageOne);
    }
    public void deelteTopicUser(int userID, int postID) {
        topicUserDAO.deelteTopicUser(userID,postID);
    }
    public void saveAndUpdateTopicUser(int userID, int postID, String dateJoin, int status) {
        topicUserDAO.saveAndUpdateTopicUser(userID,postID,dateJoin,status);
    }
    public List<Topic_User> getAllUserJoinTopic(int userID, int status) {
        return topicUserDAO.getAllUserJoinTopic(userID,status);
    }
    public Topic_User getTopicUserWithPostIdUserId( int postId,  int userId) {
        return topicUserDAO.getTopicUserWithPostIdUserId(postId,userId);
    }
}
