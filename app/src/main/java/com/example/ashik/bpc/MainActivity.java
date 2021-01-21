package com.example.ashik.bpc;


import android.content.Context;
import android.content.Intent;

import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button btLogin;
    EditText email,password;
    String emailValu,passwordValu;
    Intent i;
    ProgressBar progressBar;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btLogin = (Button) findViewById(R.id.btLogin);
        progressBar= (ProgressBar) findViewById(R.id.progressBar);


        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email= (EditText) findViewById(R.id.etEmail);
                password= (EditText) findViewById(R.id.etPassword);
                emailValu= email.getText().toString();
                passwordValu= password.getText().toString();
                SharedPreferences sharedPreferences = getApplication().getSharedPreferences(String.valueOf(R.string.fcmPre), Context.MODE_PRIVATE);
                token= sharedPreferences.getString(String.valueOf(R.string.fcmKey),"");

                // call rquInDataBase method for connect to db and verify user id and password
                rquInDataBase();

            }
        });
    }
    boolean abc;
    public void onBackPressed() {

        //onBackPressed button work
        if (abc ==true){
            Intent i = new Intent(Intent.ACTION_MAIN);
            i.addCategory(Intent.CATEGORY_HOME);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
            finish();
            System.exit(0);
        }
        Toast toast= new Toast(getApplicationContext());
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toastlayout,(ViewGroup) findViewById(R.id.myToast));
        toast.setView(layout);
        toast.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                abc = false;
            }
        },1000);
        abc =true;


    }

    private void rquInDataBase(){

        String url = "http://www.rrmtrustfoundation.com/login.php";
        progressBar.setVisibility(View.VISIBLE);

        final RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    JSONObject jsonObject = new JSONObject(response);
                    String mass = jsonObject.getString("mass");
                    if(mass.equals("ok")){

                        // received data from db api and set in sharedPreferences

                        String id = jsonObject.getString("id");
                        String username = jsonObject.getString("username");
                        String access = jsonObject.getString("access");

                        LogerInfo logerInfo = new LogerInfo(MainActivity.this);

                        logerInfo.setEmail(emailValu);
                        logerInfo.setName(username);
                        logerInfo.setaccessLevel(access);
                        logerInfo.setId(id);
                        i = new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(i);
                        //Toast.makeText(MainActivity.this,response,Toast.LENGTH_LONG).show();
                    }
                    else {

                        Toast.makeText(MainActivity.this,mass,Toast.LENGTH_LONG).show();
                    }
                    progressBar.setVisibility(View.INVISIBLE);
                    email.setText("");
                    password.setText("");


                } catch (JSONException e) {
                    progressBar.setVisibility(View.INVISIBLE);
                    email.setText("");
                    password.setText("");
                    e.printStackTrace();
                }

                requestQueue.stop();


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.INVISIBLE);
                email.setText("");
                password.setText("");
                Toast.makeText(MainActivity.this,String.valueOf("Sorry"),Toast.LENGTH_LONG).show();
                requestQueue.stop();

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                // post data to db api
                params.put("user_id", emailValu);
                params.put("password", passwordValu);
                params.put("fcmKey", token);
                return params;
            }
        };
        AppController.getInstance(MainActivity.this).addToRequestQueue(stringRequest);
        //requestQueue.add(stringRequest);


    }
}
