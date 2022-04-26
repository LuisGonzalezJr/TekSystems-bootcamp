package com.teksystem.capstone.controller;


import com.teksystem.capstone.database.DAO.userDAO;
import com.teksystem.capstone.database.DAO.userRoleDAO;
import com.teksystem.capstone.database.entity.User;
import com.teksystem.capstone.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
public class UserController {

    @Autowired
    private userDAO userDao;

    @PostMapping("/user/search")
    public ModelAndView findUser(String firstName) {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/search");

        log.info(String.valueOf(firstName == ""));




        if (StringUtils.isEmpty(firstName)) {
            String error = "Search cannot be blank";
            response.addObject("error", error);
            return response;

        }



        List<User> users = userDao.findByFirstNameIgnoreCaseContaining(firstName);

        response.addObject("usersModelKey", users);

        return response;
    }

    @RequestMapping(value = "/user/delete/{userId}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable("userId") Integer userId) throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("user/home");
        User u = userDao.findById(userId);
        log.info("Delete User: " + u.getFirstName());
        if(u == null){
            String error = "Error deleting";
            response.addObject("error", error);
        }
        else{
            userDao.delete(u);
        }
        return response;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value="/user/search", method= RequestMethod.GET)
    public ModelAndView search(@RequestParam(value = "firstName", required = false) String firstName) {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/search");

        List<User> users = new ArrayList<>();

        if (!StringUtils.isEmpty(firstName)) {
            users = userDao.findByFirstNameIgnoreCaseContaining(firstName);
        }


        response.addObject("usersModelKey", users);
        response.addObject("firstName", firstName);

        return response;
    }

}
