module com.example.exam2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.sql;

    opens com.example.exam2 to javafx.fxml;
    exports com.example.exam2;
}