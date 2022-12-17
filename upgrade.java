package com.example.cookieclicker;

public class upgrade {
    public String name;


    private int cost;
    public int quantity;
    public String description;
    public int cps;

    public upgrade(String name, int cost,int quantity,String description,int cps) {
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
        this.description = description;
        this.cps = cps;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    public String toString(){
        return(name);
    }

}

