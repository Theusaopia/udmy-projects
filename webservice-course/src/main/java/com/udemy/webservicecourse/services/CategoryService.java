package com.udemy.webservicecourse.services;

import com.udemy.webservicecourse.entities.Category;
import com.udemy.webservicecourse.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository repo;

    public CategoryService(CategoryRepository repo) {
        this.repo = repo;
    }

    public List<Category> findAll() {
        return repo.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> obj = repo.findById(id);

        return obj.get();
    }
}
