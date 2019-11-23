package com.example.sweet_life;

public class Icecream extends Dish{
    boolean isHornForIcecream = false;
    boolean isAutomat = false;
    boolean isPosypka = false;

    public Icecream(int colour, boolean isColour, boolean isHornForIcecream, boolean isAutomat, boolean isPosypka){
        super(colour,isColour);
        this.isHornForIcecream = isHornForIcecream;
        this.isAutomat = isAutomat;
        this.isPosypka = isPosypka;

    }
}
