package com.theu.todoolist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.theu.todoolist.models.Task;

@Repository
public interface TaskRepositories extends JpaRepository<Task, Long> {
    
    List<Task> findByUserId(Long id);
}
