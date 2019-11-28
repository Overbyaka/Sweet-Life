package com.example.sweet_life;

import android.widget.ImageButton;

import androidx.annotation.Nullable;

public abstract class Dish {

        static public int hp = 30;
        public int colour = 0;// 0 - нейтральный, 1 - ванильный, 2 - шоколадный, 3 - клубничный//
        public boolean isColour = false;

        public abstract void setImage(ImageButton imageButton, boolean flag);
}
