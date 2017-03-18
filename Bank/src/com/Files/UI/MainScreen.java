package com.Files.UI;


import com.Files.Infrasructure.AccountList;
import com.Files.Infrasructure.Accounts;
import com.Files.Interfaces.ChangeSceneListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class MainScreen extends AccountList {


    public MainScreen(final ChangeSceneListener listener) {
        super(listener);

        TextField enterAccountInput = new TextField();
        enterAccountInput.setPromptText("Enter Account Number");
        enterAccountInput.setFocusTraversable(false);
        Button enterAccountBtn = new Button("Enter Account Details");
        Button createAccountBtn = new Button("Create New Account");
        enterAccountBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int number = Integer.parseInt(enterAccountInput.getText());
                Accounts account = getAccount(number-1);
                listener.changeScene(new DetailsScreen(listener, account));
            }
        });
        createAccountBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                listener.changeScene(new CreateScreen(listener));
            }
        });
        getChildren().addAll(enterAccountInput,enterAccountBtn,createAccountBtn);
    }

}
