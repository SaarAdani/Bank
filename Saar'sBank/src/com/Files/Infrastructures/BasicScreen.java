package com.Files.Infrastructures;

import com.Files.Interfaces.MainListener;
import com.Files.UI.MainScreen;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;


public class BasicScreen extends VBox{

        public BasicScreen (final MainListener listener) {

            Button backButton = new Button("Back To Main Screen");
            backButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    listener.ChangeScene(new MainScreen(listener));
                }
            });
            getChildren().add(backButton);
        }


}
