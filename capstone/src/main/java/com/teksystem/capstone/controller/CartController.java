package com.teksystem.capstone.controller;

import com.teksystem.capstone.database.DAO.orderDAO;
import com.teksystem.capstone.database.DAO.orderProductDAO;
import com.teksystem.capstone.database.DAO.productDAO;
import com.teksystem.capstone.database.DAO.userDAO;
import com.teksystem.capstone.database.entity.Order;
import com.teksystem.capstone.database.entity.OrderProduct;
import com.teksystem.capstone.database.entity.Product;
import com.teksystem.capstone.database.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class CartController {
    @Autowired
    private userDAO userDao;

    @Autowired
    private orderDAO orderDao;

    @Autowired
    private productDAO productDao;

    @Autowired
    private orderProductDAO orderProductDao;

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public ModelAndView viewCart() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/cart");

        List<OrderProduct> orders = orderProductDao.findAll();

        response.addObject("orders", orders);
        return response;
    }

    @RequestMapping(value = "/AddCart/{productId}", method = RequestMethod.GET)
    public ModelAndView addItemToList(@PathVariable("productId") Integer productId) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/cart");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userDao.findByEmail(username);

        Product product = productDao.findById(productId);
        OrderProduct cartItem;
        Order order = orderDao.findOrderByUserIdAndStatus(user.getId(), "PENDING");
        if (order == null) {
            order = new Order();
            order.setStatus("PENDING");
            order.setUser(user);

            cartItem = new OrderProduct();
            cartItem.setOrder(order);
            cartItem.setProduct(product);
            cartItem.setQuantity(1);
        } else {
            if (order.getStatus().equals("COMPLETE")) {
                order = new Order();
                order.setStatus("active");

                cartItem = new OrderProduct();
                cartItem.setOrder(order);
                cartItem.setProduct(product);
                cartItem.setQuantity(1);
                orderProductDao.save(cartItem);

            } else {
                cartItem = orderProductDao.findOrderProductByProductAndOrder(product, order);
                if (cartItem == null){
                    cartItem = new OrderProduct();
                    cartItem.setOrder(order);
                    cartItem.setProduct(product);
                    cartItem.setQuantity(1);
                }
                else{
                    cartItem.setQuantity(cartItem.getQuantity() + 1);
                }
            }
        }
        orderDao.save(order);
        orderProductDao.save(cartItem);
        log.info("added: " + cartItem.getProduct().getName());
        return response;
    }
    @RequestMapping(value = "/cart/delete/{orderProductId}", method = RequestMethod.GET)
    public ModelAndView deleteProduct(@PathVariable("orderProductId") Integer orderProductId) throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("user/cart");
        OrderProduct cartItem = orderProductDao.findById(orderProductId);
        if(cartItem == null){
            String error = "No Items";
            response.addObject("error", error);
        }
        else{
            orderProductDao.delete(cartItem);
            log.info("Remove Item: " + cartItem.getId());
        }
        return response;
    }


}
