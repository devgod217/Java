package com.java.codegeek;



public class Hotel extends Place{


    private final float price;
    private int owner;
    private int star;
    private final String name;

    public Hotel(String name,int index, float price, int owner, int star, int curPlayer) {
        this.name = name;
        this.index = index;
        this.price = price;
        this.owner = owner;
        this.star = star;
        this.curLandPlayer = curPlayer;
    }


    public float getPrice() {
        return price;
    }

    public int getOwner() {
        return owner;
    }

    public int getStar() {
        return star;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getName() {
        return name;
    }


}
