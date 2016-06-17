package com.projecttlc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.projecttlc.model.*;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;

public class PostDAOImpl implements PostDAO{
    private JdbcTemplate jdbcTemplate;

    public PostDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    public List<Posts> getAllPost() {
        String sql = "SELECT * FROM `posts` " +
                "INNER JOIN `categories` ON `posts`.`Cate_ID` = `categories`.`Cate_ID` " +
                "INNER JOIN users ON users.`User_ID` = posts.`User_ID` " +
                "ORDER BY `posts`.`Post_ID` DESC";
        List<Posts> listPost = jdbcTemplate.query(sql, new RowMapper<Posts>() {
            // RowMapper de get 1 list<DATA>
            public Posts mapRow(ResultSet rs, int rowNum) throws SQLException {
                Posts posts = new Posts();
                Categories categories = new Categories();
                categories.setCateId(rs.getInt(15));
                categories.setCateName(rs.getString(16));
                categories.setCateDesc(rs.getString(17));

                Users users = new Users();
                users.setUser_ID(rs.getInt(18));
                users.setFirst_Name(rs.getString(19));
                users.setLast_Name(rs.getString(20));
                users.setGender(rs.getInt(21));
                users.setEmail(rs.getString(22));
                users.setUser_Role(rs.getString(24));
                users.setActivation_Date(rs.getString(25));
                users.setAvatar(rs.getString(26));
                users.setAddress(rs.getString(27));
                users.setPhone_Number(rs.getString(28));
                users.setBirthday(rs.getString(29));
                users.setJob(rs.getString(30));
                users.setCountry(rs.getString(31));
                users.setWebsite(rs.getString(32));

                posts.setPost_ID(rs.getInt(1));
                posts.setPost_Name(rs.getString(2));
                posts.setCate_ID(categories);
                posts.setUser_ID(users);
                posts.setPost_Content(rs.getString(5));
                posts.setRule(rs.getString(6));
                posts.setDate_Start(rs.getString(7));
                posts.setDate_End(rs.getString(8));
                posts.setPublic_Date(rs.getString(9));
                posts.setLast_Edit(rs.getString(10));
                posts.setImage(rs.getString(11));
                posts.setNum_View(rs.getInt(12));
                posts.setStatus(rs.getInt(13));
                return posts;
            }
        });
        return listPost;
    }

    public List<Posts> getAllPost(int numPage, int pageOne) {
        String sql = "SELECT * FROM `posts` " +
                "INNER JOIN `categories` ON `posts`.`Cate_ID` = `categories`.`Cate_ID` " +
                "INNER JOIN users ON users.`User_ID` = posts.`User_ID`"+
                "ORDER BY `posts`.`Publish_Date` DESC " +
                "LIMIT " +(numPage*pageOne)+ "," +pageOne+ " ";
        List<Posts> listPost = jdbcTemplate.query(sql, new RowMapper<Posts>() {
            // RowMapper de get 1 list<DATA>
            public Posts mapRow(ResultSet rs, int rowNum) throws SQLException {
                Posts posts = new Posts();
                Categories categories = new Categories();
                categories.setCateId(rs.getInt(15));
                categories.setCateName(rs.getString(16));
                categories.setCateDesc(rs.getString(17));

                Users users = new Users();
                users.setUser_ID(rs.getInt(18));
                users.setFirst_Name(rs.getString(19));
                users.setLast_Name(rs.getString(20));
                users.setGender(rs.getInt(21));
                users.setEmail(rs.getString(22));
                users.setUser_Role(rs.getString(24));
                users.setActivation_Date(rs.getString(25));
                users.setAvatar(rs.getString(26));
                users.setAddress(rs.getString(27));
                users.setPhone_Number(rs.getString(28));
                users.setBirthday(rs.getString(29));
                users.setJob(rs.getString(30));
                users.setCountry(rs.getString(31));
                users.setWebsite(rs.getString(32));

                posts.setPost_ID(rs.getInt(1));
                posts.setPost_Name(rs.getString(2));
                posts.setCate_ID(categories);
                posts.setUser_ID(users);
                posts.setPost_Content(rs.getString(5));
                posts.setRule(rs.getString(6));
                posts.setDate_Start(rs.getString(7));
                posts.setDate_End(rs.getString(8));
                posts.setPublic_Date(rs.getString(9));
                posts.setLast_Edit(rs.getString(10));
                posts.setImage(rs.getString(11));
                posts.setNum_View(rs.getInt(12));
                posts.setStatus(rs.getInt(13));
                return posts;
            }
        });
        return listPost;
    }

