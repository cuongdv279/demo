package com.projecttlc.service;

import com.projecttlc.dao.MessageDAO;
import com.projecttlc.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * Created by CHIP_IT_DVC on 10/03/2016.
 */
@Service
public class MessageService {
    @Autowired
    MessageDAO messageDAO;

    public void saveAndUpdateMessage(Message message) {
        messageDAO.saveAndUpdateMessage(message);
    }

    public List<Message> getAllMessageOfUserSend(int userID) {
        return messageDAO.getAllMessageOfUserSend(userID);
    }

    public List<Message> getAllMessageOfUserRecevied(int userID) {
        return messageDAO.getAllMessageOfUserRecevied(userID);
    }
    public Message getMessageWithUserID(int fromUserID,int toUserID) {
       return messageDAO.getMessageWithUserID(fromUserID,toUserID);
    }
    public Message getMessageWithMsgID(int msgID) {
        return messageDAO.getMessageWithMsgID(msgID);
    }
}
