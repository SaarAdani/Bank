package com.Files.UI;


import com.Files.Infrasructure.Accounts;
import com.Files.Infrasructure.BackButton;
import com.Files.Interfaces.ChangeSceneListener;
import javafx.scene.text.Text;

public class DetailsScreen extends BackButton {


    public DetailsScreen(ChangeSceneListener listener, Accounts account) {
        super(listener);

        Text accountOwnerLabel = new Text("Account Owner's Name: " + account.getOwner());
        Text accountNumberLabel = new Text("Account Number: " + account.getNumber());
        Text accountBalanceLabel = new Text("Account Balance: " +account.getBalance());

        getChildren().add(0, accountOwnerLabel);
        getChildren().add(1, accountNumberLabel);
        getChildren().add(2, accountBalanceLabel);
    }
}
