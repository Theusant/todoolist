package com.theu.todoolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.theu.todoolist.models.User;

@Repository
public interface UserRepositories extends JpaRepository<User, Long> {
    
}
