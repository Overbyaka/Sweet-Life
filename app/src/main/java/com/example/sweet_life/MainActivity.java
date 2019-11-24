package com.example.sweet_life;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOError;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    final int countGuests = 4;//Количество гостей
    final int countDishes = 4;//Количество блюд
    boolean[] arrayFlags = new boolean[countDishes];//Проверка на блюда, подсвечены ли они
    Dish[] dishes = new Dish[countDishes];//Блюда
    boolean[] arrayFlagsIsEmpty = new boolean[countDishes]; //Проверка на блюда, в машине ли блюда или нет
    boolean isWorkingAutomatIcecream = false;
    int timeAutomatIcecream = 0;
    int numberTakeDishForAutomatIcecream;

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
        fillArray(arrayFlagsIsEmpty,false);//Заполняем массив

        TextView textScore = (TextView)findViewById(R.id.textScore);
        final ImageButton automatIcecream = (ImageButton)findViewById(R.id.imageAutomatIcecream);
        ImageButton furnace = (ImageButton)findViewById(R.id.imageFurnace);
        ImageButton creamChocolate = (ImageButton)findViewById(R.id.imageCreamChocolate);
        ImageButton creamStrawberry = (ImageButton)findViewById(R.id.imageCreamStrawberry);
        ImageButton creamVanille = (ImageButton)findViewById(R.id.imageCreamVanille);
        ImageButton plate = (ImageButton)findViewById(R.id.imagePlate);
        ImageButton dough = (ImageButton)findViewById(R.id.imageDough);
        ImageButton ice = (ImageButton)findViewById(R.id.imageIce);
        ImageButton hornIcecream = (ImageButton)findViewById(R.id.imageHornIcecream) ;
        ImageButton hornCake = (ImageButton) findViewById(R.id.imageHornCake);

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

        for(int i = 0; i < countDishes;i++){
            dishes[i] = new Dish();
        }

        /*Подсветка для первой тарелки*/

        arrayImageDish[0].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (!arrayFlagsIsEmpty[0]) {
                    if (arrayFlags[0]) {
                        if (dishes[0].equals(new Donut(0, true, false, false)))
                            arrayImageDish[0].setImageResource(R.drawable.donutwithposypkastrawberry); // ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВТЬ
                        else if (dishes[0].equals(new Donut(1, true, true, false)))
                            arrayImageDish[0].setImageResource(R.drawable.donutwithoutposypkavanille);
                        else if (dishes[0].equals(new Donut(2, true, true, false)))
                            arrayImageDish[0].setImageResource(R.drawable.donutwithoutposypkachocolate);
                        else if (dishes[0].equals(new Donut(3, true, true, false)))
                            arrayImageDish[0].setImageResource(R.drawable.donutwithoutposypkastrawberry);
                        else if (dishes[0].equals(new Donut(1, true, true, true)))
                            arrayImageDish[0].setImageResource(R.drawable.donutwithposypkavanille);
                        else if (dishes[0].equals(new Donut(2, true, true, false)))
                            arrayImageDish[0].setImageResource(R.drawable.donutwithposypkachocolate);
                        else if (dishes[0].equals(new Donut(3, true, true, false)))
                            arrayImageDish[0].setImageResource(R.drawable.donutwithposypkastrawberry);
                        else if (dishes[0].equals(new Cake(1, true, true, false, false)))
                            arrayImageDish[0].setImageResource(R.drawable.cakewithoutfruitchocolate); //ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ
                        else if (dishes[0].equals(new Cake(2, true, true, false, false)))
                            arrayImageDish[0].setImageResource(R.drawable.cakewithoutfruitchocolate); //ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ
                        else if (dishes[0].equals(new Cake(3, true, true, false, false)))
                            arrayImageDish[0].setImageResource(R.drawable.cakewithoutfruitchocolate); //ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ
                        else if (dishes[0].equals(new Cake(1, true, true, true, false)))
                            arrayImageDish[0].setImageResource(R.drawable.cakewithoutfruitvanille);
                        else if (dishes[0].equals(new Cake(2, true, true, true, false)))
                            arrayImageDish[0].setImageResource(R.drawable.cakewithoutfruitchocolate);
                        else if (dishes[0].equals(new Cake(3, true, true, true, false)))
                            arrayImageDish[0].setImageResource(R.drawable.cakewithoutfruitstrawberry);
                        else if (dishes[0].equals(new Cake(1, true, true, true, true)))
                            arrayImageDish[0].setImageResource(R.drawable.cakewithfruitvanille);
                        else if (dishes[0].equals(new Cake(2, true, true, true, true)))
                            arrayImageDish[0].setImageResource(R.drawable.cakewithfruitchocolate);
                        else if (dishes[0].equals(new Cake(3, true, true, true, true)))
                            arrayImageDish[0].setImageResource(R.drawable.cakewithfruitstrawberry);
                        else if (dishes[0].equals(new Croissant(1, true, true)))
                            arrayImageDish[0].setImageResource(R.drawable.croissantvanille);
                        else if (dishes[0].equals(new Croissant(2, true, true)))
                            arrayImageDish[0].setImageResource(R.drawable.croissantchocolate);
                        else if (dishes[0].equals(new Croissant(3, true, true)))
                            arrayImageDish[0].setImageResource(R.drawable.croissantstrawberry);
                        /*else if (dishes[0].equals(new Icecream(0, false, true, false, false, false)))
                            arrayImageDish[0].setImageResource(R.drawable.hornoficecream);
                        else if (dishes[0].equals(new Icecream(0, false, true, true, false, false)))
                            arrayImageDish[0].setImageResource((R.drawable.hornoficecreamonstandart));*/
                        else if(dishes[0] instanceof Icecream && (((Icecream)dishes[0]).equals(new Icecream(0,false,true,false,false,false))))
                            arrayImageDish[0].setImageResource((R.drawable.hornoficecream));
                        else if(dishes[0] instanceof Icecream && (((Icecream)dishes[0]).equals(new Icecream(0,false,true,true,false,false))))
                            arrayImageDish[0].setImageResource((R.drawable.hornoficecreamonstandart));
                        else if (dishes[0].equals(new Icecream(1, true, true, true, false, false)))
                            arrayImageDish[0].setImageResource((R.drawable.hornoficecreamonvanille));
                        else if (dishes[0].equals(new Icecream(2, true, true, true, false, false)))
                            arrayImageDish[0].setImageResource((R.drawable.hornoficecreamonchocolate));
                        else if (dishes[0].equals(new Icecream(3, true, true, true, false, false)))
                            arrayImageDish[0].setImageResource((R.drawable.hornoficecreamonstrawberry));
                        else if (dishes[0].equals(new Icecream(1, true, true, true, true, false)))
                            arrayImageDish[0].setImageResource((R.drawable.icecreamwithoutposypkavanille));
                        else if (dishes[0].equals(new Icecream(2, true, true, true, true, false)))
                            arrayImageDish[0].setImageResource((R.drawable.icecreamwithoutposypkachocolate));
                        else if (dishes[0].equals(new Icecream(3, true, true, true, true, false)))
                            arrayImageDish[0].setImageResource((R.drawable.icecreamwithoutposypkastrawberry));
                        else if (dishes[0].equals(new Icecream(1, true, true, true, true, true)))
                            arrayImageDish[0].setImageResource((R.drawable.icecreamwithposypkavanille));
                        else if (dishes[0].equals(new Icecream(2, true, true, true, true, true)))
                            arrayImageDish[0].setImageResource((R.drawable.icecreamwithposypkachocolate));
                        else if (dishes[0].equals(new Icecream(3, true, true, true, true, true)))
                            arrayImageDish[0].setImageResource((R.drawable.icecreamwithposypkastrawberry));
                        else if (dishes[0].equals(new Dough(0, false)))
                            arrayImageDish[0].setImageResource((R.drawable.dough));
                        else if (dishes[0].equals(new Dough(1, true)))
                            arrayImageDish[0].setImageResource((R.drawable.doughvanille));
                        else if (dishes[0].equals(new Dough(2, true)))
                            arrayImageDish[0].setImageResource((R.drawable.doughchocolate));
                        else if (dishes[0].equals(new Dough(3, true)))
                            arrayImageDish[0].setImageResource((R.drawable.doughstrawberry));
                        else
                            arrayImageDish[0].setImageResource((R.drawable.dish));
                    } else {
                        if (dishes[0].equals(new Donut(0, true, false, false)))
                            arrayImageDish[0].setImageResource(R.drawable.donutwithposypkastrawberryon); // ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВТЬ
                        else if (dishes[0].equals(new Donut(1, true, true, false)))
                            arrayImageDish[0].setImageResource(R.drawable.donutwithoutposypkavanilleon);
                        else if (dishes[0].equals(new Donut(2, true, true, false)))
                            arrayImageDish[0].setImageResource(R.drawable.donutwithoutposypkachocolateon);
                        else if (dishes[0].equals(new Donut(3, true, true, false)))
                            arrayImageDish[0].setImageResource(R.drawable.donutwithoutposypkastrawberryon);
                        else if (dishes[0].equals(new Donut(1, true, true, true)))
                            arrayImageDish[0].setImageResource(R.drawable.donutwithposypkavanilleon);
                        else if (dishes[0].equals(new Donut(2, true, true, false)))
                            arrayImageDish[0].setImageResource(R.drawable.donutwithposypkachocolateon);
                        else if (dishes[0].equals(new Donut(3, true, true, false)))
                            arrayImageDish[0].setImageResource(R.drawable.donutwithposypkastrawberryon);
                        else if (dishes[0].equals(new Cake(1, true, true, false, false)))
                            arrayImageDish[0].setImageResource(R.drawable.cakewithoutfruitchocolateon); //ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ
                        else if (dishes[0].equals(new Cake(2, true, true, false, false)))
                            arrayImageDish[0].setImageResource(R.drawable.cakewithoutfruitchocolateon); //ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ
                        else if (dishes[0].equals(new Cake(3, true, true, false, false)))
                            arrayImageDish[0].setImageResource(R.drawable.cakewithoutfruitchocolateon); //ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ
                        else if (dishes[0].equals(new Cake(1, true, true, true, false)))
                            arrayImageDish[0].setImageResource(R.drawable.cakewithoutfruitvanilleon);
                        else if (dishes[0].equals(new Cake(2, true, true, true, false)))
                            arrayImageDish[0].setImageResource(R.drawable.cakewithoutfruitchocolateon);
                        else if (dishes[0].equals(new Cake(3, true, true, true, false)))
                            arrayImageDish[0].setImageResource(R.drawable.cakewithoutfruitstrawberryon);
                        else if (dishes[0].equals(new Cake(1, true, true, true, true)))
                            arrayImageDish[0].setImageResource(R.drawable.cakewithfruitvanilleon);
                        else if (dishes[0].equals(new Cake(2, true, true, true, true)))
                            arrayImageDish[0].setImageResource(R.drawable.cakewithfruitchocolateon);
                        else if (dishes[0].equals(new Cake(3, true, true, true, true)))
                            arrayImageDish[0].setImageResource(R.drawable.cakewithfruitstrawberryon);
                        else if (dishes[0].equals(new Croissant(1, true, true)))
                            arrayImageDish[0].setImageResource(R.drawable.croissantvanilleon);
                        else if (dishes[0].equals(new Croissant(2, true, true)))
                            arrayImageDish[0].setImageResource(R.drawable.croissantchocolateon);
                        else if (dishes[0].equals(new Croissant(3, true, true)))
                            arrayImageDish[0].setImageResource(R.drawable.croissantstrawberryon);
                        /*else if (dishes[0].equals(new Icecream(0, false, true, false, false, false)))
                            arrayImageDish[0].setImageResource(R.drawable.hornoficecreamon);
                        else if (dishes[0].equals(new Icecream(0, false, true, true, false, false)))
                            arrayImageDish[0].setImageResource((R.drawable.hornoficecreamonstandarton));*/
                        else if(dishes[0] instanceof Icecream && (((Icecream)dishes[0]).equals(new Icecream(0,false,true,false,false,false))))
                            arrayImageDish[0].setImageResource((R.drawable.hornoficecreamon));
                        else if(dishes[0] instanceof Icecream && (((Icecream)dishes[0]).equals(new Icecream(0,false,true,true,false,false))))
                            arrayImageDish[0].setImageResource((R.drawable.hornoficecreamonstandarton));
                        else if (dishes[0].equals(new Icecream(1, true, true, true, false, false)))
                            arrayImageDish[0].setImageResource((R.drawable.hornoficecreamonvanilleon));
                        else if (dishes[0].equals(new Icecream(2, true, true, true, false, false)))
                            arrayImageDish[0].setImageResource((R.drawable.hornoficecreamonchocolateon));
                        else if (dishes[0].equals(new Icecream(3, true, true, true, false, false)))
                            arrayImageDish[0].setImageResource((R.drawable.hornoficecreamonstrawberryon));
                        else if (dishes[0].equals(new Icecream(1, true, true, true, true, false)))
                            arrayImageDish[0].setImageResource((R.drawable.icecreamwithoutposypkavanilleon));
                        else if (dishes[0].equals(new Icecream(2, true, true, true, true, false)))
                            arrayImageDish[0].setImageResource((R.drawable.icecreamwithoutposypkachocolateon));
                        else if (dishes[0].equals(new Icecream(3, true, true, true, true, false)))
                            arrayImageDish[0].setImageResource((R.drawable.icecreamwithoutposypkastrawberryon));
                        else if (dishes[0].equals(new Icecream(1, true, true, true, true, true)))
                            arrayImageDish[0].setImageResource((R.drawable.icecreamwithposypkavanilleon));
                        else if (dishes[0].equals(new Icecream(2, true, true, true, true, true)))
                            arrayImageDish[0].setImageResource((R.drawable.icecreamwithposypkachocolateon));
                        else if (dishes[0].equals(new Icecream(3, true, true, true, true, true)))
                            arrayImageDish[0].setImageResource((R.drawable.icecreamwithposypkastrawberryon));
                        else if (dishes[0].equals(new Dough(0, false)))
                            arrayImageDish[0].setImageResource((R.drawable.doughon));
                        else if (dishes[0].equals(new Dough(1, true)))
                            arrayImageDish[0].setImageResource((R.drawable.doughvanilleon));
                        else if (dishes[0].equals(new Dough(2, true)))
                            arrayImageDish[0].setImageResource((R.drawable.doughchocolateon));
                        else if (dishes[0].equals(new Dough(3, true)))
                            arrayImageDish[0].setImageResource((R.drawable.doughstrawberryon));
                        else
                            arrayImageDish[0].setImageResource(R.drawable.dishon);
                    }
                    boolean change = false;
                    if (arrayFlags[0]) {
                        arrayFlags[0] = !arrayFlags[0];
                        change = true;
                    }
                    if (arrayFlags[3])
                        arrayImageDish[3].callOnClick();
                    if (arrayFlags[1])
                        arrayImageDish[1].callOnClick();
                    if (arrayFlags[2])
                        arrayImageDish[2].callOnClick();
                    if (!change)
                        arrayFlags[0] = !arrayFlags[0];
                }
            }
            });

        /*Подсветка для второй тарелки*/

        arrayImageDish[1].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (!arrayFlagsIsEmpty[1]) {
                    if (arrayFlags[1]) {
                        if (dishes[1].equals(new Donut(0, true, false, false)))
                            arrayImageDish[1].setImageResource(R.drawable.donutwithposypkastrawberry); // ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВТЬ
                        else if (dishes[1].equals(new Donut(1, true, true, false)))
                            arrayImageDish[1].setImageResource(R.drawable.donutwithoutposypkavanille);
                        else if (dishes[1].equals(new Donut(2, true, true, false)))
                            arrayImageDish[1].setImageResource(R.drawable.donutwithoutposypkachocolate);
                        else if (dishes[1].equals(new Donut(3, true, true, false)))
                            arrayImageDish[1].setImageResource(R.drawable.donutwithoutposypkastrawberry);
                        else if (dishes[1].equals(new Donut(1, true, true, true)))
                            arrayImageDish[1].setImageResource(R.drawable.donutwithposypkavanille);
                        else if (dishes[1].equals(new Donut(2, true, true, false)))
                            arrayImageDish[1].setImageResource(R.drawable.donutwithposypkachocolate);
                        else if (dishes[1].equals(new Donut(3, true, true, false)))
                            arrayImageDish[1].setImageResource(R.drawable.donutwithposypkastrawberry);
                        else if (dishes[1].equals(new Cake(1, true, true, false, false)))
                            arrayImageDish[1].setImageResource(R.drawable.cakewithoutfruitchocolate); //ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ
                        else if (dishes[1].equals(new Cake(2, true, true, false, false)))
                            arrayImageDish[1].setImageResource(R.drawable.cakewithoutfruitchocolate); //ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ
                        else if (dishes[1].equals(new Cake(3, true, true, false, false)))
                            arrayImageDish[1].setImageResource(R.drawable.cakewithoutfruitchocolate); //ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ
                        else if (dishes[1].equals(new Cake(1, true, true, true, false)))
                            arrayImageDish[1].setImageResource(R.drawable.cakewithoutfruitvanille);
                        else if (dishes[1].equals(new Cake(2, true, true, true, false)))
                            arrayImageDish[1].setImageResource(R.drawable.cakewithoutfruitchocolate);
                        else if (dishes[1].equals(new Cake(3, true, true, true, false)))
                            arrayImageDish[1].setImageResource(R.drawable.cakewithoutfruitstrawberry);
                        else if (dishes[1].equals(new Cake(1, true, true, true, true)))
                            arrayImageDish[1].setImageResource(R.drawable.cakewithfruitvanille);
                        else if (dishes[1].equals(new Cake(2, true, true, true, true)))
                            arrayImageDish[1].setImageResource(R.drawable.cakewithfruitchocolate);
                        else if (dishes[1].equals(new Cake(3, true, true, true, true)))
                            arrayImageDish[1].setImageResource(R.drawable.cakewithfruitstrawberry);
                        else if (dishes[1].equals(new Croissant(1, true, true)))
                            arrayImageDish[1].setImageResource(R.drawable.croissantvanille);
                        else if (dishes[1].equals(new Croissant(2, true, true)))
                            arrayImageDish[1].setImageResource(R.drawable.croissantchocolate);
                        else if (dishes[1].equals(new Croissant(3, true, true)))
                            arrayImageDish[1].setImageResource(R.drawable.croissantstrawberry);
                        else if (dishes[1].equals(new Icecream(0, false, true, false, false, false)))
                            arrayImageDish[1].setImageResource(R.drawable.hornoficecream);
                        else if (dishes[1].equals(new Icecream(0, false, true, true, false, false)))
                            arrayImageDish[1].setImageResource((R.drawable.hornoficecreamonstandart));
                        else if (dishes[1].equals(new Icecream(1, true, true, true, false, false)))
                            arrayImageDish[1].setImageResource((R.drawable.hornoficecreamonvanille));
                        else if (dishes[1].equals(new Icecream(2, true, true, true, false, false)))
                            arrayImageDish[1].setImageResource((R.drawable.hornoficecreamonchocolate));
                        else if (dishes[1].equals(new Icecream(3, true, true, true, false, false)))
                            arrayImageDish[1].setImageResource((R.drawable.hornoficecreamonstrawberry));
                        else if (dishes[1].equals(new Icecream(1, true, true, true, true, false)))
                            arrayImageDish[1].setImageResource((R.drawable.icecreamwithoutposypkavanille));
                        else if (dishes[1].equals(new Icecream(2, true, true, true, true, false)))
                            arrayImageDish[1].setImageResource((R.drawable.icecreamwithoutposypkachocolate));
                        else if (dishes[1].equals(new Icecream(3, true, true, true, true, false)))
                            arrayImageDish[1].setImageResource((R.drawable.icecreamwithoutposypkastrawberry));
                        else if (dishes[1].equals(new Icecream(1, true, true, true, true, true)))
                            arrayImageDish[1].setImageResource((R.drawable.icecreamwithposypkavanille));
                        else if (dishes[1].equals(new Icecream(2, true, true, true, true, true)))
                            arrayImageDish[1].setImageResource((R.drawable.icecreamwithposypkachocolate));
                        else if (dishes[1].equals(new Icecream(3, true, true, true, true, true)))
                            arrayImageDish[1].setImageResource((R.drawable.icecreamwithposypkastrawberry));
                        else if (dishes[1].equals(new Dough(0, false)))
                            arrayImageDish[1].setImageResource((R.drawable.dough));
                        else if (dishes[1].equals(new Dough(1, true)))
                            arrayImageDish[1].setImageResource((R.drawable.doughvanille));
                        else if (dishes[1].equals(new Dough(2, true)))
                            arrayImageDish[1].setImageResource((R.drawable.doughchocolate));
                        else if (dishes[1].equals(new Dough(3, true)))
                            arrayImageDish[1].setImageResource((R.drawable.doughstrawberry));
                        else
                            arrayImageDish[1].setImageResource((R.drawable.dish));
                    } else {
                        if (dishes[1].equals(new Donut(0, true, false, false)))
                            arrayImageDish[1].setImageResource(R.drawable.donutwithposypkastrawberryon); // ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВТЬ
                        else if (dishes[1].equals(new Donut(1, true, true, false)))
                            arrayImageDish[1].setImageResource(R.drawable.donutwithoutposypkavanilleon);
                        else if (dishes[1].equals(new Donut(2, true, true, false)))
                            arrayImageDish[1].setImageResource(R.drawable.donutwithoutposypkachocolateon);
                        else if (dishes[1].equals(new Donut(3, true, true, false)))
                            arrayImageDish[1].setImageResource(R.drawable.donutwithoutposypkastrawberryon);
                        else if (dishes[1].equals(new Donut(1, true, true, true)))
                            arrayImageDish[1].setImageResource(R.drawable.donutwithposypkavanilleon);
                        else if (dishes[1].equals(new Donut(2, true, true, false)))
                            arrayImageDish[1].setImageResource(R.drawable.donutwithposypkachocolateon);
                        else if (dishes[1].equals(new Donut(3, true, true, false)))
                            arrayImageDish[1].setImageResource(R.drawable.donutwithposypkastrawberryon);
                        else if (dishes[1].equals(new Cake(1, true, true, false, false)))
                            arrayImageDish[1].setImageResource(R.drawable.cakewithoutfruitchocolateon); //ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ
                        else if (dishes[1].equals(new Cake(2, true, true, false, false)))
                            arrayImageDish[1].setImageResource(R.drawable.cakewithoutfruitchocolateon); //ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ
                        else if (dishes[1].equals(new Cake(3, true, true, false, false)))
                            arrayImageDish[1].setImageResource(R.drawable.cakewithoutfruitchocolateon); //ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ
                        else if (dishes[1].equals(new Cake(1, true, true, true, false)))
                            arrayImageDish[1].setImageResource(R.drawable.cakewithoutfruitvanilleon);
                        else if (dishes[1].equals(new Cake(2, true, true, true, false)))
                            arrayImageDish[1].setImageResource(R.drawable.cakewithoutfruitchocolateon);
                        else if (dishes[1].equals(new Cake(3, true, true, true, false)))
                            arrayImageDish[1].setImageResource(R.drawable.cakewithoutfruitstrawberryon);
                        else if (dishes[1].equals(new Cake(1, true, true, true, true)))
                            arrayImageDish[1].setImageResource(R.drawable.cakewithfruitvanilleon);
                        else if (dishes[1].equals(new Cake(2, true, true, true, true)))
                            arrayImageDish[1].setImageResource(R.drawable.cakewithfruitchocolateon);
                        else if (dishes[1].equals(new Cake(3, true, true, true, true)))
                            arrayImageDish[1].setImageResource(R.drawable.cakewithfruitstrawberryon);
                        else if (dishes[1].equals(new Croissant(1, true, true)))
                            arrayImageDish[1].setImageResource(R.drawable.croissantvanilleon);
                        else if (dishes[1].equals(new Croissant(2, true, true)))
                            arrayImageDish[1].setImageResource(R.drawable.croissantchocolateon);
                        else if (dishes[1].equals(new Croissant(3, true, true)))
                            arrayImageDish[1].setImageResource(R.drawable.croissantstrawberryon);
                        else if (dishes[1].equals(new Icecream(0, false, true, false, false, false)))
                            arrayImageDish[1].setImageResource(R.drawable.hornoficecreamon);
                        else if (dishes[1].equals(new Icecream(0, false, true, true, false, false)))
                            arrayImageDish[1].setImageResource((R.drawable.hornoficecreamonstandarton));
                        else if (dishes[1].equals(new Icecream(1, true, true, true, false, false)))
                            arrayImageDish[1].setImageResource((R.drawable.hornoficecreamonvanilleon));
                        else if (dishes[1].equals(new Icecream(2, true, true, true, false, false)))
                            arrayImageDish[1].setImageResource((R.drawable.hornoficecreamonchocolateon));
                        else if (dishes[1].equals(new Icecream(3, true, true, true, false, false)))
                            arrayImageDish[1].setImageResource((R.drawable.hornoficecreamonstrawberryon));
                        else if (dishes[1].equals(new Icecream(1, true, true, true, true, false)))
                            arrayImageDish[1].setImageResource((R.drawable.icecreamwithoutposypkavanilleon));
                        else if (dishes[1].equals(new Icecream(2, true, true, true, true, false)))
                            arrayImageDish[1].setImageResource((R.drawable.icecreamwithoutposypkachocolateon));
                        else if (dishes[1].equals(new Icecream(3, true, true, true, true, false)))
                            arrayImageDish[1].setImageResource((R.drawable.icecreamwithoutposypkastrawberryon));
                        else if (dishes[1].equals(new Icecream(1, true, true, true, true, true)))
                            arrayImageDish[1].setImageResource((R.drawable.icecreamwithposypkavanilleon));
                        else if (dishes[1].equals(new Icecream(2, true, true, true, true, true)))
                            arrayImageDish[1].setImageResource((R.drawable.icecreamwithposypkachocolateon));
                        else if (dishes[1].equals(new Icecream(3, true, true, true, true, true)))
                            arrayImageDish[1].setImageResource((R.drawable.icecreamwithposypkastrawberryon));
                        else if (dishes[1].equals(new Dough(0, false)))
                            arrayImageDish[1].setImageResource((R.drawable.doughon));
                        else if (dishes[1].equals(new Dough(1, true)))
                            arrayImageDish[1].setImageResource((R.drawable.doughvanilleon));
                        else if (dishes[1].equals(new Dough(2, true)))
                            arrayImageDish[1].setImageResource((R.drawable.doughchocolateon));
                        else if (dishes[1].equals(new Dough(3, true)))
                            arrayImageDish[1].setImageResource((R.drawable.doughstrawberryon));
                        else
                            arrayImageDish[1].setImageResource(R.drawable.dishon);
                    }
                    boolean change = false;
                    if (arrayFlags[1]) {
                        arrayFlags[1] = !arrayFlags[1];
                        change = true;
                    }
                    if (arrayFlags[0])
                        arrayImageDish[0].callOnClick();
                    if (arrayFlags[3])
                        arrayImageDish[3].callOnClick();
                    if (arrayFlags[2])
                        arrayImageDish[2].callOnClick();
                    if (!change)
                        arrayFlags[1] = !arrayFlags[1];
                }
            }
        });

        /*Подсветка для третьей тарелки*/

        arrayImageDish[2].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (!arrayFlagsIsEmpty[2]) {
                    if (arrayFlags[2]) {
                        if (dishes[2].equals(new Donut(0, true, false, false)))
                            arrayImageDish[2].setImageResource(R.drawable.donutwithposypkastrawberry); // ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВТЬ
                        else if (dishes[2].equals(new Donut(1, true, true, false)))
                            arrayImageDish[2].setImageResource(R.drawable.donutwithoutposypkavanille);
                        else if (dishes[2].equals(new Donut(2, true, true, false)))
                            arrayImageDish[2].setImageResource(R.drawable.donutwithoutposypkachocolate);
                        else if (dishes[2].equals(new Donut(3, true, true, false)))
                            arrayImageDish[2].setImageResource(R.drawable.donutwithoutposypkastrawberry);
                        else if (dishes[2].equals(new Donut(1, true, true, true)))
                            arrayImageDish[2].setImageResource(R.drawable.donutwithposypkavanille);
                        else if (dishes[2].equals(new Donut(2, true, true, false)))
                            arrayImageDish[2].setImageResource(R.drawable.donutwithposypkachocolate);
                        else if (dishes[2].equals(new Donut(3, true, true, false)))
                            arrayImageDish[2].setImageResource(R.drawable.donutwithposypkastrawberry);
                        else if (dishes[2].equals(new Cake(1, true, true, false, false)))
                            arrayImageDish[2].setImageResource(R.drawable.cakewithoutfruitchocolate); //ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ
                        else if (dishes[2].equals(new Cake(2, true, true, false, false)))
                            arrayImageDish[2].setImageResource(R.drawable.cakewithoutfruitchocolate); //ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ
                        else if (dishes[2].equals(new Cake(3, true, true, false, false)))
                            arrayImageDish[2].setImageResource(R.drawable.cakewithoutfruitchocolate); //ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ
                        else if (dishes[2].equals(new Cake(1, true, true, true, false)))
                            arrayImageDish[2].setImageResource(R.drawable.cakewithoutfruitvanille);
                        else if (dishes[2].equals(new Cake(2, true, true, true, false)))
                            arrayImageDish[2].setImageResource(R.drawable.cakewithoutfruitchocolate);
                        else if (dishes[2].equals(new Cake(3, true, true, true, false)))
                            arrayImageDish[2].setImageResource(R.drawable.cakewithoutfruitstrawberry);
                        else if (dishes[2].equals(new Cake(1, true, true, true, true)))
                            arrayImageDish[2].setImageResource(R.drawable.cakewithfruitvanille);
                        else if (dishes[2].equals(new Cake(2, true, true, true, true)))
                            arrayImageDish[2].setImageResource(R.drawable.cakewithfruitchocolate);
                        else if (dishes[2].equals(new Cake(3, true, true, true, true)))
                            arrayImageDish[2].setImageResource(R.drawable.cakewithfruitstrawberry);
                        else if (dishes[2].equals(new Croissant(1, true, true)))
                            arrayImageDish[2].setImageResource(R.drawable.croissantvanille);
                        else if (dishes[2].equals(new Croissant(2, true, true)))
                            arrayImageDish[2].setImageResource(R.drawable.croissantchocolate);
                        else if (dishes[2].equals(new Croissant(3, true, true)))
                            arrayImageDish[2].setImageResource(R.drawable.croissantstrawberry);
                        else if (dishes[2].equals(new Icecream(0, false, true, false, false, false)))
                            arrayImageDish[2].setImageResource(R.drawable.hornoficecream);
                        else if (dishes[2].equals(new Icecream(0, false, true, true, false, false)))
                            arrayImageDish[2].setImageResource((R.drawable.hornoficecreamonstandart));
                        else if (dishes[2].equals(new Icecream(1, true, true, true, false, false)))
                            arrayImageDish[2].setImageResource((R.drawable.hornoficecreamonvanille));
                        else if (dishes[2].equals(new Icecream(2, true, true, true, false, false)))
                            arrayImageDish[2].setImageResource((R.drawable.hornoficecreamonchocolate));
                        else if (dishes[2].equals(new Icecream(3, true, true, true, false, false)))
                            arrayImageDish[2].setImageResource((R.drawable.hornoficecreamonstrawberry));
                        else if (dishes[2].equals(new Icecream(1, true, true, true, true, false)))
                            arrayImageDish[2].setImageResource((R.drawable.icecreamwithoutposypkavanille));
                        else if (dishes[2].equals(new Icecream(2, true, true, true, true, false)))
                            arrayImageDish[2].setImageResource((R.drawable.icecreamwithoutposypkachocolate));
                        else if (dishes[2].equals(new Icecream(3, true, true, true, true, false)))
                            arrayImageDish[2].setImageResource((R.drawable.icecreamwithoutposypkastrawberry));
                        else if (dishes[2].equals(new Icecream(1, true, true, true, true, true)))
                            arrayImageDish[2].setImageResource((R.drawable.icecreamwithposypkavanille));
                        else if (dishes[2].equals(new Icecream(2, true, true, true, true, true)))
                            arrayImageDish[2].setImageResource((R.drawable.icecreamwithposypkachocolate));
                        else if (dishes[2].equals(new Icecream(3, true, true, true, true, true)))
                            arrayImageDish[2].setImageResource((R.drawable.icecreamwithposypkastrawberry));
                        else if (dishes[2].equals(new Dough(0, false)))
                            arrayImageDish[2].setImageResource((R.drawable.dough));
                        else if (dishes[2].equals(new Dough(1, true)))
                            arrayImageDish[2].setImageResource((R.drawable.doughvanille));
                        else if (dishes[2].equals(new Dough(2, true)))
                            arrayImageDish[2].setImageResource((R.drawable.doughchocolate));
                        else if (dishes[2].equals(new Dough(3, true)))
                            arrayImageDish[2].setImageResource((R.drawable.doughstrawberry));
                        else
                            arrayImageDish[2].setImageResource((R.drawable.dish));
                    } else {
                        if (dishes[2].equals(new Donut(0, true, false, false)))
                            arrayImageDish[2].setImageResource(R.drawable.donutwithposypkastrawberryon); // ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВТЬ
                        else if (dishes[2].equals(new Donut(1, true, true, false)))
                            arrayImageDish[2].setImageResource(R.drawable.donutwithoutposypkavanilleon);
                        else if (dishes[2].equals(new Donut(2, true, true, false)))
                            arrayImageDish[2].setImageResource(R.drawable.donutwithoutposypkachocolateon);
                        else if (dishes[2].equals(new Donut(3, true, true, false)))
                            arrayImageDish[2].setImageResource(R.drawable.donutwithoutposypkastrawberryon);
                        else if (dishes[2].equals(new Donut(1, true, true, true)))
                            arrayImageDish[2].setImageResource(R.drawable.donutwithposypkavanilleon);
                        else if (dishes[2].equals(new Donut(2, true, true, false)))
                            arrayImageDish[2].setImageResource(R.drawable.donutwithposypkachocolateon);
                        else if (dishes[2].equals(new Donut(3, true, true, false)))
                            arrayImageDish[2].setImageResource(R.drawable.donutwithposypkastrawberryon);
                        else if (dishes[2].equals(new Cake(1, true, true, false, false)))
                            arrayImageDish[2].setImageResource(R.drawable.cakewithoutfruitchocolateon); //ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ
                        else if (dishes[2].equals(new Cake(2, true, true, false, false)))
                            arrayImageDish[2].setImageResource(R.drawable.cakewithoutfruitchocolateon); //ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ
                        else if (dishes[2].equals(new Cake(3, true, true, false, false)))
                            arrayImageDish[2].setImageResource(R.drawable.cakewithoutfruitchocolateon); //ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ
                        else if (dishes[2].equals(new Cake(1, true, true, true, false)))
                            arrayImageDish[2].setImageResource(R.drawable.cakewithoutfruitvanilleon);
                        else if (dishes[2].equals(new Cake(2, true, true, true, false)))
                            arrayImageDish[2].setImageResource(R.drawable.cakewithoutfruitchocolateon);
                        else if (dishes[2].equals(new Cake(3, true, true, true, false)))
                            arrayImageDish[2].setImageResource(R.drawable.cakewithoutfruitstrawberryon);
                        else if (dishes[2].equals(new Cake(1, true, true, true, true)))
                            arrayImageDish[2].setImageResource(R.drawable.cakewithfruitvanilleon);
                        else if (dishes[2].equals(new Cake(2, true, true, true, true)))
                            arrayImageDish[2].setImageResource(R.drawable.cakewithfruitchocolateon);
                        else if (dishes[2].equals(new Cake(3, true, true, true, true)))
                            arrayImageDish[2].setImageResource(R.drawable.cakewithfruitstrawberryon);
                        else if (dishes[2].equals(new Croissant(1, true, true)))
                            arrayImageDish[2].setImageResource(R.drawable.croissantvanilleon);
                        else if (dishes[2].equals(new Croissant(2, true, true)))
                            arrayImageDish[2].setImageResource(R.drawable.croissantchocolateon);
                        else if (dishes[2].equals(new Croissant(3, true, true)))
                            arrayImageDish[2].setImageResource(R.drawable.croissantstrawberryon);
                        else if (dishes[2].equals(new Icecream(0, false, true, false, false, false)))
                            arrayImageDish[2].setImageResource(R.drawable.hornoficecreamon);
                        else if (dishes[2].equals(new Icecream(0, false, true, true, false, false)))
                            arrayImageDish[2].setImageResource((R.drawable.hornoficecreamonstandarton));
                        else if (dishes[2].equals(new Icecream(1, true, true, true, false, false)))
                            arrayImageDish[2].setImageResource((R.drawable.hornoficecreamonvanilleon));
                        else if (dishes[2].equals(new Icecream(2, true, true, true, false, false)))
                            arrayImageDish[2].setImageResource((R.drawable.hornoficecreamonchocolateon));
                        else if (dishes[2].equals(new Icecream(3, true, true, true, false, false)))
                            arrayImageDish[2].setImageResource((R.drawable.hornoficecreamonstrawberryon));
                        else if (dishes[2].equals(new Icecream(1, true, true, true, true, false)))
                            arrayImageDish[2].setImageResource((R.drawable.icecreamwithoutposypkavanilleon));
                        else if (dishes[2].equals(new Icecream(2, true, true, true, true, false)))
                            arrayImageDish[2].setImageResource((R.drawable.icecreamwithoutposypkachocolateon));
                        else if (dishes[2].equals(new Icecream(3, true, true, true, true, false)))
                            arrayImageDish[2].setImageResource((R.drawable.icecreamwithoutposypkastrawberryon));
                        else if (dishes[2].equals(new Icecream(1, true, true, true, true, true)))
                            arrayImageDish[2].setImageResource((R.drawable.icecreamwithposypkavanilleon));
                        else if (dishes[2].equals(new Icecream(2, true, true, true, true, true)))
                            arrayImageDish[2].setImageResource((R.drawable.icecreamwithposypkachocolateon));
                        else if (dishes[2].equals(new Icecream(3, true, true, true, true, true)))
                            arrayImageDish[2].setImageResource((R.drawable.icecreamwithposypkastrawberryon));
                        else if (dishes[2].equals(new Dough(0, false)))
                            arrayImageDish[2].setImageResource((R.drawable.doughon));
                        else if (dishes[2].equals(new Dough(1, true)))
                            arrayImageDish[2].setImageResource((R.drawable.doughvanilleon));
                        else if (dishes[2].equals(new Dough(2, true)))
                            arrayImageDish[2].setImageResource((R.drawable.doughchocolateon));
                        else if (dishes[2].equals(new Dough(3, true)))
                            arrayImageDish[2].setImageResource((R.drawable.doughstrawberryon));
                        else
                            arrayImageDish[2].setImageResource(R.drawable.dishon);
                    }
                    boolean change = false;
                    if (arrayFlags[2]) {
                        arrayFlags[2] = !arrayFlags[2];
                        change = true;
                    }
                    if (arrayFlags[0])
                        arrayImageDish[0].callOnClick();
                    if (arrayFlags[1])
                        arrayImageDish[1].callOnClick();
                    if (arrayFlags[3])
                        arrayImageDish[3].callOnClick();
                    if (!change)
                        arrayFlags[2] = !arrayFlags[2];
                }
            }
        });

        /*Подсветка для четвертой тарелки*/

        arrayImageDish[3].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (!arrayFlagsIsEmpty[3]) {
                    if (arrayFlags[3]) {
                        if (dishes[3].equals(new Donut(0, true, false, false)))
                            arrayImageDish[3].setImageResource(R.drawable.donutwithposypkastrawberry); // ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВТЬ
                        else if (dishes[3].equals(new Donut(1, true, true, false)))
                            arrayImageDish[3].setImageResource(R.drawable.donutwithoutposypkavanille);
                        else if (dishes[3].equals(new Donut(2, true, true, false)))
                            arrayImageDish[3].setImageResource(R.drawable.donutwithoutposypkachocolate);
                        else if (dishes[3].equals(new Donut(3, true, true, false)))
                            arrayImageDish[3].setImageResource(R.drawable.donutwithoutposypkastrawberry);
                        else if (dishes[3].equals(new Donut(1, true, true, true)))
                            arrayImageDish[3].setImageResource(R.drawable.donutwithposypkavanille);
                        else if (dishes[3].equals(new Donut(2, true, true, false)))
                            arrayImageDish[3].setImageResource(R.drawable.donutwithposypkachocolate);
                        else if (dishes[3].equals(new Donut(3, true, true, false)))
                            arrayImageDish[3].setImageResource(R.drawable.donutwithposypkastrawberry);
                        else if (dishes[3].equals(new Cake(1, true, true, false, false)))
                            arrayImageDish[3].setImageResource(R.drawable.cakewithoutfruitchocolate); //ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ
                        else if (dishes[3].equals(new Cake(2, true, true, false, false)))
                            arrayImageDish[3].setImageResource(R.drawable.cakewithoutfruitchocolate); //ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ
                        else if (dishes[3].equals(new Cake(3, true, true, false, false)))
                            arrayImageDish[3].setImageResource(R.drawable.cakewithoutfruitchocolate); //ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ
                        else if (dishes[3].equals(new Cake(1, true, true, true, false)))
                            arrayImageDish[3].setImageResource(R.drawable.cakewithoutfruitvanille);
                        else if (dishes[3].equals(new Cake(2, true, true, true, false)))
                            arrayImageDish[3].setImageResource(R.drawable.cakewithoutfruitchocolate);
                        else if (dishes[3].equals(new Cake(3, true, true, true, false)))
                            arrayImageDish[3].setImageResource(R.drawable.cakewithoutfruitstrawberry);
                        else if (dishes[3].equals(new Cake(1, true, true, true, true)))
                            arrayImageDish[3].setImageResource(R.drawable.cakewithfruitvanille);
                        else if (dishes[3].equals(new Cake(2, true, true, true, true)))
                            arrayImageDish[3].setImageResource(R.drawable.cakewithfruitchocolate);
                        else if (dishes[3].equals(new Cake(3, true, true, true, true)))
                            arrayImageDish[3].setImageResource(R.drawable.cakewithfruitstrawberry);
                        else if (dishes[3].equals(new Croissant(1, true, true)))
                            arrayImageDish[3].setImageResource(R.drawable.croissantvanille);
                        else if (dishes[3].equals(new Croissant(2, true, true)))
                            arrayImageDish[3].setImageResource(R.drawable.croissantchocolate);
                        else if (dishes[3].equals(new Croissant(3, true, true)))
                            arrayImageDish[3].setImageResource(R.drawable.croissantstrawberry);
                        else if (dishes[3].equals(new Icecream(0, false, true, false, false, false)))
                            arrayImageDish[3].setImageResource(R.drawable.hornoficecream);
                        else if (dishes[3].equals(new Icecream(0, false, true, true, false, false)))
                            arrayImageDish[3].setImageResource((R.drawable.hornoficecreamonstandart));
                        else if (dishes[3].equals(new Icecream(1, true, true, true, false, false)))
                            arrayImageDish[3].setImageResource((R.drawable.hornoficecreamonvanille));
                        else if (dishes[3].equals(new Icecream(2, true, true, true, false, false)))
                            arrayImageDish[3].setImageResource((R.drawable.hornoficecreamonchocolate));
                        else if (dishes[3].equals(new Icecream(3, true, true, true, false, false)))
                            arrayImageDish[3].setImageResource((R.drawable.hornoficecreamonstrawberry));
                        else if (dishes[3].equals(new Icecream(1, true, true, true, true, false)))
                            arrayImageDish[3].setImageResource((R.drawable.icecreamwithoutposypkavanille));
                        else if (dishes[3].equals(new Icecream(2, true, true, true, true, false)))
                            arrayImageDish[3].setImageResource((R.drawable.icecreamwithoutposypkachocolate));
                        else if (dishes[3].equals(new Icecream(3, true, true, true, true, false)))
                            arrayImageDish[3].setImageResource((R.drawable.icecreamwithoutposypkastrawberry));
                        else if (dishes[3].equals(new Icecream(1, true, true, true, true, true)))
                            arrayImageDish[3].setImageResource((R.drawable.icecreamwithposypkavanille));
                        else if (dishes[3].equals(new Icecream(2, true, true, true, true, true)))
                            arrayImageDish[3].setImageResource((R.drawable.icecreamwithposypkachocolate));
                        else if (dishes[3].equals(new Icecream(3, true, true, true, true, true)))
                            arrayImageDish[3].setImageResource((R.drawable.icecreamwithposypkastrawberry));
                        else if (dishes[3].equals(new Dough(0, false)))
                            arrayImageDish[3].setImageResource((R.drawable.dough));
                        else if (dishes[3].equals(new Dough(1, true)))
                            arrayImageDish[3].setImageResource((R.drawable.doughvanille));
                        else if (dishes[3].equals(new Dough(2, true)))
                            arrayImageDish[3].setImageResource((R.drawable.doughchocolate));
                        else if (dishes[3].equals(new Dough(3, true)))
                            arrayImageDish[3].setImageResource((R.drawable.doughstrawberry));
                        else
                            arrayImageDish[3].setImageResource((R.drawable.dish));
                    } else {
                        if (dishes[3].equals(new Donut(0, true, false, false)))
                            arrayImageDish[3].setImageResource(R.drawable.donutwithposypkastrawberryon); // ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВТЬ
                        else if (dishes[3].equals(new Donut(1, true, true, false)))
                            arrayImageDish[3].setImageResource(R.drawable.donutwithoutposypkavanilleon);
                        else if (dishes[3].equals(new Donut(2, true, true, false)))
                            arrayImageDish[3].setImageResource(R.drawable.donutwithoutposypkachocolateon);
                        else if (dishes[3].equals(new Donut(3, true, true, false)))
                            arrayImageDish[3].setImageResource(R.drawable.donutwithoutposypkastrawberryon);
                        else if (dishes[3].equals(new Donut(1, true, true, true)))
                            arrayImageDish[3].setImageResource(R.drawable.donutwithposypkavanilleon);
                        else if (dishes[3].equals(new Donut(2, true, true, false)))
                            arrayImageDish[3].setImageResource(R.drawable.donutwithposypkachocolateon);
                        else if (dishes[3].equals(new Donut(3, true, true, false)))
                            arrayImageDish[3].setImageResource(R.drawable.donutwithposypkastrawberryon);
                        else if (dishes[3].equals(new Cake(1, true, true, false, false)))
                            arrayImageDish[3].setImageResource(R.drawable.cakewithoutfruitchocolateon); //ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ
                        else if (dishes[3].equals(new Cake(2, true, true, false, false)))
                            arrayImageDish[3].setImageResource(R.drawable.cakewithoutfruitchocolateon); //ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ
                        else if (dishes[3].equals(new Cake(3, true, true, false, false)))
                            arrayImageDish[3].setImageResource(R.drawable.cakewithoutfruitchocolateon); //ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ ИСПРАВИТЬ
                        else if (dishes[3].equals(new Cake(1, true, true, true, false)))
                            arrayImageDish[3].setImageResource(R.drawable.cakewithoutfruitvanilleon);
                        else if (dishes[3].equals(new Cake(2, true, true, true, false)))
                            arrayImageDish[3].setImageResource(R.drawable.cakewithoutfruitchocolateon);
                        else if (dishes[3].equals(new Cake(3, true, true, true, false)))
                            arrayImageDish[3].setImageResource(R.drawable.cakewithoutfruitstrawberryon);
                        else if (dishes[3].equals(new Cake(1, true, true, true, true)))
                            arrayImageDish[3].setImageResource(R.drawable.cakewithfruitvanilleon);
                        else if (dishes[3].equals(new Cake(2, true, true, true, true)))
                            arrayImageDish[3].setImageResource(R.drawable.cakewithfruitchocolateon);
                        else if (dishes[3].equals(new Cake(3, true, true, true, true)))
                            arrayImageDish[3].setImageResource(R.drawable.cakewithfruitstrawberryon);
                        else if (dishes[3].equals(new Croissant(1, true, true)))
                            arrayImageDish[3].setImageResource(R.drawable.croissantvanilleon);
                        else if (dishes[3].equals(new Croissant(2, true, true)))
                            arrayImageDish[3].setImageResource(R.drawable.croissantchocolateon);
                        else if (dishes[3].equals(new Croissant(3, true, true)))
                            arrayImageDish[3].setImageResource(R.drawable.croissantstrawberryon);
                        else if (dishes[3].equals(new Icecream(0, false, true, false, false, false)))
                            arrayImageDish[3].setImageResource(R.drawable.hornoficecreamon);
                        else if (dishes[3].equals(new Icecream(0, false, true, true, false, false)))
                            arrayImageDish[3].setImageResource((R.drawable.hornoficecreamonstandarton));
                        else if (dishes[3].equals(new Icecream(1, true, true, true, false, false)))
                            arrayImageDish[3].setImageResource((R.drawable.hornoficecreamonvanilleon));
                        else if (dishes[3].equals(new Icecream(2, true, true, true, false, false)))
                            arrayImageDish[3].setImageResource((R.drawable.hornoficecreamonchocolateon));
                        else if (dishes[3].equals(new Icecream(3, true, true, true, false, false)))
                            arrayImageDish[3].setImageResource((R.drawable.hornoficecreamonstrawberryon));
                        else if (dishes[3].equals(new Icecream(1, true, true, true, true, false)))
                            arrayImageDish[3].setImageResource((R.drawable.icecreamwithoutposypkavanilleon));
                        else if (dishes[3].equals(new Icecream(2, true, true, true, true, false)))
                            arrayImageDish[3].setImageResource((R.drawable.icecreamwithoutposypkachocolateon));
                        else if (dishes[3].equals(new Icecream(3, true, true, true, true, false)))
                            arrayImageDish[3].setImageResource((R.drawable.icecreamwithoutposypkastrawberryon));
                        else if (dishes[3].equals(new Icecream(1, true, true, true, true, true)))
                            arrayImageDish[3].setImageResource((R.drawable.icecreamwithposypkavanilleon));
                        else if (dishes[3].equals(new Icecream(2, true, true, true, true, true)))
                            arrayImageDish[3].setImageResource((R.drawable.icecreamwithposypkachocolateon));
                        else if (dishes[3].equals(new Icecream(3, true, true, true, true, true)))
                            arrayImageDish[3].setImageResource((R.drawable.icecreamwithposypkastrawberryon));
                        else if (dishes[3].equals(new Dough(0, false)))
                            arrayImageDish[3].setImageResource((R.drawable.doughon));
                        else if (dishes[3].equals(new Dough(1, true)))
                            arrayImageDish[3].setImageResource((R.drawable.doughvanilleon));
                        else if (dishes[3].equals(new Dough(2, true)))
                            arrayImageDish[3].setImageResource((R.drawable.doughchocolateon));
                        else if (dishes[3].equals(new Dough(3, true)))
                            arrayImageDish[3].setImageResource((R.drawable.doughstrawberryon));
                        else
                            arrayImageDish[3].setImageResource(R.drawable.dishon);
                    }
                    boolean change = false;
                    if (arrayFlags[3]) {
                        arrayFlags[3] = !arrayFlags[3];
                        change = true;
                    }
                    if (arrayFlags[0])
                        arrayImageDish[0].callOnClick();
                    if (arrayFlags[1])
                        arrayImageDish[1].callOnClick();
                    if (arrayFlags[2])
                        arrayImageDish[2].callOnClick();
                    if (!change)
                        arrayFlags[3] = !arrayFlags[3];
                }
            }
        });

        /*Работа холодильника (тесто)*/

        dough.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arrayFlags[0] && dishes[0].equals(new Dish())){
                    arrayFlags[0] = false;
                    dishes[0] = new Dough(0,false);
                    arrayImageDish[0].setImageResource(R.drawable.dough);
                }
                else if(arrayFlags[1] && dishes[1].equals(new Dish())){
                    dishes[1] = new Dough(0,false);
                    arrayFlags[1] = false;
                    arrayImageDish[1].setImageResource(R.drawable.dough);
                }
                else if(arrayFlags[2] && dishes[2].equals(new Dish())){
                    dishes[2] = new Dough(0,false);
                    arrayFlags[2] = false;
                    arrayImageDish[2].setImageResource(R.drawable.dough);
                }
                else if(arrayFlags[3] && dishes[3].equals(new Dish())){
                    dishes[3] = new Dough(0,false);
                    arrayFlags[3] = false;
                    arrayImageDish[3].setImageResource(R.drawable.dough);
                }
            }
        });

        /*Работа льда*/

        ice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arrayFlags[0] && dishes[0].equals(new Icecream(0,false,true,false,false,false))){
                    arrayFlags[0] = false;
                    dishes[0] = new Icecream(0, false, true, true, false, false);
                    arrayImageDish[0].setImageResource(R.drawable.hornoficecreamonstandart);
                }
                else if(arrayFlags[1] && dishes[1].equals(new Icecream(0,false,true,false,false,false))){
                    arrayFlags[1] = false;
                    dishes[1] = new Icecream(0,false,true,true,false,false);
                    arrayImageDish[1].setImageResource(R.drawable.hornoficecreamonstandart);
                }
                else if(arrayFlags[2] && dishes[2].equals(new Icecream(0,false,true,false,false,false))){
                    arrayFlags[2] = false;
                    dishes[2] = new Icecream(0,false,true,true,false,false);
                    arrayImageDish[2].setImageResource(R.drawable.hornoficecreamonstandart);
                }
                else if(arrayFlags[3] && dishes[3].equals(new Icecream(0,false,true,false,false,false))){
                    arrayFlags[3] = false;
                    dishes[3] = new Icecream(0,false,true,true,false,false);
                    arrayImageDish[3].setImageResource(R.drawable.hornoficecreamonstandart);
                }
            }
        });

        /*Работа рожка для мороженого*/

        hornIcecream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arrayFlags[0] && dishes[0].equals(new Dish())){
                    arrayFlags[0] = false;
                    dishes[0] = new Icecream(0,false,true,false,false,false);
                    arrayImageDish[0].setImageResource(R.drawable.hornoficecream);
                }
                else if(arrayFlags[1] && dishes[1].equals(new Dish())){
                    dishes[1] = new Icecream(0,false,true,false,false,false);
                    arrayFlags[1] = false;
                    arrayImageDish[1].setImageResource(R.drawable.hornoficecream);
                }
                else if(arrayFlags[2] && dishes[2].equals(new Dish())){
                    dishes[2] = new Icecream(0,false,true,false,false,false);
                    arrayFlags[2] = false;
                    arrayImageDish[2].setImageResource(R.drawable.hornoficecream);
                }
                else if(arrayFlags[3] && dishes[3].equals(new Dish())){
                    dishes[3] = new Icecream(0,false,true,false,false,false);
                    arrayFlags[3] = false;
                    arrayImageDish[3].setImageResource(R.drawable.hornoficecream);
                }
            }
        });

        /*Работа рожка для пироженого*/

        hornCake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arrayFlags[0] && dishes[0].equals(new Dough(1,true))){
                    arrayFlags[0] = false;
                    dishes[0] = new Cake(1,true,true,false,false);
                    arrayImageDish[0].setImageResource(R.drawable.cakewithfruitstrawberry); //ИСПРАВИТЬ НА ПИРОЖЕНОЕ В РОЖКЕ
                }
                else if(arrayFlags[1] && dishes[0].equals(new Dough(1,true))){
                    arrayFlags[1] = false;
                    dishes[1] = new Cake(1,true,true,false,false);
                    arrayImageDish[1].setImageResource(R.drawable.cakewithfruitstrawberry); //ИСПРАВИТЬ НА ПИРОЖЕНОЕ В РОЖКЕ
                }
                else if(arrayFlags[2] && dishes[0].equals(new Dough(1,true))){
                    arrayFlags[2] = false;
                    dishes[2] = new Cake(1,true,true,false,false);
                    arrayImageDish[2].setImageResource(R.drawable.cakewithfruitstrawberry); //ИСПРАВИТЬ НА ПИРОЖЕНОЕ В РОЖКЕ
                }
                else if(arrayFlags[3] && dishes[0].equals(new Dough(1,true))){
                    arrayFlags[3] = false;
                    dishes[3] = new Cake(1,true,true,false,false);
                    arrayImageDish[3].setImageResource(R.drawable.cakewithfruitstrawberry); //ИСПРАВИТЬ НА ПИРОЖЕНОЕ В РОЖКЕ
                }
                else if(arrayFlags[0] && dishes[0].equals(new Dough(2,true))){
                    arrayFlags[0] = false;
                    dishes[0] = new Cake(2,true,true,false,false);
                    arrayImageDish[0].setImageResource(R.drawable.cakewithfruitstrawberry); //ИСПРАВИТЬ НА ПИРОЖЕНОЕ В РОЖКЕ
                }
                else if(arrayFlags[1] && dishes[0].equals(new Dough(2,true))){
                    arrayFlags[1] = false;
                    dishes[1] = new Cake(2,true,true,false,false);
                    arrayImageDish[1].setImageResource(R.drawable.cakewithfruitstrawberry); //ИСПРАВИТЬ НА ПИРОЖЕНОЕ В РОЖКЕ
                }
                else if(arrayFlags[2] && dishes[0].equals(new Dough(2,true))){
                    arrayFlags[2] = false;
                    dishes[2] = new Cake(2,true,true,false,false);
                    arrayImageDish[2].setImageResource(R.drawable.cakewithfruitstrawberry); //ИСПРАВИТЬ НА ПИРОЖЕНОЕ В РОЖКЕ
                }
                else if(arrayFlags[3] && dishes[0].equals(new Dough(2,true))){
                    arrayFlags[3] = false;
                    dishes[3] = new Cake(2,true,true,false,false);
                    arrayImageDish[3].setImageResource(R.drawable.cakewithfruitstrawberry); //ИСПРАВИТЬ НА ПИРОЖЕНОЕ В РОЖКЕ
                }
                else if(arrayFlags[0] && dishes[0].equals(new Dough(3,true))){
                    arrayFlags[0] = false;
                    dishes[0] = new Cake(3,true,true,false,false);
                    arrayImageDish[0].setImageResource(R.drawable.cakewithfruitstrawberry); //ИСПРАВИТЬ НА ПИРОЖЕНОЕ В РОЖКЕ
                }
                else if(arrayFlags[1] && dishes[0].equals(new Dough(3,true))){
                    arrayFlags[1] = false;
                    dishes[1] = new Cake(3,true,true,false,false);
                    arrayImageDish[1].setImageResource(R.drawable.cakewithfruitstrawberry); //ИСПРАВИТЬ НА ПИРОЖЕНОЕ В РОЖКЕ
                }
                else if(arrayFlags[2] && dishes[0].equals(new Dough(3,true))){
                    arrayFlags[2] = false;
                    dishes[2] = new Cake(3,true,true,false,false);
                    arrayImageDish[2].setImageResource(R.drawable.cakewithfruitstrawberry); //ИСПРАВИТЬ НА ПИРОЖЕНОЕ В РОЖКЕ
                }
                else if(arrayFlags[3] && dishes[0].equals(new Dough(3,true))){
                    arrayFlags[3] = false;
                    dishes[3] = new Cake(3,true,true,false,false);
                    arrayImageDish[3].setImageResource(R.drawable.cakewithfruitstrawberry); //ИСПРАВИТЬ НА ПИРОЖЕНОЕ В РОЖКЕ
                }

            }
        });

        /*Работа ванильного красителя*/

        creamVanille.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arrayFlags[0] && dishes[0].equals(new Icecream(0,false,true,true,false,false))){
                    arrayFlags[0] = false;
                    dishes[0] = new Icecream(1,true,true,true,false,false);
                    arrayImageDish[0].setImageResource(R.drawable.hornoficecreamonvanille);
                }
                else if(arrayFlags[1] && dishes[1].equals(new Icecream(0,false,true,true,false,false))){
                    arrayFlags[1] = false;
                    dishes[1] = new Icecream(1,true,true,true,false,false);
                    arrayImageDish[1].setImageResource(R.drawable.hornoficecreamonvanille);
                }
                else if(arrayFlags[2] && dishes[2].equals(new Icecream(0,false,true,true,false,false))){
                    arrayFlags[2] = false;
                    dishes[2] = new Icecream(1,true,true,true,false,false);
                    arrayImageDish[2].setImageResource(R.drawable.hornoficecreamonvanille);
                }
                else if(arrayFlags[3] && dishes[3].equals(new Icecream(0,false,true,true,false,false))){
                    arrayFlags[3] = false;
                    dishes[3] = new Icecream(1,true,true,true,false,false);
                    arrayImageDish[3].setImageResource(R.drawable.hornoficecreamonvanille);
                }
                else if(arrayFlags[0] && dishes[0].equals(new Dough(0,false))){
                    arrayFlags[0] = false;
                    dishes[0] = new Dough(1,true);
                    arrayImageDish[0].setImageResource(R.drawable.doughvanille);
                }
                else if(arrayFlags[1] && dishes[1].equals(new Dough(0,false))){
                    arrayFlags[1] = false;
                    dishes[1] = new Dough(1,true);
                    arrayImageDish[1].setImageResource(R.drawable.doughvanille);
                }
                else if(arrayFlags[2] && dishes[2].equals(new Dough(0,false))){
                    arrayFlags[2] = false;
                    dishes[2] = new Dough(1,true);
                    arrayImageDish[2].setImageResource(R.drawable.doughvanille);
                }
                else if(arrayFlags[3] && dishes[3].equals(new Dough(0,false))){
                    arrayFlags[3] = false;
                    dishes[3] = new Dough(1,true);
                    arrayImageDish[3].setImageResource(R.drawable.doughvanille);
                }
            }
        });

        /*Работа шоколадного красителя*/

        creamChocolate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arrayFlags[0] && dishes[0].equals(new Icecream(0,false,true,true,false,false))){
                    arrayFlags[0] = false;
                    dishes[0] = new Icecream(2,true,true,true,false,false);
                    arrayImageDish[0].setImageResource(R.drawable.hornoficecreamonchocolate);
                }
                else if(arrayFlags[1] && dishes[1].equals(new Icecream(0,false,true,true,false,false))){
                    arrayFlags[1] = false;
                    dishes[1] = new Icecream(2,true,true,true,false,false);
                    arrayImageDish[1].setImageResource(R.drawable.hornoficecreamonchocolate);
                }
                else if(arrayFlags[2] && dishes[2].equals(new Icecream(0,false,true,true,false,false))){
                    arrayFlags[2] = false;
                    dishes[2] = new Icecream(2,true,true,true,false,false);
                    arrayImageDish[2].setImageResource(R.drawable.hornoficecreamonchocolate);
                }
                else if(arrayFlags[3] && dishes[3].equals(new Icecream(0,false,true,true,false,false))){
                    arrayFlags[3] = false;
                    dishes[3] = new Icecream(2,true,true,true,false,false);
                    arrayImageDish[3].setImageResource(R.drawable.hornoficecreamonchocolate);
                }
                else if(arrayFlags[0] && dishes[0].equals(new Dough(0,false))){
                    arrayFlags[0] = false;
                    dishes[0] = new Dough(2,true);
                    arrayImageDish[0].setImageResource(R.drawable.doughchocolate);
                }
                else if(arrayFlags[1] && dishes[1].equals(new Dough(0,false))){
                    arrayFlags[1] = false;
                    dishes[1] = new Dough(2,true);
                    arrayImageDish[1].setImageResource(R.drawable.doughchocolate);
                }
                else if(arrayFlags[2] && dishes[2].equals(new Dough(0,false))){
                    arrayFlags[2] = false;
                    dishes[2] = new Dough(2,true);
                    arrayImageDish[2].setImageResource(R.drawable.doughchocolate);
                }
                else if(arrayFlags[3] && dishes[3].equals(new Dough(0,false))){
                    arrayFlags[3] = false;
                    dishes[3] = new Dough(2,true);
                    arrayImageDish[3].setImageResource(R.drawable.doughchocolate);
                }
            }
        });

        /*Работа клубничного красителя*/

        creamStrawberry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arrayFlags[0] && dishes[0].equals(new Icecream(0,false,true,true,false,false))){
                    arrayFlags[0] = false;
                    dishes[0] = new Icecream(3,true,true,true,false,false);
                    arrayImageDish[0].setImageResource(R.drawable.hornoficecreamonstrawberry);
                }
                else if(arrayFlags[1] && dishes[1].equals(new Icecream(0,false,true,true,false,false))){
                    arrayFlags[1] = false;
                    dishes[1] = new Icecream(3,true,true,true,false,false);
                    arrayImageDish[1].setImageResource(R.drawable.hornoficecreamonstrawberry);
                }
                else if(arrayFlags[2] && dishes[2].equals(new Icecream(0,false,true,true,false,false))){
                    arrayFlags[2] = false;
                    dishes[2] = new Icecream(3,true,true,true,false,false);
                    arrayImageDish[2].setImageResource(R.drawable.hornoficecreamonstrawberry);
                }
                else if(arrayFlags[3] && dishes[3].equals(new Icecream(0,false,true,true,false,false))){
                    arrayFlags[3] = false;
                    dishes[3] = new Icecream(3,true,true,true,false,false);
                    arrayImageDish[3].setImageResource(R.drawable.hornoficecreamonstrawberry);
                }
                else if(arrayFlags[0] && dishes[0].equals(new Dough(0,false))){
                    arrayFlags[0] = false;
                    dishes[0] = new Dough(3,true);
                    arrayImageDish[0].setImageResource(R.drawable.doughstrawberry);
                }
                else if(arrayFlags[1] && dishes[1].equals(new Dough(0,false))){
                    arrayFlags[1] = false;
                    dishes[1] = new Dough(3,true);
                    arrayImageDish[1].setImageResource(R.drawable.doughstrawberry);
                }
                else if(arrayFlags[2] && dishes[2].equals(new Dough(0,false))){
                    arrayFlags[2] = false;
                    dishes[2] = new Dough(3,true);
                    arrayImageDish[2].setImageResource(R.drawable.doughstrawberry);
                }
                else if(arrayFlags[3] && dishes[3].equals(new Dough(0,false))){
                    arrayFlags[3] = false;
                    dishes[3] = new Dough(3,true);
                    arrayImageDish[3].setImageResource(R.drawable.doughstrawberry);
                }
            }
        });

        /*Работа автомата для мороженого*/

        automatIcecream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arrayFlags[0] && dishes[0].equals(new Icecream(1,true,true,true,false,false))){
                    arrayFlags[0] = false;
                    arrayFlagsIsEmpty[0] = true;
                    dishes[0] = new Icecream(1,true,true,true,true,true);
                    arrayImageDish[0].setImageResource(R.drawable.nothing);
                    isWorkingAutomatIcecream = true;
                    numberTakeDishForAutomatIcecream = 0;
                } else if(arrayFlags[1] && dishes[1].equals(new Icecream(1,true,true,true,false,false))){
                    arrayFlags[1] = false;
                    arrayFlagsIsEmpty[1] = true;
                    dishes[1] = new Icecream(1,true,true,true,true,true);
                    arrayImageDish[1].setImageResource(R.drawable.nothing);
                    isWorkingAutomatIcecream = true;
                    numberTakeDishForAutomatIcecream = 1;
                } else if(arrayFlags[2] && dishes[2].equals(new Icecream(1,true,true,true,false,false))){
                    arrayFlags[2] = false;
                    arrayFlagsIsEmpty[2] = true;
                    dishes[2] = new Icecream(1,true,true,true,true,true);
                    arrayImageDish[2].setImageResource(R.drawable.nothing);
                    isWorkingAutomatIcecream = true;
                    numberTakeDishForAutomatIcecream = 2;
                } else if(arrayFlags[3] && dishes[3].equals(new Icecream(1,true,true,true,false,false))){
                    arrayFlags[3] = false;
                    arrayFlagsIsEmpty[3] = true;
                    dishes[3] = new Icecream(1,true,true,true,true,true);
                    arrayImageDish[3].setImageResource(R.drawable.nothing);
                    isWorkingAutomatIcecream = true;
                    numberTakeDishForAutomatIcecream = 3;
                } else if(arrayFlags[0] && dishes[0].equals(new Icecream(2,true,true,true,false,false))){
                    arrayFlags[0] = false;
                    arrayFlagsIsEmpty[0] = true;
                    dishes[0] = new Icecream(2,true,true,true,true,true);
                    arrayImageDish[0].setImageResource(R.drawable.nothing);
                    isWorkingAutomatIcecream = true;
                    numberTakeDishForAutomatIcecream = 0;
                } else if(arrayFlags[1] && dishes[1].equals(new Icecream(2,true,true,true,false,false))){
                    arrayFlags[1] = false;
                    arrayFlagsIsEmpty[1] = true;
                    dishes[1] = new Icecream(2,true,true,true,true,true);
                    arrayImageDish[1].setImageResource(R.drawable.nothing);
                    isWorkingAutomatIcecream = true;
                    numberTakeDishForAutomatIcecream = 1;
                } else if(arrayFlags[2] && dishes[2].equals(new Icecream(2,true,true,true,false,false))){
                    arrayFlags[2] = false;
                    arrayFlagsIsEmpty[2] = true;
                    dishes[2] = new Icecream(2,true,true,true,true,true);
                    arrayImageDish[2].setImageResource(R.drawable.nothing);
                    isWorkingAutomatIcecream = true;
                    numberTakeDishForAutomatIcecream = 2;
                } else if(arrayFlags[3] && dishes[3].equals(new Icecream(2,true,true,true,false,false))){
                    arrayFlags[3] = false;
                    arrayFlagsIsEmpty[3] = true;
                    dishes[3] = new Icecream(2,true,true,true,true,true);
                    arrayImageDish[3].setImageResource(R.drawable.nothing);
                    isWorkingAutomatIcecream = true;
                    numberTakeDishForAutomatIcecream = 3;
                } else if(arrayFlags[0] && dishes[0].equals(new Icecream(3,true,true,true,false,false))){
                    arrayFlags[0] = false;
                    arrayFlagsIsEmpty[0] = true;
                    dishes[0] = new Icecream(3,true,true,true,true,true);
                    arrayImageDish[0].setImageResource(R.drawable.nothing);
                    isWorkingAutomatIcecream = true;
                    numberTakeDishForAutomatIcecream = 0;
                } else if(arrayFlags[1] && dishes[1].equals(new Icecream(3,true,true,true,false,false))){
                    arrayFlags[1] = false;
                    arrayFlagsIsEmpty[1] = true;
                    dishes[1] = new Icecream(3,true,true,true,true,true);
                    arrayImageDish[1].setImageResource(R.drawable.nothing);
                    isWorkingAutomatIcecream = true;
                    numberTakeDishForAutomatIcecream = 1;
                } else if(arrayFlags[2] && dishes[2].equals(new Icecream(3,true,true,true,false,false))){
                    arrayFlags[2] = false;
                    arrayFlagsIsEmpty[2] = true;
                    dishes[2] = new Icecream(3,true,true,true,true,true);
                    arrayImageDish[2].setImageResource(R.drawable.nothing);
                    isWorkingAutomatIcecream = true;
                    numberTakeDishForAutomatIcecream = 2;
                } else if(arrayFlags[3] && dishes[3].equals(new Icecream(3,true,true,true,false,false))){
                    arrayFlags[3] = false;
                    arrayFlagsIsEmpty[3] = true;
                    dishes[3] = new Icecream(3,true,true,true,true,true);
                    arrayImageDish[3].setImageResource(R.drawable.nothing);
                    isWorkingAutomatIcecream = true;
                    numberTakeDishForAutomatIcecream = 3;
                }
                if(isWorkingAutomatIcecream){
                    final Timer timer = new Timer();
                    long delay = 1;
                    long period = 3001;
                    timeAutomatIcecream = 0;
                    timer.scheduleAtFixedRate(new TimerTask() {
                        @Override
                        public void run() {
                            timeAutomatIcecream++;
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    automatIcecream.setImageResource(R.drawable.icecreamwithposypkavanille); //ПОМЕНЯТЬ
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            automatIcecream.setImageResource(R.drawable.icecreamwithposypkastrawberry); //ПОМЕНЯТЬ
                                            isWorkingAutomatIcecream = false;
                                            arrayFlagsIsEmpty[numberTakeDishForAutomatIcecream] = false;
                                            if(dishes[numberTakeDishForAutomatIcecream].colour == 1)
                                                arrayImageDish[numberTakeDishForAutomatIcecream].setImageResource(R.drawable.icecreamwithoutposypkavanille);
                                            else if(dishes[numberTakeDishForAutomatIcecream].colour == 2)
                                                arrayImageDish[numberTakeDishForAutomatIcecream].setImageResource(R.drawable.icecreamwithoutposypkachocolate);
                                            else if(dishes[numberTakeDishForAutomatIcecream].colour == 3)
                                                arrayImageDish[numberTakeDishForAutomatIcecream].setImageResource(R.drawable.icecreamwithoutposypkastrawberry);
                                            timer.cancel();
                                        }
                                    });
                                }
                            });
                        }
                    },delay,period);

                }
            }
        });
    }

    void fillArray(boolean[] array,boolean temp){
        for(int i = 0; i < array.length;i++){
            array[i] = temp;
        }
    }

}//2340 1080
