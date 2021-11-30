package it.univr.bank;
import java.util.ArrayList;

public class BankAccount {

    ArrayList<Integer> transactions;

    public BankAccount(){
        this.transactions = new ArrayList<Integer>();
    }

    public void deposit (int value){
        transactions.add(Integer.valueOf(value));
    }

    public void withdraw (int value){
        transactions.add(Integer.valueOf(-1*value));
    }

    public int balance(){
        int result = 0;
        for (Integer e : transactions){
            result += e;
        }
        return result;
    }

}
