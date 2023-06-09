package com.example.exam2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;

public class HelloApplication extends Application {
    private Double x,y;
    @Override
    public void start(Stage stage) throws IOException {

        Parent root =  FXMLLoader.load(getClass().getResource("loginStage.fxml"));
//        Parent root =  FXMLLoader.load(getClass().getResource("main-view.fxml"));

        Scene scene = new Scene(root);

        stage.setResizable(false);
        root.setOnMousePressed((MouseEvent event) -> {
             x = event.getSceneX();
             y = event.getSceneY();
        });
        root.setOnMouseDragged((MouseEvent event) -> {
            stage.setX(event.getScreenX() - this.x);
            stage.setY(event.getScreenY() - this.y);
            stage.setOpacity(0.8);
        });
        root.setOnMouseReleased((MouseEvent event) -> {
            stage.setOpacity(1);
        });

        stage.initStyle(StageStyle.UNDECORATED);
        stage.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("icon.png")));
        stage.setTitle("نظام مراقبة سير الامتحانات");

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch();
    }
}