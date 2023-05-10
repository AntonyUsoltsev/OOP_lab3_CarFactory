package ru.nsu.ccfit.usoltsev.carfactory.storages;

import ru.nsu.ccfit.usoltsev.carfactory.details.Detail;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class Storage<D extends Detail> {

    private final LinkedList<D> itemList;
    private final int storageCapacity;
    private final AtomicInteger storageFill;

    public Storage(int storageCapacity) {
        this.storageCapacity = storageCapacity;
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
        System.out.println("Put new " + newDetail.getClass().getSimpleName() + ", id: " + newDetail.getID() + " fill:" + storageFill.intValue());
        notify();
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
        notifyAll();
        return retItem;
    }

    public AtomicInteger getStorageFill() {
        return storageFill;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }
}
