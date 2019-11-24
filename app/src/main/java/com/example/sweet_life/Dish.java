package com.example.sweet_life;

import androidx.annotation.Nullable;

public class Dish {

        static public int hp = 30;
        public String name = "dish";
        public int colour = 0; // 0 - нейтральный, 1 - ванильный, 2 - шоколадный, 3 - клубничный//
        public boolean isColour = false;

    public Dish(int colour,boolean isColour){
        this.colour = colour;
        this.isColour = isColour;
        this.name = "dish";
    }
    public Dish(){
        this.colour = 0;
        this.isColour = false;
        this.name = "dish";
    }

    /*public boolean equals(Dish dish){
        if(dish.colour==this.colour && dish.isColour == this.isColour && this.name.equals(dish.name))
            return true;
        else return false;
    }*/

    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(obj == null || obj.getClass() != this.getClass())
            return false;
        Dish dish = (Dish)obj;
        return dish.colour==this.colour && dish.isColour == this.isColour && this.name.equals(dish.name);
    }

    public void setColour(int colour) {
            this.colour = colour;
        }

        public void setColour(boolean colour) {
            isColour = colour;
        }
    }
