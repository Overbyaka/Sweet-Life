package com.example.sweet_life;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOError;
import java.io.IOException;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private final int countGuests = 4;//Количество гостей
    private final int countDishes = 4;//Количество блюд
    private boolean[] arrayFlags = new boolean[countDishes];//Проверка на блюда, подсвечены ли они
    private Dish[] dishes = new Dish[countDishes];//Блюда
    private boolean[] arrayFlagsIsEmpty = new boolean[countDishes]; //Проверка на блюда, в машине ли блюда или нет
    private boolean[] change = new boolean[countDishes];
    private int numberTakeDishForAutomatIcecream, numberTakeDishForFurnace, numberTakeDishForPlate;
    private boolean isWorkingAutomatIcecream = false, isWorkingFurnace = false, isWorkingPlate = false;
    private boolean[] isQuest = new boolean[countGuests];
    private int[] numberWishes = new int[countGuests];
    private int score = 0;

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
        fillArray(isQuest,false);

        final TextView textScore = (TextView)findViewById(R.id.textScore);
        final ImageButton automatIcecream = (ImageButton)findViewById(R.id.imageAutomatIcecream);
        final ImageButton furnace = (ImageButton)findViewById(R.id.imageFurnace);
        ImageButton creamChocolate = (ImageButton)findViewById(R.id.imageCreamChocolate);
        ImageButton creamStrawberry = (ImageButton)findViewById(R.id.imageCreamStrawberry);
        ImageButton creamVanille = (ImageButton)findViewById(R.id.imageCreamVanille);
        ImageButton fruitSrawberry = (ImageButton)findViewById(R.id.imageFruitStrawberry);
        ImageButton fruitNut = (ImageButton)findViewById(R.id.imageFruitNut);
        ImageButton fruitBanana = (ImageButton)findViewById(R.id.imageFruitBanana);
        final ImageButton plate = (ImageButton)findViewById(R.id.imagePlate);
        ImageButton dough = (ImageButton)findViewById(R.id.imageDough);
        ImageButton ice = (ImageButton)findViewById(R.id.imageIce);
        ImageButton hornIcecream = (ImageButton)findViewById(R.id.imageHornIcecream) ;
        ImageButton hornCake = (ImageButton) findViewById(R.id.imageHornCake);
        ImageButton posypka = (ImageButton)findViewById(R.id.imagePosypka);
        ImageButton garbage = (ImageButton)findViewById(R.id.imageGarbage);

        final ImageButton[] arrayImageGuests = new ImageButton[countGuests];
        final ImageButton[] arrayImageDish = new ImageButton[countDishes];
        final ImageView[] arrayImageWishes = new ImageView[countGuests];


        arrayImageGuests[0] = (ImageButton)findViewById(R.id.imageGuest1);
        arrayImageGuests[1] = (ImageButton)findViewById(R.id.imageGuest2);
        arrayImageGuests[2] = (ImageButton)findViewById(R.id.imageGuest3);
        arrayImageGuests[3] = (ImageButton)findViewById(R.id.imageGuest4);

        arrayImageDish[0] = (ImageButton)findViewById(R.id.imageDish1);
        arrayImageDish[1] = (ImageButton)findViewById(R.id.imageDish2);
        arrayImageDish[2] = (ImageButton)findViewById(R.id.imageDish3);
        arrayImageDish[3] = (ImageButton)findViewById(R.id.imageDish4);

        arrayImageWishes[0] = (ImageView)findViewById((R.id.imageWish1));
        arrayImageWishes[1] = (ImageView)findViewById((R.id.imageWish2));
        arrayImageWishes[2] = (ImageView)findViewById((R.id.imageWish3));
        arrayImageWishes[3] = (ImageView)findViewById((R.id.imageWish4));

        for(int i = 0; i < countDishes;i++){
            dishes[i] = new Nothing();
        }

        /*Генерация гостей с желанием*/

        final Handler quests = new Handler();
        Runnable runnableQuests = new Runnable() {
            public void run() {
                for(int i = 0; i < countGuests;i++){
                    if(!isQuest[i]){
                        isQuest[i] = true;
                        arrayImageGuests[i].setImageResource(R.drawable.guest);
                        numberWishes[i] = (int)(Math.random()*12);
                        switch (numberWishes[i]){
                            case 0:
                                arrayImageWishes[i].setImageResource(R.drawable.want0);
                                break;
                            case 1:
                                arrayImageWishes[i].setImageResource(R.drawable.want1);
                                break;
                            case 2:
                                arrayImageWishes[i].setImageResource(R.drawable.want2);
                                break;
                            case 3:
                                arrayImageWishes[i].setImageResource(R.drawable.want3);
                                break;
                            case 4:
                                arrayImageWishes[i].setImageResource(R.drawable.want4);
                                break;
                            case 5:
                                arrayImageWishes[i].setImageResource(R.drawable.want5);
                                break;
                            case 6:
                                arrayImageWishes[i].setImageResource(R.drawable.want6);
                                break;
                            case 7:
                                arrayImageWishes[i].setImageResource(R.drawable.want7);
                                break;
                            case 8:
                                arrayImageWishes[i].setImageResource(R.drawable.want8);
                                break;
                            case 9:
                                arrayImageWishes[i].setImageResource(R.drawable.want9);
                                break;
                            case 10:
                                arrayImageWishes[i].setImageResource(R.drawable.want10);
                                break;
                            case 11:
                                arrayImageWishes[i].setImageResource(R.drawable.want11);
                                break;
                        }
                        break;
                    }
                }
                quests.postDelayed(this, 13000);
            }
        };
