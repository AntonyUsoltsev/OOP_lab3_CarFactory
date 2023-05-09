package ru.nsu.ccfit.usoltsev.carfactory.threadPool;

import ru.nsu.ccfit.usoltsev.carfactory.dealers.Dealer;
import ru.nsu.ccfit.usoltsev.carfactory.details.Auto;
import ru.nsu.ccfit.usoltsev.carfactory.details.Body;
import ru.nsu.ccfit.usoltsev.carfactory.details.Detail;
import ru.nsu.ccfit.usoltsev.carfactory.details.Engine;
import ru.nsu.ccfit.usoltsev.carfactory.storages.AccessoryStorage;
import ru.nsu.ccfit.usoltsev.carfactory.storages.BodyStorage;
import ru.nsu.ccfit.usoltsev.carfactory.storages.EngineStorage;

import java.util.LinkedList;
import java.util.concurrent.Callable;

public class Task implements Callable<Auto> {
    EngineStorage engineStorage;
    BodyStorage bodyStorage;
    AccessoryStorage accessoryStorage;

    public Task(EngineStorage engineStorage, BodyStorage bodyStorage,AccessoryStorage accessoryStorage) {
        this.engineStorage = engineStorage;
        this.bodyStorage = bodyStorage;
        this.accessoryStorage = accessoryStorage;
    }

    public Auto call() {
//        Engine engine = engineStorage.get();
//        Body body = bodyStorage.get();

        LinkedList<Detail> details = new LinkedList<>();
        details.add(engineStorage.get());
        details.add(bodyStorage.get());
        details.add(accessoryStorage.get());
        return new Auto(details);
    }
}
