package com.udemy.webservicecourse.services;

import com.udemy.webservicecourse.entities.Product;
import com.udemy.webservicecourse.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> findAll() {
        return repo.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> obj = repo.findById(id);

        return obj.get();
    }
}
