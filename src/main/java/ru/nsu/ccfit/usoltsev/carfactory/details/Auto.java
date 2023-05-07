package ru.nsu.ccfit.usoltsev.carfactory.details;

import java.util.UUID;

public class Auto {
    Engine engine;

    UUID autoID;

    public Auto(Engine engine) {
        this.autoID = UUID.randomUUID();
        this.engine = engine;
    }

    public String getAutoID() {
        return String.valueOf(UUID.randomUUID());
    }
    public Engine getEngine(){
        return engine;
    }
}
