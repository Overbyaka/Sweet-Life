package com.example.sweet_life;

    public class Dish {

    static public int hp = 30;
        public String name = "dish";
    public int colour = 0; // 0 - нейтральный, 1 - ванильный, 2 - шоколадный, 3 - клубничный//

    boolean isColour = false;
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

    public boolean equals(Dish dish){
        if(dish.colour==this.colour && dish.isColour == this.isColour && this.name.equals(dish.name))
            return true;
        else return false;
    }
}
