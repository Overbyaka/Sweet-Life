package com.example.sweet_life;

import android.widget.ImageButton;

public class Nothing extends Dish{

    static public int hp = 30;

    public void setImage(ImageButton imageButton, boolean flag){
        if(flag){
            imageButton.setImageResource(R.drawable.dish);
        }
        else
        {
            imageButton.setImageResource(R.drawable.dishon);
        }
    }
}
