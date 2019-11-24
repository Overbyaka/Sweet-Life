package com.example.sweet_life;

public class Dough extends Dish{

    public Dough(int colour,boolean isColour){
        super(colour,isColour);
        this.name = "dough";
    }
    public boolean equals(Dough dough){
        if(dough.colour==this.colour && dough.isColour == this.isColour && this.name.equals(dough.name))
            return true;
        else return false;
    }
}
