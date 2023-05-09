package ru.nsu.ccfit.usoltsev.carfactory.storages;

import ru.nsu.ccfit.usoltsev.carfactory.details.Detail;
import ru.nsu.ccfit.usoltsev.carfactory.details.Engine;

import java.util.LinkedList;

public class Storage<D extends Detail> {

    private final LinkedList<D> engineList = new LinkedList<>();
    private final int storageCapacity;

    public Storage(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    public synchronized void put(D newDetail) {
        while (engineList.size() >= storageCapacity) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
        engineList.add(newDetail);
        System.out.println("Put new " + newDetail.getClass().getSimpleName() + " id: " + newDetail.getID());
        notify();
    }

    public synchronized D get() {
        while (engineList.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
        D retStr = engineList.removeFirst();
        notify();
        return retStr;
    }

}
