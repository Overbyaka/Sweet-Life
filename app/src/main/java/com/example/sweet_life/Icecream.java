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
        this.name = "icecream";

    }
    public boolean equals(Icecream icecream){
        if(icecream.colour==this.colour && icecream.isColour == this.isColour && this.name.equals(icecream.name) && icecream.isHornForIcecream == this.isHornForIcecream &&
                icecream.isAutomat == this.isAutomat && icecream.isPosypka == this.isPosypka)
            return true;
        else return false;
    }
}
