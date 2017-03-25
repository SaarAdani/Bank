package com.Files.UI;

import com.Files.Infrastructures.Accounts;
import com.Files.Interfaces.MainListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


public class MainScreen extends VBox{

    Accounts account;

    public MainScreen (final MainListener listener) {

        TextField enterAccountInput = new TextField();
        enterAccountInput.setPromptText("Enter Account Number");
        enterAccountInput.setFocusTraversable(false);
        Button detailsButton = new Button("Enter Account Details");
        Button createButton = new Button("Create New Account");
        detailsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                account = listener.GetAccount(Integer.parseInt(enterAccountInput.getText()));
                listener.ChangeScene(new DetailsScreen(listener,account));
            }
        });
        createButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                listener.ChangeScene(new CreateScreen(listener));
            }
        });
        getChildren().addAll(enterAccountInput,detailsButton,createButton);

    }

}
