package com.projecttlc.service;

import com.projecttlc.dao.UserDAO;
import com.projecttlc.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by CHIP_IT_DVC on 25/02/2016.
 */
@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public List<Users> getAllUser(){
        return userDAO.getAllUser();
    }
    public List<Users> getAllUser(int numPage, int pageOne){
        return userDAO.getAllUser(numPage,pageOne);
    }
    public List<Users> getAllUserWithStatus(int status) {
        return userDAO.getAllUserWithStatus(status);
    }

    public Users getUser(int user_ID){
        return userDAO.getUser(user_ID);
    }
    public Users getUser(String email){
        return userDAO.getUser(email);
    }

    public Users logIn(String email, String password){
        return userDAO.logIn(email,password);
    }

    public boolean logOut(){
        return false;
    }


    public void saveOrUpdateUser(Users user){
         userDAO.saveOrUpdateUser(user);
    }

    public void updateStatusAndRoleUser(int user_ID, String role, int status) {
        userDAO.updateStatusAndRoleUser(user_ID,role,status);
    }

    public void updateProfileAdmin(Users user) {
        userDAO.updateProfileAdmin(user);
    }
    public void deleteUser(int user_ID){

    }
    public void updatePassword(int  user_ID, String pw){
        userDAO.updatePassword(user_ID,pw);
    }
}
