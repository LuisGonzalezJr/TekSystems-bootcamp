package com.teksystem.capstone.controller;


import com.teksystem.capstone.database.DAO.userDAO;
import com.teksystem.capstone.database.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class HomeController {

   @Autowired
    private userDAO userDao;

   @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home() throws Exception {
       ModelAndView response = new ModelAndView();


       response.setViewName("user/home");

       return response;
   }
}
