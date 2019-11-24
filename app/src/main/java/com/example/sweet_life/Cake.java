package com.example.sweet_life;

public class Cake extends Dough{
    boolean isHornForCake = false;
    boolean isFurnace = false;
    boolean isFruit = false;

    public Cake(int colour, boolean isColour, boolean isHornForCake, boolean isFurnace, boolean isFruit){
        super(colour,isColour);
        this.isHornForCake = isHornForCake;
        this.isFurnace = isFurnace;
        this.isFruit = isFruit;
        this.name = "cake";
    }

    public boolean equals(Cake cake){
        if(cake.colour==this.colour && cake.isColour == this.isColour && this.name.equals(cake.name) && cake.isHornForCake == this.isHornForCake && cake.isFurnace == this.isFurnace &&
        cake.isFruit == this.isFruit)
            return true;
        else return false;
    }
}
