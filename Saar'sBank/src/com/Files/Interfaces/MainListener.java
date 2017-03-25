package com.Files.Interfaces;

import com.Files.Infrastructures.Accounts;
import javafx.scene.layout.VBox;


public interface MainListener {

    void ChangeScene (VBox layout);
    void AddAccount(String name);
    Accounts GetAccount(int number);
    int GetCounter();
}
