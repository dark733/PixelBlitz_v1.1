module com.example.fxml_manual {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.fxml_manual to javafx.fxml;
    exports com.example.fxml_manual;
}