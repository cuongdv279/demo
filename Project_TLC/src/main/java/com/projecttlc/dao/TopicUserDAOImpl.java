package com.projecttlc.dao;

import com.projecttlc.model.Categories;
import com.projecttlc.model.Posts;
import com.projecttlc.model.Topic_User;
import com.projecttlc.model.Users;
import com.projecttlc.service.PostTopicService;
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
 * Created by CHIP_IT_DVC on 19/02/2016.
 */
public class TopicUserDAOImpl implements TopicUserDAO {

    private JdbcTemplate jdbcTemplate;
    @Autowired
    PostTopicService topicService;
    @Autowired
    UserService userService;
    public TopicUserDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    public List<Topic_User> getAllTopicUser() {

        return null;
    }

    public List<Topic_User> getAllTopicUser(int numPage, int pageOne) {
        return null;
    }

    public List<Topic_User> getAllTopicUserDateJoin(String dateJoin) {
        return null;
    }

    public List<Topic_User> getAllTopicUserDateJoin(String dateJoin, int numPage, int pageOne) {
        return null;
    }

    public List<Topic_User> getAllTopicUser(int status, int numPage, int pageOne) {
        return null;
    }

    /**
     *Lấy danh sách những User đã join vào topic và được chấp nhận
     * @param postID
     * @return List<Topic_User>
     */
    @Override
    public List<Topic_User> getAllUserJoinTopicWithPostID(int postID,int status) {
        String sql = "SELECT topic_user.`Post_ID`, topic_user.`User_ID`, topic_user.`Date_Join`, topic_user.`Status`, users.`User_ID`," +
                " users.`First_Name`, users.`Last_Name`, users.`Gender`, users.`Email`, users.`User_Role`, users.`Activation_Date`," +
                " users.`Avatar`, users.`Address`, users.`Phone_Number`, users.`Birthday`, users.`Job`, users.`Country`, users.`Website`, users.`Status`" +
                "FROM `topic_user` " +
                "INNER JOIN `users` ON users.`User_ID` = `topic_user`.`User_ID` " +
                "INNER JOIN `posts` ON `topic_user`.`Post_ID` = `posts`.`Post_ID` " +
                "WHERE `topic_user`.`Post_ID` = "+postID+" AND `topic_user`.`Status` = "+status+" ";
        List<Topic_User> topicUserList = jdbcTemplate.query(sql, new RowMapper<Topic_User>() {
            // RowMapper de get 1 list<DATA>
            public Topic_User mapRow(ResultSet rs, int rowNum) throws SQLException {

                Users users = new Users();
                users.setUser_ID(rs.getInt(5));
                users.setFirst_Name(rs.getString(6));
                users.setLast_Name(rs.getString(7));
                users.setGender(rs.getInt(8));
                users.setEmail(rs.getString(9));
                users.setUser_Role(rs.getString(10));
                users.setActivation_Date(rs.getString(11));
                users.setAvatar(rs.getString(12));
                users.setAddress(rs.getString(13));
                users.setPhone_Number(rs.getString(14));
                users.setBirthday(rs.getString(15));
                users.setJob(rs.getString(16));
                users.setCountry(rs.getString(17));
                users.setWebsite(rs.getString(18));
                users.setStatus(rs.getInt(19));

                Topic_User topic_user  = new Topic_User();
                topic_user.setUser_ID(users);
                topic_user.setStatus(rs.getInt(4));
                topic_user.setDate_Join(rs.getString(3));
                return topic_user;
            }
        });
        return topicUserList;

    }

