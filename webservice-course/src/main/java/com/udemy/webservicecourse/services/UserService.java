package com.udemy.webservicecourse.services;

import com.udemy.webservicecourse.entities.User;
import com.udemy.webservicecourse.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = repo.findById(id);

        return obj.get();
    }

    public User insert(User obj) {
        return repo.save(obj);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
