package com.example.sweet_life;

public class Donut extends Dough{
    public boolean isPlate;
    public boolean isPosypka;

    public Donut(int colour,boolean isPlate,boolean isColour,boolean isPosypka){
        super(colour,isColour);
        this.isPlate = isPlate;
        this.isPosypka = isPosypka;
        this.name = "donut";
    }
    public boolean equals(Donut donut){
        if(donut.colour==this.colour && donut.isColour == this.isColour && this.name.equals(donut.name) && donut.isPlate == this.isPlate && donut.isPosypka == this.isPosypka)
            return true;
        else return false;
    }
}
