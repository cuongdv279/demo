package com.projecttlc.dao;

import com.projecttlc.model.Message;
import com.projecttlc.model.Users;
import com.projecttlc.service.MessageService;
import com.projecttlc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by CHIP_IT_DVC on 10/03/2016.
 */
public class MessageDAOImpl implements MessageDAO {
    @Autowired
    UserService userService;
    private JdbcTemplate jdbcTemplate;

    public MessageDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public List<Message> getAllMessage() {
        return null;
    }

    @Override
    public List<Message> getAllMessage(int numPage, int pageOne) {
        return null;
    }

    @Override
    public List<Message> getAllMessageOfUserSend(int userID) {
        String sql = "SELECT * " +
                "FROM `message` " +
                "INNER JOIN users AS us1 ON us1.User_ID = message.fromUser " +
                "INNER JOIN users AS us2 ON us2.User_ID = message.toUser " +
                "WHERE `fromUser` = "+userID+" " +
                "ORDER BY `dateSend` DESC";
        List<Message> messageList = jdbcTemplate.query(sql, new RowMapper<Message>() {
            @Override
            public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
                Message message = new Message();

                Users fromUser = new Users();
                fromUser.setUser_ID(rs.getInt(8));
                fromUser.setFirst_Name(rs.getString(9));
                fromUser.setLast_Name(rs.getString(10));
                fromUser.setGender(rs.getInt(11));
                fromUser.setEmail(rs.getString(12));
                fromUser.setUser_Role(rs.getString(14));
                fromUser.setActivation_Date(rs.getString(15));
                fromUser.setAvatar(rs.getString(16));
                fromUser.setAddress(rs.getString(17));
                fromUser.setPhone_Number(rs.getString(18));
                fromUser.setBirthday(rs.getString(19));
                fromUser.setJob(rs.getString(20));
                fromUser.setCountry(rs.getString(21));
                fromUser.setWebsite(rs.getString(22));

                Users toUser = new Users();
                toUser.setUser_ID(rs.getInt(24));
                toUser.setFirst_Name(rs.getString(25));
                toUser.setLast_Name(rs.getString(26));
                toUser.setGender(rs.getInt(27));
                toUser.setEmail(rs.getString(28));
                toUser.setUser_Role(rs.getString(30));
                toUser.setActivation_Date(rs.getString(31));
                toUser.setAvatar(rs.getString(32));
                toUser.setAddress(rs.getString(33));
                toUser.setPhone_Number(rs.getString(34));
                toUser.setBirthday(rs.getString(35));
                toUser.setJob(rs.getString(36));
                toUser.setCountry(rs.getString(37));
                toUser.setWebsite(rs.getString(38));

                message.setMessageID(rs.getInt(1));
                message.setSubject(rs.getString(2));
                message.setContent(rs.getString(3));
                message.setFromUserID(fromUser);
                message.setToUserID(toUser);
                message.setDateSend(rs.getString(6));

                return message;
            }
        });
        return messageList;
    }

    @Override
    public List<Message> getAllMessageOfUserSend(int userID, int numPage, int pageOne) {
        return null;
    }

    @Override
    public List<Message> getAllMessageOfUserRecevied(int userID) {
        String sql = "SELECT * " +
                "FROM `message` " +
                "INNER JOIN users AS us1 ON us1.User_ID = message.fromUser " +
                "INNER JOIN users AS us2 ON us2.User_ID = message.toUser " +
                "WHERE `toUser` = "+userID+" " +
                "ORDER BY `dateSend` DESC";
        List<Message> messageList = jdbcTemplate.query(sql, new RowMapper<Message>() {
            @Override
            public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
                Message message = new Message();

                Users fromUser = new Users();
                fromUser.setUser_ID(rs.getInt(8));
                fromUser.setFirst_Name(rs.getString(9));
                fromUser.setLast_Name(rs.getString(10));
                fromUser.setGender(rs.getInt(11));
                fromUser.setEmail(rs.getString(12));
                fromUser.setUser_Role(rs.getString(14));
                fromUser.setActivation_Date(rs.getString(15));
                fromUser.setAvatar(rs.getString(16));
                fromUser.setAddress(rs.getString(17));
                fromUser.setPhone_Number(rs.getString(18));
                fromUser.setBirthday(rs.getString(19));
                fromUser.setJob(rs.getString(20));
                fromUser.setCountry(rs.getString(21));
                fromUser.setWebsite(rs.getString(22));

                Users toUser = new Users();
                toUser.setUser_ID(rs.getInt(24));
                toUser.setFirst_Name(rs.getString(25));
                toUser.setLast_Name(rs.getString(26));
                toUser.setGender(rs.getInt(27));
                toUser.setEmail(rs.getString(28));
                toUser.setUser_Role(rs.getString(30));
                toUser.setActivation_Date(rs.getString(31));
                toUser.setAvatar(rs.getString(32));
                toUser.setAddress(rs.getString(33));
                toUser.setPhone_Number(rs.getString(34));
                toUser.setBirthday(rs.getString(35));
                toUser.setJob(rs.getString(36));
                toUser.setCountry(rs.getString(37));
                toUser.setWebsite(rs.getString(38));

                message.setMessageID(rs.getInt(1));
                message.setSubject(rs.getString(2));
                message.setContent(rs.getString(3));
                message.setFromUserID(fromUser);
                message.setToUserID(toUser);
                message.setDateSend(rs.getString(6));

                return message;
            }
        });
        return messageList;
    }

    @Override
    public List<Message> getAllMessageOfUserRecevied(int userID, int numPage, int pageOne) {
        return null;
    }

    @Override
    public Message getMessageWithMsgID(int msgID) {
        String sql = "SELECT `message_ID`, `subject`, `content`, `fromUser`, `toUser`, `dateSend`, `subMsgID` " +
                "FROM `message` " +
                "WHERE `message_ID` = "+msgID+" " +
                "ORDER BY `message_ID` DESC";
        return  jdbcTemplate.query(sql, new ResultSetExtractor<Message>() {
            @Override
            public Message extractData(ResultSet rs) throws SQLException, DataAccessException {
                if(rs.next()){
                    Users toUser = new Users();
                    Users fromUser = new Users();
                    Message message = new Message();
                    toUser = userService.getUser(rs.getInt("toUser"));
                    fromUser = userService.getUser(rs.getInt("fromUser"));
                    message.setMessageID(rs.getInt("message_ID"));
                    message.setSubject(rs.getString("subject"));
                    message.setContent(rs.getString("content"));
                    message.setFromUserID(fromUser);
                    message.setToUserID(toUser);
                    message.setDateSend(rs.getString("dateSend"));
                    return message;
                }
                return null;
            }
        });
    }

    @Override
    public Message getMessageWithUserID(int fromUserID,int toUserID) {
       String sql = "SELECT MAX(`message_ID`), `subject`, `content`, `fromUser`, `toUser`, `dateSend`, `subMsgID` " +
               "FROM `message` " +
               "WHERE `fromUser` = "+fromUserID+" AND `toUser` = "+toUserID+" " +
               "ORDER BY `message_ID` DESC";
        return  jdbcTemplate.query(sql, new ResultSetExtractor<Message>() {
            @Override
            public Message extractData(ResultSet rs) throws SQLException, DataAccessException {
                if(rs.next()){
                    Message message = new Message();
                    message.setMessageID(rs.getInt(1));
                    return message;
                }
                return null;
            }
        });
    }

    @Override
    public List<Message> getAllMessageSubMsg(int subMgsID) {
        return null;
    }

    @Override
    public List<Message> getAllMessageSubMsg(int subMgsID, int numPage, int pageOne) {
        return null;
    }

    @Override
    public void saveAndUpdateMessage(Message message) {
        if(message.getSubMsgID() != null){
            String sql = "INSERT INTO `message`(`subject`, `content`, `fromUser`, `toUser`, `dateSend`, `subMsgID`) VALUES (?,?,?,?,?,?)";
            jdbcTemplate.update(sql,message.getSubject(),message.getContent(),message.getFromUserID().getUser_ID(),message.getToUserID().getUser_ID(),message.getDateSend(),message.getSubMsgID());
        } else {
            String sql = "INSERT INTO `message`(`subject`, `content`, `fromUser`, `toUser`, `dateSend`) VALUES (?,?,?,?,?)";
            System.out.println(message.getSubject());
            System.out.println(message.getContent());
            System.out.println(message.getFromUserID().getUser_ID());
            System.out.println(message.getToUserID().getUser_ID());
            System.out.println(message.getDateSend());
            jdbcTemplate.update(sql,message.getSubject(),message.getContent(),message.getFromUserID().getUser_ID(),message.getToUserID().getUser_ID(),message.getDateSend());
        }
    }

    @Override
    public void deleteMessage(Message message) {

    }
}