    @Override
    public List<Posts> getAllPostStatus(int status) {
        String sql = "SELECT * FROM `posts` " +
                "INNER JOIN `categories` ON `posts`.`Cate_ID` = `categories`.`Cate_ID` " +
                "INNER JOIN users ON users.`User_ID` = posts.`User_ID` " +
                "WHERE posts.`Status` = " + status + " "+
                "ORDER BY `posts`.`Publish_Date` DESC ";
        List<Posts> listPost = jdbcTemplate.query(sql, new RowMapper<Posts>() {
            // RowMapper de get 1 list<DATA>
            public Posts mapRow(ResultSet rs, int rowNum) throws SQLException {
                Posts posts = new Posts();
                Categories categories = new Categories();
                categories.setCateId(rs.getInt(15));
                categories.setCateName(rs.getString(16));
                categories.setCateDesc(rs.getString(17));

                Users users = new Users();
                users.setUser_ID(rs.getInt(18));
                users.setFirst_Name(rs.getString(19));
                users.setLast_Name(rs.getString(20));
                users.setGender(rs.getInt(21));
                users.setEmail(rs.getString(22));
                users.setUser_Role(rs.getString(24));
                users.setActivation_Date(rs.getString(25));
                users.setAvatar(rs.getString(26));
                users.setAddress(rs.getString(27));
                users.setPhone_Number(rs.getString(28));
                users.setBirthday(rs.getString(29));
                users.setJob(rs.getString(30));
                users.setCountry(rs.getString(31));
                users.setWebsite(rs.getString(32));

                posts.setPost_ID(rs.getInt(1));
                posts.setPost_Name(rs.getString(2));
                posts.setCate_ID(categories);
                posts.setUser_ID(users);
                posts.setPost_Content(rs.getString(5));
                posts.setRule(rs.getString(6));
                posts.setDate_Start(rs.getString(7));
                posts.setDate_End(rs.getString(8));
                posts.setPublic_Date(rs.getString(9));
                posts.setLast_Edit(rs.getString(10));
                posts.setImage(rs.getString(11));
                posts.setNum_View(rs.getInt(12));
                posts.setStatus(rs.getInt(13));
                return posts;
            }
        });
        return listPost;
    }

    public List<Posts> getAllPostStatus(int status, int numPage, int pageOne) {
        String sql = "SELECT * FROM `posts` " +
                "INNER JOIN `categories` ON `posts`.`Cate_ID` = `categories`.`Cate_ID` " +
                "INNER JOIN users ON users.`User_ID` = posts.`User_ID`"+
                "WHERE posts.`Status` =" + status + " " +
                "ORDER BY `posts`.`Publish_Date` DESC " +
                "LIMIT " +(numPage*pageOne)+ "," +pageOne+ " ";
        List<Posts> listPost = jdbcTemplate.query(sql, new RowMapper<Posts>() {
            // RowMapper de get 1 list<DATA>
            public Posts mapRow(ResultSet rs, int rowNum) throws SQLException {
                Posts posts = new Posts();
                Categories categories = new Categories();
                categories.setCateId(rs.getInt(15));
                categories.setCateName(rs.getString(16));
                categories.setCateDesc(rs.getString(17));

                Users users = new Users();
                users.setUser_ID(rs.getInt(18));
                users.setFirst_Name(rs.getString(19));
                users.setLast_Name(rs.getString(20));
                users.setGender(rs.getInt(21));
                users.setEmail(rs.getString(22));
                users.setUser_Role(rs.getString(24));
                users.setActivation_Date(rs.getString(25));
                users.setAvatar(rs.getString(26));
                users.setAddress(rs.getString(27));
                users.setPhone_Number(rs.getString(28));
                users.setBirthday(rs.getString(29));
                users.setJob(rs.getString(30));
                users.setCountry(rs.getString(31));
                users.setWebsite(rs.getString(32));

                posts.setPost_ID(rs.getInt(1));
                posts.setPost_Name(rs.getString(2));
                posts.setCate_ID(categories);
                posts.setUser_ID(users);
                posts.setPost_Content(rs.getString(5));
                posts.setRule(rs.getString(6));
                posts.setDate_Start(rs.getString(7));
                posts.setDate_End(rs.getString(8));
                posts.setPublic_Date(rs.getString(9));
                posts.setLast_Edit(rs.getString(10));
                posts.setImage(rs.getString(11));
                posts.setNum_View(rs.getInt(12));
                posts.setStatus(rs.getInt(13));
                return posts;
            }
        });
        return listPost;
    }

