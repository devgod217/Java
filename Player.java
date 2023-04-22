package com.java.codegeek;

public class Player {

    public static final float INIT_BALANCE = 2000;

    private String name;
    private float balance;
    private int no;

    public Player() {
        this.name = "";
        this.balance = INIT_BALANCE;
    }

    public Player( String name, float balance, int no) {
        this.balance = balance;
        this.name = name;
        this.no = no;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
}
