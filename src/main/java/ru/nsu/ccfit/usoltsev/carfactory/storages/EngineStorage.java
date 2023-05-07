package ru.nsu.ccfit.usoltsev.carfactory.storages;

import java.util.LinkedList;

public class EngineStorage {
    private LinkedList<String> engineList = new LinkedList<>();
    private int maxSize = 3;

    public synchronized void put(String newEngine){
        while (engineList.size()>=maxSize) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        engineList.add(newEngine);
        notify();
    }

    public synchronized String get(){
        while (engineList.isEmpty()) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        String retStr = engineList.removeFirst();
        notify();
        return retStr;
    }
}
