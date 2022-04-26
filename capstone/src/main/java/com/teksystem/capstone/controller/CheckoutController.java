package com.teksystem.capstone.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class CheckoutController {

    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public ModelAndView checkout() throws Exception {

        ModelAndView response = new ModelAndView();
        response.setViewName("user/checkout");

        return response;
    }

    @RequestMapping(value = "/checkoutSubmit", method = RequestMethod.POST)
    public ModelAndView checkoutSubmit() throws Exception {

        ModelAndView response = new ModelAndView();
        response.setViewName("redirect:/home");

        return response;
    }
}
