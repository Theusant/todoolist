package com.theu.todoolist.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theu.todoolist.models.Task;
import com.theu.todoolist.models.User;
import com.theu.todoolist.repositories.TaskRepositories;

import jakarta.transaction.Transactional;

@Service
public class TaskService {

    @Autowired
    private UserService userService;

    @Autowired
    private TaskRepositories taskRepositories;

    public Task findById(Long id) {
        Optional<Task> task = this.taskRepositories.findById(id);
        return task.orElseThrow(() -> new RuntimeException("Couldn't find"));
    }

    @Transactional
    public Task create (Task obj) {
        User user = this.userService.findById(obj.getUser().getId());
        obj.setId(null);
        obj.setUser(user);
        obj = this.taskRepositories.save(obj);
        return obj;
    }

    @Transactional
    public Task update (Task obj) {
        Task newObj = findById(obj.getId());
        newObj.setDescription(obj.getDescription());
        return this.taskRepositories.save(newObj);
    }

    public void delete(Long id) {
        findById(id);
        try {
            this.taskRepositories.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting");
        }
    }
}
