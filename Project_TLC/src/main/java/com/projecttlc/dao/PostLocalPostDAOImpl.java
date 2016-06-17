package com.projecttlc.dao;

import com.projecttlc.model.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by CHIP_IT_DVC on 19/02/2016.
 */
public class PostLocalPostDAOImpl implements PostLocalPostDAO {

    private JdbcTemplate jdbcTemplate;

    public PostLocalPostDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<PostLocal_Post> getAllPostLocalPost() {
        String sql = "SELECT * FROM `postlocal_post` " +
                "INNER JOIN postslocal ON postlocal_post.`PostLocal_ID` = postslocal.Post_ID " +
                "INNER JOIN posts ON postlocal_post.`Post_ID`= posts.Post_ID " +
                "INNER JOIN users AS us1 ON postslocal.User_ID = us1.User_ID " +
                "INNER JOIN categories AS cate1 ON postslocal.Cate_ID = cate1.Cate_ID " +
                "INNER JOIN users AS us2 ON posts.User_ID = us2.User_ID " +
                "INNER JOIN categories AS cate2 ON posts.Cate_ID = cate2.Cate_ID " +
                "ORDER BY `posts`.`Publish_Date` DESC ";
        List<PostLocal_Post> listpostLocalPost = jdbcTemplate.query(sql, new RowMapper<PostLocal_Post>() {
            // RowMapper de get 1 list<DATA>
            public PostLocal_Post mapRow(ResultSet rs, int rowNum) throws SQLException {

                Categories categoriesPostLocal = new Categories();
                categoriesPostLocal.setCateId(rs.getInt(42));
                categoriesPostLocal.setCateName(rs.getString(43));
                categoriesPostLocal.setCateDesc(rs.getString(44));

                Categories categoriesPostTopic = new Categories();
                categoriesPostTopic.setCateId(rs.getInt(60));
                categoriesPostTopic.setCateName(rs.getString(61));
                categoriesPostTopic.setCateDesc(rs.getString(62));

                Users usersPostLocal = new Users();
                usersPostLocal.setUser_ID(rs.getInt(27));
                usersPostLocal.setFirst_Name(rs.getString(28));
                usersPostLocal.setLast_Name(rs.getString(29));
                usersPostLocal.setGender(rs.getInt(30));
                usersPostLocal.setEmail(rs.getString(31));
                usersPostLocal.setUser_Role(rs.getString(33));
                usersPostLocal.setActivation_Date(rs.getString(34));
                usersPostLocal.setAvatar(rs.getString(35));
                usersPostLocal.setAddress(rs.getString(36));
                usersPostLocal.setPhone_Number(rs.getString(37));
                usersPostLocal.setBirthday(rs.getString(38));
                usersPostLocal.setJob(rs.getString(39));
                usersPostLocal.setCountry(rs.getString(40));
                usersPostLocal.setWebsite(rs.getString(41));

                Users usersPostTopic = new Users();
                usersPostTopic.setUser_ID(rs.getInt(45));
                usersPostTopic.setFirst_Name(rs.getString(46));
                usersPostTopic.setLast_Name(rs.getString(47));
                usersPostTopic.setGender(rs.getInt(48));
                usersPostTopic.setEmail(rs.getString(49));
                usersPostTopic.setUser_Role(rs.getString(51));
                usersPostTopic.setActivation_Date(rs.getString(52));
                usersPostTopic.setAvatar(rs.getString(53));
                usersPostTopic.setAddress(rs.getString(54));
                usersPostTopic.setPhone_Number(rs.getString(55));
                usersPostTopic.setBirthday(rs.getString(56));
                usersPostTopic.setJob(rs.getString(57));
                usersPostTopic.setCountry(rs.getString(58));
                usersPostTopic.setWebsite(rs.getString(59));

                Posts posts = new Posts();
                posts.setPost_ID(rs.getInt(14));
                posts.setPost_Name(rs.getString(15));
                posts.setCate_ID(categoriesPostTopic);
                posts.setUser_ID(usersPostTopic);
                posts.setPost_Content(rs.getString(18));
                posts.setRule(rs.getString(19));
                posts.setDate_Start(rs.getString(20));
                posts.setDate_End(rs.getString(21));
                posts.setPublic_Date(rs.getString(22));
                posts.setLast_Edit(rs.getString(23));
                posts.setImage(rs.getString(24));
                posts.setNum_View(rs.getInt(25));
                posts.setStatus(rs.getInt(26));

                Posts_Local posts_local = new Posts_Local();
                posts_local.setPost_ID(rs.getInt(4));
                posts_local.setPost_Name(rs.getString(5));
                posts_local.setCate_ID(categoriesPostLocal);
                posts_local.setUser_ID(usersPostLocal);
                posts_local.setPost_Content(rs.getString(8));
                posts_local.setPublic_Date(rs.getString(9));
                posts_local.setLast_Edit(rs.getString(10));
                posts_local.setImage(rs.getString(11));
                posts_local.setNum_View(rs.getInt(12));
                posts_local.setStatus(rs.getInt(13));

                PostLocal_Post postLocal_post = new PostLocal_Post();
                postLocal_post.setPostLocal_ID(posts_local);
                postLocal_post.setPost_ID(posts);
                postLocal_post.setStatus(rs.getInt(3));
                return postLocal_post;
            }
        });
        return listpostLocalPost;
    }

