package ru.nsu.ccfit.usoltsev.carfactory.details;

import java.util.Base64;
import java.util.UUID;

public class Detail {
    UUID ID;

    public Detail() {
        this.ID = UUID.randomUUID();
    }

    public String getID() {
        return String.valueOf(ID);
    }
}
