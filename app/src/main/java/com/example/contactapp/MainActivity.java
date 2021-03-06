package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    private  static  int SPLASH_SCREEN =5000; //means 5seconds
    //variables
    Animation topAnim, bottomAnim;
    ImageView imgLogo, imgText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //we hold the animation that we created
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
       //hooks
        imgLogo = findViewById(R.id.imglogo);
        imgText = findViewById(R.id.imgtext);

        imgLogo.setAnimation(topAnim);
        imgText.setAnimation(bottomAnim);


        //we create a splash screen
        //handler is going to handle our delay process
       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               //we call the other activity
               Intent intent = new Intent(MainActivity.this,login.class);
               startActivity(intent);
               finish();
           }
       },SPLASH_SCREEN);



    }
}