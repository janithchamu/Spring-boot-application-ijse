package com.ijse.intro.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ijse.intro.entity.Task;



@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

     
}
