package com.example.prog3_final_project;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class HelloApplication extends Application {
    LogIn log_in;
    static Stage stage;
static String currentUser;
    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        Image icon = new Image("C:\\Users\\chadi\\Desktop\\images\\mushroom.png");
        stage.getIcons().add(icon);

        log_in = new LogIn();
        stage.setScene(log_in.start());
        stage.setTitle("Retro Games");
        // primaryStage.setFullScreen(true);  //to open the stage in full screen
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}