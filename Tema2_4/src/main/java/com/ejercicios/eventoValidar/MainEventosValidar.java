package com.ejercicios.eventoValidar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainEventosValidar extends Application {

    private VBox rootLayout;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("EventosValidar.fxml"));
        rootLayout = (VBox) loader.load();


        Scene scene = new Scene(rootLayout);
        stage.setTitle("Ejemplo sobre eventos!");
        stage.setScene(scene);
        stage.show();

    }
}
