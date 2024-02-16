/**
 *
 */
module com.example.myproje {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.myproje to javafx.fxml;
    exports com.example.myproje;
}