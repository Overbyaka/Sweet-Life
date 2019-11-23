package com.example.sweet_life;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    final int countGuests = 4;//Количество гостей
    final int countDishes = 4;//Количество блюд
    boolean[] arrayFlags = new boolean[countDishes];//Проверка на блюда, подсвечены ли они
    Dish[] dishes = new Dish[countDishes];//Блюда

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Window w= getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        final int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        getWindow().getDecorView().setSystemUiVisibility(flags);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        fillArray(arrayFlags,false);//Заполняем массив

        TextView textScore = (TextView)findViewById(R.id.textScore);
        ImageButton automatIcecream = (ImageButton)findViewById(R.id.imageAutomatIcecream);
        ImageButton furnace = (ImageButton)findViewById(R.id.imageFurnace);
        ImageButton creamChocolate = (ImageButton)findViewById(R.id.imageCreamChocolate);
        ImageButton creamStrawberry = (ImageButton)findViewById(R.id.imageCreamStrawberry);
        ImageButton creamVanille = (ImageButton)findViewById(R.id.imageCreamVanille);
        ImageButton plate = (ImageButton)findViewById(R.id.imagePlate);

        ImageButton[] arrayImageGuests = new ImageButton[countGuests];
        final ImageButton[] arrayImageDish = new ImageButton[countDishes];

        arrayImageGuests[0] = (ImageButton)findViewById(R.id.imageGuest1);
        arrayImageGuests[1] = (ImageButton)findViewById(R.id.imageGuest2);
        arrayImageGuests[2] = (ImageButton)findViewById(R.id.imageGuest3);
        arrayImageGuests[3] = (ImageButton)findViewById(R.id.imageGuest4);

        arrayImageDish[0] = (ImageButton)findViewById(R.id.imageDish1);
        arrayImageDish[1] = (ImageButton)findViewById(R.id.imageDish2);
        arrayImageDish[2] = (ImageButton)findViewById(R.id.imageDish3);
        arrayImageDish[3] = (ImageButton)findViewById(R.id.imageDish4);

        arrayImageDish[0].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(arrayFlags[0]) {
                    /*if(dishes[0].equals(new Donut(0,true,false,false)))
                        arrayImageDish[0].setImageResource(R.drawable.donutwithposypkastrawberry); // ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВТЬ
                    else if(dishes[0].equals(new Donut(1,true,true,false)))
                        arrayImageDish[0].setImageResource(R.drawable.donutwithoutposypkavanille);
                    else if(dishes[0].equals(new Donut(2,true,true,false)))
                        arrayImageDish[0].setImageResource(R.drawable.donutwithoutposypkachocolate);
                    else if(dishes[0].equals(new Donut(3,true,true,false)))
                        arrayImageDish[0].setImageResource(R.drawable.donutwithoutposypkastrawberry);
                    else if(dishes[0].equals(new Donut(1,true,true,true)))
                        arrayImageDish[0].setImageResource(R.drawable.donutwithposypkavanille);
                    else if(dishes[0].equals(new Donut(2,true,true,false)))
                        arrayImageDish[0].setImageResource(R.drawable.donutwithposypkachocolate);
                    else if(dishes[0].equals(new Donut(3,true,true,false)))
                        arrayImageDish[0].setImageResource(R.drawable.donutwithposypkastrawberry);
                    else if(dishes[0].equals(new Cake(1,true,true,false,false)))
                        arrayImageDish[0].setImageResource(R.drawable.cakewithoutfruitchocolate); //ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ
                    else if(dishes[0].equals(new Cake(2,true,true,false,false)))
                        arrayImageDish[0].setImageResource(R.drawable.cakewithoutfruitchocolate); //ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ
                    else if(dishes[0].equals(new Cake(3,true,true,false,false)))
                        arrayImageDish[0].setImageResource(R.drawable.cakewithoutfruitchocolate); //ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ
                    else if(dishes[0].equals(new Cake(1,true,true,true,false)))
                        arrayImageDish[0].setImageResource(R.drawable.cakewithoutfruitvanille);
                    else if(dishes[0].equals(new Cake(2,true,true,true,false)))
                        arrayImageDish[0].setImageResource(R.drawable.cakewithoutfruitchocolate);
                    else if(dishes[0].equals(new Cake(3,true,true,true,false)))
                        arrayImageDish[0].setImageResource(R.drawable.cakewithoutfruitstrawberry);
                    else if(dishes[0].equals(new Cake(1,true,true,true,true)))
                        arrayImageDish[0].setImageResource(R.drawable.cakewithfruitvanille);
                    else if(dishes[0].equals(new Cake(2,true,true,true,true)))
                        arrayImageDish[0].setImageResource(R.drawable.cakewithfruitchocolate);
                    else if(dishes[0].equals(new Cake(3,true,true,true,true)))
                        arrayImageDish[0].setImageResource(R.drawable.cakewithfruitstrawberry);
                    else if(dishes[0].equals(new Croissant(1,true,true)))
                        arrayImageDish[0].setImageResource(R.drawable.croissantvanille);
                    else if(dishes[0].equals(new Croissant(2,true,true)))
                        arrayImageDish[0].setImageResource(R.drawable.croissantchocolate);
                    else if(dishes[0].equals(new Croissant(3,true,true)))
                        arrayImageDish[0].setImageResource(R.drawable.croissantstrawberry);
                    else if(dishes[0].equals(new Icecream(0,false,true,false,false)))
                        arrayImageDish[0].setImageResource((R.drawable.icecreamwithoutposypkachocolate)); //ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ
                    else if(dishes[0].equals(new Icecream(1,true,true,false,false)))
                        arrayImageDish[0].setImageResource((R.drawable.icecreamwithoutposypkachocolate)); //ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ
                    else if(dishes[0].equals(new Icecream(2,true,true,false,false)))
                        arrayImageDish[0].setImageResource((R.drawable.icecreamwithoutposypkachocolate)); //ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ
                    else if(dishes[0].equals(new Icecream(3,true,true,false,false)))
                        arrayImageDish[0].setImageResource((R.drawable.icecreamwithoutposypkachocolate)); //ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ
                    else if(dishes[0].equals(new Icecream(1,true,true,true,false)))
                        arrayImageDish[0].setImageResource((R.drawable.icecreamwithoutposypkavanille));
                    else if(dishes[0].equals(new Icecream(2,true,true,true,false)))
                        arrayImageDish[0].setImageResource((R.drawable.icecreamwithoutposypkachocolate));
                    else if(dishes[0].equals(new Icecream(3,true,true,true,false)))
                        arrayImageDish[0].setImageResource((R.drawable.icecreamwithoutposypkastrawberry));
                    else if(dishes[0].equals(new Icecream(1,true,true,true,true)))
                        arrayImageDish[0].setImageResource((R.drawable.icecreamwithposypkavanille));
                    else if(dishes[0].equals(new Icecream(2,true,true,true,true)))
                        arrayImageDish[0].setImageResource((R.drawable.icecreamwithposypkachocolate));
                    else if(dishes[0].equals(new Icecream(3,true,true,true,true)))
                        arrayImageDish[0].setImageResource((R.drawable.icecreamwithposypkastrawberry));
                    else*/ if(dishes[0].equals(new Dough(0,false)))
                        arrayImageDish[0].setImageResource((R.drawable.icecreamwithoutposypkachocolate)); //ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ
                    else if(dishes[0].equals(new Dough(1,true)))
                        arrayImageDish[0].setImageResource((R.drawable.icecreamwithoutposypkachocolate)); //ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ
                    else if(dishes[0].equals(new Dough(2,true)))
                        arrayImageDish[0].setImageResource((R.drawable.icecreamwithoutposypkachocolate)); //ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ
                    else if(dishes[0].equals(new Dough(3,true)))
                        arrayImageDish[0].setImageResource((R.drawable.icecreamwithoutposypkachocolate)); //ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ
                    else
                        arrayImageDish[0].setImageResource((R.drawable.dish));
                    } else{
                        arrayImageDish[0].setImageResource(R.drawable.dishon);
                    }
                    arrayFlags[0] = !arrayFlags[0];
                    arrayFlags[1] = false;
                    arrayFlags[2] = false;
                    arrayFlags[3] = false;
                }
            });
    }

    void fillArray(boolean[] array,boolean temp){
        for(int i = 0; i < array.length;i++){
            array[i] = temp;
        }
    }

}//2340 1080
