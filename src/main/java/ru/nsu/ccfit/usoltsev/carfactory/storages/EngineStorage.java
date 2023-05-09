package ru.nsu.ccfit.usoltsev.carfactory.storages;

import ru.nsu.ccfit.usoltsev.carfactory.details.Engine;

import java.util.LinkedList;

public class EngineStorage extends Storage<Engine> {
    public EngineStorage(int storageCapacity){
        super(storageCapacity);
    }
}
