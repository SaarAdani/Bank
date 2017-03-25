package com.Files.UI;

import com.Files.Infrastructures.Accounts;
import com.Files.Infrastructures.BasicScreen;
import com.Files.Interfaces.MainListener;
import com.Files.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


public class DepositsScreen extends VBox{

    public DepositsScreen (final MainListener listener, Accounts account) {

        TextField depositInput = new TextField();
        depositInput.setPromptText("Enter Amount To Deposit");
        depositInput.setFocusTraversable(false);
        Button depositButton = new Button("Deposit");
        depositButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                account.DepositBalance(Integer.parseInt(depositInput.getText()));
                listener.ChangeScene(new DetailsScreen(listener,account));
            }
        });
        getChildren().addAll(depositInput,depositButton);
    }
}
