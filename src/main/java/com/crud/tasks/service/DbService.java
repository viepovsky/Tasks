package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbService {
    private final TaskRepository repository;

    public List<Task> getAllTasks(){
        return repository.findAll();
    }
    public Task getTask(Long taskId){
        Optional<Task> possibleTask = repository.findById(taskId);
        if (possibleTask.isPresent()){
            return possibleTask.get();
        } else{
            return null;
        }
    }
    public void deleteTask(Long taskId){

    }
    public Task updateTask(Task task){
        return null;
    }
    public void createTask(Task task){

    }
}
