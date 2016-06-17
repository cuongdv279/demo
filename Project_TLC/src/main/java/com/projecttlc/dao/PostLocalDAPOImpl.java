package com.projecttlc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.projecttlc.model.Categories;
import com.projecttlc.model.Posts;
import com.projecttlc.model.Posts_Local;
import com.projecttlc.model.Users;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;

public class PostLocalDAPOImpl implements PostLocalDAO{

    private JdbcTemplate jdbcTemplate;

    public PostLocalDAPOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Posts_Local> getAllPostLocal() {
        String sql = "SELECT * FROM `postslocal` " +
                "INNER JOIN `categories` ON `postslocal`.`Cate_ID` = `categories`.`Cate_ID` " +
                "INNER JOIN users ON users.`User_ID` = postslocal.`User_ID`";
        List<Posts_Local> listPostLocal = jdbcTemplate.query(sql, new RowMapper<Posts_Local>() {
            // RowMapper de get 1 list<DATA>
            public Posts_Local mapRow(ResultSet rs, int rowNum) throws SQLException {
                Posts_Local posts_local = new Posts_Local();
                Categories categories = new Categories();
                categories.setCateId(rs.getInt(11));
                categories.setCateName(rs.getString(12));
                categories.setCateDesc(rs.getString(13));

                Users users = new Users();
                users.setUser_ID(rs.getInt(14));
                users.setFirst_Name(rs.getString(15));
                users.setLast_Name(rs.getString(16));
                users.setGender(rs.getInt(17));
                users.setEmail(rs.getString(18));
                users.setUser_Role(rs.getString(20));
                users.setActivation_Date(rs.getString(21));
                users.setAvatar(rs.getString(22));
                users.setAddress(rs.getString(23));
                users.setPhone_Number(rs.getString(24));
                users.setBirthday(rs.getString(25));
                users.setJob(rs.getString(26));
                users.setCountry(rs.getString(27));
                users.setWebsite(rs.getString(28));

                posts_local.setPost_ID(rs.getInt(1));
                posts_local.setPost_Name(rs.getString(2));
                posts_local.setCate_ID(categories);
                posts_local.setUser_ID(users);
                posts_local.setPost_Content(rs.getString(5));
                posts_local.setPublic_Date(rs.getString(6));
                posts_local.setLast_Edit(rs.getString(7));
                posts_local.setImage(rs.getString(8));
                posts_local.setNum_View(rs.getInt(9));
                posts_local.setStatus(rs.getInt(10));
                return posts_local;
            }
        });
        return listPostLocal;
    }

