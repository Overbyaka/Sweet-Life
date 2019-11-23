package com.example.sweet_life;

abstract public class Dish {
    static public int hp = 30;
    public int colour = 0; // 0 - нейтральный, 1 - ванильный, 2 - шоколадный, 3 - клубничный
    boolean isColour = false;
    public Dish(int colour,boolean isColour){
        this.colour = colour;
        this.isColour = isColour;
    }
    public Dish(){
        this.colour = 0;
        this.isColour = false;

    }
}
