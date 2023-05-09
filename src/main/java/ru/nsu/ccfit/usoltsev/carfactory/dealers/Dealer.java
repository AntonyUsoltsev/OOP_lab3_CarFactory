package ru.nsu.ccfit.usoltsev.carfactory.dealers;

import ru.nsu.ccfit.usoltsev.carfactory.details.Auto;
import ru.nsu.ccfit.usoltsev.carfactory.details.Engine;
import ru.nsu.ccfit.usoltsev.carfactory.storages.AutoStorage;

public class Dealer extends Thread {
    AutoStorage autoStorage;

    public Dealer(AutoStorage autoStorage) {
        this.autoStorage = autoStorage;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Auto newAuto = autoStorage.get();
                Thread.sleep(10000);
                System.out.println("Buy new car: " + newAuto.getAutoID() + " engine id:" + newAuto.getEngine().getID());
            }
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}
