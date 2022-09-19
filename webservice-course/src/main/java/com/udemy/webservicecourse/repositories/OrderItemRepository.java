package com.udemy.webservicecourse.repositories;

import com.udemy.webservicecourse.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
