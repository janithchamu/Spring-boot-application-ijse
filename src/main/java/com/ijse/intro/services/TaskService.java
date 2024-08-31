package com.ijse.intro.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.intro.entity.Task;


@Service
public interface TaskService {
   
      List<Task> getAllTasks();
      Task createTask(Task task);
	Task updateTask(long taskId, Task task);
      Task getTaskById(long taskId);
      void taskDeleteById(long taskId);
      void deleteAllTasks();

}
