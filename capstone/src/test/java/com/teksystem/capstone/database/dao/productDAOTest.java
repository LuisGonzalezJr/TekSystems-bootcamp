package com.teksystem.capstone.database.dao;


import com.teksystem.capstone.database.DAO.productDAO;
import com.teksystem.capstone.database.entity.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;


@SpringBootTest
public class productDAOTest {

    @Autowired
    productDAO productDao;


    @Test
    public void createProductTest() {
        Product product = new Product();

        product.setId(2);
        product.setName("ps1");
        product.setDescription("sony playstation console");
        product.setImageURL("playstation1");
        product.setPrice(60.00);

        productDao.save(product);

        Product checkProduct = productDao.findProductByName("ps1");

        Assertions.assertThat(checkProduct.getName().equals(product.getName()));
    }


    @Test
    public void findProductByDescriptionTest() {
        Product checkProduct = productDao.findProductByDescription("sony");

        Assertions.assertThat(checkProduct);
    }

    @Test
    public void findProductByNameTest() {
        Product checkProduct = productDao.findProductByName("ps1");

        Assertions.assertThat(checkProduct);
    }

    @Test
    public void findProductByImageURLTest() {
        Product checkProduct = productDao.findProductByImageURL("");

        Assertions.assertThat(checkProduct);
    }

    @Test
    public void findByPriceTest() {
        List<Product> checkProduct = productDao.findByPrice(60.00);

        Assertions.assertThat(checkProduct);
    }

    @Test
    public void findByNameIgnoreCaseContainingTest() {
        List<Product> checkProduct = productDao.findByNameIgnoreCaseContaining("ps1");

        Assertions.assertThat(checkProduct);
    }
}