    @Override
    public List<Topic_User> getAllUserJoinTopicWithPostID(int postID) {
        String sql = "SELECT topic_user.`Post_ID`, topic_user.`User_ID`, topic_user.`Date_Join`, topic_user.`Status`, users.`User_ID`," +
                " users.`First_Name`, users.`Last_Name`, users.`Gender`, users.`Email`, users.`User_Role`, users.`Activation_Date`," +
                " users.`Avatar`, users.`Address`, users.`Phone_Number`, users.`Birthday`, users.`Job`, users.`Country`, users.`Website`, users.`Status`" +
                "FROM `topic_user` " +
                "INNER JOIN `users` ON users.`User_ID` = `topic_user`.`User_ID` " +
                "INNER JOIN `posts` ON `topic_user`.`Post_ID` = `posts`.`Post_ID` " +
                "WHERE `topic_user`.`Post_ID` = "+postID+" ";
        List<Topic_User> topicUserList = jdbcTemplate.query(sql, new RowMapper<Topic_User>() {
            // RowMapper de get 1 list<DATA>
            public Topic_User mapRow(ResultSet rs, int rowNum) throws SQLException {

                Users users = new Users();
                users.setUser_ID(rs.getInt(5));
                users.setFirst_Name(rs.getString(6));
                users.setLast_Name(rs.getString(7));
                users.setGender(rs.getInt(8));
                users.setEmail(rs.getString(9));
                users.setUser_Role(rs.getString(10));
                users.setActivation_Date(rs.getString(11));
                users.setAvatar(rs.getString(12));
                users.setAddress(rs.getString(13));
                users.setPhone_Number(rs.getString(14));
                users.setBirthday(rs.getString(15));
                users.setJob(rs.getString(16));
                users.setCountry(rs.getString(17));
                users.setWebsite(rs.getString(18));
                users.setStatus(rs.getInt(19));

                Topic_User topic_user  = new Topic_User();
                topic_user.setUser_ID(users);
                topic_user.setStatus(rs.getInt(4));
                topic_user.setDate_Join(rs.getString(3));
                return topic_user;
            }
        });
        return topicUserList;

    }
    @Override
    public List<Topic_User> getAllUserJoinTopic(int userID, int status) {
        String sql = "SELECT " +
                "topic_user.`Post_ID`,topic_user.`User_ID`,topic_user.`Date_Join`,topic_user.`Status`, " +
                "us1.`User_ID`, us1.`First_Name`, us1.`Last_Name`, us1.`Gender`, us1.`Email`, us1.`User_Role`, us1.`Activation_Date`, " +
                "us1.`Avatar`, us1.`Address`, us1.`Phone_Number`, us1.`Birthday`, us1.`Job`, us1.`Country`, us1.`Website`, us1.`Status`, " +
                "posts.`Post_ID`, posts.`Post_Name` " +
                "FROM `topic_user` " +
                "INNER JOIN `users` AS us1 ON us1.`User_ID` = `topic_user`.`User_ID` " +
                "INNER JOIN `posts` ON `topic_user`.`Post_ID` = `posts`.`Post_ID` " +
                "INNER JOIN `users` AS us2 ON `posts`.`User_ID` = us2.`User_ID` " +
                "WHERE `topic_user`.`Status` = "+status+" AND us2.`User_ID` = "+userID+" ";
        List<Topic_User> topicUserList = jdbcTemplate.query(sql, new RowMapper<Topic_User>() {
            // RowMapper de get 1 list<DATA>
            public Topic_User mapRow(ResultSet rs, int rowNum) throws SQLException {

                Users users = new Users();
                users.setUser_ID(rs.getInt("User_ID"));
                users.setFirst_Name(rs.getString("First_Name"));
                users.setLast_Name(rs.getString("Last_Name"));
                users.setGender(rs.getInt("Gender"));
                users.setEmail(rs.getString("Email"));
                users.setUser_Role(rs.getString("User_Role"));
                users.setActivation_Date(rs.getString("Activation_Date"));
                users.setAvatar(rs.getString("Avatar"));
                users.setAddress(rs.getString("Address"));
                users.setPhone_Number(rs.getString("Phone_Number"));
                users.setBirthday(rs.getString("Birthday"));
                users.setJob(rs.getString("Job"));
                users.setCountry(rs.getString("Country"));
                users.setWebsite(rs.getString("Website"));
                users.setStatus(rs.getInt("Status"));

                Posts post = new Posts();
                post.setPost_ID(rs.getInt("Post_ID"));
                post.setPost_Name(rs.getString("Post_Name"));

                Topic_User topic_user  = new Topic_User();
                topic_user.setUser_ID(users);
                topic_user.setPost_ID(post);
                topic_user.setStatus(rs.getInt(4));
                topic_user.setDate_Join(rs.getString(3));
                return topic_user;
            }
        });
        return topicUserList;
    }

