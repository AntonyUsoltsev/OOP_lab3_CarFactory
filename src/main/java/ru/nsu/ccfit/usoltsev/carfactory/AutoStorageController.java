package ru.nsu.ccfit.usoltsev.carfactory;

import ru.nsu.ccfit.usoltsev.carfactory.storages.AutoStorage;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class AutoStorageController extends Thread {
    private final Factory factory;
    private final AutoStorage autoStorage;

    public AutoStorageController(Factory factory, AutoStorage autoStorage) {
        this.factory = factory;
        this.autoStorage = autoStorage;
    }

    @Override
    public void run() {
        synchronized (autoStorage) {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    factory.createAuto();
                    TimeUnit.SECONDS.sleep(1);
                }

            } catch (InterruptedException e) {
                System.out.println(Arrays.toString(e.getStackTrace()));
                Thread.currentThread().interrupt();
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
