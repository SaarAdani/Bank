package com.Files.UI;

import com.Files.Infrastructures.Accounts;
import com.Files.Infrastructures.BasicScreen;
import com.Files.Interfaces.MainListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;


public class DetailsScreen extends BasicScreen {

    public DetailsScreen(final MainListener listener, Accounts account) {
        super(listener);

        Text accountOwnerLabel = new Text("Account Owner's Name: " + account.getName());
        Text accountNumberLabel = new Text("Account Number: " + account.getAccountNumber());
        Text accountBalanceLabel = new Text("Account Balance: " + account.getBalance());
        Button depositButton = new Button("Deposit");
        Button withdrawalButton = new Button("Withdrawal");
        Button transferButton = new Button("Transfer");
        depositButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                listener.ChangeScene(new DepositsScreen(listener,account));
            }
        });
        withdrawalButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                listener.ChangeScene(new WithdrawalsScreen(listener,account));
            }
        });
        transferButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                listener.ChangeScene(new TransfersScreen(listener,account));
            }
        });
        HBox hbox = new HBox(depositButton,withdrawalButton,transferButton);

        getChildren().add(0,accountOwnerLabel);
        getChildren().add(1,accountNumberLabel);
        getChildren().add(2,accountBalanceLabel);
        getChildren().add(3,hbox);
    }
}
