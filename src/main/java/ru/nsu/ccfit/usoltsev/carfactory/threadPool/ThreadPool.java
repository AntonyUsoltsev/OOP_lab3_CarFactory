package ru.nsu.ccfit.usoltsev.carfactory.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public ExecutorService executorService;

    public ThreadPool() {
        this.executorService = Executors.newFixedThreadPool(4);
    }

    public void killThreadPool() {
        executorService.shutdown();
    }
}