    @Override
    public List<Posts> getAllPostStatus(int userID, int status) {
        String sql = "SELECT * FROM `posts` " +
                "INNER JOIN `categories` ON `posts`.`Cate_ID` = `categories`.`Cate_ID` " +
                "INNER JOIN users ON users.`User_ID` = posts.`User_ID` " +
                "WHERE posts.`Status` = " + status + " AND posts.`User_ID`= "+userID+" "+
                "ORDER BY `posts`.`Publish_Date` DESC ";
        List<Posts> listPost = jdbcTemplate.query(sql, new RowMapper<Posts>() {
            // RowMapper de get 1 list<DATA>
            public Posts mapRow(ResultSet rs, int rowNum) throws SQLException {
                Posts posts = new Posts();
                Categories categories = new Categories();
                categories.setCateId(rs.getInt(15));
                categories.setCateName(rs.getString(16));
                categories.setCateDesc(rs.getString(17));

                Users users = new Users();
                users.setUser_ID(rs.getInt(18));
                users.setFirst_Name(rs.getString(19));
                users.setLast_Name(rs.getString(20));
                users.setGender(rs.getInt(21));
                users.setEmail(rs.getString(22));
                users.setUser_Role(rs.getString(24));
                users.setActivation_Date(rs.getString(25));
                users.setAvatar(rs.getString(26));
                users.setAddress(rs.getString(27));
                users.setPhone_Number(rs.getString(28));
                users.setBirthday(rs.getString(29));
                users.setJob(rs.getString(30));
                users.setCountry(rs.getString(31));
                users.setWebsite(rs.getString(32));

                posts.setPost_ID(rs.getInt(1));
                posts.setPost_Name(rs.getString(2));
                posts.setCate_ID(categories);
                posts.setUser_ID(users);
                posts.setPost_Content(rs.getString(5));
                posts.setRule(rs.getString(6));
                posts.setDate_Start(rs.getString(7));
                posts.setDate_End(rs.getString(8));
                posts.setPublic_Date(rs.getString(9));
                posts.setLast_Edit(rs.getString(10));
                posts.setImage(rs.getString(11));
                posts.setNum_View(rs.getInt(12));
                posts.setStatus(rs.getInt(13));
                return posts;
            }
        });
        return listPost;
    }

    @Override
    public List<Posts> getAllPostStatus(int userID, int status, int numPage, int pageOne) {
        return null;
    }

    public List<Posts> getAllPostDateEnd() {
        // TODO Auto-generated method stub
        return null;
    }


    public List<Posts> getAllPostCate(int cate_ID,int status) {
        String sql = "SELECT * FROM `posts` " +
                "INNER JOIN `categories` ON `posts`.`Cate_ID` = `categories`.`Cate_ID` " +
                "INNER JOIN users ON users.`User_ID` = posts.`User_ID`"+
                "WHERE posts.`Cate_ID` =" + cate_ID + " AND posts.`Status` = " + status + " " +
                "ORDER BY `posts`.`Publish_Date` DESC " ;
        List<Posts> listPost = jdbcTemplate.query(sql, new RowMapper<Posts>() {
            // RowMapper de get 1 list<DATA>
            public Posts mapRow(ResultSet rs, int rowNum) throws SQLException {
                Posts posts = new Posts();
                Categories categories = new Categories();
                categories.setCateId(rs.getInt(15));
                categories.setCateName(rs.getString(16));
                categories.setCateDesc(rs.getString(17));

                Users users = new Users();
                users.setUser_ID(rs.getInt(18));
                users.setFirst_Name(rs.getString(19));
                users.setLast_Name(rs.getString(20));
                users.setGender(rs.getInt(21));
                users.setEmail(rs.getString(22));
                users.setUser_Role(rs.getString(24));
                users.setActivation_Date(rs.getString(25));
                users.setAvatar(rs.getString(26));
                users.setAddress(rs.getString(27));
                users.setPhone_Number(rs.getString(28));
                users.setBirthday(rs.getString(29));
                users.setJob(rs.getString(30));
                users.setCountry(rs.getString(31));
                users.setWebsite(rs.getString(32));

                posts.setPost_ID(rs.getInt(1));
                posts.setPost_Name(rs.getString(2));
                posts.setCate_ID(categories);
                posts.setUser_ID(users);
                posts.setPost_Content(rs.getString(5));
                posts.setRule(rs.getString(6));
                posts.setDate_Start(rs.getString(7));
                posts.setDate_End(rs.getString(8));
                posts.setPublic_Date(rs.getString(9));
                posts.setLast_Edit(rs.getString(10));
                posts.setImage(rs.getString(11));
                posts.setNum_View(rs.getInt(12));
                posts.setStatus(rs.getInt(13));
                return posts;
            }
        });
        return listPost;
    }
    public List<Posts> getAllPostCate(int cate_ID,int status, int numPage, int pageOne) {
        String sql = "SELECT * FROM `posts` " +
                "INNER JOIN `categories` ON `posts`.`Cate_ID` = `categories`.`Cate_ID` " +
                "INNER JOIN users ON users.`User_ID` = posts.`User_ID`"+
                "WHERE posts.`Cate_ID` =" + cate_ID + " AND posts.`Status` = " + status + " " +
                "ORDER BY `posts`.`Publish_Date` DESC " +
                "LIMIT " +(numPage*pageOne)+ "," +pageOne+ " ";
        List<Posts> listPost = jdbcTemplate.query(sql, new RowMapper<Posts>() {
            // RowMapper de get 1 list<DATA>
            public Posts mapRow(ResultSet rs, int rowNum) throws SQLException {
                Posts posts = new Posts();
                Categories categories = new Categories();
                categories.setCateId(rs.getInt(15));
                categories.setCateName(rs.getString(16));
                categories.setCateDesc(rs.getString(17));

                Users users = new Users();
                users.setUser_ID(rs.getInt(18));
                users.setFirst_Name(rs.getString(19));
                users.setLast_Name(rs.getString(20));
                users.setGender(rs.getInt(21));
                users.setEmail(rs.getString(22));
                users.setUser_Role(rs.getString(24));
                users.setActivation_Date(rs.getString(25));
                users.setAvatar(rs.getString(26));
                users.setAddress(rs.getString(27));
                users.setPhone_Number(rs.getString(28));
                users.setBirthday(rs.getString(29));
                users.setJob(rs.getString(30));
                users.setCountry(rs.getString(31));
                users.setWebsite(rs.getString(32));

                posts.setPost_ID(rs.getInt(1));
                posts.setPost_Name(rs.getString(2));
                posts.setCate_ID(categories);
                posts.setUser_ID(users);
                posts.setPost_Content(rs.getString(5));
                posts.setRule(rs.getString(6));
                posts.setDate_Start(rs.getString(7));
                posts.setDate_End(rs.getString(8));
                posts.setPublic_Date(rs.getString(9));
                posts.setLast_Edit(rs.getString(10));
                posts.setImage(rs.getString(11));
                posts.setNum_View(rs.getInt(12));
                posts.setStatus(rs.getInt(13));
                return posts;
            }
        });
        return listPost;
    }

