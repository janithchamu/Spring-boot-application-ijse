package com.ijse.intro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ijse.intro.entity.Task;
import com.ijse.intro.services.TaskService;


@RestController
public class TaskController {

   @Autowired
   private TaskService taskService;

   @GetMapping("/tasks")
   private ResponseEntity<List<Task>> getAllTasks(){
      List<Task> allTasks =  taskService.getAllTasks();

      return ResponseEntity.status(200).body(allTasks);
   }

   @PostMapping("/task")
   private ResponseEntity<String> createTask(@RequestBody Task task){
           if(task.getTaskName() == null || task.getTaskName() == ""){
               return ResponseEntity.status(422).body("Please Enter a Task Name");
           }
           if(task.getPriority()==null){
              return ResponseEntity.status(422).body(" Please Enter Valid Priority");
           }

           taskService.createTask(task);

           return ResponseEntity.status(201).body("Task add Successfuly");
   }

   @PutMapping("/task/{taskId}")
   private ResponseEntity<Task> updateTask(@PathVariable long taskId, @RequestBody Task task){
      Task updatedTask = taskService.updateTask(taskId, task);

      if(updatedTask == null){
        return ResponseEntity.status(404).body(null);
      }
      else{
        return ResponseEntity.status(200).body(task);
      }
      
   }

   @GetMapping("/task/{taskId}")
   private ResponseEntity<Task> getTaskbyId(@PathVariable long taskId){

     Task task = taskService.getTaskById(taskId);
     if(task == null){
      return ResponseEntity.status(404).body(null);
      }
      else{
        return ResponseEntity.status(200).body(task);
      }

   }

   @DeleteMapping("/task/{taskId}")
   private void taskDeleteById(@PathVariable long taskId){
       taskService.taskDeleteById(taskId);
   }

   @DeleteMapping("/alltasks")
   private void deleteAllTasks(){
    taskService.deleteAllTasks();
   }
}
