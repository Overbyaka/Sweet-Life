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
    boolean change;

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
            dishes[i] = new Nothing();
        }

        /*Подсветка для первой тарелки*/

        arrayImageDish[0].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (!arrayFlagsIsEmpty[0]) {
                    dishes[0].setImage(arrayImageDish[0],arrayFlags[0]);
                    change = false;
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
                    dishes[1].setImage(arrayImageDish[1],arrayFlags[1]);
                    change = false;
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
                    dishes[2].setImage(arrayImageDish[2],arrayFlags[2]);
                    change = false;
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
                    dishes[3].setImage(arrayImageDish[3],arrayFlags[3]);
                    change = false;
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
                                    arrayImageDish[i].setImageResource(R.drawable.cakewithfruitvanille); //Исправить на пироженое в рожке
                                case 2:
                                    arrayImageDish[i].setImageResource(R.drawable.cakewithfruitchocolate); //Исправить на пироженое в рожке
                                case 3:
                                    arrayImageDish[i].setImageResource(R.drawable.cakewithfruitstrawberry); //Исправить на пироженое в рожке
                            }
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
                            }
                        } else if(dishes[i] instanceof Dough){
                            if(!((Dough)dishes[i]).isColour){
                                ((Dough)dishes[i]).paint(1,arrayImageDish[i]);
                                arrayFlags[i] = false;
                            }
                        } else if(dishes[i] instanceof Donut){
                            if(!((Donut)dishes[i]).isColour){
                                ((Donut)dishes[i]).paint(1,arrayImageDish[i]);
                                arrayFlags[i] = false;
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
                            }
                        } else if(dishes[i] instanceof Dough){
                            if(!((Dough)dishes[i]).isColour){
                                ((Dough)dishes[i]).paint(2,arrayImageDish[i]);
                                arrayFlags[i] = false;
                            }
                        } else if(dishes[i] instanceof Donut){
                            if(!((Donut)dishes[i]).isColour){
                                ((Donut)dishes[i]).paint(2,arrayImageDish[i]);
                                arrayFlags[i] = false;
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
                            }
                        } else if(dishes[i] instanceof Dough){
                            if(!((Dough)dishes[i]).isColour){
                                ((Dough)dishes[i]).paint(3,arrayImageDish[i]);
                                arrayFlags[i] = false;
                            }
                        } else if(dishes[i] instanceof Donut){
                            if(!((Donut)dishes[i]).isColour){
                                ((Donut)dishes[i]).paint(3,arrayImageDish[i]);
                                arrayFlags[i] = false;
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
                for(int i = 0; i < countDishes; i++){
                    if(arrayFlags[i] && dishes[i] instanceof Icecream){
                        if(((Icecream)dishes[i]).isColour && !((Icecream)dishes[i]).isAutomat){
                            arrayFlags[i] = false;
                            numberTakeDishForAutomatIcecream = i;
                            isWorkingAutomatIcecream = true;
                            arrayFlagsIsEmpty[i] = true;
                            ((Icecream)dishes[i]).setAutomat(true,arrayImageDish[i]);
                        }
                    }
                }
                /*if(isWorkingAutomatIcecream){
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

                }*/
            }
        });
    }

    void fillArray(boolean[] array,boolean temp){
        for(int i = 0; i < array.length;i++){
            array[i] = temp;
        }
    }
}//2340 1080
