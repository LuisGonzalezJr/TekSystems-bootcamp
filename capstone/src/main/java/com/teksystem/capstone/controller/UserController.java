package com.teksystem.capstone.controller;


import com.teksystem.capstone.database.DAO.userDAO;
import com.teksystem.capstone.database.entity.User;
import com.teksystem.capstone.formbean.RegisterFormBean;
import com.teksystem.capstone.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
public class UserController {

    @Autowired
    private userDAO userDAO;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public ModelAndView create() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/register");


        RegisterFormBean form = new RegisterFormBean();
        response.addObject("form", form);

        return response;
    }

    @RequestMapping(value = "/user/registerSubmit", method = {RequestMethod.POST, RequestMethod.GET} )
    public ModelAndView registerSubmit(@Valid RegisterFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();

        log.info(form.toString());

        int i = 10/0;

        if (bindingResult.hasErrors()) {

            List<String> errorMessages = new ArrayList<>();

            for (ObjectError error : bindingResult.getAllErrors()) {
                log.info( ((FieldError) error).getField() + " " + error.getDefaultMessage());
            }

            response.addObject("form", form);


            response.addObject("errorMessages", errorMessages);
            response.addObject("bindingResult", bindingResult);


            response.setViewName("user/register");
            return response;
        }


        User user = userDAO.findById(form.getId());


        if (user == null) {
            user = new User();
        }


        user.setEmail(form.getEmail());
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setCreateDate(new Date());

        String password = passwordEncoder.encode(form.getPassword());
        user.setPassword(password);

        userDAO.save(user);


        log.info(form.toString());

        response.setViewName("redirect:/user/edit/" + user.getId());

        return response;
    }

    @GetMapping("/user/edit/{userId}")
    public ModelAndView editUser(@PathVariable("userId")Integer userId) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/register");

        User user = userDAO.findById(userId);

        RegisterFormBean form = new RegisterFormBean();

        form.setId(user.getId());
        form.setEmail(user.getEmail());
        form.setFirstName(user.getFirstName());
        form.setLastName(user.getLastName());
        form.setPassword(user.getPassword());
        form.setConfirmPassword(user.getPassword());


        response.addObject("form", form);

        return response;
    }


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



        List<User> users = userDAO.findByFirstNameIgnoreCaseContaining(firstName);

        response.addObject("usersModelKey", users);

        return response;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value="/user/search", method= RequestMethod.GET)
    public ModelAndView search(@RequestParam(value = "firstName", required = false) String firstName) {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/search");

        List<User> users = new ArrayList<>();

        if (!StringUtils.isEmpty(firstName)) {
            users = userDAO.findByFirstNameIgnoreCaseContaining(firstName);
        }


        response.addObject("usersModelKey", users);
        response.addObject("firstName", firstName);

        return response;
    }

}
