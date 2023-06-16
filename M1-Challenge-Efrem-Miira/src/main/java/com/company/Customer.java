package com.company;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private List<AccountRecord> charges = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        //update this
        int balance = 0;
        List<AccountRecord> charges = this.getCharges();  //iterate through charges list and sum up the charges
        for (int i = 0; i < charges.size(); i++) {
            balance += charges.get(i).getCharge();
        }
        return balance;
    }

    public List<AccountRecord> getCharges() {
        return charges;
    }


    @Override
    public String toString() {
        //update this
        // customer ID, customer name, and customer balance.
        return this.getId() + "," + this.getName() + "," + this.getBalance();

    }
}
