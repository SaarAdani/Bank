package com.Files;

import com.Files.Infrastructures.Accounts;
import com.Files.Interfaces.MainListener;
import com.Files.UI.MainScreen;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application implements MainListener {

    private Stage window;
    private static int counter;
    private ArrayList<Accounts> accounts = new ArrayList<>();

    public static void main(String[] args) {

        launch();
    }

    @Override
    public void start(Stage window) throws Exception {
        this.window = window;
        ChangeScene(new MainScreen(this));
        window.show();

    }

    @Override
    public void ChangeScene(VBox layout) {
        window.setScene(new Scene(layout,240,125));
    }

    @Override
    public void AddAccount(String name) {

        accounts.add(new Accounts(name));
        ++counter;

    }

    @Override
    public Accounts GetAccount(int number) {

        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNumber() == number) {
                return accounts.get(i);
            }
        }
        return null;
    }

    @Override
    public int GetCounter() {
        return counter;
    }

}
