package com.example.mini_rpg_try_2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static final int SCREEN_SIZE = 900;


    @Override
    public void start(Stage stage) throws IOException {
        Parent root = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml")).load();


        stage.setTitle("Mini RPG Lite 3000");

        stage.setScene(new Scene(root, SCREEN_SIZE, SCREEN_SIZE));
        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}