quests.post(runnableQuests);


        /*Подсветка для первой тарелки*/

        arrayImageDish[0].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (!arrayFlagsIsEmpty[0]) {
                    dishes[0].setImage(arrayImageDish[0],arrayFlags[0]);
                    change[0] = false;
                    if (arrayFlags[0]) {
                        arrayFlags[0] = !arrayFlags[0];
                        change[0] = true;
                    }
                    if (arrayFlags[3])
                        arrayImageDish[3].callOnClick();
                    if (arrayFlags[1])
                        arrayImageDish[1].callOnClick();
                    if (arrayFlags[2])
                        arrayImageDish[2].callOnClick();
                    if (!change[0])
                        arrayFlags[0] = !arrayFlags[0];
                }
            }
            });

        /*Подсветка для второй тарелки*/

        arrayImageDish[1].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (!arrayFlagsIsEmpty[1]) {
                    dishes[1].setImage(arrayImageDish[1],arrayFlags[1]);
                    change[1] = false;
                    if (arrayFlags[1]) {
                        arrayFlags[1] = !arrayFlags[1];
                        change[1] = true;
                    }
                    if (arrayFlags[0])
                        arrayImageDish[0].callOnClick();
                    if (arrayFlags[3])
                        arrayImageDish[3].callOnClick();
                    if (arrayFlags[2])
                        arrayImageDish[2].callOnClick();
                    if (!change[1])
                        arrayFlags[1] = !arrayFlags[1];
                }
            }
        });

        /*Подсветка для третьей тарелки*/

        arrayImageDish[2].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (!arrayFlagsIsEmpty[2]) {
                    dishes[2].setImage(arrayImageDish[2],arrayFlags[2]);
                    change[2] = false;
                    if (arrayFlags[2]) {
                        arrayFlags[2] = !arrayFlags[2];
                        change[2] = true;
                    }
                    if (arrayFlags[0])
                        arrayImageDish[0].callOnClick();
                    if (arrayFlags[1])
                        arrayImageDish[1].callOnClick();
                    if (arrayFlags[3])
                        arrayImageDish[3].callOnClick();
                    if (!change[2])
                        arrayFlags[2] = !arrayFlags[2];
                }
            }
        });

        /*Подсветка для четвертой тарелки*/

        arrayImageDish[3].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (!arrayFlagsIsEmpty[3]) {
                    dishes[3].setImage(arrayImageDish[3],arrayFlags[3]);
                    change[3] = false;
                    if (arrayFlags[3]) {
                        arrayFlags[3] = !arrayFlags[3];
                        change[3] = true;
                    }
                    if (arrayFlags[0])
                        arrayImageDish[0].callOnClick();
                    if (arrayFlags[1])
                        arrayImageDish[1].callOnClick();
                    if (arrayFlags[2])
                        arrayImageDish[2].callOnClick();
                    if (!change[3])
                        arrayFlags[3] = !arrayFlags[3];
                }
            }
        });

        /*Работа холодильника (тесто)*/

        dough.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i < countDishes;i++){
                    if(arrayFlags[i] && dishes[i] instanceof Nothing){
                        arrayFlags[i] = false;
                        dishes[i] = new Dough(0,false);
                        arrayImageDish[i].setImageResource(R.drawable.dough);
                        break;
                    }
                }
            }
        });

        /*Работа льда*/

        ice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i < countDishes;i++){
                    if(arrayFlags[i] && dishes[i] instanceof Icecream){
                        if(!((Icecream)dishes[i]).isIce){
                            ((Icecream)dishes[i]).setIce(true,arrayImageDish[i]);
                            arrayFlags[i] = false;
                            break;
                        }
                    }
                }
            }
        });

        /*Работа рожка для мороженого*/

        hornIcecream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i < countDishes; i++){
                    if(arrayFlags[i] && dishes[i] instanceof Nothing){
                        arrayFlags[i] = false;
                        dishes[i] = new Icecream(0,false,false,false,false);
                        arrayImageDish[i].setImageResource(R.drawable.hornoficecream);
                        break;
                    }
                }
            }
        });

        /*Работа рожка для пироженого*/

        hornCake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i < countDishes; i++){
                    if(arrayFlags[i] && dishes[i] instanceof Dough){
                        if(dishes[i].isColour){
                            arrayFlags[i] = false;
                            dishes[i] = new Cake(((Dough)dishes[i]).colour,true,false,false);
                            switch (((Cake)dishes[i]).colour){
                                case 1:
                                    arrayImageDish[i].setImageResource(R.drawable.cakeinhornvanille);
                                case 2:
                                    arrayImageDish[i].setImageResource(R.drawable.cakeinhornchocolate);
                                case 3:
                                    arrayImageDish[i].setImageResource(R.drawable.cakeinhornstrawberry);
                            }
                            break;
                        }
                    }
                }
            }
        });

        /*Работа ванильного красителя*/

        creamVanille.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i < countDishes; i++){
                    if(arrayFlags[i]){
                        if(dishes[i] instanceof Icecream){
                            if(((Icecream)dishes[i]).isIce && !((Icecream)dishes[i]).isColour){
                                ((Icecream)dishes[i]).paint(1,arrayImageDish[i]);
                                arrayFlags[i] = false;
                                break;
                            }
                        } else if(dishes[i] instanceof Dough){
                            if(!((Dough)dishes[i]).isColour){
                                ((Dough)dishes[i]).paint(1,arrayImageDish[i]);
                                arrayFlags[i] = false;
                                break;
                            }
                        } else if(dishes[i] instanceof Donut){
                            if(!((Donut)dishes[i]).isColour){
                                ((Donut)dishes[i]).paint(1,arrayImageDish[i]);
                                arrayFlags[i] = false;
                                break;
                            }
                        }
                    }
                }
            }
        });

        /*Работа шоколадного красителя*/

        creamChocolate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i < countDishes; i++){
                    if(arrayFlags[i]){
                        if(dishes[i] instanceof Icecream){
                            if(((Icecream)dishes[i]).isIce && !((Icecream)dishes[i]).isColour){
                                ((Icecream)dishes[i]).paint(2,arrayImageDish[i]);
                                arrayFlags[i] = false;
                                break;
                            }
                        } else if(dishes[i] instanceof Dough){
                            if(!((Dough)dishes[i]).isColour){
                                ((Dough)dishes[i]).paint(2,arrayImageDish[i]);
                                arrayFlags[i] = false;
                                break;
                            }
                        } else if(dishes[i] instanceof Donut){
                            if(!((Donut)dishes[i]).isColour){
                                ((Donut)dishes[i]).paint(2,arrayImageDish[i]);
                                arrayFlags[i] = false;
                                break;
                            }
                        }
                    }
                }
            }
        });

        /*Работа клубничного красителя*/

        creamStrawberry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i < countDishes; i++){
                    if(arrayFlags[i]){
                        if(dishes[i] instanceof Icecream){
                            if(((Icecream)dishes[i]).isIce && !((Icecream)dishes[i]).isColour){
                                ((Icecream)dishes[i]).paint(3,arrayImageDish[i]);
                                arrayFlags[i] = false;
                                break;
                            }
                        } else if(dishes[i] instanceof Dough){
                            if(!((Dough)dishes[i]).isColour){
                                ((Dough)dishes[i]).paint(3,arrayImageDish[i]);
                                arrayFlags[i] = false;
                                break;
                            }
                        } else if(dishes[i] instanceof Donut){
                            if(!((Donut)dishes[i]).isColour){
                                ((Donut)dishes[i]).paint(3,arrayImageDish[i]);
                                arrayFlags[i] = false;
                                break;
                            }
                        }
                    }
                }
            }
        });

        /*Работа автомата для мороженого*/

        automatIcecream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isWorkingAutomatIcecream) {
                    for (int i = 0; i < countDishes; i++) {
                        if (arrayFlags[i] && dishes[i] instanceof Icecream) {
                            if (((Icecream) dishes[i]).isColour && !((Icecream) dishes[i]).isAutomat) {
                                arrayFlags[i] = false;
                                arrayFlagsIsEmpty[i] = true;
                                isWorkingAutomatIcecream = true;
                                ((Icecream) dishes[i]).setAutomat(true, arrayImageDish[i]);
                                automatIcecream.setImageResource(R.drawable.automateicecreamon);
                                numberTakeDishForAutomatIcecream = i;
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        arrayFlagsIsEmpty[numberTakeDishForAutomatIcecream] = false;
                                        automatIcecream.setImageResource(R.drawable.automaticrecream);
                                        isWorkingAutomatIcecream = false;
                                        switch (((Icecream) dishes[numberTakeDishForAutomatIcecream]).colour) {
                                            case 1:
                                                arrayImageDish[numberTakeDishForAutomatIcecream].setImageResource(R.drawable.icecreamwithoutposypkavanille);
                                                break;
                                            case 2:
                                                arrayImageDish[numberTakeDishForAutomatIcecream].setImageResource(R.drawable.icecreamwithoutposypkachocolate);
                                                break;
                                            case 3:
                                                arrayImageDish[numberTakeDishForAutomatIcecream].setImageResource(R.drawable.icecreamwithoutposypkastrawberry);
                                                break;
                                        }
                                    }
                                }, 5000);
                                break;
                            }
                        }
                    }
                }
            }
        });

        /*Работа печи*/

        furnace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isWorkingFurnace) {
                    for (int i = 0; i < countDishes; i++) {
                        if (arrayFlags[i]) {
                            if (dishes[i] instanceof Cake) {
                                if (!((Cake) dishes[i]).isFurnace) {
                                    arrayFlags[i] = false;
                                    arrayFlagsIsEmpty[i] = true;
                                    isWorkingFurnace = true;
                                    ((Cake) dishes[i]).setFurnace(true, arrayImageDish[i]);
                                    furnace.setImageResource(R.drawable.furnaceon);
                                    numberTakeDishForFurnace = i;
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            arrayFlagsIsEmpty[numberTakeDishForFurnace] = false;
                                            isWorkingFurnace = false;
                                            furnace.setImageResource(R.drawable.furnace);
                                            switch (((Cake) dishes[numberTakeDishForFurnace]).colour) {
                                                case 1:
                                                    arrayImageDish[numberTakeDishForFurnace].setImageResource(R.drawable.cakewithoutfruitvanille);
                                                    break;
                                                case 2:
                                                    arrayImageDish[numberTakeDishForFurnace].setImageResource(R.drawable.cakewithoutfruitchocolate);
                                                    break;
                                                case 3:
                                                    arrayImageDish[numberTakeDishForFurnace].setImageResource(R.drawable.cakewithoutfruitstrawberry);
                                                    break;
                                            }
                                        }
                                    }, 5000);
                                    break;
                                }
                            } else if (dishes[i] instanceof Dough) {
                                if (((Dough) dishes[i]).isColour) {
                                    arrayFlags[i] = false;
                                    arrayFlagsIsEmpty[i] = true;
                                    isWorkingFurnace = true;
                                    dishes[i] = new Croissant(((Dough) dishes[i]).colour, true);
                                    furnace.setImageResource(R.drawable.furnaceon);
                                    numberTakeDishForFurnace = i;
                                    arrayImageDish[i].setImageResource(R.drawable.nothing);
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            arrayFlagsIsEmpty[numberTakeDishForFurnace] = false;
                                            isWorkingFurnace = false;
                                            furnace.setImageResource(R.drawable.furnace);
                                            switch (((Croissant) dishes[numberTakeDishForFurnace]).colour) {
                                                case 1:
                                                    arrayImageDish[numberTakeDishForFurnace].setImageResource(R.drawable.croissantvanille);
                                                    break;
                                                case 2:
                                                    arrayImageDish[numberTakeDishForFurnace].setImageResource(R.drawable.croissantchocolate);
                                                    break;
                                                case 3:
                                                    arrayImageDish[numberTakeDishForFurnace].setImageResource(R.drawable.croissantstrawberry);
                                                    break;
                                            }
                                        }
                                    }, 5000);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        });

        /* Работа плтиы*/

        plate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isWorkingPlate) {
                    for (int i = 0; i < countDishes; i++) {
                        if (arrayFlags[i] && dishes[i] instanceof Dough) {
                            if (!((Dough) dishes[i]).isColour) {
                                arrayFlags[i] = false;
                                arrayFlagsIsEmpty[i] = true;
                                isWorkingPlate = true;
                                dishes[i] = new Donut(0,false,false);
                                plate.setImageResource(R.drawable.plateon);
                                numberTakeDishForPlate = i;
                                arrayImageDish[i].setImageResource(R.drawable.nothing);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        arrayFlagsIsEmpty[numberTakeDishForPlate] = false;
                                        plate.setImageResource(R.drawable.plate);
                                        isWorkingPlate = false;
                                        arrayImageDish[numberTakeDishForPlate].setImageResource(R.drawable.donutstandart);
                                    }
                                }, 5000);
                                break;
                            }
                        }
                    }
                }
            }
        });

        /*Работа клубники*/

        fruitSrawberry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i < countDishes;i++){
                    if(arrayFlags[i] && dishes[i] instanceof Cake){
                        if(!((Cake)dishes[i]).isFruit && ((Cake)dishes[i]).isFurnace && ((Cake)dishes[i]).colour == 2){
                            arrayFlags[i] = false;
                            ((Cake)dishes[i]).setFruit(true,arrayImageDish[i]);
                            break;
                        }
                    }
                }
            }
        });

        /*Работа банана*/
        fruitBanana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i < countDishes;i++){
                    if(arrayFlags[i] && dishes[i] instanceof Cake){
                        if(!((Cake)dishes[i]).isFruit && ((Cake)dishes[i]).isFurnace && ((Cake)dishes[i]).colour == 3){
                            arrayFlags[i] = false;
                            ((Cake)dishes[i]).setFruit(true,arrayImageDish[i]);
                            break;
                        }
                    }
                }
            }
        });

        /*Работа ореха*/

        fruitNut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i < countDishes;i++){
                    if(arrayFlags[i] && dishes[i] instanceof Cake){
                        if(!((Cake)dishes[i]).isFruit && ((Cake)dishes[i]).isFurnace && ((Cake)dishes[i]).colour == 1){
                            arrayFlags[i] = false;
                            ((Cake)dishes[i]).setFruit(true,arrayImageDish[i]);
                            break;
                        }
                    }
                }
            }
        });

        /*Работа посыпки*/

        posypka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i < countDishes;i++){
                    if(arrayFlags[i]){
                        if(dishes[i] instanceof Donut){
                            if(!((Donut)dishes[i]).isPosypka && ((Donut)dishes[i]).isColour){
                                ((Donut)dishes[i]).setPosypka(true,arrayImageDish[i]);
                                arrayFlags[i] = false;
                                break;
                            }
                        } else if(dishes[i] instanceof Icecream){
                            if(((Icecream)dishes[i]).isAutomat && !((Icecream)dishes[i]).isPosypka){
                                ((Icecream)dishes[i]).setPosypka(true,arrayImageDish[i]);
                                arrayFlags[i] = false;
                                break;
                            }
                        }
                    }
                }
            }
        });

        /*Работа урны*/

        garbage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i < countDishes;i++){
                    if(arrayFlags[i]){
                        arrayFlags[i] = false;
                        dishes[i] = new Nothing();
                        arrayImageDish[i].setImageResource(R.drawable.dish);
                        break;
                    }
                }
            }
        });

        arrayImageGuests[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isQuest[0]){
                    for(int i = 0; i < countDishes; i++){
                        if(arrayFlags[i]){
                            completeQuest(textScore, arrayImageGuests[0],arrayImageWishes[0],arrayImageDish[i],0,i);
                        }
                    }
                }
            }
        });

        arrayImageGuests[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isQuest[1]){
                    for(int i = 0; i < countDishes; i++){
                        if(arrayFlags[i]){
                            completeQuest(textScore, arrayImageGuests[1],arrayImageWishes[1],arrayImageDish[i],1,i);
                        }
                    }
                }
            }
        });

        arrayImageGuests[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isQuest[2]){
                    for(int i = 0; i < countDishes; i++){
                        if(arrayFlags[i]){
                            completeQuest(textScore, arrayImageGuests[2],arrayImageWishes[2],arrayImageDish[i],2,i);
                        }
                    }
                }
            }
        });

        arrayImageGuests[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isQuest[3]){
                    for(int i = 0; i < countDishes; i++){
                        if(arrayFlags[i]){
                            completeQuest(textScore, arrayImageGuests[3],arrayImageWishes[3],arrayImageDish[i],3,i);
                        }
                    }
                }
            }
        });
    }
    void fillArray(boolean[] array,boolean temp){
        for(int i = 0; i < array.length;i++){
            array[i] = temp;
        }
    }
    void completeQuest(TextView text, ImageButton imageGuest,ImageView imageWish, ImageButton imageDish, int number, int i){
        switch (numberWishes[number]){
            case 0:
                if(dishes[i] instanceof Icecream){
                    if(((Icecream)dishes[i]).isPosypka &&(((Icecream)dishes[i]).colour == 3)){
                        score +=40;
                        imageGuest.setImageResource(R.drawable.nothing);
                        imageWish.setImageResource(R.drawable.nothing);
                        imageDish.setImageResource(R.drawable.dish);
                        arrayFlags[i] = false;
                        isQuest[number] = false;
                        dishes[i] = new Nothing();
                        text.setText("Score " + score);

                    }
                }
                break;
            case 1:
                if(dishes[i] instanceof Icecream){
                    if(((Icecream)dishes[i]).isPosypka &&(((Icecream)dishes[i]).colour == 2)){
                        score +=40;
                        imageGuest.setImageResource(R.drawable.nothing);
                        imageWish.setImageResource(R.drawable.nothing);
                        imageDish.setImageResource(R.drawable.dish);
                        arrayFlags[i] = false;
                        isQuest[number] = false;
                        dishes[i] = new Nothing();
                        text.setText("Score " + score);
                    }
                }
                break;
            case 2:
                if(dishes[i] instanceof Icecream){
                    if(((Icecream)dishes[i]).isPosypka &&(((Icecream)dishes[i]).colour == 1)){
                        score +=40;
                        imageGuest.setImageResource(R.drawable.nothing);
                        imageWish.setImageResource(R.drawable.nothing);
                        imageDish.setImageResource(R.drawable.dish);
                        arrayFlags[i] = false;
                        isQuest[number] = false;
                        dishes[i] = new Nothing();
                        text.setText("Score " + score);
                    }
                }
                break;
            case 3:
                if(dishes[i] instanceof Cake){
                    if(((Cake)dishes[i]).isFruit &&(((Cake)dishes[i]).colour == 3)){
                        score +=50;
                        imageGuest.setImageResource(R.drawable.nothing);
                        imageWish.setImageResource(R.drawable.nothing);
                        imageDish.setImageResource(R.drawable.dish);
                        arrayFlags[i] = false;
                        isQuest[number] = false;
                        dishes[i] = new Nothing();
                        text.setText("Score " + score);
                    }
                }
                break;
            case 4:
                if(dishes[i] instanceof Cake){
                    if(((Cake)dishes[i]).isFruit &&(((Cake)dishes[i]).colour == 1)){
                        score +=50;
                        imageGuest.setImageResource(R.drawable.nothing);
                        imageWish.setImageResource(R.drawable.nothing);
                        imageDish.setImageResource(R.drawable.dish);
                        arrayFlags[i] = false;
                        isQuest[number] = false;
                        dishes[i] = new Nothing();
                        text.setText("Score " + score);
                    }
                }
                break;
            case 5:
                if(dishes[i] instanceof Cake){
                    if(((Cake)dishes[i]).isFruit &&(((Cake)dishes[i]).colour == 2)){
                        score +=50;
                        imageGuest.setImageResource(R.drawable.nothing);
                        imageWish.setImageResource(R.drawable.nothing);
                        imageDish.setImageResource(R.drawable.dish);
                        arrayFlags[i] = false;
                        isQuest[number] = false;
                        dishes[i] = new Nothing();
                        text.setText("Score " + score);
                    }
                }
                break;
            case 6:
                if(dishes[i] instanceof Croissant){
                    if(((Croissant)dishes[i]).colour == 3){
                        score +=20;
                        imageGuest.setImageResource(R.drawable.nothing);
                        imageWish.setImageResource(R.drawable.nothing);
                        imageDish.setImageResource(R.drawable.dish);
                        arrayFlags[i] = false;
                        isQuest[number] = false;
                        dishes[i] = new Nothing();
                        text.setText("Score " + score);
                    }
                }
                break;
            case 7:
                if(dishes[i] instanceof Croissant){
                    if(((Croissant)dishes[i]).colour == 2){
                        score +=20;
                        imageGuest.setImageResource(R.drawable.nothing);
                        imageWish.setImageResource(R.drawable.nothing);
                        imageDish.setImageResource(R.drawable.dish);
                        arrayFlags[i] = false;
                        isQuest[number] = false;
                        dishes[i] = new Nothing();
                        text.setText("Score " + score);
                    }
                }
                break;
            case 8:
                if(dishes[i] instanceof Croissant){
                    if(((Croissant)dishes[i]).colour == 1){
                        score +=20;
                        imageGuest.setImageResource(R.drawable.nothing);
                        imageWish.setImageResource(R.drawable.nothing);
                        imageDish.setImageResource(R.drawable.dish);
                        arrayFlags[i] = false;
                        isQuest[number] = false;
                        dishes[i] = new Nothing();
                        text.setText("Score " + score);
                    }
                }
                break;
            case 9:
                if(dishes[i] instanceof Donut){
                    if(((Donut)dishes[i]).colour == 1 && ((Donut)dishes[i]).isPosypka){
                        score +=30;
                        imageGuest.setImageResource(R.drawable.nothing);
                        imageWish.setImageResource(R.drawable.nothing);
                        imageDish.setImageResource(R.drawable.dish);
                        arrayFlags[i] = false;
                        isQuest[number] = false;
                        dishes[i] = new Nothing();
                        text.setText("Score " + score);
                    }
                }
                break;
            case 10:
                if(dishes[i] instanceof Donut){
                    if(((Donut)dishes[i]).colour == 2 && ((Donut)dishes[i]).isPosypka){
                        score +=30;
                        imageGuest.setImageResource(R.drawable.nothing);
                        imageWish.setImageResource(R.drawable.nothing);
                        imageDish.setImageResource(R.drawable.dish);
                        arrayFlags[i] = false;
                        isQuest[number] = false;
                        dishes[i] = new Nothing();
                        text.setText("Score " + score);
                    }
                }
                break;
            case 11:
                if(dishes[i] instanceof Donut){
                    if(((Donut)dishes[i]).colour == 3 && ((Donut)dishes[i]).isPosypka){
                        score +=30;
                        imageGuest.setImageResource(R.drawable.nothing);
                        imageWish.setImageResource(R.drawable.nothing);
                        imageDish.setImageResource(R.drawable.dish);
                        arrayFlags[i] = false;
                        isQuest[number] = false;
                        dishes[i] = new Nothing();
                        text.setText("Score " + score);
                    }
                }
                break;
        }
        if(score>=1000){
            text.setText("You already won. STOP!");
        }
    }
}//2340 1080