    public List<Posts> getAllPostPostLocal(int postLocal_ID) {
        String sql = "SELECT * FROM `posts` " +
                "INNER JOIN `categories` AS cate1 ON `posts`.`Cate_ID` = cate1.`Cate_ID` " +
                "INNER JOIN users AS us1 ON us1.`User_ID` = posts.`User_ID` " +
                "INNER JOIN postslocal ON postslocal.Post_ID = posts.`PostLocal_ID` " +
                "INNER JOIN `categories` AS cate2 ON `postslocal`.`Cate_ID` = cate2.`Cate_ID` " +
                "INNER JOIN users AS us2 ON us2.`User_ID` = postslocal.`User_ID` " +
                "WHERE postslocal.Post_ID = "+postLocal_ID+" ";
        List<Posts> listPost = jdbcTemplate.query(sql, new RowMapper<Posts>() {
            // RowMapper de get 1 list<DATA>
            public Posts mapRow(ResultSet rs, int rowNum) throws SQLException {

                Categories categoriesPostLocal = new Categories();
                categoriesPostLocal.setCateId(rs.getInt(44));
                categoriesPostLocal.setCateName(rs.getString(45));
                categoriesPostLocal.setCateDesc(rs.getString(46));

                Categories categoriesPostTopic = new Categories();
                categoriesPostTopic.setCateId(rs.getInt(15));
                categoriesPostTopic.setCateName(rs.getString(16));
                categoriesPostTopic.setCateDesc(rs.getString(17));

                Users usersPostLocal = new Users();
                usersPostLocal.setUser_ID(rs.getInt(47));
                usersPostLocal.setFirst_Name(rs.getString(48));
                usersPostLocal.setLast_Name(rs.getString(49));
                usersPostLocal.setGender(rs.getInt(50));
                usersPostLocal.setEmail(rs.getString(51));
                usersPostLocal.setUser_Role(rs.getString(53));
                usersPostLocal.setActivation_Date(rs.getString(54));
                usersPostLocal.setAvatar(rs.getString(55));
                usersPostLocal.setAddress(rs.getString(56));
                usersPostLocal.setPhone_Number(rs.getString(57));
                usersPostLocal.setBirthday(rs.getString(58));
                usersPostLocal.setJob(rs.getString(59));
                usersPostLocal.setCountry(rs.getString(60));
                usersPostLocal.setWebsite(rs.getString(61));
                usersPostLocal.setStatus(rs.getInt(62));

                Users usersPostTopic = new Users();
                usersPostTopic.setUser_ID(rs.getInt(18));
                usersPostTopic.setFirst_Name(rs.getString(19));
                usersPostTopic.setLast_Name(rs.getString(20));
                usersPostTopic.setGender(rs.getInt(21));
                usersPostTopic.setEmail(rs.getString(22));
                usersPostTopic.setUser_Role(rs.getString(24));
                usersPostTopic.setActivation_Date(rs.getString(25));
                usersPostTopic.setAvatar(rs.getString(26));
                usersPostTopic.setAddress(rs.getString(27));
                usersPostTopic.setPhone_Number(rs.getString(28));
                usersPostTopic.setBirthday(rs.getString(29));
                usersPostTopic.setJob(rs.getString(30));
                usersPostTopic.setCountry(rs.getString(31));
                usersPostTopic.setWebsite(rs.getString(32));
                usersPostTopic.setStatus(rs.getInt(33));

                Posts_Local posts_local = new Posts_Local();
                posts_local.setPost_ID(rs.getInt(34));
                posts_local.setPost_Name(rs.getString(35));
                posts_local.setCate_ID(categoriesPostLocal);
                posts_local.setUser_ID(usersPostLocal);
                posts_local.setPost_Content(rs.getString(38));
                posts_local.setPublic_Date(rs.getString(39));
                posts_local.setLast_Edit(rs.getString(40));
                posts_local.setImage(rs.getString(41));
                posts_local.setNum_View(rs.getInt(42));
                posts_local.setStatus(rs.getInt(43));

                Posts posts = new Posts();
                posts.setPost_ID(rs.getInt(1));
                posts.setPost_Name(rs.getString(2));
                posts.setCate_ID(categoriesPostTopic);
                posts.setUser_ID(usersPostTopic);
                posts.setPost_Content(rs.getString(5));
                posts.setRule(rs.getString(6));
                posts.setDate_Start(rs.getString(7));
                posts.setDate_End(rs.getString(8));
                posts.setPublic_Date(rs.getString(9));
                posts.setLast_Edit(rs.getString(10));
                posts.setImage(rs.getString(11));
                posts.setNum_View(rs.getInt(12));
                posts.setStatus(rs.getInt(13));
                posts.setPostLocal(posts_local);

                return posts;
            }
        });
        return listPost;
    }

