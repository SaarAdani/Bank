package com.Files.UI;


import com.Files.Infrastructures.Accounts;
import com.Files.Interfaces.MainListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class WithdrawalsScreen extends VBox{

    public WithdrawalsScreen (final MainListener listener, Accounts account) {

        TextField withdrawalInput = new TextField();
        withdrawalInput.setPromptText("Enter Amount To Withdraw");
        withdrawalInput.setFocusTraversable(false);
        Button withdrawalButton = new Button("Withdraw");
        withdrawalButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                account.WithdrawalBalance(Integer.parseInt(withdrawalInput.getText()));
                listener.ChangeScene(new DetailsScreen(listener,account));
            }
        });
        getChildren().addAll(withdrawalInput,withdrawalButton);
    }
}
