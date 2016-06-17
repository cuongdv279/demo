package com.projecttlc.service;

import com.projecttlc.dao.UserDAO;
import com.projecttlc.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by CHIP_IT_DVC on 22/02/2016.
 */
@Service
public class LoginService {
    @Autowired
    UserDAO userDAO;
    public Users checkLogIn(String email, String password ){
        return userDAO.logIn(email, password);
    }
}

