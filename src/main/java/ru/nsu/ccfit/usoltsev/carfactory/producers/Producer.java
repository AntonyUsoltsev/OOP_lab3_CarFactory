package ru.nsu.ccfit.usoltsev.carfactory.producers;

import ru.nsu.ccfit.usoltsev.carfactory.details.Detail;
import ru.nsu.ccfit.usoltsev.carfactory.storages.Storage;

public class Producer<S extends Storage<D>, D extends Detail> extends Thread{
    private final S storage;
    private final int sleepTime;
    public Producer(S storage, int sleepTime){
        this.storage = storage;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                storage.put((D) new Detail());
                Thread.sleep(sleepTime);
            }
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}
