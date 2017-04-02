package com.Files.UI;

import com.Files.Infrastructures.Accounts;
import com.Files.Infrastructures.BasicScreen;
import com.Files.Interfaces.MainListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class CreateScreen extends BasicScreen {

    private int accountNumber;
    private Accounts account;

    public CreateScreen(MainListener listener) {
        super(listener);

        TextField createAccountInput = new TextField();
        createAccountInput.setPromptText("Enter You're Name");
        createAccountInput.setFocusTraversable(false);
        Button createAccountButton = new Button("Create Account");
        createAccountButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Accounts a =listener.AddAccount(createAccountInput.getText());
                listener.ChangeScene(new DetailsScreen(listener,a));
            }
        });
        getChildren().add(0,createAccountInput);
        getChildren().add(1,createAccountButton);
    }
}
