package com.theu.todoolist.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theu.todoolist.models.User;
import com.theu.todoolist.repositories.UserRepositories;

import jakarta.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepositories userRepositories;

    public User findById(Long id) {
        Optional<User> user = this.userRepositories.findById(id);

        return user.orElseThrow(() -> new RuntimeException("Couldn't find"));
    }

    @Transactional
    public User create(User obj) {
        obj.setId(obj.getId());
        obj = this.userRepositories.save(obj);
        return obj;
    }

    @Transactional
    public User update(User obj) {
        User newObj = findById(obj.getId());
        newObj.setPassword(obj.getPassword());
        return this.userRepositories.save(newObj);
    }

    public void delete(Long id) {
        findById(id);
        try {
            this.userRepositories.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting");
        }
    }
}
