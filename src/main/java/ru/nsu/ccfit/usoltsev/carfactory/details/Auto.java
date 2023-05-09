package ru.nsu.ccfit.usoltsev.carfactory.details;

import java.util.*;

public class Auto {

    HashMap<String, Detail> details = new HashMap<>();
    UUID autoID;

    String autoInfo;

    public Auto(LinkedList<Detail> detail) {
        this.autoID = UUID.randomUUID();
        for (Detail det : detail) {
            this.details.put(det.getClass().getSimpleName(), det);
        }

    }

    public String getAutoID() {
        return String.valueOf(UUID.randomUUID());
    }

    public Engine getEngine() {
        return (Engine) details.get("Engine");
    }
}
