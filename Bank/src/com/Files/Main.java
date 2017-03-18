package com.Files;

import com.Files.Interfaces.ChangeSceneListener;
import com.Files.UI.MainScreen;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application implements ChangeSceneListener {

    private Stage window;

    public static void main(String[] args) {

        launch();
    }

    @Override
    public void start(Stage window) throws Exception {

        this.window = window;
        changeScene(new MainScreen(this));
        window.show();
    }

    @Override
    public void changeScene(VBox layout) {

        window.setScene(new Scene(layout, 600, 400));
    }


}
