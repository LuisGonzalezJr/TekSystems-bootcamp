package com.teksystem.capstone.service;

import com.teksystem.capstone.database.DAO.userDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private userDAO userDao;
}
