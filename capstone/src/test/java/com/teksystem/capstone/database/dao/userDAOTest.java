package com.teksystem.capstone.database.dao;

import com.teksystem.capstone.database.DAO.orderDAO;
import com.teksystem.capstone.database.DAO.userDAO;
import com.teksystem.capstone.database.entity.Order;
import com.teksystem.capstone.database.entity.OrderProduct;
import com.teksystem.capstone.database.entity.Product;
import com.teksystem.capstone.database.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class userDAOTest {

    @Autowired
    userDAO userDao;

    @Autowired
    orderDAO orderDao;

    @BeforeEach
    public void setUpTest() {
        userDao.deleteAll();

        User user = new User();

        user.setId(20);
        user.setEmail("ff@gmail.com");
        user.setFirstName("John");
        user.setLastName("Smith");
        user.setPassword("password");
        user.setCreateDate(new Date());



        Order order = new Order();
        Set<OrderProduct> orderProducts = new HashSet<>();
        Product product = new Product(2, "ps1", "sony", "", 60.00);

        order.setId(20);
        order.setStatus("pending");
        order.setUser(user);
        order.setCreditCard("password");
        order.setOrderDate(new Date());
        OrderProduct op = new OrderProduct(2, product, order);
        orderProducts.add(op);
        order.setOrderProducts(orderProducts);

        userDao.save(user);
    }


    @Test
    public void findByEmailTest() {
        User checkUser = userDao.findByEmail("ff@gmail.com");

        Assertions.assertThat(checkUser);
    }

    @Test
    public void findByFirstNameIgnoreCaseContainingTest() {
        List<User> checkUser = userDao.findByFirstNameIgnoreCaseContaining("john");

        Assertions.assertThat(checkUser);
    }
}