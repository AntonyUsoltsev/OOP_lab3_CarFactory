package ru.nsu.ccfit.usoltsev.carfactory.details;

import java.util.UUID;

public class Engine {
    UUID engineID;
    public Engine(){
        this.engineID = UUID.randomUUID();
    }
    public String getEngineID(){
        return String.valueOf(engineID);
    }
}
