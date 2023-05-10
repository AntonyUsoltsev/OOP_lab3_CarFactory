package ru.nsu.ccfit.usoltsev.carfactory;

import ru.nsu.ccfit.usoltsev.carfactory.details.Auto;
import ru.nsu.ccfit.usoltsev.carfactory.storages.*;
import ru.nsu.ccfit.usoltsev.carfactory.threadPool.Task;
import ru.nsu.ccfit.usoltsev.carfactory.threadPool.ThreadPool;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Factory {
    private final LinkedList<Storage> detailStorage;
    private final AutoStorage autoStorage;
    private final ThreadPool workers;

    public Factory(EngineStorage engineStorage, BodyStorage bodyStorage, AccessoryStorage accessoryStorage, AutoStorage autoStorage) {
        detailStorage = new LinkedList<>();
        detailStorage.add(engineStorage);
        detailStorage.add(bodyStorage);
        detailStorage.add(accessoryStorage);
        this.autoStorage = autoStorage;
        this.workers = new ThreadPool();
    }

    public void createAuto() throws ExecutionException, InterruptedException {
            Future<Auto> future = workers.executorService.submit(new Task(detailStorage));
            Auto newAuto = future.get();
            autoStorage.put(newAuto);
    }
}
