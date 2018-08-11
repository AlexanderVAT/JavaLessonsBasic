package org.javalessons.basic;

public class BankAccount {

    private int coins;

    public BankAccount(int coins) {
        this.coins = coins;
    }

    public void putMoney(int deposit){

        this.coins=coins+deposit;
    }


    public int getCoins(int moneyToWidthraw)

    {
        return coins;
    }

}
