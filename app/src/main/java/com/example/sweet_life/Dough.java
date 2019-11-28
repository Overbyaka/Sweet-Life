package com.example.sweet_life;

import android.widget.ImageButton;

public class Dough extends Dish implements Paint{

    public Dough(int colour, boolean isColour) {
        this.colour = colour;
        this.isColour = isColour;
    }

    public boolean equals(Dough dough) {
        if (dough.colour == this.colour && dough.isColour == this.isColour)
            return true;
        else return false;
    }

    public void paint(int colour,ImageButton imageButton){
        switch (colour){
            case 1:
                imageButton.setImageResource(R.drawable.doughvanille);
                break;
            case 2:
                imageButton.setImageResource(R.drawable.doughchocolate);
                break;
            case 3:
                imageButton.setImageResource(R.drawable.doughstrawberry);
                break;
        }
        isColour = true;
        this.colour = colour;
    }

    public void setImage(ImageButton imageButton, boolean flag) {
        if (flag) {
            if (!isColour) {
                imageButton.setImageResource(R.drawable.dough);
            } else {
                switch (colour) {
                    case 1:
                        imageButton.setImageResource(R.drawable.doughvanille);
                        break;
                    case 2:
                        imageButton.setImageResource(R.drawable.doughchocolate);
                        break;
                    case 3:
                        imageButton.setImageResource(R.drawable.doughstrawberry);
                        break;
                }
            }

        } else {
            if (!isColour) {
                imageButton.setImageResource(R.drawable.doughon);
            } else {
                switch (colour) {
                    case 1:
                        imageButton.setImageResource(R.drawable.doughvanilleon);
                        break;
                    case 2:
                        imageButton.setImageResource(R.drawable.doughchocolateon);
                        break;
                    case 3:
                        imageButton.setImageResource(R.drawable.doughstrawberryon);
                        break;
                }
            }
        }
    }
}
