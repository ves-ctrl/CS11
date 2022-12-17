package com.example.cookieclicker;

public class achievements {
    public String name;
    public int cookieRequirement;
    public boolean achieved;

    public achievements(String name, int cookieRequirement, boolean achieved){
        this.name = name;
        this.cookieRequirement = cookieRequirement;
        this.achieved = achieved;
    }
    public String toString(){
        return(name);
    }
}
