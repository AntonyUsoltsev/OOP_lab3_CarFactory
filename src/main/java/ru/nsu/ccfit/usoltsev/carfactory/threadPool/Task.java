package ru.nsu.ccfit.usoltsev.carfactory.threadPool;

import ru.nsu.ccfit.usoltsev.carfactory.details.Auto;
import ru.nsu.ccfit.usoltsev.carfactory.details.Engine;
import ru.nsu.ccfit.usoltsev.carfactory.storages.EngineStorage;

import java.util.concurrent.Callable;

public class Task implements Callable<Auto> {
    EngineStorage engineStorage;

    public Task(EngineStorage engineStorage) {
        this.engineStorage = engineStorage;
    }

    public Auto call() {
        Engine engine = engineStorage.get();
        return new Auto(engine);
    }
}