    public List<Posts_Local> getAllPostLocal(int numPage, int pageOne) {
        String sql = "SELECT * FROM `postslocal` " +
                "INNER JOIN `categories` ON `postslocal`.`Cate_ID` = `categories`.`Cate_ID` " +
                "INNER JOIN users ON users.`User_ID` = postslocal.`User_ID` " +
                "ORDER BY `postslocal`.`Publish_Date` DESC " +
                "LIMIT " +(numPage*pageOne)+ "," +pageOne+ " ";
        List<Posts_Local> listPostLocal = jdbcTemplate.query(sql, new RowMapper<Posts_Local>() {
                    // RowMapper de get 1 list<DATA>
                    public Posts_Local mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Posts_Local posts_local = new Posts_Local();
                        Categories categories = new Categories();
                        categories.setCateId(rs.getInt(11));
                        categories.setCateName(rs.getString(12));
                        categories.setCateDesc(rs.getString(13));

                        Users users = new Users();
                        users.setUser_ID(rs.getInt(14));
                        users.setFirst_Name(rs.getString(15));
                        users.setLast_Name(rs.getString(16));
                        users.setGender(rs.getInt(17));
                        users.setEmail(rs.getString(18));
                        users.setUser_Role(rs.getString(20));
                        users.setActivation_Date(rs.getString(21));
                        users.setAvatar(rs.getString(22));
                        users.setAddress(rs.getString(23));
                        users.setPhone_Number(rs.getString(24));
                        users.setBirthday(rs.getString(25));
                        users.setJob(rs.getString(26));
                        users.setCountry(rs.getString(27));
                        users.setWebsite(rs.getString(28));

                        posts_local.setPost_ID(rs.getInt(1));
                        posts_local.setPost_Name(rs.getString(2));
                        posts_local.setCate_ID(categories);
                        posts_local.setUser_ID(users);
                        posts_local.setPost_Content(rs.getString(5));
                        posts_local.setPublic_Date(rs.getString(6));
                        posts_local.setLast_Edit(rs.getString(7));
                        posts_local.setImage(rs.getString(8));
                        posts_local.setNum_View(rs.getInt(9));
                        posts_local.setStatus(rs.getInt(10));
                        return posts_local;
                    }
                });
        return listPostLocal;
    }

    @Override
    public List<Posts_Local> getAllPosts_LocalStatus(int status) {
        String sql = "SELECT * FROM `postslocal` " +
                "INNER JOIN `categories` ON `postslocal`.`Cate_ID` = `categories`.`Cate_ID` " +
                "INNER JOIN users ON users.`User_ID` = postslocal.`User_ID` " +
                "WHERE postslocal.`Status` =" + status + " ";
        List<Posts_Local> listPostLocal = jdbcTemplate.query(sql, new RowMapper<Posts_Local>() {
            // RowMapper de get 1 list<DATA>
            public Posts_Local mapRow(ResultSet rs, int rowNum) throws SQLException {
                Posts_Local posts_local = new Posts_Local();
                Categories categories = new Categories();
                categories.setCateId(rs.getInt(11));
                categories.setCateName(rs.getString(12));
                categories.setCateDesc(rs.getString(13));

                Users users = new Users();
                users.setUser_ID(rs.getInt(14));
                users.setFirst_Name(rs.getString(15));
                users.setLast_Name(rs.getString(16));
                users.setGender(rs.getInt(17));
                users.setEmail(rs.getString(18));
                users.setUser_Role(rs.getString(20));
                users.setActivation_Date(rs.getString(21));
                users.setAvatar(rs.getString(22));
                users.setAddress(rs.getString(23));
                users.setPhone_Number(rs.getString(24));
                users.setBirthday(rs.getString(25));
                users.setJob(rs.getString(26));
                users.setCountry(rs.getString(27));
                users.setWebsite(rs.getString(28));

                posts_local.setPost_ID(rs.getInt(1));
                posts_local.setPost_Name(rs.getString(2));
                posts_local.setCate_ID(categories);
                posts_local.setUser_ID(users);
                posts_local.setPost_Content(rs.getString(5));
                posts_local.setPublic_Date(rs.getString(6));
                posts_local.setLast_Edit(rs.getString(7));
                posts_local.setImage(rs.getString(8));
                posts_local.setNum_View(rs.getInt(9));
                posts_local.setStatus(rs.getInt(10));
                return posts_local;
            }
        });
        return listPostLocal;
    }

    public List<Posts_Local> getAllPosts_LocalStatus(int status, int numPage, int pageOne) {
        String sql = "SELECT * FROM `postslocal` " +
                "INNER JOIN `categories` ON `postslocal`.`Cate_ID` = `categories`.`Cate_ID` " +
                "INNER JOIN users ON users.`User_ID` = postslocal.`User_ID` " +
                "WHERE postslocal.`Status` =" + status + " " +
                "ORDER BY `postslocal`.`Publish_Date` DESC " +
                "LIMIT " +(numPage*pageOne)+ "," +pageOne+ " ";
        List<Posts_Local> listPostLocal = jdbcTemplate.query(sql, new RowMapper<Posts_Local>() {
            // RowMapper de get 1 list<DATA>
            public Posts_Local mapRow(ResultSet rs, int rowNum) throws SQLException {
                Posts_Local posts_local = new Posts_Local();
                Categories categories = new Categories();
                categories.setCateId(rs.getInt(11));
                categories.setCateName(rs.getString(12));
                categories.setCateDesc(rs.getString(13));

                Users users = new Users();
                users.setUser_ID(rs.getInt(14));
                users.setFirst_Name(rs.getString(15));
                users.setLast_Name(rs.getString(16));
                users.setGender(rs.getInt(17));
                users.setEmail(rs.getString(18));
                users.setUser_Role(rs.getString(20));
                users.setActivation_Date(rs.getString(21));
                users.setAvatar(rs.getString(22));
                users.setAddress(rs.getString(23));
                users.setPhone_Number(rs.getString(24));
                users.setBirthday(rs.getString(25));
                users.setJob(rs.getString(26));
                users.setCountry(rs.getString(27));
                users.setWebsite(rs.getString(28));

                posts_local.setPost_ID(rs.getInt(1));
                posts_local.setPost_Name(rs.getString(2));
                posts_local.setCate_ID(categories);
                posts_local.setUser_ID(users);
                posts_local.setPost_Content(rs.getString(5));
                posts_local.setPublic_Date(rs.getString(6));
                posts_local.setLast_Edit(rs.getString(7));
                posts_local.setImage(rs.getString(8));
                posts_local.setNum_View(rs.getInt(9));
                posts_local.setStatus(rs.getInt(10));
                return posts_local;
            }
        });
        return listPostLocal;
    }

    public void saveOrUpdatePostsLocal(Posts_Local postLocal) {
        if(postLocal.getPost_ID() > 0){
            if(postLocal.getStatus() == 1){
                if(postLocal.getImage() != null){
                    String sql = "UPDATE `postslocal` " +
                            "SET `Post_Name`=?,`Cate_ID`=?,`Post_Content`=?,`Publish_Date`=?,`Last_Edit`=?,`Image`=?,`Status`=? " +
                            "WHERE `Post_ID`= ?";
                    jdbcTemplate.update(sql,postLocal.getPost_Name(),postLocal.getCate_ID().getCateId(),postLocal.getPost_Content(),postLocal.getPublic_Date(),
                            postLocal.getLast_Edit(),postLocal.getImage(),postLocal.getStatus(),postLocal.getPost_ID());
                } else {
                    String sql = "UPDATE `postslocal` " +
                            "SET `Post_Name`=?,`Cate_ID`=?,`Post_Content`=?,`Publish_Date`=?,`Last_Edit`=?,`Status`=? " +
                            "WHERE `Post_ID`= ?";
                    jdbcTemplate.update(sql,postLocal.getPost_Name(),postLocal.getCate_ID().getCateId(),postLocal.getPost_Content(),postLocal.getPublic_Date(),
                            postLocal.getLast_Edit(),postLocal.getStatus(),postLocal.getPost_ID());
                }

            } else {
                if(!postLocal.getImage().equals("")){
                    String sql = "UPDATE `postslocal` " +
                            "SET `Post_Name`=?,`Cate_ID`=?,`Post_Content`=?,`Last_Edit`=?,`Image`=?,`Status`=? " +
                            "WHERE `Post_ID`= ?";
                    jdbcTemplate.update(sql,postLocal.getPost_Name(),postLocal.getCate_ID().getCateId(),postLocal.getPost_Content(),
                            postLocal.getLast_Edit(),postLocal.getImage(),postLocal.getStatus(),postLocal.getPost_ID());
                } else {
                    String sql = "UPDATE `postslocal` " +
                            "SET `Post_Name`=?,`Cate_ID`=?,`Post_Content`=?,`Last_Edit`=?,`Status`=? " +
                            "WHERE `Post_ID`= ?";
                    jdbcTemplate.update(sql,postLocal.getPost_Name(),postLocal.getCate_ID().getCateId(),postLocal.getPost_Content(),
                            postLocal.getLast_Edit(),postLocal.getStatus(),postLocal.getPost_ID());
                }

            }

        } else {
            if(postLocal.getPublic_Date() == null){
                System.out.println("loi o insert 1");
                String sql ="INSERT INTO `postslocal`(`Post_Name`, `Cate_ID`, `User_ID`, `Post_Content`, `Image`, `Last_Edit`, `Num_Views`, `Status`) " +
                        "VALUES (?,?,?,?,?,?,?,?)";
                jdbcTemplate.update(sql,postLocal.getPost_Name(),postLocal.getCate_ID().getCateId(),postLocal.getUser_ID().getUser_ID(),postLocal.getPost_Content(),
                        postLocal.getImage(),postLocal.getLast_Edit(),postLocal.getNum_View(),postLocal.getStatus());
            } else {
                String sql ="INSERT INTO `postslocal`(`Post_Name`, `Cate_ID`, `User_ID`, `Post_Content`, `Publish_Date`, `Last_Edit`, `Image`, `Num_Views`, `Status`) " +
                        "VALUES (?,?,?,?,?,?,?,?,?)";
                jdbcTemplate.update(sql,postLocal.getPost_Name(),postLocal.getCate_ID().getCateId(),postLocal.getUser_ID().getUser_ID(),postLocal.getPost_Content(),
                        postLocal.getPublic_Date(),postLocal.getLast_Edit(),postLocal.getImage(),postLocal.getNum_View(),postLocal.getStatus());
            }

        }
        
    }

    @Override
    public void countViews(int postID, int countViews) {
        String sql = "UPDATE `postslocal` SET `Num_Views`=?  WHERE `Post_ID` = ?";
        jdbcTemplate.update(sql,countViews,postID);
    }

    public void deletePostsLocal(int postLocal_ID) {
        String sql = "DELETE FROM `postslocal` WHERE `Post_ID`=?";
        jdbcTemplate.update(sql,postLocal_ID);
        
    }

    public List<Posts_Local> getAllPosts_LocalCate(int cate_ID,int status, int numPage, int pageOne) {
        String sql = "SELECT * FROM `postslocal` " +
                "INNER JOIN `categories` ON `postslocal`.`Cate_ID` = `categories`.`Cate_ID` " +
                "INNER JOIN users ON users.`User_ID` = postslocal.`User_ID` " +
                "WHERE postslocal.`Cate_ID` =" + cate_ID + " AND postslocal.`Status` =" + status + " " +
                "LIMIT " +(numPage*pageOne)+ "," +pageOne+ " ";
        List<Posts_Local> listPostLocal = jdbcTemplate.query(sql, new RowMapper<Posts_Local>() {
            // RowMapper de get 1 list<DATA>
            public Posts_Local mapRow(ResultSet rs, int rowNum) throws SQLException {
                Posts_Local posts_local = new Posts_Local();
                Categories categories = new Categories();
                categories.setCateId(rs.getInt(11));
                categories.setCateName(rs.getString(12));
                categories.setCateDesc(rs.getString(13));

                Users users = new Users();
                users.setUser_ID(rs.getInt(14));
                users.setFirst_Name(rs.getString(15));
                users.setLast_Name(rs.getString(16));
                users.setGender(rs.getInt(17));
                users.setEmail(rs.getString(18));
                users.setUser_Role(rs.getString(20));
                users.setActivation_Date(rs.getString(21));
                users.setAvatar(rs.getString(22));
                users.setAddress(rs.getString(23));
                users.setPhone_Number(rs.getString(24));
                users.setBirthday(rs.getString(25));
                users.setJob(rs.getString(26));
                users.setCountry(rs.getString(27));
                users.setWebsite(rs.getString(28));

                posts_local.setPost_ID(rs.getInt(1));
                posts_local.setPost_Name(rs.getString(2));
                posts_local.setCate_ID(categories);
                posts_local.setUser_ID(users);
                posts_local.setPost_Content(rs.getString(5));
                posts_local.setPublic_Date(rs.getString(6));
                posts_local.setLast_Edit(rs.getString(7));
                posts_local.setImage(rs.getString(8));
                posts_local.setNum_View(rs.getInt(9));
                posts_local.setStatus(rs.getInt(10));
                return posts_local;
            }
        });
        return listPostLocal;
    }
    public List<Posts_Local> getAllPosts_LocalCate(int cate_ID,int status) {
        String sql = "SELECT * FROM `postslocal` " +
                "INNER JOIN `categories` ON `postslocal`.`Cate_ID` = `categories`.`Cate_ID` " +
                "INNER JOIN users ON users.`User_ID` = postslocal.`User_ID` " +
                "WHERE postslocal.`Cate_ID` =" + cate_ID + " AND postslocal.`Status` =" + status + " "  ;
        List<Posts_Local> listPostLocal = jdbcTemplate.query(sql, new RowMapper<Posts_Local>() {
            // RowMapper de get 1 list<DATA>
            public Posts_Local mapRow(ResultSet rs, int rowNum) throws SQLException {
                Posts_Local posts_local = new Posts_Local();
                Categories categories = new Categories();
                categories.setCateId(rs.getInt(11));
                categories.setCateName(rs.getString(12));
                categories.setCateDesc(rs.getString(13));

                Users users = new Users();
                users.setUser_ID(rs.getInt(14));
                users.setFirst_Name(rs.getString(15));
                users.setLast_Name(rs.getString(16));
                users.setGender(rs.getInt(17));
                users.setEmail(rs.getString(18));
                users.setUser_Role(rs.getString(20));
                users.setActivation_Date(rs.getString(21));
                users.setAvatar(rs.getString(22));
                users.setAddress(rs.getString(23));
                users.setPhone_Number(rs.getString(24));
                users.setBirthday(rs.getString(25));
                users.setJob(rs.getString(26));
                users.setCountry(rs.getString(27));
                users.setWebsite(rs.getString(28));

                posts_local.setPost_ID(rs.getInt(1));
                posts_local.setPost_Name(rs.getString(2));
                posts_local.setCate_ID(categories);
                posts_local.setUser_ID(users);
                posts_local.setPost_Content(rs.getString(5));
                posts_local.setPublic_Date(rs.getString(6));
                posts_local.setLast_Edit(rs.getString(7));
                posts_local.setImage(rs.getString(8));
                posts_local.setNum_View(rs.getInt(9));
                posts_local.setStatus(rs.getInt(10));
                return posts_local;
            }
        });
        return listPostLocal;
    }

    public Posts_Local getPostLocal(int postLocal_ID) {
        String sql = "SELECT * FROM `postslocal` " +
                "INNER JOIN `categories` ON `postslocal`.`Cate_ID` = `categories`.`Cate_ID` " +
                "INNER JOIN users ON users.`User_ID` = postslocal.`User_ID` " +
                "WHERE postslocal.`Post_ID`= "+postLocal_ID+" ";
        return jdbcTemplate.query(sql, new ResultSetExtractor<Posts_Local>() {
            public Posts_Local extractData(ResultSet rs) throws SQLException, DataAccessException {
                if(rs.next()){
                    Posts_Local posts_local = new Posts_Local();
                    Categories categories = new Categories();
                    categories.setCateId(rs.getInt(11));
                    categories.setCateName(rs.getString(12));
                    categories.setCateDesc(rs.getString(13));

                    Users users = new Users();
                    users.setUser_ID(rs.getInt(14));
                    users.setFirst_Name(rs.getString(15));
                    users.setLast_Name(rs.getString(16));
                    users.setGender(rs.getInt(17));
                    users.setEmail(rs.getString(18));
                    users.setUser_Role(rs.getString(20));
                    users.setActivation_Date(rs.getString(21));
                    users.setAvatar(rs.getString(22));
                    users.setAddress(rs.getString(23));
                    users.setPhone_Number(rs.getString(24));
                    users.setBirthday(rs.getString(25));
                    users.setJob(rs.getString(26));
                    users.setCountry(rs.getString(27));
                    users.setWebsite(rs.getString(28));

                    posts_local.setPost_ID(rs.getInt(1));
                    posts_local.setPost_Name(rs.getString(2));
                    posts_local.setCate_ID(categories);
                    posts_local.setUser_ID(users);
                    posts_local.setPost_Content(rs.getString(5));
                    posts_local.setPublic_Date(rs.getString(6));
                    posts_local.setLast_Edit(rs.getString(7));
                    posts_local.setImage(rs.getString(8));
                    posts_local.setNum_View(rs.getInt(9));
                    posts_local.setStatus(rs.getInt(10));
                    return posts_local;
                }
                return null;
            }
        });
    }



}
