package ru.nsu.ccfit.usoltsev.carfactory.storages;

import javafx.application.Platform;
import ru.nsu.ccfit.usoltsev.carfactory.FillListener;
import ru.nsu.ccfit.usoltsev.carfactory.details.Detail;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class Storage<D extends Detail> {

    private final LinkedList<D> itemList;
    private final int storageCapacity;
    private final AtomicInteger storageFill;
    private final FillListener listener;

    public Storage(int storageCapacity, FillListener listener) {
        this.storageCapacity = storageCapacity;
        this.listener = listener;
        itemList = new LinkedList<>();
        storageFill = new AtomicInteger(0);

    }

    public synchronized void put(D newDetail) {
        while (itemList.size() >= storageCapacity) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
        itemList.add(newDetail);
        storageFill.incrementAndGet();
        Platform.runLater(() -> listener.updateFill(storageFill, this.getClass().getSimpleName()));
        System.out.println("Put new " + newDetail.getClass().getSimpleName() + ", id: " + newDetail.getID() + " fill:" + storageFill.intValue());
        notifyAll();
    }

    public synchronized D get() {
        while (itemList.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
        D retItem = itemList.removeFirst();
        storageFill.decrementAndGet();
        Platform.runLater(() -> listener.updateFill(storageFill, this.getClass().getSimpleName()));
        notifyAll();
        return retItem;
    }

}
