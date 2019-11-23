package com.example.sweet_life;

public class Croissant extends Dough{
    public boolean isPlate = false;

    public Croissant(int colour,boolean isColour,boolean isPlate){
        super(colour, isColour);
        this.isPlate = isPlate;
    }
}
