package com.projecttlc.dao;

import com.projecttlc.model.Categories;
import com.projecttlc.model.Posts;
import com.projecttlc.model.Users;
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
public class CategoriesDAOImpl implements CategoriesDAO {

    private JdbcTemplate jdbcTemplate;

    public CategoriesDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Categories> getAllCategories() {
        String sql = "SELECT `Cate_ID`, `Cate_Name`, `Cate_Desc` FROM `categories`";
        List<Categories> listCategories = jdbcTemplate.query(sql, new RowMapper<Categories>() {
            // RowMapper de get 1 list<DATA>
            public Categories mapRow(ResultSet rs, int rowNum) throws SQLException {
                Categories categories = new Categories();
                categories.setCateId(rs.getInt(1));
                categories.setCateName(rs.getString(2));
                categories.setCateDesc(rs.getString(3));
                return categories;
            }
        });
        return listCategories;
    }

    public List<Categories> getAllCategories(int numPage, int pageOne) {
        String sql = "SELECT `Cate_ID`, `Cate_Name`, `Cate_Desc` FROM `categories` " +
                "LIMIT " +(numPage*pageOne)+ "," +pageOne+ " ";
        List<Categories> listCategories = jdbcTemplate.query(sql, new RowMapper<Categories>() {
            // RowMapper de get 1 list<DATA>
            public Categories mapRow(ResultSet rs, int rowNum) throws SQLException {
                Categories categories = new Categories();
                categories.setCateId(rs.getInt(1));
                categories.setCateName(rs.getString(2));
                categories.setCateDesc(rs.getString(3));
                return categories;
            }
        });
        return listCategories;
    }


    public Categories getCategories(int cate_ID) {
        String sql = "SELECT `Cate_ID`, `Cate_Name`, `Cate_Desc` FROM `categories` WHERE Cate_ID = "+cate_ID+"";
        return jdbcTemplate.query(sql, new ResultSetExtractor<Categories>() {
            public Categories extractData(ResultSet rs) throws SQLException, DataAccessException {
                if(rs.next()){
                    Categories categories = new Categories();
                    categories.setCateId(rs.getInt("Cate_ID"));
                    categories.setCateName(rs.getString("Cate_Name"));
                    categories.setCateDesc(rs.getString("Cate_Desc"));

                    return categories;

                }
                return null;
            }
        });
    }

    public void saveAndUpdate(Categories categories) {
        if(categories.getCateId() > 0){
            String sql = "UPDATE `categories` SET `Cate_Name`=?,`Cate_Desc`=? WHERE `Cate_ID`=?";
            jdbcTemplate.update(sql,categories.getCateName(),categories.getCateDesc(),categories.getCateId());
        } else {
            String sql = "INSERT INTO `categories`(`Cate_Name`, `Cate_Desc`) VALUES (?,?)";
            jdbcTemplate.update(sql,categories.getCateName(),categories.getCateDesc());
        }
    }

    public void deleteCategories(int cate_ID) {

    }
}
