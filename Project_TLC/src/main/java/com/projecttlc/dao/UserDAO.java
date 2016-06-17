package com.projecttlc.dao;

import java.util.List;
import com.projecttlc.model.Users;

public interface UserDAO {

    List<Users> getAllUser();
    List<Users> getAllUser(int numPage, int pageOne);

    List<Users> getAllUserWithStatus(int status);

    Users getUser(int user_ID);
    Users getUser(String email);

    Users logIn(String email, String password);

    boolean logOut();

    void saveOrUpdateUser(Users user);

    void updateStatusAndRoleUser(int user_ID, String role, int status);

    void updateProfileAdmin(Users user);

    void deleteUser(int user_ID);

    void updatePassword(int user_ID, String pw);

}
