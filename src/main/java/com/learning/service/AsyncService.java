package com.learning.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class AsyncService {

    @Async("taskExecutor")
    public Future<String> processTask(String taskName, int delay) throws InterruptedException {
        System.out.println("Started " + taskName + " on thread: " + Thread.currentThread().getName());
        Thread.sleep(delay); // simulate long-running task
        return new AsyncResult<>(taskName + " completed");
    }
}

