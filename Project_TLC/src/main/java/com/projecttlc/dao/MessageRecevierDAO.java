package com.projecttlc.dao;

import com.projecttlc.model.Message_Recevier;

import java.util.List;

/**
 * Created by CHIP_IT_DVC on 11/03/2016.
 */
public interface MessageRecevierDAO {
    List<Message_Recevier> getAllMessageRecevierWithUserID(int userID, int is_read);

    Message_Recevier getMessageRecevierWithMessageID(int msgID);

    void saveAndUpdate(Message_Recevier messageRecevier);

    void deleteMessageRecevier(int messsageRecevierID);
}
