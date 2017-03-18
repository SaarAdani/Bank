package com.Files.Infrasructure;


import com.Files.Interfaces.ChangeSceneListener;

import java.util.ArrayList;

public class AccountList extends BackButton{

    private static ArrayList<Accounts> accounts = new ArrayList<>();

    public AccountList(ChangeSceneListener listener) {
        super(listener);
    }


    public static void addAccount(Accounts account) {
        accounts.add(account);
    }

    public static Accounts getAccount(int number) {
        return accounts.get(number);
    }
}
