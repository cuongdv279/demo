package com.projecttlc.model;

/**
 * Created by CHIP_IT_DVC on 11/03/2016.
 */
public class Message_Recevier {
    private int msgRecevier_ID;
    private Users recevier_ID;
    private Message message_ID;
    private int is_read;

    public int getMsgRecevier_ID() {
        return msgRecevier_ID;
    }

    public void setMsgRecevier_ID(int msgRecevier_ID) {
        this.msgRecevier_ID = msgRecevier_ID;
    }

    public Users getRecevier_ID() {
        return recevier_ID;
    }

    public void setRecevier_ID(Users recevier_ID) {
        this.recevier_ID = recevier_ID;
    }

    public Message getMessage_ID() {
        return message_ID;
    }

    public void setMessage_ID(Message message_ID) {
        this.message_ID = message_ID;
    }

    public int getIs_read() {
        return is_read;
    }

    public void setIs_read(int is_read) {
        this.is_read = is_read;
    }
}

