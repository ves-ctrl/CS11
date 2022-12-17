package com.example.cookieclicker;

public class clickUpgrade {
    public String name;
    private int cost;
    public int quantity;
    public String description;
    public int cpc;

    public boolean owned;

    public clickUpgrade(String name, int cost,int quantity, String description, int cpc, boolean owned) {
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
        this.description = description;
        this.cpc = cpc;
        this.owned = owned;
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

