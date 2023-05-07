package ru.nsu.ccfit.usoltsev.carfactory;

import ru.nsu.ccfit.usoltsev.carfactory.details.Auto;
import ru.nsu.ccfit.usoltsev.carfactory.details.Engine;
import ru.nsu.ccfit.usoltsev.carfactory.storages.AutoStorage;
import ru.nsu.ccfit.usoltsev.carfactory.storages.EngineStorage;
import ru.nsu.ccfit.usoltsev.carfactory.threadPool.Task;
import ru.nsu.ccfit.usoltsev.carfactory.threadPool.ThreadPool;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Factory extends Thread {
    EngineStorage engineStorage;
    AutoStorage autoStorage;
    ThreadPool threadPool;

    public Factory(EngineStorage storage,AutoStorage autoStorage) {
        this.engineStorage = storage;
        this.autoStorage = autoStorage;
        this.threadPool = new ThreadPool();
    }

    @Override
    public void run() {
        try {
            while(!Thread.currentThread().isInterrupted()){
//            System.out.println("get eng on fact:" + engineStorage.get());
                Future<Auto> future = threadPool.executorService.submit(new Task(engineStorage));
                Auto newAuto = future.get();
                autoStorage.put(newAuto);
                System.out.println("Manufacture new car: " + newAuto.getAutoID() + " engine id:"+ newAuto.getEngine().getEngineID());
                Thread.sleep(500);
            }

            threadPool.killThreadPool();
        }
        catch (InterruptedException | ExecutionException e){
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }
}
