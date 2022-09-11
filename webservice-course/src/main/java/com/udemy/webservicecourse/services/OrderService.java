package com.udemy.webservicecourse.services;

import com.udemy.webservicecourse.entities.Order;
import com.udemy.webservicecourse.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository repo;

    public OrderService(OrderRepository repo) {
        this.repo = repo;
    }

    public List<Order> findAll() {
        return repo.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> obj = repo.findById(id);

        return obj.get();
    }
}
