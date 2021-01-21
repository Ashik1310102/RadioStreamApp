package com.example.ashik.bpc;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.IdRes;
import android.support.annotation.RequiresApi;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static android.text.format.DateFormat.format;

/**
 * Created by Ashik on 9/28/2017.
 */
//target tab woks
public class Target extends Fragment {
    Button AT,TL,targetSubmit;
    RelativeLayout rlTL,rlAT;
    TextView targetmonth,targetYear;
    EditText targetTon,targetUnit;
    String targetmonthValu,targetYearValu,targetTonValu,targetUnitValu,monthID,date;
    boolean chakinfo;
    ProgressBar progressBarTarget;

    private DatePickerDialog.OnDateSetListener mDateSetListener;

    TargetAdapter targetAdapter;

    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_target, container, false);
        AT = (Button) rootView.findViewById(R.id.bt1);
        TL = (Button) rootView.findViewById(R.id.bt2);
        targetSubmit = (Button) rootView.findViewById(R.id.targetSubmit);
        rlAT = (RelativeLayout) rootView.findViewById(R.id.rlTL);
        rlTL = (RelativeLayout) rootView.findViewById(R.id.rlSTL);

        targetmonth= (TextView) rootView.findViewById(R.id.targetmonth);
        targetYear= (TextView) rootView.findViewById(R.id.targetYear);

        targetTon= (EditText) rootView.findViewById(R.id.targetTon);
        targetUnit= (EditText) rootView.findViewById(R.id.targetUnit);

        progressBarTarget= (ProgressBar) rootView.findViewById(R.id.progressBarTarget);


        AT.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                rlTL.setVisibility(View.GONE);
                rlAT.setVisibility(View.VISIBLE);

                date=(String)android.text.format.DateFormat.format("yyyy-MM-dd", new Date());
//

                String monthname=(String)android.text.format.DateFormat.format("MMMM", new Date());
                targetmonth.setText(monthname);
                targetmonthValu= String.valueOf(monthname);
//
                Date date= new Date();
//                Calendar cal = Calendar.getInstance();
//                cal.setTime(date);
                String month = (String)android.text.format.DateFormat.format("MM", new Date());
                monthID=month;
//
                String year=(String)android.text.format.DateFormat.format("yyyy", new Date());
                targetYearValu = year;
                targetYear.setText(year);
            }
        });

        TL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rlAT.setVisibility(View.GONE);
                rlTL.setVisibility(View.VISIBLE);
                listView= (ListView) rootView.findViewById(R.id.listViewTarget);
                TargetlistData();
            }
        });

        targetSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chakinfo = true;
                targetmonthValu = targetmonth.getText().toString();
                targetYearValu = targetYear.getText().toString();
                targetTonValu = targetTon.getText().toString();
                targetUnitValu = targetUnit.getText().toString();

                chakeData();

                if (chakinfo==true){
                    rquInDataBase();
                    targetTon.setText("");
                    targetUnit.setText("");
                    rlAT.setVisibility(View.GONE);
                }
                else {
                    targetTon.setText("");
                    targetUnit.setText("");
                    Toast.makeText(getContext(),"Place input Properly..",Toast.LENGTH_LONG).show();
                }


                //Toast.makeText(getContext(),targetmonthValu+"\n"+targetYearValu+"\n"+targetTonValu+"\n"+targetUnitValu +"\n"+monthID+"\n"+date,Toast.LENGTH_LONG).show();
            }
        });

        targetmonth.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                int year= Integer.parseInt((String) format("yyyy", new Date()));
                int month= Integer.parseInt((String) format("MM", new Date()));
                int day= Integer.parseInt((String) format("dd", new Date()));
                final java.util.Calendar calendar = java.util.Calendar.getInstance();
                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),android.R.style.Theme_Holo_Dialog_MinWidth,
                        mDateSetListener, year,month,day);
                datePickerDialog.getDatePicker().setMinDate(calendar.getTimeInMillis());
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        mDateSetListener= new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                targetYearValu = String.valueOf(year);
                targetYear.setText(String.valueOf(year));
                monthID= String.valueOf(month+1);
                switch (month){
                    case 0:
                        targetmonth.setText("January");
                        targetmonthValu= "January";
                        break;
                    case 1:
                        targetmonth.setText("February");
                        targetmonthValu= "February";
                        break;
                    case 2:
                        targetmonth.setText("March");
                        targetmonthValu= "March";
                        break;
                    case 3:
                        targetmonth.setText(" April");
                        targetmonthValu= " April";
                        break;
                    case 4:
                        targetmonth.setText("May");
                        targetmonthValu= "May";
                        break;
                    case 5:
                        targetmonth.setText("June");
                        targetmonthValu= "June";
                        break;
                    case 6:
                        targetmonth.setText("July");
                        targetmonthValu= "July";
                        break;
                    case 7:
                        targetmonth.setText("August");
                        targetmonthValu= "August";
                        break;
                    case 8:
                        targetmonth.setText("September");
                        targetmonthValu= "September";
                        break;
                    case 9:
                        targetmonth.setText("October");
                        targetmonthValu= "October";
                        break;
                    case 10:
                        targetmonth.setText(" November");
                        targetmonthValu= " November";
                        break;
                    case 11:
                        targetmonth.setText("December");
                        targetmonthValu= "December";
                        break;
                }
                //targetmonth.setText(String.valueOf(month));
                //targetmonthValu= String.valueOf(month);

            }
        };


        return rootView;
    }

    private void chakeData(){
        if(targetTonValu.equals("")){
            targetTon.setError("Place input Some Value..");
            chakinfo= false;
        }
        if (targetUnitValu.equals("")){
            targetUnit.setError("Place input Some Value..");
            chakinfo= false;
        }

    }
