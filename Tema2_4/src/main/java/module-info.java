module org.example.tema2_4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.tema2_4 to javafx.fxml;
    exports org.example.tema2_4;
}