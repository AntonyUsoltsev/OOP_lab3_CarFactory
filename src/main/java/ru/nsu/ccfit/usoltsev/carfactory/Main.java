package ru.nsu.ccfit.usoltsev.carfactory;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.nsu.ccfit.usoltsev.carfactory.dealers.Dealer;
import ru.nsu.ccfit.usoltsev.carfactory.producers.AccessoryProducer;
import ru.nsu.ccfit.usoltsev.carfactory.producers.BodyProducer;
import ru.nsu.ccfit.usoltsev.carfactory.producers.EngineProducer;
import ru.nsu.ccfit.usoltsev.carfactory.storages.AccessoryStorage;
import ru.nsu.ccfit.usoltsev.carfactory.storages.AutoStorage;
import ru.nsu.ccfit.usoltsev.carfactory.storages.BodyStorage;
import ru.nsu.ccfit.usoltsev.carfactory.storages.EngineStorage;

import java.io.IOException;

public class Main {
//    @Override
//    public void start(Stage stage) throws IOException {
////        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
////        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
////        stage.setTitle("Hello!");
////        stage.setScene(scene);
////        stage.show();
//    }

    public static void main(String[] args) throws InterruptedException {
//        launch();
        try {
            FactoryProperties.readInfo();
            EngineStorage engineStorage = new EngineStorage(FactoryProperties.ENGINE_STORAGE_SIZE);
            BodyStorage bodyStorage = new BodyStorage(FactoryProperties.BODY_STORAGE_SIZE);
            AccessoryStorage accessoryStorage = new AccessoryStorage(FactoryProperties.ACCESSORY_STORAGE_SIZE);

            AutoStorage autoStorage = new AutoStorage();

            EngineProducer engineProducer = new EngineProducer(engineStorage);
            BodyProducer bodyProducer = new BodyProducer(bodyStorage);
            AccessoryProducer accessoryProducer = new AccessoryProducer(accessoryStorage);

            Factory factory = new Factory(engineStorage, bodyStorage, accessoryStorage, autoStorage);

            Dealer dealer = new Dealer(autoStorage);

            engineProducer.start();
            bodyProducer.start();
            accessoryProducer.start();
            factory.start();
            dealer.start();

            engineProducer.join();
            bodyProducer.join();
            accessoryProducer.join();
            factory.join();
            dealer.join();
        } catch (RuntimeException e){
            System.err.println(e.getMessage());
        }
    }
}