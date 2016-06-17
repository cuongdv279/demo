package com.projecttlc.dao;

import com.projecttlc.model.Users;

/**
 * Created by CHIP_IT_DVC on 22/02/2016.
 */
public interface ConnectDAO {

    boolean Login(Users user);
    boolean Logout(Users user);
}
