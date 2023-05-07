package ru.nsu.ccfit.usoltsev.carfactory.storages;

import ru.nsu.ccfit.usoltsev.carfactory.details.Engine;

import java.util.LinkedList;

public class EngineStorage {
    private final LinkedList<Engine> engineList = new LinkedList<>();
    private final int storageSize = 5;

    public synchronized void put(Engine newEngine){
        while (engineList.size() >= storageSize) {
            try {
                wait();
            }
            catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
        engineList.add(newEngine);
        System.out.println("Put new engine, id: " + newEngine.getEngineID());
        notify();
    }

    public synchronized Engine get(){
        while (engineList.isEmpty()) {
            try {
                wait();
            }
            catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
        Engine retStr = engineList.removeFirst();
        notify();
        return retStr;
    }
}
