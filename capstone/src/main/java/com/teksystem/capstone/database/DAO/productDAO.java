package com.teksystem.capstone.database.DAO;

import com.teksystem.capstone.database.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface productDAO extends JpaRepository<Product, Long> {
    public Product findById(@Param("id")Integer id);

    public Product findByName(@Param("name")String name);

   // public List<Product> findProductByNameAndDescription(String Switch);
}
