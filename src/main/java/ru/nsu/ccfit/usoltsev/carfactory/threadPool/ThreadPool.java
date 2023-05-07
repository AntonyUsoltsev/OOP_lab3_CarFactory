package ru.nsu.ccfit.usoltsev.carfactory.threadPool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPool {
    public ExecutorService executorService;
    public ThreadPool() {
        this.executorService = Executors.newFixedThreadPool(4);
//        Future<Integer> future = executorService.submit(() -> {
//            // выполнение асинхронной задачи
//            return 42;
//        });
//        // получение результата выполнения задачи
//        int result = future.get();
//        executorService.shutdown();
    }
    public void killThreadPool(){
        executorService.shutdown();
    }
}
