package com.example.ashik.bpc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

/**
 * Created by Ashik on 10/2/2017.
 */

public class
LogerInfo {
    Context context;
    SharedPreferences sharedPreferences;
    private String email;
    private String name;
    private String id;
    private String accessLevel;

    public String getFcmToken() {
        return fcmToken;
    }

    public void setFcmToken(String fcmToken) {
        this.fcmToken = fcmToken;
    }

    private String fcmToken;

    //sharedPreferences class for data set and get



    public String getaccessLevel() {
        accessLevel= sharedPreferences.getString("LogeraccessLevel","");
        return accessLevel;
    }

    public void setaccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
        sharedPreferences.edit().putString("LogeraccessLevel",this.accessLevel).commit();
    }

    public String getId() {
        id= sharedPreferences.getString("LogerId","");
        return id;
    }

    public void setId(String id) {
        this.id = id;
        sharedPreferences.edit().putString("LogerId",this.id).commit();
    }
    public String getName() {
        name= sharedPreferences.getString("LogerName","");
        return name;
    }
    public void setName(String name) {
        this.name = name;
        sharedPreferences.edit().putString("LogerName",this.name).commit();
    }

    public String getEmail() {
        email= sharedPreferences.getString("LogerEmail","");
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        sharedPreferences.edit().putString("LogerEmail",this.email).commit();
    }

    public void remove(){
        sharedPreferences.edit().clear().commit();

    }

    public LogerInfo(Context context){
        this.context= context;
        sharedPreferences = context.getSharedPreferences("LogerInfo",context.MODE_PRIVATE);

    }
}
