package com.Files;

import com.Files.Infrastructures.Accounts;
import com.Files.Interfaces.MainListener;
import com.Files.UI.MainScreen;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class Main extends Application implements MainListener {

    private Stage window;
    private static int counter;
    private static ArrayList<Accounts> accounts = new ArrayList<>();
    private static final String FILE_NAME = "BankAccounts.txt";

    public static void main(String[] args) {

        readFromFile();
        launch();
        writeToFile();
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

    public static void writeToFile ()  {

        try {
            FileOutputStream out = new FileOutputStream(FILE_NAME,true);
            for (int i = 0; i < accounts.size(); i++) {

                out.write((accounts.get(i).getName() + "," + accounts.get(i).getAccountNumber() + "," + accounts.get(i).getBalance() + ".").getBytes());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void extractAccountList (String data) {

        String[] arr = data.split(".");
        for (int i = 0; i < arr.length; i++) {

            String[] acc = arr[i].split(",");
            accounts.add(new Accounts(acc[0],Integer.parseInt(acc[1]),Integer.parseInt(acc[2])));
        }

    }

    public static void readFromFile () {

        File file = new File(FILE_NAME);
        if (file.exists()) {
            StringBuilder sb = new StringBuilder();
            byte[] buffer = new byte[1024];
            int length;
            try {
                FileInputStream in = new FileInputStream(file);
                while ((length = in.read(buffer)) != -1) {
                    sb.append(new String(buffer,0,length));
                }
                extractAccountList(sb.toString());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

}
