package org.example.practica2_1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HelloController {

    @FXML
    private ChoiceBox<Object> locationCB;

    @FXML
    private ComboBox<String> languageCB;

    @FXML
    private ListView<String> qualificationsLV;

    @FXML
    private TreeView dataTree = new TreeView<>();

    //Listas para qualificationsList
    private ObservableList<String> names = FXCollections.observableArrayList();
    private ObservableList<String> data = FXCollections.observableArrayList();

    public void initialize(){

        names.addAll("Objects", "Classes", "Functions", "Variables", "Compiler",
                "Debugger", "Projects", "Beans", "Libraries", "Modules", "JARs");

        locationCB.setValue("Select a country...");
        locationCB.getItems().add("New York");
        locationCB.getItems().add("Orlando");
        locationCB.getItems().add(new Separator());
        locationCB.getItems().add("London");
        locationCB.getItems().add("Manchester");

        //Inicializar ListView
        for (int i = 0; i < 10; i++) {
            //qualificationsLV.getItems().add("Indeterminate (pick a choice)");
            data.add("Indeterminate (pick a choice)");
        }
        qualificationsLV.setItems(data);
        qualificationsLV.setEditable(true);
        qualificationsLV.setCellFactory(ComboBoxListCell.forListView(names));

        languageCB.setValue("Select a language...");
        languageCB.getItems().addAll("English", "Japanese", "Spanish");

        FileInputStream  fis = null;
        try {
            fis = new FileInputStream("src/main/resources/images/Img1.PNG");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ImageView folderIV = new ImageView(new Image(fis));
        folderIV.setPreserveRatio(true);
        folderIV.setFitHeight(20);

        TreeItem<String> rootItem = new TreeItem<String>("Inbox", folderIV);
        rootItem.setExpanded(true);

        List<String> treeListItem = new ArrayList<String>(Arrays.asList("Sales", "Marketing", "Distribution", "Costs"));

        for (String item : treeListItem) {
            TreeItem<String> treeItem = new TreeItem<>(item);
            rootItem.getChildren().add(treeItem);
        }

        dataTree.setRoot(rootItem);


    }

}