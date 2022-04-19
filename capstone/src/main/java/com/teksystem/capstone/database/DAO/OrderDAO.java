package com.teksystem.capstone.database.DAO;

import com.teksystem.capstone.database.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface OrderDAO extends JpaRepository<Order, Long> {
    public Order findById(@Param("id")Integer id);
}
