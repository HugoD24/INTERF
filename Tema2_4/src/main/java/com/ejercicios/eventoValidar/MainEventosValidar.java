package com.ejercicios.eventoValidar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainEventosValidar extends Application {

    private VBox rootLayout;

    @Override
    public void start(Stage primaryStage) {

        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainEventosValidar.class.getResource("EventosValidar.fxml"));
            rootLayout = (VBox) loader.load();

            Scene scene = new Scene(rootLayout);

            primaryStage.setScene(scene);
            primaryStage.setTitle("Ejemplo sobre eventos");
            primaryStage.show();

            crearDialogo(primaryStage, scene);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void crearDialogo(Stage primaryStage, Scene scene) {

        TextInputDialog textDialog = new TextInputDialog("Texto de ejemplo...");
        textDialog.initModality(Modality.WINDOW_MODAL);
        textDialog.initOwner(primaryStage);
        textDialog.setTitle("Ejemplo de dialogo");
        textDialog.setHeaderText("Dialogo para introducir un texto");

        textDialog.getEditor().setText("");
        textDialog.getEditor().setPromptText("Texto de ejemplo");

        Button btnMostrar = (Button) scene.lookup("#btnMostrar");
        TextField txtResultado = (TextField) scene.lookup("#txtResultado");

        btnMostrar.setOnAction(event -> {
            textDialog.showAndWait().ifPresent(response -> {
                txtResultado.setText(response);
            });
        });

        textDialog.setOnHidden(event -> {
            txtResultado.requestFocus();
        });

        txtResultado.setOnMouseClicked(event -> {
            txtResultado.setCursor(Cursor.HAND);
        });
    }

    public static void main(String[] args) {
        launch();
    }





}
