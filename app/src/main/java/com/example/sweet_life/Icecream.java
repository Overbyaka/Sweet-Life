package com.example.sweet_life;

import android.widget.ImageButton;

public class Icecream extends Dish implements Paint, Posypka{
    boolean isAutomat;
    boolean isPosypka;
    boolean isIce;

    public Icecream(int colour, boolean isColour, boolean isIce, boolean isAutomat, boolean isPosypka){
        this.colour = colour;
        this.isColour = isColour;
        this.isIce = isIce;
        this.isAutomat = isAutomat;
        this.isPosypka = isPosypka;
    }

    public boolean equals(Icecream icecream){
        if(icecream.colour==this.colour && icecream.isColour == this.isColour &&
                icecream.isAutomat == this.isAutomat && icecream.isPosypka == this.isPosypka && icecream.isIce == this.isIce)
            return true;
        else return false;
    }

    public void setPosypka(boolean posypka, ImageButton imageButton) {
        isPosypka = posypka;
        switch (colour){
            case 1:
                imageButton.setImageResource(R.drawable.icecreamwithposypkavanille);
                break;
            case 2:
                imageButton.setImageResource(R.drawable.icecreamwithposypkachocolate);
                break;
            case 3:
                imageButton.setImageResource(R.drawable.icecreamwithposypkastrawberry);
                break;
        }
    }

    public void setAutomat(boolean automat, ImageButton imageButton) {
        isAutomat = automat;
        imageButton.setImageResource(R.drawable.nothing);
    }

    public void setIce(boolean ice, ImageButton imageButton) {
        isIce = ice;
        imageButton.setImageResource(R.drawable.hornoficecreamonstandart);
    }

    public void paint(int colour,ImageButton imageButton){
        switch (colour){
            case 1:
                imageButton.setImageResource(R.drawable.hornoficecreamonvanille);
                break;
            case 2:
                imageButton.setImageResource(R.drawable.hornoficecreamonchocolate);
                break;
            case 3:
                imageButton.setImageResource(R.drawable.hornoficecreamonstrawberry);
                break;
        }
        isColour = true;
        this.colour = colour;
    }

    public void setImage(ImageButton imageButton, boolean flag){
        if(flag){
            if(!isIce){
                imageButton.setImageResource(R.drawable.hornoficecream);
            } else if(!isColour){
                imageButton.setImageResource(R.drawable.hornoficecreamonstandart);
            } else if(!isAutomat){
                switch (colour){
                    case 1:
                        imageButton.setImageResource(R.drawable.hornoficecreamonvanille);
                        break;
                    case 2:
                        imageButton.setImageResource(R.drawable.hornoficecreamonchocolate);
                        break;
                    case 3:
                        imageButton.setImageResource(R.drawable.hornoficecreamonstrawberry);
                        break;
                }
            } else if(!isPosypka){
                switch (colour){
                    case 1:
                        imageButton.setImageResource(R.drawable.icecreamwithoutposypkavanille);
                        break;
                    case 2:
                        imageButton.setImageResource(R.drawable.icecreamwithoutposypkachocolate);
                        break;
                    case 3:
                        imageButton.setImageResource(R.drawable.icecreamwithoutposypkastrawberry);
                        break;
                }
            } else{
                switch (colour){
                    case 1:
                        imageButton.setImageResource(R.drawable.icecreamwithposypkavanille);
                        break;
                    case 2:
                        imageButton.setImageResource(R.drawable.icecreamwithposypkachocolate);
                        break;
                    case 3:
                        imageButton.setImageResource(R.drawable.icecreamwithposypkastrawberry);
                        break;
                }
            }
        }
        else {
            if (!isIce) {
                imageButton.setImageResource(R.drawable.hornoficecreamon);
            } else if (!isColour) {
                imageButton.setImageResource(R.drawable.hornoficecreamonstandarton);
            } else if (!isAutomat) {
                switch (colour) {
                    case 1:
                        imageButton.setImageResource(R.drawable.hornoficecreamonvanilleon);
                        break;
                    case 2:
                        imageButton.setImageResource(R.drawable.hornoficecreamonchocolateon);
                        break;
                    case 3:
                        imageButton.setImageResource(R.drawable.hornoficecreamonstrawberryon);
                        break;
                }
            } else if (!isPosypka) {
                switch (colour) {
                    case 1:
                        imageButton.setImageResource(R.drawable.icecreamwithoutposypkavanilleon);
                        break;
                    case 2:
                        imageButton.setImageResource(R.drawable.icecreamwithoutposypkachocolateon);
                        break;
                    case 3:
                        imageButton.setImageResource(R.drawable.icecreamwithoutposypkastrawberryon);
                        break;
                }
            } else {
                switch (colour) {
                    case 1:
                        imageButton.setImageResource(R.drawable.icecreamwithposypkavanilleon);
                        break;
                    case 2:
                        imageButton.setImageResource(R.drawable.icecreamwithposypkachocolateon);
                        break;
                    case 3:
                        imageButton.setImageResource(R.drawable.icecreamwithposypkastrawberryon);
                        break;
                }
            }
        }
    }
}
