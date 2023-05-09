package ru.nsu.ccfit.usoltsev.carfactory;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.nsu.ccfit.usoltsev.carfactory.dealers.Dealer;
import ru.nsu.ccfit.usoltsev.carfactory.producers.BodyProducer;
import ru.nsu.ccfit.usoltsev.carfactory.producers.EngineProducer;
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
        EngineStorage engineStorage = new EngineStorage(5);
        BodyStorage bodyStorage = new BodyStorage(6);

        AutoStorage autoStorage = new AutoStorage();

        EngineProducer engineProducer = new EngineProducer(engineStorage);
        BodyProducer bodyProducer = new BodyProducer(bodyStorage);
        Factory factory = new Factory(engineStorage,bodyStorage,autoStorage);

        Dealer dealer = new Dealer(autoStorage);

        engineProducer.start();
        bodyProducer.start();
        factory.start();
        dealer.start();
        engineProducer.join();
        bodyProducer.join();
        factory.join();
        dealer.join();
    }
}