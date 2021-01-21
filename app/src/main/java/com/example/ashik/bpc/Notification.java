package com.example.ashik.bpc;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;



/**
 * Created by Ashik on 11/29/2017.
 */
// Notification calss for receive notification

public class Notification  extends FirebaseInstanceIdService {
    private String token;
    @Override
    public void onTokenRefresh() {
        token= FirebaseInstanceId.getInstance().getToken();
        SharedPreferences sharedPreferences = getApplication().getSharedPreferences(String.valueOf(R.string.fcmPre), Context.MODE_PRIVATE);
        SharedPreferences.Editor edit =sharedPreferences.edit();
        edit.putString(String.valueOf(R.string.fcmKey),token);
        edit.commit();

    }


}
