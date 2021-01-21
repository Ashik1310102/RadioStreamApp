package com.example.ashik.bpc;


import android.app.Application;
import android.content.Context;



import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Ashik on 10/28/2017.
 */

public class AppController {

    // AppController class for volley push Request in RequestQueue


    private RequestQueue mRequestQueue;

    private static Context context;

    private static AppController mInstance;



    public AppController(Context context){
        this.context= context;
        mRequestQueue= getRequestQueue();

    }

    public static synchronized AppController getInstance(Context context) {
        if(mInstance==null){
            mInstance= new AppController(context);
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }

        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {

        getRequestQueue().add(req);
    }


}