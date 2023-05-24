module com.example.exam2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.bootstrapicons;
    requires java.sql;

    opens com.example.exam2 to javafx.fxml;
    exports com.example.exam2;
}