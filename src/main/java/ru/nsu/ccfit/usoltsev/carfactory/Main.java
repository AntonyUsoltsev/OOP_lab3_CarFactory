package ru.nsu.ccfit.usoltsev.carfactory;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.nsu.ccfit.usoltsev.carfactory.producers.EngineProducer;
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
        EngineStorage engineStorage = new EngineStorage();
        EngineProducer engineProducer = new EngineProducer(engineStorage);
        Factory factory = new Factory(engineStorage);
        engineProducer.start();
        factory.start();
        engineProducer.join();
        factory.join();
    }
}