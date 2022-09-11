package com.udemy.webservicecourse.repositories;

import com.udemy.webservicecourse.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
