package com.udemy.webservicecourse.repositories;

import com.udemy.webservicecourse.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
