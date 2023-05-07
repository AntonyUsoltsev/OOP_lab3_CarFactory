package ru.nsu.ccfit.usoltsev.carfactory;

import ru.nsu.ccfit.usoltsev.carfactory.storages.EngineStorage;

public class Factory extends Thread {

    EngineStorage engineStorage;
    public Factory(EngineStorage storage){
        this.engineStorage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            System.out.println("get eng on fact:" + engineStorage.get() );
        }
    }
}
