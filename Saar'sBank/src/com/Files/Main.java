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
        window.setScene(new Scene(layout, 240, 125));
    }

    @Override
    public Accounts AddAccount(String name) {

        Accounts a = new Accounts(name);
        accounts.add(a);
        return a;

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


    private static void writeToFile() {

        try {
            FileOutputStream out = new FileOutputStream(FILE_NAME, false);
            for (int i = 0; i < accounts.size(); i++) {

                out.write((accounts.get(i).getName() + "," + accounts.get(i).getAccountNumber() + "," + accounts.get(i).getBalance() + ".").getBytes());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void extractAccountList(String data) {

        String[] arr = data.split("\\.");
        for (int i = 0; i < arr.length; i++) {

            String[] acc = arr[i].split(",");
            accounts.add(new Accounts(acc[0], Integer.parseInt(acc[1]), Integer.parseInt(acc[2])));
        }

    }

    private static void readFromFile() {

        File file = new File(FILE_NAME);
        if (file.exists()) {
            try {
                String sFileContains;
                BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
                while ((sFileContains = br.readLine()) != null) {
                    extractAccountList(sFileContains);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
            /*

            StringBuilder sb = new StringBuilder();
            byte[] buffer = new byte[1024];
            int length;
            try {
                FileInputStream in = new FileInputStream(file);
                while ((length = in.read(buffer)) != -1) {
                    sb.append(new String(buffer, 0, length));
                }
                extractAccountList(sb.toString());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            */





