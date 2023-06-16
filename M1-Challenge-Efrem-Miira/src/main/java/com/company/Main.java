package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );

    public static void main(String[] args) {
        //Update this

        ArrayList<Customer> customerList = new ArrayList<Customer>();
        ArrayList<Integer> ids = new ArrayList<Integer>();

        for (int i = 0 ; i < customerData.size(); i++) {
            String[] customerAttrs = customerData.get(i);
            int id = Integer.parseInt(customerAttrs[0]);
            String name = customerAttrs[1];
            int charge = Integer.parseInt(customerAttrs[2]);
            String date = customerAttrs[3];

            AccountRecord ar = new AccountRecord();
            ar.setCharge(charge);
            ar.setChargeDate(date);

            if (!ids.contains(id)) { //keep track of customers we've already looked at w/ unique id
                ids.add(id);
                Customer c = new Customer();
                c.setId(id);
                c.setName(name);
                c.getCharges().add(ar);
                customerList.add(c);
            }
            else {
                for (int k = 0; k < customerList.size(); k++) {  //find customer in list if already accounted for and add update its balance
                    Customer existingC = customerList.get(k);
                    if (existingC.getId() == id) {
                        existingC.getCharges().add(ar);
                    }
                }
            }
        }

        System.out.println(customerList); // list of unique customers with updated balances

        ArrayList<Customer> posCustomers = new ArrayList<Customer>(); // positive is balance of 0+
        ArrayList<Customer> negCustomers = new ArrayList<Customer>(); // balance less than 0
        for (int i = 0; i < customerList.size(); i++) { // assign positive and negative customer lists by accessing account balance
            if (customerList.get(i).getBalance() >= 0) {
                posCustomers.add(customerList.get(i));
            }
            else {
                negCustomers.add(customerList.get(i));
            }
        }

        System.out.println("positive customers: ");
        System.out.println(posCustomers);
        System.out.println("negative customers: ");
        System.out.println(negCustomers);









    }
}
