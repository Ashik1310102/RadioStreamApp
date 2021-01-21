package com.example.ashik.bpc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        LogerInfo logerInfo = new LogerInfo(Splash.this);
        //in line no 15 to 18 if any user all ready login than than go to main2activity

        if(logerInfo.getEmail()!=""){
            Intent i = new Intent(Splash.this,Main2Activity.class);
            startActivity(i);
        }

        //if no one login in this app than go to mainactivity which is login page
        else {
            Intent i = new Intent(Splash.this,MainActivity.class);
            startActivity(i);
        }
    }
}
