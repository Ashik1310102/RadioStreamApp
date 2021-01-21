package com.example.ashik.bpc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import layout.HomeFragment;
import layout.UserFragment;

/**
 * Created by Ashik on 9/28/2017.
 */

//user tab work

public class User extends Fragment {
    Button btADDUSER,btUSERLIST,auSubmit;
    RelativeLayout rlTL,rlAT;
    GridView gvFUserList;
    EditText auULI,auUN,auSTP;
    String auULIValu,auUNValu,auSTPValu,auALValu;
    RadioGroup auAL;
    RadioButton Dragan;

    ProgressBar progressBarUser;
    private boolean userFormChakeV;

    UserAdapter userAdapter;

    ListView listView;


    private void userFormChake(){

        //add user form data error
        if (auULI.getText().length()<=0){
            auULI.setError("Place Enter Some Value...");
            userFormChakeV=false;
        }
        if(auUN.getText().length()<=0){
            auUN.setError("Place Enter Some Value...");
            userFormChakeV=false;
        }
        if (auSTP.getText().length()<=0){
            auSTP.setError("Place Enter Some Value...");
            userFormChakeV=false;
        }

    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_user, container, false);

        //getActivity();

        progressBarUser= (ProgressBar) rootView.findViewById(R.id.progressBarUser);

        auAL= (RadioGroup) rootView.findViewById(R.id.auAL);
        Dragan= (RadioButton) rootView.findViewById(R.id.Dragan);

        btADDUSER = (Button) rootView.findViewById(R.id.btADDUSER);
        btUSERLIST = (Button) rootView.findViewById(R.id.btUSERLIST);
        auSubmit = (Button) rootView.findViewById(R.id.auSubmit);

        rlAT = (RelativeLayout) rootView.findViewById(R.id.rlTL);
        rlTL = (RelativeLayout) rootView.findViewById(R.id.rlSTL);

        auULI= (EditText) rootView.findViewById(R.id.auULI);
        auUN= (EditText) rootView.findViewById(R.id.auUN);
        auSTP= (EditText) rootView.findViewById(R.id.auSTP);






        auAL.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                int checked;

                checked = auAL.indexOfChild(rootView.findViewById(checkedId));
                //radio button data receive

                switch (checked) {
                    case 0:
                        auALValu= "Dragon";
                        break;
                    case 1:
                        auALValu= "Senior Management";
                        break;
                    case 2:
                        auALValu= "Production Incharge";
                        break;
                }
            }
        });

        btADDUSER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rlTL.setVisibility(View.GONE);
                rlAT.setVisibility(View.VISIBLE);
                auALValu= "Dragon";
                Dragan.setChecked(true);
            }
        });


        auSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userFormChakeV=true;
                userFormChake();

                if (userFormChakeV==true){

                    auULIValu = auULI.getText().toString();
                    auUNValu= auUN.getText().toString();
                    auSTPValu  = auSTP.getText().toString();

                    //db uplode
                    rquInDataBase();



                }
            }
        });





        btUSERLIST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listView = (ListView) rootView.findViewById(R.id.gvFUserList);
                rlAT.setVisibility(View.GONE);
                rlTL.setVisibility(View.VISIBLE);

                userlistData();
            }
        });


        return rootView;
    }

    private void rquInDataBase(){

        progressBarUser.setVisibility(View.VISIBLE);

        String url = "http://www.rrmtrustfoundation.com/userAdd.php";

        final RequestQueue requestQueue = Volley.newRequestQueue(getContext());

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String mass = jsonObject.getString("mass");
                    if(mass.equals("OK")){
                        progressBarUser.setVisibility(View.GONE);
                        Toast.makeText(getContext(),"user added successfully",Toast.LENGTH_LONG).show();
                    }
                    else {
                        progressBarUser.setVisibility(View.GONE);
                        Toast.makeText(getContext(),"Sorry",Toast.LENGTH_LONG).show();
                    }

                } catch (JSONException e) {
                    progressBarUser.setVisibility(View.GONE);
                    Toast.makeText(getContext(),"please check your internet connection",Toast.LENGTH_LONG).show();
                }
                auULI.setText("");
                auUN.setText("");
                auSTP.setText("");
                rlAT.setVisibility(View.GONE);
                requestQueue.stop();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBarUser.setVisibility(View.GONE);
                Toast.makeText(getContext(),"please check your internet connection",Toast.LENGTH_LONG).show();
                requestQueue.stop();

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("user_id", auULIValu);
                params.put("name", auUNValu);
                params.put("password", auSTPValu);
                params.put("accessLevel", auALValu);
                return params;
            }
        };
        AppController.getInstance(getContext()).addToRequestQueue(stringRequest);



    }

    private void userlistData(){
        String url = "http://www.rrmtrustfoundation.com/userList.php";
        progressBarUser.setVisibility(View.VISIBLE);

        //user list data from db
        final RequestQueue requestQueue = Volley.newRequestQueue(getContext());

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Toast.makeText(getContext(),response,Toast.LENGTH_LONG).show();
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    int si= jsonArray.length();

                    userAdapter = new UserAdapter(getContext(),R.layout.userlist);

                    for(int aaa=0;aaa<si;aaa++) {

                        String UserIda= jsonArray.getJSONObject(aaa).getString("userid");
                        String UserNamea= jsonArray.getJSONObject(aaa).getString("username");
                        String Useraccessa= jsonArray.getJSONObject(aaa).getString("access");

                        userList userlist = new userList(getContext(),UserIda,UserNamea,Useraccessa);

                        userAdapter.add(userlist);
                        userAdapter.notifyDataSetChanged();
                    }
                    progressBarUser.setVisibility(View.GONE);
                } catch (JSONException e) {
                    progressBarUser.setVisibility(View.GONE);
                    Toast.makeText(getContext(),"please check your internet connection",Toast.LENGTH_LONG).show();
                }
                listView.setAdapter(userAdapter);

                requestQueue.stop();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBarUser.setVisibility(View.GONE);
                Toast.makeText(getContext(),"please check your internet connection",Toast.LENGTH_LONG).show();
                requestQueue.stop();

            }
        });
        AppController.getInstance(getContext()).addToRequestQueue(stringRequest);

    }


}
