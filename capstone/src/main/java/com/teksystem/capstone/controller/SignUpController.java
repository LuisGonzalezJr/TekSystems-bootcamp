package com.teksystem.capstone.controller;

import com.teksystem.capstone.database.DAO.userDAO;
import com.teksystem.capstone.database.entity.User;
import com.teksystem.capstone.formbean.EditUserFormBean;
import com.teksystem.capstone.formbean.signupFormBean;
import com.teksystem.capstone.formbean.userRoleFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
public class SignUpController {

    @Autowired
    private userDAO userDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView register() throws Exception {
        ModelAndView response = new ModelAndView();


        response.setViewName("login/signup");

        signupFormBean form = new signupFormBean();
        response.addObject("form", form);

        return response;
    }

    @RequestMapping(value = "/login/signUpSubmit", method = {RequestMethod.POST, RequestMethod.GET} )
    public ModelAndView signupSubmit(@Valid signupFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();
        log.info(form.toString());

        if (bindingResult.hasErrors()) {

            List<String> errorMessages = new ArrayList<>();

            for (ObjectError error : bindingResult.getAllErrors()) {
                log.info( ((FieldError) error).getField() + " " + error.getDefaultMessage());
            }

            response.addObject("form", form);


            response.addObject("errorMessages", errorMessages);
            response.addObject("bindingResult", bindingResult);


            response.setViewName("login/signup");
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
        response.setViewName("login/signup");

        User user = userDAO.findById(userId);

        EditUserFormBean form = new EditUserFormBean();
        userRoleFormBean userRoleForm = new userRoleFormBean();

        form.setId(user.getId());
        form.setEmail(form.getEmail());
        form.setFirstName(form.getFirstName());
        form.setLastName(form.getLastName());
        userRoleForm.setUserRole(userRoleForm.getUserRole());
        userRoleForm.setUserId(user.getId());

        userDAO.save(user);


        response.addObject("form", form);

        return response;
    }
}
