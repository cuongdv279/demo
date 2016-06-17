package com.projecttlc.model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by CHIP_IT_DVC on 10/03/2016.
 */
public class Message {
    private int messageID;
    private  String subject;
    private String content;
    private Users fromUserID;
    private Users toUserID;
    private Date dateSend;
    private Message subMsgID;

    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Users getFromUserID() {
        return fromUserID;
    }

    public void setFromUserID(Users fromUserID) {
        this.fromUserID = fromUserID;
    }

    public Users getToUserID() {
        return toUserID;
    }

    public void setToUserID(Users toUserID) {
        this.toUserID = toUserID;
    }

    public Date getDateSend() {
        return dateSend;
    }

    public void setDateSend(String dateSend) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date;
        String arrdate[] ;
        if(dateSend == null) {
            arrdate = new String[1];
        } else {
            arrdate = dateSend.split("/");
        }
        String dateFormat;
        if(arrdate.length > 1) {
            dateFormat = arrdate[2]+"-"+arrdate[1]+"-"+arrdate[0];
            try {
                date = sdf.parse(dateFormat);
                java.sql.Date sqlStartDate = new Date(date.getTime());
                this.dateSend = sqlStartDate;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else if(dateSend == null){
            date = null;
            this.dateSend = (Date) date;
        } else {
            dateFormat = dateSend;
            try {
                date = sdf.parse(dateFormat);
                java.sql.Date sqlStartDate = new Date(date.getTime());
                this.dateSend = sqlStartDate;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public Message getSubMsgID() {
        return subMsgID;
    }

    public void setSubMsgID(Message subMsgID) {
        this.subMsgID = subMsgID;
    }
}
