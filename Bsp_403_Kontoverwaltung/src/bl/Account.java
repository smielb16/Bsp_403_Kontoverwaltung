/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.util.ArrayList;

/**
 *
 * @author elisc
 */
public class Account {

    private ArrayList<AccountUser> users = new ArrayList<>();
    private double balance;
    
    public Account(double balance) {
        this.balance = balance;
    }
    
    public void addUser(AccountUser user){
        users.add(user);
    }
    
    public double getBalance(){
        return balance;
    }
        
}
