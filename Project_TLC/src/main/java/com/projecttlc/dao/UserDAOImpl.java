package com.projecttlc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.projecttlc.model.Users;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;

public class UserDAOImpl implements UserDAO{

    private JdbcTemplate jdbcTemplate;

    public UserDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Users> getAllUser() {
        String sql = "SELECT `User_ID`, `First_Name`, `Last_Name`, `Gender`, `Email`, `Password`, `User_Role`, `Activation_Date`, " +
                "`Avatar`, `Address`, `Phone_Number`, `Birthday`, `Job`, `Country`, `Website`, `Status` " +
                " FROM `users`";
        List<Users> listUser = jdbcTemplate.query(sql, new RowMapper<Users>() {
            @Override
            public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
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
                users.setStatus(rs.getInt("status"));
                return users;

            }
        });
        return listUser;
    }

    public List<Users> getAllUser(int numPage, int pageOne) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Users> getAllUserWithStatus(int status) {
        String sql = "SELECT `User_ID`, `First_Name`, `Last_Name`, `Gender`, `Email`, `Password`, `User_Role`, `Activation_Date`, " +
                "`Avatar`, `Address`, `Phone_Number`, `Birthday`, `Job`, `Country`, `Website`, `Status` " +
                " FROM `users` " +
                "WHERE `users`.`Status` = "+status+"";
        List<Users> listUser = jdbcTemplate.query(sql, new RowMapper<Users>() {
            @Override
            public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
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
                users.setStatus(rs.getInt("status"));
                return users;

            }
        });
        return listUser;
    }

    public Users getUser(int user_ID) {
        String sql = "SELECT `User_ID`, `First_Name`, `Last_Name`, `Gender`, `Email`, `Password`, `User_Role`, `Activation_Date`, " +
                "`Avatar`, `Address`, `Phone_Number`, `Birthday`, `Job`, `Country`, `Website`,`Status` FROM `users` WHERE `User_ID` = '" + user_ID + "'";
        return jdbcTemplate.query(sql, new ResultSetExtractor<Users>() {
            public Users extractData(ResultSet rs) throws SQLException, DataAccessException {
                if(rs.next()){
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
                    users.setStatus(rs.getInt("status"));
                    return users;
                }
                return null;
            }
        });
    }

    @Override
    public Users getUser(String email) {
        String sql = "SELECT `User_ID`, `First_Name`, `Last_Name`, `Gender`, `Email`, `Password`, `User_Role`, `Activation_Date`, " +
                "`Avatar`, `Address`, `Phone_Number`, `Birthday`, `Job`, `Country`, `Website`,`Status` FROM `users` WHERE `Email` = '" + email + "'";
        return jdbcTemplate.query(sql, new ResultSetExtractor<Users>() {
            public Users extractData(ResultSet rs) throws SQLException, DataAccessException {
                if(rs.next()){
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
                    users.setStatus(rs.getInt("status"));
                    return users;
                }
                return null;
            }
        });
    }

    public Users logIn(String email, String password) {
        String sql = "SELECT `User_ID`, `First_Name`, `Last_Name`, `Gender`, `Email`, `Password`, `User_Role`, `Activation_Date`, " +
                "`Avatar`, `Address`, `Phone_Number`, `Birthday`, `Job`, `Country`, `Website`,`Status` FROM `users` WHERE `Email`= '" + email + "' AND `Password`= '" + password + "'";
        return jdbcTemplate.query(sql, new ResultSetExtractor<Users>() {
            public Users extractData(ResultSet rs) throws SQLException, DataAccessException {
                if(rs.next()){
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
                    users.setStatus(rs.getInt("status"));
                    return users;
                }
                return null;
            }
        });
    }

    public boolean logOut() {
        return false;
    }

    public void saveOrUpdateUser(Users user) {
        if (user.getUser_ID() > 0) {
            System.out.println("vao update");
            if(user.getAvatar() == null || user.getAvatar().equals("")){
                if(user.getWebsite() == null || user.getWebsite().equals("")){
                    String sql = "UPDATE `users` SET `First_Name`=?,`Last_Name`=?,`Gender`=?," +
                            "`Address`=?,`Phone_Number`=?,`Birthday`=?,`Job`=?,`Country`=?,`Status`=? WHERE `User_ID`=?";
                    jdbcTemplate.update(sql,user.getFirst_Name(),user.getLast_Name(),user.getGender(),
                            user.getAddress(),user.getPhone_Number(),user.getBirthday(),user.getJob(),user.getCountry(),user.getStatus(),user.getUser_ID());
                    System.out.println("update thanh cong o 1");
                } else {
                    String sql = "UPDATE `users` SET `First_Name`=?,`Last_Name`=?,`Gender`=?," +
                            "`Address`=?,`Phone_Number`=?,`Birthday`=?,`Job`=?,`Country`=?,`Website`=?, `Status`=? WHERE `User_ID`=?";
                    jdbcTemplate.update(sql,user.getFirst_Name(),user.getLast_Name(),user.getGender(),
                            user.getAddress(),user.getPhone_Number(),user.getBirthday(),user.getJob(),user.getCountry(),user.getWebsite(),user.getStatus(),user.getUser_ID());
                    System.out.println("update thanh cong o 2");
                }
            } else {
                if(user.getWebsite() == null || user.getWebsite().equals("")){
                    String sql = "UPDATE `users` SET `First_Name`=?,`Last_Name`=?,`Gender`=?," +
                            "`Avatar`=?,`Address`=?,`Phone_Number`=?,`Birthday`=?,`Job`=?,`Country`=?,`Status`=? WHERE `User_ID`=?";
                    jdbcTemplate.update(sql,user.getFirst_Name(),user.getLast_Name(),user.getGender(),
                            user.getAvatar(),user.getAddress(),user.getPhone_Number(),user.getBirthday(),user.getJob(),user.getCountry(),user.getStatus(),user.getUser_ID());
                    System.out.println("update thanh cong o 3");
                } else {
                    String sql = "UPDATE `users` SET `First_Name`=?,`Last_Name`=?,`Gender`=?," +
                            "`Avatar`=?,`Address`=?,`Phone_Number`=?,`Birthday`=?,`Job`=?,`Country`=?,`Website`=?, `Status`=? WHERE `User_ID`=?";
                    jdbcTemplate.update(sql,user.getFirst_Name(),user.getLast_Name(),user.getGender(),
                            user.getAvatar(),user.getAddress(),user.getPhone_Number(),user.getBirthday(),user.getJob(),user.getCountry(),user.getWebsite(),user.getStatus(),user.getUser_ID());
                    System.out.println("update thanh cong o 4");
                }
            }
        } else {
            System.out.println("da vao signup");
            if(user.getAvatar().equals("")){
                if (user.getWebsite().equals("")){
                    System.out.println("loi o sign up ca 2");
                    String sql = "INSERT INTO `users`(`First_Name`, `Last_Name`, `Gender`, `Email`, `Password`, `User_Role`, " +
                            "`Activation_Date`, `Address`, `Phone_Number`, `Birthday`, `Job`, `Country`,`Status`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
                    jdbcTemplate.update(sql,user.getFirst_Name(),user.getLast_Name(),user.getGender(),user.getEmail(),user.getPassword(),user.getUser_Role(),
                            user.getActivation_Date(),user.getAddress(),user.getPhone_Number(),user.getBirthday(),user.getJob(),user.getCountry(),user.getStatus());
                    System.out.println("sign up thanh cong o ca 2");
                } else {
                    System.out.println("loi o sigun avatar");
                    String sql = "INSERT INTO `users`(`First_Name`, `Last_Name`, `Gender`, `Email`, `Password`, `User_Role`, " +
                            "`Activation_Date`, `Address`, `Phone_Number`, `Birthday`, `Job`, `Country`, `Website`,`Status`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                    jdbcTemplate.update(sql,user.getFirst_Name(),user.getLast_Name(),user.getGender(),user.getEmail(),user.getPassword(),user.getUser_Role(),
                            user.getActivation_Date(),user.getAddress(),user.getPhone_Number(),user.getBirthday(),user.getJob(),user.getCountry(),user.getWebsite(),user.getStatus());
                    System.out.println("sign up thanh cong o avatar");
                }
            }else  {
                if (!user.getWebsite().equals("")){
                    System.out.println("loi o sign up day du");
                    String sql = "INSERT INTO `users`(`First_Name`, `Last_Name`, `Gender`, `Email`, `Password`, `User_Role`, " +
                            "`Activation_Date`, `Address`, `Phone_Number`, `Birthday`, `Job`, `Country`,`Website`,`Avatar`,`Status`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                    jdbcTemplate.update(sql,user.getFirst_Name(),user.getLast_Name(),user.getGender(),user.getEmail(),user.getPassword(),user.getUser_Role(),
                            user.getActivation_Date(),user.getAddress(),user.getPhone_Number(),user.getBirthday(),user.getJob(),user.getCountry(),user.getWebsite(),user.getAvatar(),user.getStatus());
                    System.out.println("sign up thanh cong o day du");
                } else {
                    System.out.println("loi o sign up website");
                    String sql = "INSERT INTO `users`(`First_Name`, `Last_Name`, `Gender`, `Email`, `Password`, `User_Role`, " +
                            "`Activation_Date`, `Address`, `Phone_Number`, `Birthday`, `Job`, `Country`, `Avatar`,`Status`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                    jdbcTemplate.update(sql,user.getFirst_Name(),user.getLast_Name(),user.getGender(),user.getEmail(),user.getPassword(),user.getUser_Role(),
                            user.getActivation_Date(),user.getAddress(),user.getPhone_Number(),user.getBirthday(),user.getJob(),user.getCountry(),user.getAvatar(),user.getStatus());
                    System.out.println("sign up thanh cong o website");
                }
            }
        }
    }

    @Override
    public void updateStatusAndRoleUser(int user_ID, String role, int status) {
        String sql = "UPDATE `users` SET `User_Role`=?,`Status`=? WHERE `User_ID`=?";
        jdbcTemplate.update(sql,role,status,user_ID);
    }

    @Override
    public void updateProfileAdmin(Users user) {
        if(user.getAvatar().equals("")){
            String sql = "UPDATE `users` SET `First_Name`=?,`Last_Name`=?,`Gender`=?," +
                    "`Address`=?,`Phone_Number`=?,`Birthday`=?,`Job`=?,`Country`=?,`Website`=?,`User_Role`=?,`Status`=? WHERE `User_ID`=?";
            jdbcTemplate.update(sql,user.getFirst_Name(),user.getLast_Name(),user.getGender(),
                    user.getAddress(),user.getPhone_Number(),user.getBirthday(),user.getJob(),user.getCountry(),user.getWebsite(),user.getUser_Role(),user.getStatus(),user.getUser_ID());
        } else {
            String sql = "UPDATE `users` SET `First_Name`=?,`Last_Name`=?,`Gender`=?," +
                    "`Avatar`=?,`Address`=?,`Phone_Number`=?,`Birthday`=?,`Job`=?,`Country`=?,`Website`=?,`User_Role`=?,`Status`=? WHERE `User_ID`=?";
            jdbcTemplate.update(sql,user.getFirst_Name(),user.getLast_Name(),user.getGender(),
                    user.getAvatar(),user.getAddress(),user.getPhone_Number(),user.getBirthday(),user.getJob(),user.getCountry(),user.getWebsite(),user.getUser_Role(),user.getStatus(),user.getUser_ID());
        }
    }

    public void deleteUser(int user_ID) {
        String sql = "DELETE FROM `users` WHERE  `User_ID`=?";
        jdbcTemplate.update(sql,user_ID);

    }

    @Override
    public void updatePassword(int user_ID, String pw) {
        String sql = "UPDATE `users` SET `Password`=? WHERE `User_ID`=?";
        jdbcTemplate.update(sql,pw,user_ID);
    }

}
