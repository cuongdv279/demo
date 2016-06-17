package com.projecttlc.dao;

import com.projecttlc.model.Message;
import com.projecttlc.model.Message_Recevier;
import com.projecttlc.model.Users;
import com.projecttlc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by CHIP_IT_DVC on 11/03/2016.
 */
public class MessageRecevierDAOImpl implements MessageRecevierDAO {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    UserService userService;
    public MessageRecevierDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public List<Message_Recevier> getAllMessageRecevierWithUserID(int userID, int is_read) {
        String sql = "SELECT * FROM `message_recevier` " +
                "INNER JOIN message ON message.message_ID = message_recevier.`message_ID` " +
                "INNER JOIN users AS us1 ON  us1.User_ID = message_recevier.`recevier_ID` " +
                "INNER JOIN users AS us2 ON  us2.User_ID = message.fromUser " +
                "WHERE message_recevier.`recevier_ID` = "+userID+" AND message_recevier.is_read = "+is_read+" ";
        List<Message_Recevier> messageRecevierList = jdbcTemplate.query(sql, new RowMapper<Message_Recevier>() {
            @Override
            public Message_Recevier mapRow(ResultSet rs, int rowNum) throws SQLException {
                Message_Recevier messageRecevier = new Message_Recevier();
                Message message = new Message();
                Users user = new Users();
                Users fromUser = new Users();


                user.setUser_ID(rs.getInt(12));
                user.setFirst_Name(rs.getString(13));
                user.setLast_Name(rs.getString(14));
                user.setGender(rs.getInt(15));
                user.setEmail(rs.getString(16));
                user.setUser_Role(rs.getString(18));
                user.setActivation_Date(rs.getString(19));
                user.setAvatar(rs.getString(20));
                user.setAddress(rs.getString(21));
                user.setPhone_Number(rs.getString(22));
                user.setBirthday(rs.getString(23));
                user.setJob(rs.getString(24));
                user.setCountry(rs.getString(25));
                user.setWebsite(rs.getString(26));

                fromUser.setUser_ID(rs.getInt(28));
                fromUser.setFirst_Name(rs.getString(29));
                fromUser.setLast_Name(rs.getString(30));
                fromUser.setGender(rs.getInt(31));
                fromUser.setEmail(rs.getString(32));
                fromUser.setUser_Role(rs.getString(34));
                fromUser.setActivation_Date(rs.getString(35));
                fromUser.setAvatar(rs.getString(36));
                fromUser.setAddress(rs.getString(37));
                fromUser.setPhone_Number(rs.getString(38));
                fromUser.setBirthday(rs.getString(39));
                fromUser.setJob(rs.getString(40));
                fromUser.setCountry(rs.getString(41));
                fromUser.setWebsite(rs.getString(42));

                message.setMessageID(rs.getInt(5));
                message.setSubject(rs.getString(6));
                message.setContent(rs.getString(7));
                message.setDateSend(rs.getString(10));
                message.setFromUserID(fromUser);

                messageRecevier.setMsgRecevier_ID(rs.getInt(1));
                messageRecevier.setMessage_ID(message);
                messageRecevier.setRecevier_ID(user);
                messageRecevier.setIs_read(rs.getInt(4));

                return messageRecevier;
            }
        });
        return  messageRecevierList;
    }

    @Override
    public Message_Recevier getMessageRecevierWithMessageID(int msgID) {
        String sql = "SELECT * " +
                "FROM `message_recevier` " +
                "INNER JOIN message ON message.message_ID = message_recevier.message_ID " +
                "INNER JOIN users AS fromUser ON fromUser.User_ID = message.fromUser " +
                "WHERE `message_recevier`.`message_ID` = "+msgID+" ";
        return  jdbcTemplate.query(sql, new ResultSetExtractor<Message_Recevier>() {
            @Override
            public Message_Recevier extractData(ResultSet rs) throws SQLException, DataAccessException {
                if(rs.next()){
                    Message_Recevier messageRecevier = new Message_Recevier();
                    Message message = new Message();
                    Users fromUser = new Users();
                    Users users = new Users();
                    fromUser.setUser_ID(rs.getInt(12));
                    fromUser.setFirst_Name(rs.getString(13));
                    fromUser.setLast_Name(rs.getString(14));
//                    fromUser.setGender(rs.getInt(31));
                    fromUser.setEmail(rs.getString(16));
//                    fromUser.setUser_Role(rs.getString(34));
//                    fromUser.setActivation_Date(rs.getString(35));
                    fromUser.setAvatar(rs.getString(20));
//                    fromUser.setAddress(rs.getString(37));
//                    fromUser.setPhone_Number(rs.getString(38));
//                    fromUser.setBirthday(rs.getString(39));
//                    fromUser.setJob(rs.getString(40));
//                    fromUser.setCountry(rs.getString(41));
//                    fromUser.setWebsite(rs.getString(42));

                    message.setSubject(rs.getString(6));
                    message.setContent(rs.getString(7));
                    message.setFromUserID(fromUser);
                    message.setDateSend(rs.getString(10));

                    messageRecevier.setMsgRecevier_ID(rs.getInt(1));
                    users = userService.getUser(rs.getInt(2));
                    messageRecevier.setRecevier_ID(users);
                    messageRecevier.setMessage_ID(message);
                    return messageRecevier;
                }
                return null;
            }
        });
    }

    @Override
    public void saveAndUpdate(Message_Recevier messageRecevier) {
        if(messageRecevier.getMsgRecevier_ID() > 0){
            String sql = "UPDATE `message_recevier` SET `is_read`= ? WHERE `msgRecevie_ID`= ?";
            jdbcTemplate.update(sql,messageRecevier.getIs_read(),messageRecevier.getMsgRecevier_ID());
        } else {
            String sql = "INSERT INTO `message_recevier`(`recevier_ID`, `message_ID`, `is_read`) VALUES (?,?,?)";
            jdbcTemplate.update(sql,messageRecevier.getRecevier_ID().getUser_ID(),messageRecevier.getMessage_ID().getMessageID(),messageRecevier.getIs_read());
        }
    }

    @Override
    public void deleteMessageRecevier(int messsageRecevierID) {

    }
}
