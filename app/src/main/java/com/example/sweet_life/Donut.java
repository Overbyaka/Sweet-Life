package com.example.sweet_life;

public class Donut extends Dough{
    public boolean isPlate;
    public boolean isPosypka;

    public Donut(int colour,boolean isPlate,boolean isColour,boolean isPosypka){
        super(colour,isColour);
        this.isPlate = isPlate;
        this.isPosypka = isPosypka;
    }
}