    public List<Posts> getAllPostPostLocal(int postLocal_ID,int numPage, int pageOne) {
        String sql = "SELECT * FROM `posts` " +
                "INNER JOIN `categories` AS cate1 ON `posts`.`Cate_ID` = cate1.`Cate_ID` " +
                "INNER JOIN users AS us1 ON us1.`User_ID` = posts.`User_ID` " +
                "INNER JOIN postslocal ON postslocal.Post_ID = posts.`PostLocal_ID` " +
                "INNER JOIN `categories` AS cate2 ON `postslocal`.`Cate_ID` = cate2.`Cate_ID` " +
                "INNER JOIN users AS us2 ON us2.`User_ID` = postslocal.`User_ID` " +
                "WHERE postslocal.Post_ID = "+postLocal_ID+" "+
                "ORDER BY `posts`.`Publish_Date` DESC " +
                "LIMIT " +(numPage*pageOne)+ "," +pageOne+ " ";
        List<Posts> listPost = jdbcTemplate.query(sql, new RowMapper<Posts>() {
            // RowMapper de get 1 list<DATA>
            public Posts mapRow(ResultSet rs, int rowNum) throws SQLException {

                Categories categoriesPostLocal = new Categories();
                categoriesPostLocal.setCateId(rs.getInt(44));
                categoriesPostLocal.setCateName(rs.getString(45));
                categoriesPostLocal.setCateDesc(rs.getString(46));

                Categories categoriesPostTopic = new Categories();
                categoriesPostTopic.setCateId(rs.getInt(15));
                categoriesPostTopic.setCateName(rs.getString(16));
                categoriesPostTopic.setCateDesc(rs.getString(17));

                Users usersPostLocal = new Users();
                usersPostLocal.setUser_ID(rs.getInt(47));
                usersPostLocal.setFirst_Name(rs.getString(48));
                usersPostLocal.setLast_Name(rs.getString(49));
                usersPostLocal.setGender(rs.getInt(50));
                usersPostLocal.setEmail(rs.getString(51));
                usersPostLocal.setUser_Role(rs.getString(53));
                usersPostLocal.setActivation_Date(rs.getString(54));
                usersPostLocal.setAvatar(rs.getString(55));
                usersPostLocal.setAddress(rs.getString(56));
                usersPostLocal.setPhone_Number(rs.getString(57));
                usersPostLocal.setBirthday(rs.getString(58));
                usersPostLocal.setJob(rs.getString(59));
                usersPostLocal.setCountry(rs.getString(60));
                usersPostLocal.setWebsite(rs.getString(61));
                usersPostLocal.setStatus(rs.getInt(62));

                Users usersPostTopic = new Users();
                usersPostTopic.setUser_ID(rs.getInt(18));
                usersPostTopic.setFirst_Name(rs.getString(19));
                usersPostTopic.setLast_Name(rs.getString(20));
                usersPostTopic.setGender(rs.getInt(21));
                usersPostTopic.setEmail(rs.getString(22));
                usersPostTopic.setUser_Role(rs.getString(24));
                usersPostTopic.setActivation_Date(rs.getString(25));
                usersPostTopic.setAvatar(rs.getString(26));
                usersPostTopic.setAddress(rs.getString(27));
                usersPostTopic.setPhone_Number(rs.getString(28));
                usersPostTopic.setBirthday(rs.getString(29));
                usersPostTopic.setJob(rs.getString(30));
                usersPostTopic.setCountry(rs.getString(31));
                usersPostTopic.setWebsite(rs.getString(32));
                usersPostTopic.setStatus(rs.getInt(33));

                Posts_Local posts_local = new Posts_Local();
                posts_local.setPost_ID(rs.getInt(34));
                posts_local.setPost_Name(rs.getString(35));
                posts_local.setCate_ID(categoriesPostLocal);
                posts_local.setUser_ID(usersPostLocal);
                posts_local.setPost_Content(rs.getString(38));
                posts_local.setPublic_Date(rs.getString(39));
                posts_local.setLast_Edit(rs.getString(40));
                posts_local.setImage(rs.getString(41));
                posts_local.setNum_View(rs.getInt(42));
                posts_local.setStatus(rs.getInt(43));

                Posts posts = new Posts();
                posts.setPost_ID(rs.getInt(1));
                posts.setPost_Name(rs.getString(2));
                posts.setCate_ID(categoriesPostTopic);
                posts.setUser_ID(usersPostTopic);
                posts.setPost_Content(rs.getString(5));
                posts.setRule(rs.getString(6));
                posts.setDate_Start(rs.getString(7));
                posts.setDate_End(rs.getString(8));
                posts.setPublic_Date(rs.getString(9));
                posts.setLast_Edit(rs.getString(10));
                posts.setImage(rs.getString(11));
                posts.setNum_View(rs.getInt(12));
                posts.setStatus(rs.getInt(13));
                posts.setPostLocal(posts_local);
                return posts;
            }
        });
        return listPost;
    }