    public List<PostLocal_Post> getAllPostLocalPost(int numPage, int pageOne) {
        String sql = "SELECT * FROM `postlocal_post` " +
                "INNER JOIN postslocal ON postlocal_post.`PostLocal_ID` = postslocal.Post_ID " +
                "INNER JOIN posts ON postlocal_post.`Post_ID`= posts.Post_ID " +
                "INNER JOIN users AS us1 ON postslocal.User_ID = us1.User_ID " +
                "INNER JOIN categories AS cate1 ON postslocal.Cate_ID = cate1.Cate_ID " +
                "INNER JOIN users AS us2 ON posts.User_ID = us2.User_ID " +
                "INNER JOIN categories AS cate2 ON posts.Cate_ID = cate2.Cate_ID " +
                "ORDER BY `posts`.`Publish_Date` DESC " +
                "LIMIT " +(numPage*pageOne)+ "," +pageOne+ " ";;
        List<PostLocal_Post> listpostLocalPost = jdbcTemplate.query(sql, new RowMapper<PostLocal_Post>() {
            // RowMapper de get 1 list<DATA>
            public PostLocal_Post mapRow(ResultSet rs, int rowNum) throws SQLException {

                Categories categoriesPostLocal = new Categories();
                categoriesPostLocal.setCateId(rs.getInt(42));
                categoriesPostLocal.setCateName(rs.getString(43));
                categoriesPostLocal.setCateDesc(rs.getString(44));

                Categories categoriesPostTopic = new Categories();
                categoriesPostTopic.setCateId(rs.getInt(60));
                categoriesPostTopic.setCateName(rs.getString(61));
                categoriesPostTopic.setCateDesc(rs.getString(62));

                Users usersPostLocal = new Users();
                usersPostLocal.setUser_ID(rs.getInt(27));
                usersPostLocal.setFirst_Name(rs.getString(28));
                usersPostLocal.setLast_Name(rs.getString(29));
                usersPostLocal.setGender(rs.getInt(30));
                usersPostLocal.setEmail(rs.getString(31));
                usersPostLocal.setUser_Role(rs.getString(33));
                usersPostLocal.setActivation_Date(rs.getString(34));
                usersPostLocal.setAvatar(rs.getString(35));
                usersPostLocal.setAddress(rs.getString(36));
                usersPostLocal.setPhone_Number(rs.getString(37));
                usersPostLocal.setBirthday(rs.getString(38));
                usersPostLocal.setJob(rs.getString(39));
                usersPostLocal.setCountry(rs.getString(40));
                usersPostLocal.setWebsite(rs.getString(41));

                Users usersPostTopic = new Users();
                usersPostTopic.setUser_ID(rs.getInt(45));
                usersPostTopic.setFirst_Name(rs.getString(46));
                usersPostTopic.setLast_Name(rs.getString(47));
                usersPostTopic.setGender(rs.getInt(48));
                usersPostTopic.setEmail(rs.getString(49));
                usersPostTopic.setUser_Role(rs.getString(51));
                usersPostTopic.setActivation_Date(rs.getString(52));
                usersPostTopic.setAvatar(rs.getString(53));
                usersPostTopic.setAddress(rs.getString(54));
                usersPostTopic.setPhone_Number(rs.getString(55));
                usersPostTopic.setBirthday(rs.getString(56));
                usersPostTopic.setJob(rs.getString(57));
                usersPostTopic.setCountry(rs.getString(58));
                usersPostTopic.setWebsite(rs.getString(59));

                Posts posts = new Posts();
                posts.setPost_ID(rs.getInt(14));
                posts.setPost_Name(rs.getString(15));
                posts.setCate_ID(categoriesPostTopic);
                posts.setUser_ID(usersPostTopic);
                posts.setPost_Content(rs.getString(18));
                posts.setRule(rs.getString(19));
                posts.setDate_Start(rs.getString(20));
                posts.setDate_End(rs.getString(21));
                posts.setPublic_Date(rs.getString(22));
                posts.setLast_Edit(rs.getString(23));
                posts.setImage(rs.getString(24));
                posts.setNum_View(rs.getInt(25));
                posts.setStatus(rs.getInt(26));

                Posts_Local posts_local = new Posts_Local();
                posts_local.setPost_ID(rs.getInt(4));
                posts_local.setPost_Name(rs.getString(5));
                posts_local.setCate_ID(categoriesPostLocal);
                posts_local.setUser_ID(usersPostLocal);
                posts_local.setPost_Content(rs.getString(8));
                posts_local.setPublic_Date(rs.getString(9));
                posts_local.setLast_Edit(rs.getString(10));
                posts_local.setImage(rs.getString(11));
                posts_local.setNum_View(rs.getInt(12));
                posts_local.setStatus(rs.getInt(13));

                PostLocal_Post postLocal_post = new PostLocal_Post();
                postLocal_post.setPostLocal_ID(posts_local);
                postLocal_post.setPost_ID(posts);
                postLocal_post.setStatus(rs.getInt(3));
                return postLocal_post;
            }
        });
        return listpostLocalPost;
    }

