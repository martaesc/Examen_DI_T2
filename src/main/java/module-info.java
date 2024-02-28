module org.example.examendit2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.examendit2 to javafx.fxml;
    exports org.example.examendit2;
}