package com.example.ashik.bpc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Ashik on 10/2/2017.
 */
// user list set & get class
public class userList  {
    private Context context;

    private String userId;
    private String NameA;
    private String AccessLevelA;

    public void setContext(Context context) {
        this.context = context;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setNameA(String NameA) {
        this.NameA = NameA;
    }
    public void setAccessLevelA(String AccessLevelA) {
        this.AccessLevelA = AccessLevelA;
    }

    public String getUserId() {
        return userId;
    }

    public String getNameA() {
        return NameA;
    }

    public String getAccessLevelA() {
        return AccessLevelA;
    }

    public userList(Context context, String userId, String name, String accessLevel){

        this.context= context;
        this.userId = userId;
        this.NameA = name;
        this.AccessLevelA = accessLevel;
    }




}
