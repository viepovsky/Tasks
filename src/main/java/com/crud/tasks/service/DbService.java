package com.crud.tasks.service;

import com.crud.tasks.exceptions.TaskNotFoundException;
import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbService {
    private final TaskRepository repository;

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task getTask(Long id) throws TaskNotFoundException {
        return repository.findById(id).orElseThrow(TaskNotFoundException::new);
    }

    public Task saveTask(Task task) {
        return repository.save(task);
    }

    public Task updateTask(Task task) throws TaskNotFoundException {
        if (repository.findById(task.getId()).isPresent()) {
            return repository.save(task);
        } else {
            throw new TaskNotFoundException();
        }
    }

    public void deleteTask(Long id) throws TaskNotFoundException {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
        } else {
            throw new TaskNotFoundException();
        }

    }

}
