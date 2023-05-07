package ru.nsu.ccfit.usoltsev.carfactory.storages;

import ru.nsu.ccfit.usoltsev.carfactory.details.Auto;
import ru.nsu.ccfit.usoltsev.carfactory.details.Engine;

import java.util.LinkedList;

public class AutoStorage {
    private final LinkedList<Auto> autoList = new LinkedList<>();
    private final int storageSize = 5;

    public synchronized void put(Auto newAuto){
        while (autoList.size() >= storageSize) {
            try {
                wait();
            }
            catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
        autoList.add(newAuto);
     //   System.out.println("Put new engine, id: " + newEngine.getEngineID());
        notify();
    }

    public synchronized Auto get(){
        while (autoList.isEmpty()) {
            try {
                wait();
            }
            catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
        Auto retAuto = autoList.removeFirst();
        notify();
        return retAuto;
    }
}
