package com.Files.UI;


import com.Files.Infrasructure.AccountList;
import com.Files.Infrasructure.Accounts;
import com.Files.Infrasructure.BackButton;
import com.Files.Interfaces.ChangeSceneListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CreateScreen extends AccountList {


    public CreateScreen(ChangeSceneListener listener) {
        super(listener);

        TextField createAccountInput = new TextField();
        createAccountInput.setPromptText("Enter Your Name");
        createAccountInput.setFocusTraversable(false);
        Button createAccountBtn = new Button("Create Account");
        createAccountBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Accounts accounts = new Accounts(createAccountInput.getText());
                addAccount(accounts);
                listener.changeScene(new DetailsScreen(listener, accounts));
            }
        });
        getChildren().add(0,createAccountInput);
        getChildren().add(1,createAccountBtn);
    }

}
