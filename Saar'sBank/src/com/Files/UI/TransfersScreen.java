package com.Files.UI;


import com.Files.Infrastructures.Accounts;
import com.Files.Interfaces.MainListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class TransfersScreen extends VBox{

    private boolean minus;
    private Accounts destination;
    private int amount;

    public TransfersScreen (final MainListener listener, Accounts account) {

        TextField destinationAccountInput = new TextField();
        destinationAccountInput.setPromptText("Enter Account Number");
        destinationAccountInput.setFocusTraversable(false);
        TextField depositAmountInput = new TextField();
        depositAmountInput.setPromptText("Enter Amount To Deposit");
        depositAmountInput.setFocusTraversable(false);
        Button transferButton = new Button("Transfer");
        transferButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                amount = Integer.parseInt(depositAmountInput.getText());
                account.WithdrawalBalance(amount);
                minus = account.isMinus();
                destination = listener.GetAccount(Integer.parseInt(destinationAccountInput.getText()));
                if (!minus && destination != null) {
                    destination.DepositBalance(amount);
                    listener.ChangeScene(new DetailsScreen(listener, account));

                }else {
                    listener.ChangeScene(new DetailsScreen(listener,account));
                }
            }
        });
        getChildren().addAll(destinationAccountInput,depositAmountInput,transferButton);
    }
}
