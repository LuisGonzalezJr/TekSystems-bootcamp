package com.teksystem.capstone.controller;


import com.teksystem.capstone.database.DAO.productDAO;
import com.teksystem.capstone.database.entity.Product;
import com.teksystem.capstone.formbean.ProductFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Slf4j
@Controller
public class ProductController {

    @Autowired
    private productDAO productDAO;

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public ModelAndView product() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/product");

        return response;
    }

    @RequestMapping(value = "/product/productSubmit", method = RequestMethod.POST)
    public ModelAndView submit(@Valid ProductFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/product");

        if(bindingResult.hasErrors()) {
            for(FieldError error : bindingResult.getFieldErrors()) {
                log.debug(error.toString());
            }

            response.addObject("bindingResult", bindingResult);
            response.addObject("form", form);

        } else {
            Product product = new Product();
            product.setName(form.getProductName());
            product.setDescription(form.getDescription());
            product.setPrice(form.getPrice());
            product.setImageURL(form.getImageURL());

            productDAO.save(product);
        }

        log.debug(form.toString());

        return response;
    }

    @RequestMapping(value = "/product/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@Param("id")Integer id) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("product");

        Product p = productDAO.findById(id);
        if(p == null) {
        } else {
            productDAO.delete(p);
        }

        return response;
    }
}
