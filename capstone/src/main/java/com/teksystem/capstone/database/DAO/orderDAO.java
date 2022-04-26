package com.teksystem.capstone.database.DAO;

import com.teksystem.capstone.database.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface orderDAO extends JpaRepository<Order, Long> {
    public Order findById(@Param("id")Integer id);

    public Order findByUserId(@Param("userId") Integer userId);

    public Order findByCreditCard(@Param("creditCard") String creditCard);

    public List<Order> findByOrderDate(@Param("orderDate") Date orderDate);

    public List<Order> findByStatus(@Param("status") String status);

    @Query(value = "SELECT * FROM orders WHERE user_id = :userId AND status = :status", nativeQuery = true)
    public Order findOrderByUserIdAndStatus(@Param("userId") Integer userId, @Param("status") String status);
}
