package com.example.techtask.repository;

import com.example.techtask.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {


    @Query(value = """
            SELECT u.id, u.email, u.user_status
            FROM users u
                     JOIN orders o ON u.id = o.user_id
            WHERE
                EXTRACT(YEAR FROM o.created_at) = 2003
              AND o.order_status = 'DELIVERED'
              AND (o.price * o.quantity) = (
                SELECT MAX(price * quantity)
                FROM orders
                WHERE EXTRACT(YEAR FROM created_at) = 2003
                  AND order_status = 'DELIVERED')
                  """, nativeQuery = true)
    User findUserWithMaxTotalPrice();


    @Query(value = """
        SELECT u.id, u.email, u.user_status
        FROM users u
                 JOIN orders o ON u.id = o.user_id
        WHERE
            EXTRACT(YEAR FROM o.created_at) = 2010
          AND o.order_status = 'PAID'
        """, nativeQuery = true)
    List<User> findUsersWithPaidOrder();
}