    @Override
    public List<Posts> getAllPostWithUserID(int userID) {
        String sql = "SELECT * FROM `posts` " +
                "INNER JOIN `categories` AS cate1 ON `posts`.`Cate_ID` = cate1.`Cate_ID` " +
                "INNER JOIN users AS us1 ON us1.`User_ID` = posts.`User_ID` " +
                "WHERE posts.User_ID = "+userID+" " +
                "ORDER BY `posts`.`Publish_Date` DESC ";
        List<Posts> listPost = jdbcTemplate.query(sql, new RowMapper<Posts>() {
            // RowMapper de get 1 list<DATA>
            public Posts mapRow(ResultSet rs, int rowNum) throws SQLException {



                Categories categoriesPostTopic = new Categories();
                categoriesPostTopic.setCateId(rs.getInt(15));
                categoriesPostTopic.setCateName(rs.getString(16));
                categoriesPostTopic.setCateDesc(rs.getString(17));


                Users usersPostTopic = new Users();
                usersPostTopic.setUser_ID(rs.getInt(18));
                usersPostTopic.setFirst_Name(rs.getString(19));
                usersPostTopic.setLast_Name(rs.getString(20));
                usersPostTopic.setGender(rs.getInt(21));
                usersPostTopic.setEmail(rs.getString(22));
                usersPostTopic.setUser_Role(rs.getString(24));
                usersPostTopic.setActivation_Date(rs.getString(25));
                usersPostTopic.setAvatar(rs.getString(26));
                usersPostTopic.setAddress(rs.getString(27));
                usersPostTopic.setPhone_Number(rs.getString(28));
                usersPostTopic.setBirthday(rs.getString(29));
                usersPostTopic.setJob(rs.getString(30));
                usersPostTopic.setCountry(rs.getString(31));
                usersPostTopic.setWebsite(rs.getString(32));


                Posts posts = new Posts();
                posts.setPost_ID(rs.getInt(1));
                posts.setPost_Name(rs.getString(2));
                posts.setCate_ID(categoriesPostTopic);
                posts.setUser_ID(usersPostTopic);
                posts.setPost_Content(rs.getString(5));
                posts.setRule(rs.getString(6));
                posts.setDate_Start(rs.getString(7));
                posts.setDate_End(rs.getString(8));
                posts.setPublic_Date(rs.getString(9));
                posts.setLast_Edit(rs.getString(10));
                posts.setImage(rs.getString(11));
                posts.setNum_View(rs.getInt(12));
                posts.setStatus(rs.getInt(13));
                return posts;
            }
        });
        return listPost;
    }

