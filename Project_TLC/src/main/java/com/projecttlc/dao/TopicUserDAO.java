package com.projecttlc.dao;

import com.projecttlc.model.Topic_User;
import com.projecttlc.model.Users;

import java.util.List;

/**
 * Created by CHIP_IT_DVC on 19/02/2016.
 */
public interface TopicUserDAO {
    List<Topic_User> getAllTopicUser();
    List<Topic_User> getAllTopicUser(int numPage, int pageOne);

    List<Topic_User> getAllTopicUserDateJoin(String dateJoin);
    List<Topic_User> getAllTopicUserDateJoin(String dateJoin, int numPage, int pageOne);

    List<Topic_User> getAllTopicUser(int status, int numPage, int pageOne);

    List<Topic_User> getAllUserJoinTopicWithPostID(int postID,int status);
    List<Topic_User> getAllUserJoinTopicWithPostID(int postID);
    List<Topic_User> getAllUserJoinTopic(int userID, int status);


    List<Topic_User> getTopicWithUser(int userID);
    List<Topic_User> getTopicWithUser(int userID, int numPage, int pageOne);

    Topic_User getTopicUser(int topicUser_ID);
    Topic_User getTopicUserWithPostIdUserId(int postId, int userId);

    void saveAndUpdateTopicUser(int userID, int postID, String dateJoin, int status);
    void updateTopicUser(int userID, int postID, int status);
    void deelteTopicUser(int userID, int postID);
}
