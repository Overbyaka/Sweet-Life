package com.example.sweet_life;

public class Icecream extends Dish{
    boolean isHornForIcecream;
    boolean isAutomat;
    boolean isPosypka;
    boolean isIce;

    public Icecream(int colour, boolean isColour, boolean isHornForIcecream, boolean isIce, boolean isAutomat, boolean isPosypka){
        super(colour,isColour);
        this.isHornForIcecream = isHornForIcecream;
        this.isIce = isIce;
        this.isAutomat = isAutomat;
        this.isPosypka = isPosypka;
        this.name = "icecream";

    }

    public boolean equals(Icecream icecream){
        if(icecream.colour==this.colour && icecream.isColour == this.isColour && this.name.equals(icecream.name) && icecream.isHornForIcecream == this.isHornForIcecream &&
                icecream.isAutomat == this.isAutomat && icecream.isPosypka == this.isPosypka && icecream.isIce == this.isIce)
            return true;
        else return false;
    }
    @Override
    public void setColour(int colour){
        this.colour = colour;
    }
    @Override
    public void setColour(boolean colour){
        this.isColour = colour;
    }
    public void setIce(boolean ice) {
        isIce = ice;
    }

    public void setHornForIcecream(boolean hornForIcecream) {
        isHornForIcecream = hornForIcecream;
    }

    public void setAutomat(boolean automat) {
        isAutomat = automat;
    }

    public void setPosypka(boolean posypka) {
        isPosypka = posypka;
    }
}
