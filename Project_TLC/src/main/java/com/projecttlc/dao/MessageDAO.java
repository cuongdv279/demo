package com.projecttlc.dao;

import com.projecttlc.model.Message;

import java.sql.Date;
import java.util.List;

/**
 * Created by CHIP_IT_DVC on 10/03/2016.
 */
public interface MessageDAO {
    List<Message> getAllMessage();
    List<Message> getAllMessage(int numPage, int pageOne);

    List<Message> getAllMessageOfUserSend(int userID);
    List<Message> getAllMessageOfUserSend(int userID,int numPage, int pageOne);

    List<Message> getAllMessageOfUserRecevied(int userID);
    List<Message> getAllMessageOfUserRecevied(int userID,int numPage, int pageOne);

    Message getMessageWithMsgID(int msgID);
    Message getMessageWithUserID(int fromUserID,int toUserID);

    List<Message> getAllMessageSubMsg(int subMgsID);
    List<Message> getAllMessageSubMsg(int subMgsID, int numPage, int pageOne);

    void saveAndUpdateMessage(Message message);

    void deleteMessage(Message message);
}
