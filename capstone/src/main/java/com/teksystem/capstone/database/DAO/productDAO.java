package com.teksystem.capstone.database.DAO;

import com.teksystem.capstone.database.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface productDAO extends JpaRepository<Product, Long> {
    public Product findById(@Param("id")Integer id);

    public Product findProductByName(@Param("name") String name);

    public Product findProductByImageURL(@Param("imageURL") String imageURL);

    public Product findProductByDescription(@Param("description") String description);

    public List<Product> findByPrice(@Param("price") Double price);

    public List<Product> findByNameIgnoreCaseContaining(@Param("name") String name);


}
