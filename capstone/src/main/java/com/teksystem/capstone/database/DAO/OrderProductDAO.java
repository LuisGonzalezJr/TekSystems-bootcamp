package com.teksystem.capstone.database.DAO;


import com.teksystem.capstone.database.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OrderProductDAO extends JpaRepository<OrderProduct, Long> {
    public OrderProduct findById(@Param("id")Integer id);

    @Query(value = "select product_id, count(*) as cnt, p.name from order_products op, products p where op.product_id = p.id group by product_id", nativeQuery = true)
    List<Map<String,Object>> getProductNameAndOrderCount();
}
