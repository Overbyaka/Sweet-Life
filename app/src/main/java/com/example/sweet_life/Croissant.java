package com.example.sweet_life;

public class Croissant extends Dough{
    public boolean isPlate = false;

    public Croissant(int colour,boolean isColour,boolean isPlate){
        super(colour, isColour);
        this.isPlate = isPlate;
        this.name = "croissant";
    }
    public boolean equals(Croissant croissant){
        if(croissant.colour==this.colour && croissant.isColour == this.isColour && this.name.equals(croissant.name) && croissant.isPlate == this.isPlate)
            return true;
        else return false;
    }
}
