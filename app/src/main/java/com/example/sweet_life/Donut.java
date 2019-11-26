package com.example.sweet_life;

import android.widget.ImageButton;

public class Donut extends Dish implements Paint{
    public boolean isPosypka;

    public Donut(int colour,boolean isColour,boolean isPosypka){
        this.colour = colour;
        this.isColour = isColour;
        this.isPosypka = isPosypka;
    }
    public boolean equals(Donut donut){
        if(donut.colour==this.colour && donut.isColour == this.isColour && donut.isPosypka == this.isPosypka)
            return true;
        else return false;
    }

    public void paint(int colour, ImageButton imageButton){
        switch (colour){
            case 1:
                imageButton.setImageResource(R.drawable.donutwithoutposypkavanille);
                break;
            case 2:
                imageButton.setImageResource(R.drawable.donutwithposypkachocolate);
                break;
            case 3:
                imageButton.setImageResource(R.drawable.donutwithoutposypkastrawberry);
                break;
        }
        isColour = true;
        this.colour = colour;
    }

    public void setImage(ImageButton imageButton, boolean flag){
        if(flag){
            if(!isColour){
                imageButton.setImageResource(R.drawable.donutwithposypkastrawberry); //Поменять
            } else if(!isPosypka){
                switch (colour){
                    case 1:
                        imageButton.setImageResource(R.drawable.donutwithoutposypkavanille);
                        break;
                    case 2:
                        imageButton.setImageResource(R.drawable.donutwithoutposypkachocolate);
                        break;
                    case 3:
                        imageButton.setImageResource(R.drawable.donutwithoutposypkastrawberry);
                        break;
                }
            } else{
                switch (colour){
                    case 1:
                        imageButton.setImageResource(R.drawable.donutwithposypkavanille);
                        break;
                    case 2:
                        imageButton.setImageResource(R.drawable.donutwithposypkachocolate);
                        break;
                    case 3:
                        imageButton.setImageResource(R.drawable.donutwithposypkastrawberry);
                        break;
                }
            }
        } else{
            if(!isColour){
                imageButton.setImageResource(R.drawable.donutwithposypkastrawberryon); //Поменять
            } else if(!isPosypka){
                switch (colour){
                    case 1:
                        imageButton.setImageResource(R.drawable.donutwithoutposypkavanilleon);
                        break;
                    case 2:
                        imageButton.setImageResource(R.drawable.donutwithoutposypkachocolateon);
                        break;
                    case 3:
                        imageButton.setImageResource(R.drawable.donutwithoutposypkastrawberryon);
                        break;
                }
            } else{
                switch (colour){
                    case 1:
                        imageButton.setImageResource(R.drawable.donutwithposypkavanilleon);
                        break;
                    case 2:
                        imageButton.setImageResource(R.drawable.donutwithposypkachocolateon);
                        break;
                    case 3:
                        imageButton.setImageResource(R.drawable.donutwithposypkastrawberryon);
                        break;
                }
            }
        }
    }
}