    public List<PostLocal_Post> getAllPostLocalPost(int postLocal_ID, int numPage, int pageOne) {
        String sql = "SELECT * FROM `postlocal_post` " +
                "INNER JOIN postslocal ON postlocal_post.`PostLocal_ID` = postslocal.Post_ID " +
                "INNER JOIN posts ON postlocal_post.`Post_ID`= posts.Post_ID " +
                "INNER JOIN users AS us1 ON postslocal.User_ID = us1.User_ID " +
                "INNER JOIN categories AS cate1 ON postslocal.Cate_ID = cate1.Cate_ID " +
                "INNER JOIN users AS us2 ON posts.User_ID = us2.User_ID " +
                "INNER JOIN categories AS cate2 ON posts.Cate_ID = cate2.Cate_ID " +
                "WHERE postlocal_post.`PostLocal_ID` = " +postLocal_ID+ " "+
                "ORDER BY `posts`.`Publish_Date` DESC " +
                "LIMIT " +(numPage*pageOne)+ "," +pageOne+ " ";;
        List<PostLocal_Post> listpostLocalPost = jdbcTemplate.query(sql, new RowMapper<PostLocal_Post>() {
            // RowMapper de get 1 list<DATA>
            public PostLocal_Post mapRow(ResultSet rs, int rowNum) throws SQLException {

                Categories categoriesPostLocal = new Categories();
                categoriesPostLocal.setCateId(rs.getInt(42));
                categoriesPostLocal.setCateName(rs.getString(43));
                categoriesPostLocal.setCateDesc(rs.getString(44));

                Categories categoriesPostTopic = new Categories();
                categoriesPostTopic.setCateId(rs.getInt(60));
                categoriesPostTopic.setCateName(rs.getString(61));
                categoriesPostTopic.setCateDesc(rs.getString(62));

                Users usersPostLocal = new Users();
                usersPostLocal.setUser_ID(rs.getInt(27));
                usersPostLocal.setFirst_Name(rs.getString(28));
                usersPostLocal.setLast_Name(rs.getString(29));
                usersPostLocal.setGender(rs.getInt(30));
                usersPostLocal.setEmail(rs.getString(31));
                usersPostLocal.setUser_Role(rs.getString(33));
                usersPostLocal.setActivation_Date(rs.getString(34));
                usersPostLocal.setAvatar(rs.getString(35));
                usersPostLocal.setAddress(rs.getString(36));
                usersPostLocal.setPhone_Number(rs.getString(37));
                usersPostLocal.setBirthday(rs.getString(38));
                usersPostLocal.setJob(rs.getString(39));
                usersPostLocal.setCountry(rs.getString(40));
                usersPostLocal.setWebsite(rs.getString(41));

                Users usersPostTopic = new Users();
                usersPostTopic.setUser_ID(rs.getInt(45));
                usersPostTopic.setFirst_Name(rs.getString(46));
                usersPostTopic.setLast_Name(rs.getString(47));
                usersPostTopic.setGender(rs.getInt(48));
                usersPostTopic.setEmail(rs.getString(49));
                usersPostTopic.setUser_Role(rs.getString(51));
                usersPostTopic.setActivation_Date(rs.getString(52));
                usersPostTopic.setAvatar(rs.getString(53));
                usersPostTopic.setAddress(rs.getString(54));
                usersPostTopic.setPhone_Number(rs.getString(55));
                usersPostTopic.setBirthday(rs.getString(56));
                usersPostTopic.setJob(rs.getString(57));
                usersPostTopic.setCountry(rs.getString(58));
                usersPostTopic.setWebsite(rs.getString(59));

                Posts posts = new Posts();
                posts.setPost_ID(rs.getInt(14));
                posts.setPost_Name(rs.getString(15));
                posts.setCate_ID(categoriesPostTopic);
                posts.setUser_ID(usersPostTopic);
                posts.setPost_Content(rs.getString(18));
                posts.setRule(rs.getString(19));
                posts.setDate_Start(rs.getString(20));
                posts.setDate_End(rs.getString(21));
                posts.setPublic_Date(rs.getString(22));
                posts.setLast_Edit(rs.getString(23));
                posts.setImage(rs.getString(24));
                posts.setNum_View(rs.getInt(25));
                posts.setStatus(rs.getInt(26));

                Posts_Local posts_local = new Posts_Local();
                posts_local.setPost_ID(rs.getInt(4));
                posts_local.setPost_Name(rs.getString(5));
                posts_local.setCate_ID(categoriesPostLocal);
                posts_local.setUser_ID(usersPostLocal);
                posts_local.setPost_Content(rs.getString(8));
                posts_local.setPublic_Date(rs.getString(9));
                posts_local.setLast_Edit(rs.getString(10));
                posts_local.setImage(rs.getString(11));
                posts_local.setNum_View(rs.getInt(12));
                posts_local.setStatus(rs.getInt(13));

                PostLocal_Post postLocal_post = new PostLocal_Post();
                postLocal_post.setPostLocal_ID(posts_local);
                postLocal_post.setPost_ID(posts);
                postLocal_post.setStatus(rs.getInt(3));
                return postLocal_post;
            }
        });
        return listpostLocalPost;
    }

