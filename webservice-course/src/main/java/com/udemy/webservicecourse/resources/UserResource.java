package com.udemy.webservicecourse.resources;

import com.udemy.webservicecourse.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User u = new User(1L, "Matheus", "matheus@email.com", "45998520914", "corinthians");

        return ResponseEntity.ok(u);
    }
}
