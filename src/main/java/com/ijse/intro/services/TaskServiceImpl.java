package com.ijse.intro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.intro.entity.Task;
import com.ijse.intro.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
       return taskRepository.findAll();
        
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(long taskId, Task task) {
       Task to_change_task = taskRepository.findById(taskId).orElse(null);
       if(to_change_task == null ){
          return null;
       }
       else{
          to_change_task.setTaskName(task.getTaskName());
          to_change_task.setPriority(task.getPriority());
          to_change_task.setDueDate(task.getDueDate());

          return taskRepository.save(to_change_task);
          
       }
    }

    @Override
    public Task getTaskById(long taskId) {
       return  taskRepository.findById(taskId).orElse(null);
    }

    @Override
    public void taskDeleteById(long taskId) {
        taskRepository.deleteById(taskId);
    }
      
   

    @Override
    public void deleteAllTasks() {
        taskRepository.deleteAll();
    }

}
