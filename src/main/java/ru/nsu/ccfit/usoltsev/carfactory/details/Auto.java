package ru.nsu.ccfit.usoltsev.carfactory.details;

import java.util.*;

public class Auto {

    HashMap<String, Detail> details = new HashMap<>();
    UUID autoID;

    String autoInfo ;

    public Auto(LinkedList<Detail> detail) {
        autoInfo = "";
        this.autoID = UUID.randomUUID();
        autoInfo += ("Auto: " + autoID );
        for (Detail det : detail) {
            this.details.put(det.getClass().getSimpleName(), det);
            autoInfo += (", " + det.getClass().getSimpleName()+ " " + det.getID());
        }

    }

    public String getAutoID() {
        return String.valueOf(UUID.randomUUID());
    }
    public String getAutoInfo() {
        return autoInfo;
    }

    public Engine getEngine() {
        return (Engine) details.get("Engine");
    }
}
