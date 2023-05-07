package ru.nsu.ccfit.usoltsev.carfactory.producers;

import ru.nsu.ccfit.usoltsev.carfactory.storages.EngineStorage;

public class EngineProducer extends Thread{
    EngineStorage engineStorage;
    public EngineProducer(EngineStorage storage){
        this.engineStorage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            engineStorage.put("New engine №" + i );
            System.out.println("Put new eng №" + i );
        }
    }
}