// data input in db for target add
    private void rquInDataBase(){

        progressBarTarget.setVisibility(View.VISIBLE);

        String url = "http://www.rrmtrustfoundation.com/targetAdd.php";

        final RequestQueue requestQueue = Volley.newRequestQueue(getContext());

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String mass = jsonObject.getString("mass");
                    if(mass.equals("OK")){
                        progressBarTarget.setVisibility(View.GONE);
                        Toast.makeText(getContext(),"Target added successfully",Toast.LENGTH_LONG).show();
                    }
                    else {
                        progressBarTarget.setVisibility(View.GONE);
                        Toast.makeText(getContext(),"Sorry",Toast.LENGTH_LONG).show();
                    }


                } catch (JSONException e) {
                    progressBarTarget.setVisibility(View.GONE);
                    Toast.makeText(getContext(),"Problem in your internet connection",Toast.LENGTH_LONG).show();
                }

                requestQueue.stop();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBarTarget.setVisibility(View.GONE);
                Toast.makeText(getContext(),"please check your internet connection",Toast.LENGTH_LONG).show();
                requestQueue.stop();

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();

                LogerInfo logerInfo =new LogerInfo(getContext());

                params.put("month",targetmonthValu );
                params.put("year", targetYearValu);
                params.put("TargetTon", targetTonValu);
                params.put("TargetUnit", targetUnitValu);
                params.put("date", date);
                params.put("monthId", monthID);
                params.put("name", logerInfo.getName());
                params.put("id", logerInfo.getId());
                return params;
            }
        };
        AppController.getInstance(getContext()).addToRequestQueue(stringRequest);



    }

    //list data from db
    private void TargetlistData(){

        progressBarTarget.setVisibility(View.VISIBLE);
        String url = "http://www.rrmtrustfoundation.com/targetList.php";

        final RequestQueue requestQueue = Volley.newRequestQueue(getContext());

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Toast.makeText(getContext(),response,Toast.LENGTH_LONG).show();
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    int si= jsonArray.length();

                    targetAdapter = new TargetAdapter(getContext(),R.layout.turgerlist);



                    for(int aaa=0;aaa<si;aaa++) {

                        String target_month= jsonArray.getJSONObject(aaa).getString("target_month");
                               target_month= target_month+" "+jsonArray.getJSONObject(aaa).getString("year");
                        String target_unit= jsonArray.getJSONObject(aaa).getString("target_unit");
                        String target= jsonArray.getJSONObject(aaa).getString("target");

                        TargetList targetList = new TargetList(getContext(),target_month,target_unit,target);

                        targetAdapter.add(targetList);
                        targetAdapter.notifyDataSetChanged();
                    }


                } catch (JSONException e) {
                    Toast.makeText(getContext(),"Problem in your internet connection",Toast.LENGTH_LONG).show();
                }
                progressBarTarget.setVisibility(View.GONE);
                listView.setAdapter(targetAdapter);
                requestQueue.stop();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBarTarget.setVisibility(View.GONE);
                Toast.makeText(getContext(),"please check your internet connection",Toast.LENGTH_LONG).show();
                requestQueue.stop();

            }
        });
        AppController.getInstance(getContext()).addToRequestQueue(stringRequest);

    }


}
