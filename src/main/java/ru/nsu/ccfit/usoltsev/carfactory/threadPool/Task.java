package ru.nsu.ccfit.usoltsev.carfactory.threadPool;

import ru.nsu.ccfit.usoltsev.carfactory.details.Auto;
import ru.nsu.ccfit.usoltsev.carfactory.details.Detail;
import ru.nsu.ccfit.usoltsev.carfactory.storages.Storage;

import java.util.LinkedList;
import java.util.concurrent.Callable;

public class Task implements Callable<Auto> {

    private final LinkedList<Storage<? extends Detail>> detailStorages;

    public Task(LinkedList<Storage<? extends Detail>> inpDetailStorage) {
        this.detailStorages = new LinkedList<>(inpDetailStorage);
    }

    @Override
    public Auto call() {
        LinkedList<Detail> details = new LinkedList<>();
        for (Storage<? extends Detail> str : detailStorages) {
            details.add(str.get());
        }
        return new Auto(details);
    }
}
