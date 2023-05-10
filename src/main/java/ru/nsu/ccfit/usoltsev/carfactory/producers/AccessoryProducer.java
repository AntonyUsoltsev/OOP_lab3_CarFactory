package ru.nsu.ccfit.usoltsev.carfactory.producers;

import ru.nsu.ccfit.usoltsev.carfactory.details.Accessories;
import ru.nsu.ccfit.usoltsev.carfactory.storages.AccessoryStorage;

import java.util.concurrent.TimeUnit;

public class AccessoryProducer extends Thread {
    AccessoryStorage accessoryStorage;

    public AccessoryProducer(AccessoryStorage accessoryStorage) {
        this.accessoryStorage = accessoryStorage;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                accessoryStorage.put(new Accessories());
                TimeUnit.MILLISECONDS.sleep(1500);
            }
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}
