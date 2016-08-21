package com.speedsumm.bu.btnclick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener{
    ScaleAnimation sAnim;
    int step = 2;
    ArrayList<Integer> arrayList;

    Button btn1, btn2,btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        arrayList = new ArrayList<>();


        sAnim = new ScaleAnimation(0f,1f,0f,1f,0.5f,0.5f);
        sAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.d("....","Закончена анимация");

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        sAnim.setDuration(500);



    }


    public void OnClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                btn1.startAnimation(sAnim);
                break;
            case R.id.btn2:
                btn2.startAnimation(sAnim);
                break;
            case R.id.btn3:
                btn3.startAnimation(sAnim);
                break;

        }
    }

    public void startGame(View view) {
        for (int i = 1;i<=step;i++){
            Random r = new Random();
            int cur = r.nextInt(4-1)+1;
            Log.d("...","Случайное число "+cur);
            switch (cur){
                case 1:
                    this.btn1.callOnClick();
                    break;
                case 2:
                    this.btn2.callOnClick();
                    break;
                case 3:
                    this.btn3.callOnClick();
                    break;
            }
            arrayList.add(cur);

        }
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        Log.d("....","Закончена анимация");

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
