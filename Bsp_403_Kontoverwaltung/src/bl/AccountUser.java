/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import gui.AccountGUI;
import java.util.Random;

/**
 *
 * @author elisc
 */
public class AccountUser implements Runnable{

    private String username;
    private Account account;
    private AccountGUI gui;
    
    public AccountUser(String username, Account account, AccountGUI gui) {
        this.username = username;
        this.account = account;
        this.gui = gui;
    }   
    
    @Override
    public void run() {
        int sleepTime;
        int value;
        int numberOfOperations = 10;
        boolean balanceOperation; //false = deposit, true = withdraw
        
        Random random = new Random();
        
        for (int i = 0; i < numberOfOperations; i++) {
            balanceOperation = random.nextBoolean();
            value = random.nextInt(50 - 10 + 1) + 10;
            sleepTime = random.nextInt(1000 - 1 + 1) + 1;

            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException ex) {}

            if (balanceOperation) {
                if (value > account.getBalance()) {
                    continue;
                }
                account.withdraw(value);
                
                gui.updateLog(String.format("%s withdrawing...\n", username)); 
                gui.updateBalance(account.getBalance());
                
            } else {
                account.deposit(value);

                gui.updateLog(String.format("%s depositing...\n", username)); 
                gui.updateBalance(account.getBalance());
                
            }
            
            if (i == 9) {
                gui.updateLog(String.format("%s has finished operation!\n", username)); 
                gui.updateBalance(account.getBalance());
                
            }
        }
    }
    
    @Override
    public String toString(){
        return username;
    }
    
}