    public List<PostLocal_Post> getAllPostStatus(int status) {
        String sql = "SELECT * FROM `postlocal_post` " +
                "INNER JOIN postslocal ON postlocal_post.`PostLocal_ID` = postslocal.Post_ID " +
                "INNER JOIN posts ON postlocal_post.`Post_ID`= posts.Post_ID " +
                "INNER JOIN users AS us1 ON postslocal.User_ID = us1.User_ID " +
                "INNER JOIN categories AS cate1 ON postslocal.Cate_ID = cate1.Cate_ID " +
                "INNER JOIN users AS us2 ON posts.User_ID = us2.User_ID " +
                "INNER JOIN categories AS cate2 ON posts.Cate_ID = cate2.Cate_ID " +
                "WHERE postlocal_post.`Status` = " +status+ " ";
        List<PostLocal_Post> listpostLocalPost = jdbcTemplate.query(sql, new RowMapper<PostLocal_Post>() {
            // RowMapper de get 1 list<DATA>
            public PostLocal_Post mapRow(ResultSet rs, int rowNum) throws SQLException {

                Categories categoriesPostLocal = new Categories();
                categoriesPostLocal.setCateId(rs.getInt(42));
                categoriesPostLocal.setCateName(rs.getString(43));
                categoriesPostLocal.setCateDesc(rs.getString(44));

                Categories categoriesPostTopic = new Categories();
                categoriesPostTopic.setCateId(rs.getInt(60));
                categoriesPostTopic.setCateName(rs.getString(61));
                categoriesPostTopic.setCateDesc(rs.getString(62));

                Users usersPostLocal = new Users();
                usersPostLocal.setUser_ID(rs.getInt(27));
                usersPostLocal.setFirst_Name(rs.getString(28));
                usersPostLocal.setLast_Name(rs.getString(29));
                usersPostLocal.setGender(rs.getInt(30));
                usersPostLocal.setEmail(rs.getString(31));
                usersPostLocal.setUser_Role(rs.getString(33));
                usersPostLocal.setActivation_Date(rs.getString(34));
                usersPostLocal.setAvatar(rs.getString(35));
                usersPostLocal.setAddress(rs.getString(36));
                usersPostLocal.setPhone_Number(rs.getString(37));
                usersPostLocal.setBirthday(rs.getString(38));
                usersPostLocal.setJob(rs.getString(39));
                usersPostLocal.setCountry(rs.getString(40));
                usersPostLocal.setWebsite(rs.getString(41));

                Users usersPostTopic = new Users();
                usersPostTopic.setUser_ID(rs.getInt(45));
                usersPostTopic.setFirst_Name(rs.getString(46));
                usersPostTopic.setLast_Name(rs.getString(47));
                usersPostTopic.setGender(rs.getInt(48));
                usersPostTopic.setEmail(rs.getString(49));
                usersPostTopic.setUser_Role(rs.getString(51));
                usersPostTopic.setActivation_Date(rs.getString(52));
                usersPostTopic.setAvatar(rs.getString(53));
                usersPostTopic.setAddress(rs.getString(54));
                usersPostTopic.setPhone_Number(rs.getString(55));
                usersPostTopic.setBirthday(rs.getString(56));
                usersPostTopic.setJob(rs.getString(57));
                usersPostTopic.setCountry(rs.getString(58));
                usersPostTopic.setWebsite(rs.getString(59));

                Posts posts = new Posts();
                posts.setPost_ID(rs.getInt(14));
                posts.setPost_Name(rs.getString(15));
                posts.setCate_ID(categoriesPostTopic);
                posts.setUser_ID(usersPostTopic);
                posts.setPost_Content(rs.getString(18));
                posts.setRule(rs.getString(19));
                posts.setDate_Start(rs.getString(20));
                posts.setDate_End(rs.getString(21));
                posts.setPublic_Date(rs.getString(22));
                posts.setLast_Edit(rs.getString(23));
                posts.setImage(rs.getString(24));
                posts.setNum_View(rs.getInt(25));
                posts.setStatus(rs.getInt(26));

                Posts_Local posts_local = new Posts_Local();
                posts_local.setPost_ID(rs.getInt(4));
                posts_local.setPost_Name(rs.getString(5));
                posts_local.setCate_ID(categoriesPostLocal);
                posts_local.setUser_ID(usersPostLocal);
                posts_local.setPost_Content(rs.getString(8));
                posts_local.setPublic_Date(rs.getString(9));
                posts_local.setLast_Edit(rs.getString(10));
                posts_local.setImage(rs.getString(11));
                posts_local.setNum_View(rs.getInt(12));
                posts_local.setStatus(rs.getInt(13));

                PostLocal_Post postLocal_post = new PostLocal_Post();
                postLocal_post.setPostLocal_ID(posts_local);
                postLocal_post.setPost_ID(posts);
                postLocal_post.setStatus(rs.getInt(3));
                return postLocal_post;
            }
        });
        return listpostLocalPost;
    }


