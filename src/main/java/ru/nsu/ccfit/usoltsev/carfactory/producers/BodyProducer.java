package ru.nsu.ccfit.usoltsev.carfactory.producers;

import ru.nsu.ccfit.usoltsev.carfactory.details.Body;
import ru.nsu.ccfit.usoltsev.carfactory.storages.BodyStorage;

public class BodyProducer extends Thread {

    BodyStorage bodyStorage;

    public BodyProducer(BodyStorage bodyStorage) {
        this.bodyStorage = bodyStorage;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                bodyStorage.put(new Body());
                Thread.sleep(1500);
            }
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}
