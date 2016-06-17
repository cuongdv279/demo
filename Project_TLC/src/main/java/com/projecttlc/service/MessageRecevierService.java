package com.projecttlc.service;

import com.projecttlc.dao.MessageRecevierDAO;
import com.projecttlc.model.Message_Recevier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by CHIP_IT_DVC on 11/03/2016.
 */
@Service
public class MessageRecevierService {
    @Autowired
    MessageRecevierDAO messageRecevierDAO;

    public List<Message_Recevier> getAllMessageRecevierWithUserID(int userID, int is_read) {
        return messageRecevierDAO.getAllMessageRecevierWithUserID(userID,is_read);
    }

    public void saveAndUpdate(Message_Recevier messageRecevier) {
        messageRecevierDAO.saveAndUpdate(messageRecevier);
    }

    public Message_Recevier getMessageRecevierWithMessageID(int msgID) {
         return messageRecevierDAO.getMessageRecevierWithMessageID(msgID);
    }
}
