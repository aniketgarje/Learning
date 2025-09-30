package com.learning.controller;

import com.learning.service.AsyncService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final AsyncService asyncService;

    public TaskController(AsyncService asyncService) {
        this.asyncService = asyncService;
    }

    @GetMapping("/process")
    public ResponseEntity<String> processTasks() throws InterruptedException, ExecutionException {
        Future<String> task1 = asyncService.processTask("Task1", 2000);
        Future<String> task2 = asyncService.processTask("Task2", 4000);
        Future<String> task3 = asyncService.processTask("Task3", 1000);

        // Wait for results (blocking)
        String result = task1.get() + ", " + task2.get() + ", " + task3.get();

        return ResponseEntity.ok("All tasks completed: " + result);
    }
}

