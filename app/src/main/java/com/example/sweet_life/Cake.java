package com.example.sweet_life;

import android.widget.ImageButton;

public class Cake extends Dish{
    boolean isFurnace;
    boolean isFruit;

    public Cake(int colour, boolean isColour, boolean isFurnace, boolean isFruit){
        this.colour = colour;
        this.isColour = isColour;
        this.isFurnace = isFurnace;
        this.isFruit = isFruit;
    }

    public boolean equals(Cake cake){
        if(cake.colour==this.colour && cake.isColour == this.isColour && cake.isFurnace == this.isFurnace &&
        cake.isFruit == this.isFruit)
            return true;
        else return false;
    }

    public void setImage(ImageButton imageButton, boolean flag){
        if(flag){
            if(!isFurnace){
                switch (colour){
                    case 1:
                        imageButton.setImageResource(R.drawable.cakewithfruitvanille); //Поменять!
                        break;
                    case 2:
                        imageButton.setImageResource(R.drawable.cakewithfruitchocolate); //Поменять!
                        break;
                    case 3:
                        imageButton.setImageResource(R.drawable.cakewithfruitstrawberry); //Поменять!
                        break;
                }
            } else if(!isFruit){
                switch (colour){
                    case 1:
                        imageButton.setImageResource(R.drawable.cakewithoutfruitvanille);
                        break;
                    case 2:
                        imageButton.setImageResource(R.drawable.cakewithoutfruitchocolate);
                        break;
                    case 3:
                        imageButton.setImageResource(R.drawable.cakewithoutfruitstrawberry);
                        break;
                }
            } else{
                switch (colour){
                    case 1:
                        imageButton.setImageResource(R.drawable.cakewithfruitvanille);
                        break;
                    case 2:
                        imageButton.setImageResource(R.drawable.cakewithfruitchocolate);
                        break;
                    case 3:
                        imageButton.setImageResource(R.drawable.cakewithfruitstrawberry);
                        break;
                }
            }
        } else{
            if(!isFurnace){
                switch (colour){
                    case 1:
                        imageButton.setImageResource(R.drawable.cakewithfruitvanilleon); //Поменять!
                        break;
                    case 2:
                        imageButton.setImageResource(R.drawable.cakewithfruitchocolateon); //Поменять!
                        break;
                    case 3:
                        imageButton.setImageResource(R.drawable.cakewithfruitstrawberryon); //Поменять!
                        break;
                }
            } else if(!isFruit){
                switch (colour){
                    case 1:
                        imageButton.setImageResource(R.drawable.cakewithoutfruitvanilleon);
                        break;
                    case 2:
                        imageButton.setImageResource(R.drawable.cakewithoutfruitchocolateon);
                        break;
                    case 3:
                        imageButton.setImageResource(R.drawable.cakewithoutfruitstrawberryon);
                        break;
                }
            } else{
                switch (colour){
                    case 1:
                        imageButton.setImageResource(R.drawable.cakewithfruitvanilleon);
                        break;
                    case 2:
                        imageButton.setImageResource(R.drawable.cakewithfruitchocolateon);
                        break;
                    case 3:
                        imageButton.setImageResource(R.drawable.cakewithfruitstrawberryon);
                        break;
                }
            }
        }
    }
}
