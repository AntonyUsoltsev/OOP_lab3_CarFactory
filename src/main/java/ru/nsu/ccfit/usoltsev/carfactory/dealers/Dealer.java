package ru.nsu.ccfit.usoltsev.carfactory.dealers;

import ru.nsu.ccfit.usoltsev.carfactory.details.Auto;
import ru.nsu.ccfit.usoltsev.carfactory.storages.AutoStorage;
import ru.nsu.ccfit.usoltsev.carfactory.threadPool.ThreadPool;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Dealer extends Thread {
    private final AutoStorage autoStorage;
    private final Logger LOGGER = Logger.getLogger(Logger.class.getName());
    private final ThreadPool dealers;

    public Dealer(AutoStorage autoStorage) {
        this.autoStorage = autoStorage;
        dealers=new ThreadPool();
        try (FileInputStream configFile = new FileInputStream("src/main/resources/ru/nsu/ccfit/usoltsev/carfactory/LoggerProperties.txt")) {
            LogManager.getLogManager().readConfiguration(configFile);
        } catch (Exception e) {
            throw new RuntimeException("Error loading logger configuration file");
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Auto newAuto = autoStorage.get();
                TimeUnit.SECONDS.sleep(15);
                System.out.println("Buy new car: " + newAuto.getAutoInfo());
                LOGGER.log(Level.INFO, "Buy new car: " + newAuto.getAutoInfo());
            }
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}