    public List<PostLocal_Post> getAllPostLocalPostWithPostLocal_ID(int postLocal_ID) {
        String sql = "SELECT * FROM `postlocal_post` " +
                "INNER JOIN postslocal ON postlocal_post.`PostLocal_ID` = postslocal.Post_ID " +
                "INNER JOIN posts ON postlocal_post.`Post_ID`= posts.Post_ID " +
                "INNER JOIN users AS us1 ON postslocal.User_ID = us1.User_ID " +
                "INNER JOIN categories AS cate1 ON postslocal.Cate_ID = cate1.Cate_ID " +
                "INNER JOIN users AS us2 ON posts.User_ID = us2.User_ID " +
                "INNER JOIN categories AS cate2 ON posts.Cate_ID = cate2.Cate_ID " +
                "WHERE postlocal_post.`PostLocal_ID` = " +postLocal_ID+ " ";
        List<PostLocal_Post> listpostLocalPost = jdbcTemplate.query(sql, new RowMapper<PostLocal_Post>() {
            // RowMapper de get 1 list<DATA>
            public PostLocal_Post mapRow(ResultSet rs, int rowNum) throws SQLException {

                Categories categoriesPostLocal = new Categories();
                categoriesPostLocal.setCateId(rs.getInt(42));
                categoriesPostLocal.setCateName(rs.getString(43));
                categoriesPostLocal.setCateDesc(rs.getString(44));

                Categories categoriesPostTopic = new Categories();
                categoriesPostTopic.setCateId(rs.getInt(60));
                categoriesPostTopic.setCateName(rs.getString(61));
                categoriesPostTopic.setCateDesc(rs.getString(62));

                Users usersPostLocal = new Users();
                usersPostLocal.setUser_ID(rs.getInt(27));
                usersPostLocal.setFirst_Name(rs.getString(28));
                usersPostLocal.setLast_Name(rs.getString(29));
                usersPostLocal.setGender(rs.getInt(30));
                usersPostLocal.setEmail(rs.getString(31));
                usersPostLocal.setUser_Role(rs.getString(33));
                usersPostLocal.setActivation_Date(rs.getString(34));
                usersPostLocal.setAvatar(rs.getString(35));
                usersPostLocal.setAddress(rs.getString(36));
                usersPostLocal.setPhone_Number(rs.getString(37));
                usersPostLocal.setBirthday(rs.getString(38));
                usersPostLocal.setJob(rs.getString(39));
                usersPostLocal.setCountry(rs.getString(40));
                usersPostLocal.setWebsite(rs.getString(41));

                Users usersPostTopic = new Users();
                usersPostTopic.setUser_ID(rs.getInt(45));
                usersPostTopic.setFirst_Name(rs.getString(46));
                usersPostTopic.setLast_Name(rs.getString(47));
                usersPostTopic.setGender(rs.getInt(48));
                usersPostTopic.setEmail(rs.getString(49));
                usersPostTopic.setUser_Role(rs.getString(51));
                usersPostTopic.setActivation_Date(rs.getString(52));
                usersPostTopic.setAvatar(rs.getString(53));
                usersPostTopic.setAddress(rs.getString(54));
                usersPostTopic.setPhone_Number(rs.getString(55));
                usersPostTopic.setBirthday(rs.getString(56));
                usersPostTopic.setJob(rs.getString(57));
                usersPostTopic.setCountry(rs.getString(58));
                usersPostTopic.setWebsite(rs.getString(59));

                Posts posts = new Posts();
                posts.setPost_ID(rs.getInt(14));
                posts.setPost_Name(rs.getString(15));
                posts.setCate_ID(categoriesPostTopic);
                posts.setUser_ID(usersPostTopic);
                posts.setPost_Content(rs.getString(18));
                posts.setRule(rs.getString(19));
                posts.setDate_Start(rs.getString(20));
                posts.setDate_End(rs.getString(21));
                posts.setPublic_Date(rs.getString(22));
                posts.setLast_Edit(rs.getString(23));
                posts.setImage(rs.getString(24));
                posts.setNum_View(rs.getInt(25));
                posts.setStatus(rs.getInt(26));

                Posts_Local posts_local = new Posts_Local();
                posts_local.setPost_ID(rs.getInt(4));
                posts_local.setPost_Name(rs.getString(5));
                posts_local.setCate_ID(categoriesPostLocal);
                posts_local.setUser_ID(usersPostLocal);
                posts_local.setPost_Content(rs.getString(8));
                posts_local.setPublic_Date(rs.getString(9));
                posts_local.setLast_Edit(rs.getString(10));
                posts_local.setImage(rs.getString(11));
                posts_local.setNum_View(rs.getInt(12));
                posts_local.setStatus(rs.getInt(13));

                PostLocal_Post postLocal_post = new PostLocal_Post();
                postLocal_post.setPostLocal_ID(posts_local);
                postLocal_post.setPost_ID(posts);
                postLocal_post.setStatus(rs.getInt(3));
                return postLocal_post;
            }
        });
        return listpostLocalPost;
    }

    public void saveOrUpdatePostLocalPost(PostLocal_Post postLocalPost) {

    }
}
