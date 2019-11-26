package com.example.sweet_life;

import android.widget.ImageButton;

public class Croissant extends Dish{

    public Croissant(int colour,boolean isColour){
        this.colour = colour;
        this.isColour = isColour;
    }
    public boolean equals(Croissant croissant){
        if(croissant.colour==this.colour && croissant.isColour == this.isColour)
            return true;
        else return false;
    }

    public void setImage(ImageButton imageButton, boolean flag){
        if(flag){
            switch (colour){
                case 1:
                    imageButton.setImageResource(R.drawable.croissantvanille);
                    break;
                case 2:
                    imageButton.setImageResource(R.drawable.croissantchocolate);
                    break;
                case 3:
                    imageButton.setImageResource(R.drawable.croissantstrawberry);
                    break;
            }
        } else{
            switch (colour){
                case 1:
                    imageButton.setImageResource(R.drawable.croissantvanilleon);
                    break;
                case 2:
                    imageButton.setImageResource(R.drawable.croissantchocolateon);
                    break;
                case 3:
                    imageButton.setImageResource(R.drawable.croissantstrawberryon);
                    break;
            }
        }
    }
}
