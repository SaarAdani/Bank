package com.Files.Infrasructure;


import com.Files.Interfaces.ChangeSceneListener;
import com.Files.UI.MainScreen;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class BackButton extends VBox {


    public BackButton(final ChangeSceneListener listener) {

        Button backBtn = new Button("Back");
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                listener.changeScene(new MainScreen(listener));
            }
        });
        getChildren().add(backBtn);
    }

}
