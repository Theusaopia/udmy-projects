package com.udemy.webservicecourse.services;

import com.udemy.webservicecourse.entities.User;
import com.udemy.webservicecourse.repositories.UserRepository;
import com.udemy.webservicecourse.services.exceptions.DatabaseException;
import com.udemy.webservicecourse.services.exceptions.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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

        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj) {
        return repo.save(obj);
    }

    public void delete(Long id) {
        try {
            repo.deleteById(id);
        }
        catch (EmptyResultDataAccessException ex) {
            throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException ex) {
            throw new DatabaseException(ex.getMessage());
        }
    }

    public User update(Long id, User obj) {
        try {
            User entity = repo.getReferenceById(id);

            updateData(entity, obj);

            return repo.save(entity);
        }
        catch (EntityNotFoundException ex) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User obj) {
        entity.setEmail(obj.getEmail());
        entity.setName(obj.getName());
        entity.setPhone(obj.getPhone());
    }
}
