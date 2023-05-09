package ru.nsu.ccfit.usoltsev.carfactory.producers;

import ru.nsu.ccfit.usoltsev.carfactory.details.Engine;
import ru.nsu.ccfit.usoltsev.carfactory.storages.EngineStorage;

public class EngineProducer extends Thread {
    EngineStorage engineStorage;

    public EngineProducer(EngineStorage storage) {
        this.engineStorage = storage;
    }

//    public EngineProducer(EngineStorage storage, int sleepTime) {
//        super(storage, sleepTime);
//    }
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                engineStorage.put(new Engine());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}