    @Override
    public List<Topic_User> getTopicWithUser(int userID) {
        String sql ="SELECT posts.`Post_ID`,posts.`Post_Name`, `topic_user`.`Date_Join`, `topic_user`.`Status` " +
                "FROM `topic_user` " +
                "INNER JOIN posts ON `topic_user`.`Post_ID` = posts.`Post_ID` " +
                "WHERE `topic_user`.`User_ID` = "+userID+"";
        List<Topic_User> topicUserList = jdbcTemplate.query(sql, new RowMapper<Topic_User>() {
            // RowMapper de get 1 list<DATA>
            public Topic_User mapRow(ResultSet rs, int rowNum) throws SQLException {

                Posts post = new Posts();
                post.setPost_ID(rs.getInt(1));
                post.setPost_Name(rs.getString(2));

                Topic_User topic_user  = new Topic_User();
                topic_user.setStatus(rs.getInt(4));
                topic_user.setDate_Join(rs.getString(3));
                topic_user.setPost_ID(post);
                return topic_user;
            }
        });
        return topicUserList;

    }

    @Override
    public List<Topic_User> getTopicWithUser(int userID, int numPage, int pageOne) {
        String sql ="SELECT posts.`Post_ID`,posts.`Post_Name`, `topic_user`.`Date_Join`, `topic_user`.`Status` " +
                "FROM `topic_user` " +
                "INNER JOIN posts ON `topic_user`.`Post_ID` = posts.`Post_ID` " +
                "WHERE `topic_user`.`User_ID` = "+userID+" "+
                "LIMIT " +(numPage*pageOne)+ "," +pageOne+ " ";;
        List<Topic_User> topicUserList = jdbcTemplate.query(sql, new RowMapper<Topic_User>() {
            // RowMapper de get 1 list<DATA>
            public Topic_User mapRow(ResultSet rs, int rowNum) throws SQLException {

                Posts post = new Posts();
                post.setPost_ID(rs.getInt(1));
                post.setPost_Name(rs.getString(2));

                Topic_User topic_user  = new Topic_User();
                topic_user.setStatus(rs.getInt(4));
                topic_user.setDate_Join(rs.getString(3));
                topic_user.setPost_ID(post);
                return topic_user;
            }
        });
        return topicUserList;
    }

    public Topic_User getTopicUser(int topicUser_ID) {
        return null;
    }

    @Override
    public Topic_User getTopicUserWithPostIdUserId(final int postId, final int userId) {
        String sql = "SELECT `Post_ID`, `User_ID`, `Date_Join`, `Status` " +
                "FROM `topic_user` " +
                "WHERE `Post_ID` = "+postId+" AND `User_ID` = "+userId+ " ";
        return jdbcTemplate.query(sql, new ResultSetExtractor<Topic_User>() {
            @Override
            public Topic_User extractData(ResultSet rs) throws SQLException, DataAccessException {
                if(rs.next()){
                    Topic_User topic_user = new Topic_User();
                    Posts posts = new Posts();
                    Users users = new Users();
                    posts = topicService.getPost(postId);
                    users = userService.getUser(userId);
                    topic_user.setPost_ID(posts);
                    topic_user.setUser_ID(users);
                    topic_user.setDate_Join(rs.getString("Date_Join"));
                    topic_user.setStatus(rs.getInt("Status"));
                    return topic_user;
                }
                return null;
            }
        });
    }

    public void saveAndUpdateTopicUser(int userID, int postID, String dateJoin, int status) {
        String sql  = "INSERT INTO `topic_user`(`Post_ID`, `User_ID`, `Date_Join`, `Status`) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql,postID,userID,dateJoin,status);
    }

    @Override
    public void updateTopicUser(int userID, int postID, int status) {
        String sql = "UPDATE `topic_user` SET `Status`=? WHERE `Post_ID`=? AND `User_ID`=?";
        jdbcTemplate.update(sql,status,postID,userID);
    }

    @Override
    public void deelteTopicUser(int userID, int postID) {
        String sql = "DELETE FROM `topic_user` WHERE `topic_user`.`Post_ID`= ? AND `topic_user`.`User_ID` = ?";
        jdbcTemplate.update(sql,postID,userID);
    }
}
