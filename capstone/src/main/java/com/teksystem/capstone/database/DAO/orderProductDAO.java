package com.teksystem.capstone.database.DAO;


import com.teksystem.capstone.database.entity.Order;
import com.teksystem.capstone.database.entity.OrderProduct;
import com.teksystem.capstone.database.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


public interface orderProductDAO extends JpaRepository<OrderProduct, Long> {
    public OrderProduct findById(@Param("id") Integer id);
    public List<OrderProduct> findByOrderId(@Param("orderId") Integer orderId);
    public OrderProduct findByProductId(@Param("productId") Integer Productid);
    public OrderProduct findByQuantity(@Param("quantity") Integer quantity);

    @Query(value=" select product_id, count(*) as cnt, p.name from order_products op, products p where op.product_id = p.id group by product_id",
            nativeQuery = true)
    List<Map<String,Object>> getProductNameAndOrderCount();

    @Query(value="select p.id as product_id, p.name, p.price, op.quantity, o.id as order_id, (price * quantity) as total " +
            "from products p, order_products op, orders o " +
            "where p.id = op.product_id and o.id = op.order_id " +
            "and o.user_id = :userId and status = :status", nativeQuery = true)
    List<Map<String,Object>> getCartProducts(@Param("userId") Integer userId, @Param("status") String status );

    @Query(value="select p.*, op.quantity from products p, order_products op, orders o where p.id = op.product_id and o.id = op.order_id and o.id = 1",
            nativeQuery = true)
    List<Map<String,Object>> getProductsInOrder();

    @Query("select oP from OrderProduct as oP where oP.product = :product and oP.order = :order")
    public OrderProduct findOrderProductByProductAndOrder(@Param("product") Product product, @Param("order") Order order);
}