    @Override
    public List<Posts> getAllPostWithUserID(int userID, int numPage, int pageOne) {
        String sql = "SELECT * FROM `posts` " +
                "INNER JOIN `categories` AS cate1 ON `posts`.`Cate_ID` = cate1.`Cate_ID` " +
                "INNER JOIN users AS us1 ON us1.`User_ID` = posts.`User_ID` " +
                "WHERE posts.User_ID = "+userID+" ORDER BY `posts`.`Publish_Date` DESC " +
                "LIMIT " +(numPage*pageOne)+ "," +pageOne+ " ";
        List<Posts> listPost = jdbcTemplate.query(sql, new RowMapper<Posts>() {
            // RowMapper de get 1 list<DATA>
            public Posts mapRow(ResultSet rs, int rowNum) throws SQLException {



                Categories categoriesPostTopic = new Categories();
                categoriesPostTopic.setCateId(rs.getInt(15));
                categoriesPostTopic.setCateName(rs.getString(16));
                categoriesPostTopic.setCateDesc(rs.getString(17));


                Users usersPostTopic = new Users();
                usersPostTopic.setUser_ID(rs.getInt(18));
                usersPostTopic.setFirst_Name(rs.getString(19));
                usersPostTopic.setLast_Name(rs.getString(20));
                usersPostTopic.setGender(rs.getInt(21));
                usersPostTopic.setEmail(rs.getString(22));
                usersPostTopic.setUser_Role(rs.getString(24));
                usersPostTopic.setActivation_Date(rs.getString(25));
                usersPostTopic.setAvatar(rs.getString(26));
                usersPostTopic.setAddress(rs.getString(27));
                usersPostTopic.setPhone_Number(rs.getString(28));
                usersPostTopic.setBirthday(rs.getString(29));
                usersPostTopic.setJob(rs.getString(30));
                usersPostTopic.setCountry(rs.getString(31));
                usersPostTopic.setWebsite(rs.getString(32));


                Posts posts = new Posts();
                posts.setPost_ID(rs.getInt(1));
                posts.setPost_Name(rs.getString(2));
                posts.setCate_ID(categoriesPostTopic);
                posts.setUser_ID(usersPostTopic);
                posts.setPost_Content(rs.getString(5));
                posts.setRule(rs.getString(6));
                posts.setDate_Start(rs.getString(7));
                posts.setDate_End(rs.getString(8));
                posts.setPublic_Date(rs.getString(9));
                posts.setLast_Edit(rs.getString(10));
                posts.setImage(rs.getString(11));
                posts.setNum_View(rs.getInt(12));
                posts.setStatus(rs.getInt(13));
                return posts;
            }
        });
        return listPost;
    }

