package com.udemy.webservicecourse.repositories;

import com.udemy.webservicecourse.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