    public Posts getPost(int posts) {
        String sql = "SELECT * FROM `posts` " +
                "INNER JOIN `categories` ON `posts`.`Cate_ID` = `categories`.`Cate_ID` " +
                "INNER JOIN users ON users.`User_ID` = posts.`User_ID` " +
                "WHERE posts.`Post_ID`= "+posts+" ";
        return jdbcTemplate.query(sql, new ResultSetExtractor<Posts>() {
            public Posts extractData(ResultSet rs) throws SQLException, DataAccessException {
                if(rs.next()){
                    Posts posts = new Posts();
                    Categories categories = new Categories();
                    categories.setCateId(rs.getInt(15));
                    categories.setCateName(rs.getString(16));
                    categories.setCateDesc(rs.getString(17));

                    Users users = new Users();
                    users.setUser_ID(rs.getInt(18));
                    users.setFirst_Name(rs.getString(19));
                    users.setLast_Name(rs.getString(20));
                    users.setGender(rs.getInt(21));
                    users.setEmail(rs.getString(22));
                    users.setUser_Role(rs.getString(24));
                    users.setActivation_Date(rs.getString(25));
                    users.setAvatar(rs.getString(26));
                    users.setAddress(rs.getString(27));
                    users.setPhone_Number(rs.getString(28));
                    users.setBirthday(rs.getString(29));
                    users.setJob(rs.getString(30));
                    users.setCountry(rs.getString(31));
                    users.setWebsite(rs.getString(32));

                    posts.setPost_ID(rs.getInt(1));
                    posts.setPost_Name(rs.getString(2));
                    posts.setCate_ID(categories);
                    posts.setUser_ID(users);
                    posts.setPost_Content(rs.getString(5));
                    posts.setRule(rs.getString(6));
                    posts.setDate_Start(rs.getString(7));
                    posts.setDate_End(rs.getString(8));
                    posts.setPublic_Date(rs.getString(9));
                    posts.setLast_Edit(rs.getString(10));
                    posts.setImage(rs.getString(11));
                    posts.setNum_View(rs.getInt(12));
                    posts.setStatus(rs.getInt(13));

                    return posts;
                }
                return null;
            }
        });
    }
    public void saveOrUpdatePost(Posts post) {
        if(post.getPost_ID() > 0){
            if(post.getImage().equals("")){
                System.out.println("loi o 1");
                String sql = "UPDATE `posts` SET `Post_Name`=?,`Cate_ID`=?,`User_ID`=?,`Post_Content`=?,`Rules`=?,`Date_Start`=?," +
                        "`Date_End`=?,`Publish_Date`=?,`Last_Edit`=? WHERE `posts`.`Post_ID`=?";
                jdbcTemplate.update(sql,post.getPost_Name(),post.getCate_ID().getCateId(),post.getUser_ID().getUser_ID(),post.getPost_Content(),post.getRule(),post.getDate_Start(),
                        post.getDate_End(),post.getPublic_Date(),post.getLast_Edit(),post.getPost_ID());
                System.out.println("okie 1");
            } else {
                System.out.println("loi o 2");
                String sql = "UPDATE `posts` SET `Post_Name`=?,`Cate_ID`=?,`User_ID`=?,`Post_Content`=?,`Rules`=?,`Date_Start`=?," +
                        "`Date_End`=?,`Publish_Date`=?,`Last_Edit`=?,`Image`=? WHERE `posts`.`Post_ID`=?";
                jdbcTemplate.update(sql,post.getPost_Name(),post.getCate_ID().getCateId(),post.getUser_ID().getUser_ID(),post.getPost_Content(),post.getRule(),post.getDate_Start(),
                        post.getDate_End(),post.getPublic_Date(),post.getLast_Edit(),post.getImage() ,post.getPost_ID());
                System.out.println("okie 2");
            }

        } else {

            if (post.getPostLocal().getPost_ID() == 0) {
                String sql = "INSERT INTO `posts`(`Post_Name`, `Cate_ID`, `User_ID`, `Post_Content`, `Rules`, `Date_Start`," +
                        " `Date_End`, `Publish_Date`, `Last_Edit`, `Image`, `Num_Views`, `Status`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
                jdbcTemplate.update(sql,post.getPost_Name(),post.getCate_ID().getCateId(),post.getUser_ID().getUser_ID(),post.getPost_Content(),post.getRule(),post.getDate_Start(),
                        post.getDate_End(),post.getPublic_Date(),post.getLast_Edit(),post.getImage(),post.getNum_View(),post.getStatus());
            } else {
                String sql = "INSERT INTO `posts`(`Post_Name`, `Cate_ID`, `User_ID`, `Post_Content`, `Rules`, `Date_Start`," +
                        " `Date_End`, `Publish_Date`, `Last_Edit`, `Image`, `Num_Views`, `Status`, `PostLocal_ID`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
                jdbcTemplate.update(sql,post.getPost_Name(),post.getCate_ID().getCateId(),post.getUser_ID().getUser_ID(),post.getPost_Content(),post.getRule(),post.getDate_Start(),
                        post.getDate_End(),post.getPublic_Date(),post.getLast_Edit(),post.getImage(),post.getNum_View(),post.getStatus(), post.getPostLocal().getPost_ID() );
            }

        }

    }

    @Override
    public void increaseNumView(int post_ID,int numview) {
        String sql = "UPDATE `posts` SET `Num_Views`= ?  WHERE `posts`.`Post_ID`=?";
        jdbcTemplate.update(sql,numview,post_ID);
    }

    @Override
    public void editStatusPost(int post_ID, int status) {
        String sql = "UPDATE `posts` SET `Status`=?  WHERE `Post_ID`=?";
        jdbcTemplate.update(sql,status, post_ID);
    }

    @Override
    public void editPublicPost(int post_ID, String pubicDate, int status) {
        String sql = "UPDATE `posts` SET `Status`=?,`Publish_Date`=?  WHERE `Post_ID`=?";
        jdbcTemplate.update(sql,status, pubicDate, post_ID);
    }

    public void deletePost(int post_ID) {
        String sql = "DELETE FROM `posts` WHERE `Post_ID`=?";
        jdbcTemplate.update(sql, post_ID);
    }
}
