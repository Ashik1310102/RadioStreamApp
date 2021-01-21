package com.example.ashik.bpc;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;

import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.NumberPicker;
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

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static android.text.format.DateFormat.*;


/**
 * Created by Ashik on 9/28/2017.
 */

public class Report extends android.support.v4.app.Fragment {

    //report tab works



    TextView btRMDtDF,btRMDtDT;


    private DatePickerDialog.OnDateSetListener mDateSetListenerR,mDateSetListenerRD;

    Button btTPP,btRP,btMW,btTPT;

    RelativeLayout reportTable;
    LinearLayout RRinREPORT,LLRM,piker;
    FloatingActionButton listButton;

    ProgressBar progressBarReport;


    String urlList,urltab,AsDate,pikertype;
    String YearValu="2017";
    String monthValu="January";
    String monthId="0";
    String form,To;

    NumberPicker dpF;

    ImageButton set,ibRMDS;


    TextView MPTQ,MFTV,MATV,MPTV,TPODFTV,TPODATV,TPODPTV,PDAPFTV,PDAPATV,PDAPPTV,TMPDUFTV,TMPDUATV,TMPDUPTV,PTPDFTV,PTPDATV,PTPDPTV,TTTTDFTV,TTTTDATV,TTTTDPTV,PDAHNFTV,PDAHNATV,PDAHNPTV;

    int hours,min,monthMaxDays,dateC;

    int dakKiKori=0;


    String monthnameF;
    ReportAdapter reportAdapter;
    ListView listView;
    int dateFRM=1;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_report, container, false);

        RRinREPORT= (LinearLayout) rootView.findViewById(R.id.RRinREPORT);
        LLRM= (LinearLayout) rootView.findViewById(R.id.LLRM);
        piker= (LinearLayout) rootView.findViewById(R.id.piker);
        reportTable= (RelativeLayout) rootView.findViewById(R.id.reportTable);

        progressBarReport = (ProgressBar) rootView.findViewById(R.id.progressBarReport);

        MPTQ = (TextView) rootView.findViewById(R.id.MPTQ);
        MFTV = (TextView) rootView.findViewById(R.id.MFTV);
        MATV = (TextView) rootView.findViewById(R.id.MATV);
        MPTV = (TextView) rootView.findViewById(R.id.MPTV);

        TPODFTV = (TextView) rootView.findViewById(R.id.TPODFTV);
        TPODATV = (TextView) rootView.findViewById(R.id.TPODATV);
        TPODPTV = (TextView) rootView.findViewById(R.id.TPODPTV);

        PDAPFTV = (TextView) rootView.findViewById(R.id.PDAPFTV);
        PDAPATV = (TextView) rootView.findViewById(R.id.PDAPATV);
        PDAPPTV = (TextView) rootView.findViewById(R.id.PDAPPTV);

        TMPDUFTV = (TextView) rootView.findViewById(R.id.TMPDUFTV);
        TMPDUATV = (TextView) rootView.findViewById(R.id.TMPDUATV);
        TMPDUPTV = (TextView) rootView.findViewById(R.id.TMPDUPTV);

        PTPDFTV = (TextView) rootView.findViewById(R.id.PTPDFTV);
        PTPDATV = (TextView) rootView.findViewById(R.id.PTPDATV);
        PTPDPTV = (TextView) rootView.findViewById(R.id.PTPDPTV);

        TTTTDFTV = (TextView) rootView.findViewById(R.id.TTTTDFTV);
        TTTTDATV = (TextView) rootView.findViewById(R.id.TTTTDATV);
        TTTTDPTV = (TextView) rootView.findViewById(R.id.TTTTDPTV);

        PDAHNFTV = (TextView) rootView.findViewById(R.id.PDAHNFTV);
        PDAHNATV = (TextView) rootView.findViewById(R.id.PDAHNATV);
        PDAHNPTV = (TextView) rootView.findViewById(R.id.PDAHNPTV);


        btRMDtDF = (TextView) rootView.findViewById(R.id.btRMDtDF);
        btRMDtDT = (TextView) rootView.findViewById(R.id.btDtdT);

        btMW= (Button) rootView.findViewById(R.id.btMW);
        btRP= (Button) rootView.findViewById(R.id.btRP);
        btTPP= (Button) rootView.findViewById(R.id.btTPP);
        btTPT= (Button) rootView.findViewById(R.id.btTPT);
        listButton= (FloatingActionButton) rootView.findViewById(R.id.fab);

        listView= (ListView) rootView.findViewById(R.id.reportListView);


        dpF= (NumberPicker) rootView.findViewById(R.id.dpF);
        set= (ImageButton) rootView.findViewById(R.id.set);
        ibRMDS= (ImageButton) rootView.findViewById(R.id.ibRMDS);



        //tabData();




        hours = new Time(System.currentTimeMillis()).getHours();
        min = new Time(System.currentTimeMillis()).getMinutes();
        //dateC = new Time(System.currentTimeMillis()).getMinutes();

        Calendar c = Calendar.getInstance();
        monthMaxDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);

        AsDate= (String) format("dd", new Date());
        dateC=Integer.parseInt(AsDate);
        monthnameF =(String) format("yyyy-MM-dd", new Date());

        monthId = String.valueOf(c.get(Calendar.MONTH)+1);
        YearValu= String.valueOf(c.get(Calendar.YEAR));




        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dakKiKori%2==0){

                    reportTable.setVisibility(View.INVISIBLE);
                    RRinREPORT.setVisibility(View.VISIBLE);
                    listButton.setImageResource(R.drawable.ic_border_all_black_24dp);
                    dakKiKori++;
                }
                else {
                    RRinREPORT.setVisibility(View.INVISIBLE);
                    reportTable.setVisibility(View.VISIBLE);
                    listButton.setImageResource(R.drawable.ic_format_align_justify_black_24dp);
                    dakKiKori--;
                }

            }
        });

        btTPT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                piker.setVisibility(View.INVISIBLE);
                LLRM.setVisibility(View.INVISIBLE);
                listView.setAdapter(null);
                dakKiKori=0;
                Calendar c = Calendar.getInstance();
                monthId = String.valueOf(c.get(Calendar.MONTH)+1);
                YearValu= String.valueOf(c.get(Calendar.YEAR));


                listButton.setImageResource(R.drawable.ic_format_align_justify_black_24dp);
                listButton.setVisibility(View.VISIBLE);
                reportTable.setVisibility(View.VISIBLE);
                RRinREPORT.setVisibility(View.INVISIBLE);
                MPTQ.setText("Today's production\ntarget Qty");
                urlList="http://www.rrmtrustfoundation.com/tDayList.php";
                urltab="http://www.rrmtrustfoundation.com/monthReport.php";
                tabData();
                TdaylistData();

            }
        });


        btMW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                piker.setVisibility(View.INVISIBLE);
                LLRM.setVisibility(View.INVISIBLE);
                ////////////////

                final int yearM= Integer.parseInt((String) format("yyyy", new Date()));
                final int monthM= Integer.parseInt((String) format("MM", new Date()));
                int dayM= Integer.parseInt((String) format("dd", new Date()));
                final Calendar calendar = Calendar.getInstance();
                ///////////////////
                // date picker works

                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), AlertDialog.THEME_HOLO_DARK,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                YearValu = String.valueOf(year);
                                monthId= String.valueOf(monthOfYear+1);
                                tabData();
                                TdaylistData();

                            }
                        }, yearM, monthM-1, dayM);
                ((ViewGroup) datePickerDialog.getDatePicker()).findViewById(Resources.getSystem().getIdentifier("day", "id", "android")).setVisibility(View.GONE);
                datePickerDialog.getDatePicker().setMaxDate(new Date().getTime());
                datePickerDialog.show();

                //list view adapter clean
                listView.setAdapter(null);

                listButton.setVisibility(View.VISIBLE);
                reportTable.setVisibility(View.VISIBLE);
                RRinREPORT.setVisibility(View.INVISIBLE);
                dakKiKori=0;
                listButton.setImageResource(R.drawable.ic_format_align_justify_black_24dp);
                urlList= "http://www.rrmtrustfoundation.com/monthList.php";
                urltab="http://www.rrmtrustfoundation.com/monthReport.php";


            }
        });

        ibRMDS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                form = btRMDtDF.getText().toString();
                To = btRMDtDT.getText().toString();
                LLRM.setVisibility(View.INVISIBLE);
                listView.setAdapter(null);

                listButton.setVisibility(View.VISIBLE);
                reportTable.setVisibility(View.VISIBLE);
//                RRinREPORT.setVisibility(View.INVISIBLE);

                monthId=form;
                YearValu=To;
                urlList= "http://www.rrmtrustfoundation.com/daytodaylist.php";
                urltab="http://www.rrmtrustfoundation.com/daytodaytab.php";
                TdaylistData();
                tabData();

            }
        });

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int year = Integer.parseInt((String) format("yyyy", new Date()));
                int month= Integer.parseInt((String) format("MM", new Date()));
                if(pikertype=="F"){
                    dateFRM=dpF.getValue();
                    String dateV= String.valueOf(year)+"-"+String.valueOf(month)+"-"+String.valueOf(dateFRM);
                    btRMDtDF.setText(dateV);
                    piker.setVisibility(View.INVISIBLE);
                }
                else if(pikertype=="T") {
                    int date=dpF.getValue();

                    String dateV= String.valueOf(year)+"-"+String.valueOf(month)+"-"+String.valueOf(date);
                    btRMDtDT.setText(dateV);
                    piker.setVisibility(View.INVISIBLE);

                }


            }
        });

        btRMDtDT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pikertype="T";
                dateFRM=1;
                piker.setVisibility(View.INVISIBLE);
                final int yearM= Integer.parseInt((String) format("yyyy", new Date()));
                final int monthM= Integer.parseInt((String) format("MM", new Date()));
                int dayM= Integer.parseInt((String) format("dd", new Date()));
                final Calendar calendar = Calendar.getInstance();
                ///////////////////

                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), AlertDialog.THEME_HOLO_DARK,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                btRMDtDT.setText(String.valueOf(year)+"-"+String.valueOf(monthOfYear+1)+"-"+String.valueOf(dayOfMonth));

                            }
                        }, yearM, monthM-1, dayM);
                ((ViewGroup) datePickerDialog.getDatePicker()).findViewById(Resources.getSystem().getIdentifier("year", "id", "android")).setVisibility(View.GONE);
                ((ViewGroup) datePickerDialog.getDatePicker()).findViewById(Resources.getSystem().getIdentifier("month", "id", "android")).setVisibility(View.GONE);
                datePickerDialog.getDatePicker().setMaxDate(new Date().getTime());
                datePickerDialog.show();

                int lastdayT = Integer.parseInt((String) format("dd", new Date()));
                dpF.setMaxValue(lastdayT);
                dpF.setMinValue(dateFRM);
                ibRMDS.setVisibility(View.VISIBLE);

            }
        });

        btRMDtDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pikertype="F";
                dpF.clearFocus();
                final int yearM= Integer.parseInt((String) format("yyyy", new Date()));
                final int monthM= Integer.parseInt((String) format("MM", new Date()));
                int dayM= Integer.parseInt((String) format("dd", new Date()));
                final Calendar calendar = Calendar.getInstance();
                ///////////////////
                //date picker work

                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), AlertDialog.THEME_HOLO_DARK,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                btRMDtDF.setText(String.valueOf(year)+"-"+String.valueOf(monthOfYear+1)+"-"+String.valueOf(dayOfMonth));

                            }
                        }, yearM, monthM-1, dayM);
                ((ViewGroup) datePickerDialog.getDatePicker()).findViewById(Resources.getSystem().getIdentifier("year", "id", "android")).setVisibility(View.GONE);
                ((ViewGroup) datePickerDialog.getDatePicker()).findViewById(Resources.getSystem().getIdentifier("month", "id", "android")).setVisibility(View.GONE);
                datePickerDialog.getDatePicker().setMaxDate(new Date().getTime());
//                datePickerDialog.getDatePicker().setMinDate(new Date().);
                datePickerDialog.show();
                piker.setVisibility(View.INVISIBLE);

                dpF.setMinValue(dateFRM);
                int lastdayF= Integer.parseInt((String) format("dd", new Date()));
                dpF.setMaxValue(lastdayF);

            }
        });



        btRP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btRMDtDF.setText("");
                btRMDtDT.setText("");
                dateFRM=1;
                piker.setVisibility(View.INVISIBLE);
                LLRM.setVisibility(View.VISIBLE);
                listView.setAdapter(null);
                listButton.setVisibility(View.INVISIBLE);
                reportTable.setVisibility(View.INVISIBLE);
                RRinREPORT.setVisibility(View.INVISIBLE);
                dakKiKori=0;
                listButton.setImageResource(R.drawable.ic_format_align_justify_black_24dp);
//                urlList= "http://www.rrmtrustfoundation.com/monthList.php";
//                urltab="http://www.rrmtrustfoundation.com/monthReport.php";
                //TdaylistData();

            }
        });


      /*  mDateSetListenerR= new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                YearValu = String.valueOf(year);
                monthId= String.valueOf(month+1);
                switch (month){
                    case 0:
                        monthValu= "January";
                        break;
                    case 1:
                        monthValu= "February";
                        break;
                    case 2:
                        monthValu= "March";
                        break;
                    case 3:
                        monthValu= " April";
                        break;
                    case 4:
                        monthValu= "May";
                        break;
                    case 5:
                        monthValu= "June";
                        break;
                    case 6:
                        monthValu= "July";
                        break;
                    case 7:
                        monthValu= "August";
                        break;
                    case 8:
                        monthValu= "September";
                        break;
                    case 9:
                        monthValu= "October";
                        break;
                    case 10:
                        monthValu= " November";
                        break;
                    case 11:
                        monthValu= "December";
                        break;
                }
                // Toast.makeText(getContext(),monthValu+" "+ YearValu,Toast.LENGTH_LONG).show();
                MPTQ.setText(monthValu+ " month\nproduction target Qty");

                tabData();
                TdaylistData();


            }

        };*/





        btTPP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listView.setAdapter(null);
                dakKiKori=0;
                piker.setVisibility(View.INVISIBLE);
                LLRM.setVisibility(View.INVISIBLE);
                Calendar c = Calendar.getInstance();
                monthId = String.valueOf(c.get(Calendar.MONTH)+1);
                YearValu= String.valueOf(c.get(Calendar.YEAR));
                monthnameF =(String) format("yyyy-MM-dd", new Date());

                listButton.setImageResource(R.drawable.ic_format_align_justify_black_24dp);
                listButton.setVisibility(View.VISIBLE);
                reportTable.setVisibility(View.VISIBLE);
                RRinREPORT.setVisibility(View.INVISIBLE);
                MPTQ.setText("Today's production\ntarget Qty");
                urlList="http://www.rrmtrustfoundation.com/tDayList.php";
                ToDayTab();
                TdaylistData();

            }
        });



        return rootView;
    }




    // table info
    private void tabData(){

        progressBarReport.setVisibility(View.VISIBLE);
        final RequestQueue requestQueue = Volley.newRequestQueue(getContext());

        StringRequest stringRequest = new StringRequest(Request.Method.POST, urltab, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String mass = jsonObject.getString("mass");
                    if(mass.equals("OK")){
                        MFTV.setText(jsonObject.getString("FTfM")+"\nTON");
                        MATV.setText(jsonObject.getString("ATfM")+"\nTON");
                        MPTV.setText(jsonObject.getString("PTfM")+"\nTON");

                        TPODFTV.setText(jsonObject.getString("FTfTPD")+"\nDays");
                        TPODATV.setText(jsonObject.getString("ATfTPD")+"\nDays");
                        TPODPTV.setText(jsonObject.getString("PTfTPD")+"\nDays");

                        PDAPFTV.setText(jsonObject.getString("FTfPDAP")+"\nTON");
                        PDAPATV.setText(jsonObject.getString("ATfPDAP")+"\nTON");
                        PDAPPTV.setText(jsonObject.getString("PTfPDAP")+"\nTON");

                        TMPDUFTV.setText(jsonObject.getString("FTfTMPPDU")+"\nUnit\n");
                        TMPDUATV.setText(jsonObject.getString("ATfTMPPDU")+"\nUnit\n");
                        TMPDUPTV.setText(jsonObject.getString("PTfTMPPDU")+"\nUnit\n");

                        PTPDFTV.setText(jsonObject.getString("FTfPTPD")+"\nUnit");
                        PTPDATV.setText(jsonObject.getString("ATfPTPD")+"\nUnit");
                        PTPDPTV.setText(jsonObject.getString("PTfPTPD")+"\nUnit");

                        TTTTDFTV.setText(jsonObject.getString("FTfTtTTD")+"\nMin");
                        TTTTDATV.setText(jsonObject.getString("ATfTtTTD")+"\nMin");
                        TTTTDPTV.setText(jsonObject.getString("PTfTtTTD")+"\nMin");

                        PDAHNFTV.setText(jsonObject.getString("FTfPDAHN")+"\nHEATS");
                        PDAHNATV.setText(jsonObject.getString("ATfPDAHN")+"\nHEATS");
                        PDAHNPTV.setText(jsonObject.getString("PTfPDAHN")+"\nHEATS");

                    }
                    progressBarReport.setVisibility(View.INVISIBLE);
                } catch (JSONException e) {
                    progressBarReport.setVisibility(View.INVISIBLE);
                    Toast.makeText(getContext(),"Problem in your internet connection",Toast.LENGTH_LONG).show();
                }

                requestQueue.stop();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBarReport.setVisibility(View.INVISIBLE);
                Toast.makeText(getContext(),"please check your internet connection",Toast.LENGTH_LONG).show();
                requestQueue.stop();

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();


                params.put("month",monthId );
                params.put("year", YearValu);

                return params;
            }
        };
        AppController.getInstance(getContext()).addToRequestQueue(stringRequest);
        //requestQueue.add(stringRequest);


    }

    //list data
    private void TdaylistData(){

        progressBarReport.setVisibility(View.VISIBLE);
        final RequestQueue requestQueue = Volley.newRequestQueue(getContext());

        StringRequest stringRequest = new StringRequest(Request.Method.POST, urlList, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Toast.makeText(getContext(),response,Toast.LENGTH_LONG).show();
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    int si= jsonArray.length();



                    reportAdapter = new ReportAdapter(getContext(),R.layout.todayreport);

                    for(int aaa=0;aaa<si;aaa++) {

                        String dateka= jsonArray.getJSONObject(aaa).getString("date");
                        String shift= jsonArray.getJSONObject(aaa).getString("shift");
                        String UserName= jsonArray.getJSONObject(aaa).getString("u_name");
                        String rcpn= jsonArray.getJSONObject(aaa).getString("rcpn");
                        String rcn= jsonArray.getJSONObject(aaa).getString("rcn");

                        String rclln= jsonArray.getJSONObject(aaa).getString("rclln");
                        String rhn= jsonArray.getJSONObject(aaa).getString("rhn");
                        String hmt= jsonArray.getJSONObject(aaa).getString("hmt");
                        String fst= jsonArray.getJSONObject(aaa).getString("fst");

                        String fht= jsonArray.getJSONObject(aaa).getString("fht");
                        String fhk= jsonArray.getJSONObject(aaa).getString("fhk");
                        String tttt= jsonArray.getJSONObject(aaa).getString("tttt");
                        String pupttth= jsonArray.getJSONObject(aaa).getString("pupttth");
                        String tufth= jsonArray.getJSONObject(aaa).getString("tufth");
                        String pupt= jsonArray.getJSONObject(aaa).getString("pupt");
                        String ccpt= jsonArray.getJSONObject(aaa).getString("ccpt");

                        String bllai= jsonArray.getJSONObject(aaa).getString("bllai");
                        String bllap= jsonArray.getJSONObject(aaa).getString("bllap");
                        String bllbi= jsonArray.getJSONObject(aaa).getString("bllbi");
                        String bllbp= jsonArray.getJSONObject(aaa).getString("bllbp");
                        String bsli= jsonArray.getJSONObject(aaa).getString("bsli");
                        String bslp= jsonArray.getJSONObject(aaa).getString("bslp");
                        String remark= jsonArray.getJSONObject(aaa).getString("remarks");

                        String time= jsonArray.getJSONObject(aaa).getString("time");
                        String rhpq= jsonArray.getJSONObject(aaa).getString("rhpq");

                        String[] listdatatest ={dateka,shift,UserName,rcpn,rcn,rclln,rhn,hmt,fst,fht,fhk,tttt,pupttth,tufth,pupt,ccpt,bllai,bllap,bllbi,bllbp,bsli,bslp,remark,time,rhpq};

                        //Toast.makeText(getContext(),String.valueOf(aaa)+" "+listdatatest[1],Toast.LENGTH_LONG).show();

                        ReportValu reportValu = new ReportValu(getContext(),listdatatest);

                        reportAdapter.add(reportValu);
                        reportAdapter.notifyDataSetChanged();
                    }

                    progressBarReport.setVisibility(View.INVISIBLE);
                } catch (JSONException e) {
                    progressBarReport.setVisibility(View.INVISIBLE);
                    Toast.makeText(getContext(),"Problem in your internet connection",Toast.LENGTH_LONG).show();
                }
                listView.setAdapter(reportAdapter);

                requestQueue.stop();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBarReport.setVisibility(View.INVISIBLE);
                Toast.makeText(getContext(),"please check your internet connection",Toast.LENGTH_LONG).show();
                requestQueue.stop();

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();


                params.put("date", monthnameF);
                params.put("month",monthId );
                params.put("year", YearValu);
                return params;
            }
        };
        AppController.getInstance(getContext()).addToRequestQueue(stringRequest);

    }

    //today's table info
    private void ToDayTab(){
        progressBarReport.setVisibility(View.VISIBLE);
        int remH= 24-(hours+1);
        int remM= 60-(min);
        if(remM==60) {remH+=1;}

        TPODFTV.setText("24:00\nHours");
        TPODATV.setText(String.valueOf(hours)+":"+String.valueOf(min)+"\nHours");
        TPODPTV.setText(String.valueOf(remH)+":"+String.valueOf(remM)+"\nHours");


        String url = "http://www.rrmtrustfoundation.com/tdayReport.php";

        final RequestQueue requestQueue = Volley.newRequestQueue(getContext());

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    //String mass = jsonObject.getString("mass");

                    String a= jsonObject.getString("ReTarget");
                    String b= jsonObject.getString("ReUnit");
                    String totalActarget= jsonObject.getString("totalActarget");
                    String totalAcUnit= jsonObject.getString("totalAcUnit");

                    float totalTarget= Float.parseFloat(a);
                    float totalUnit= Float.parseFloat(b);
                    float totalActargetV= Float.parseFloat(totalActarget);
                    float totAcUnitV= Float.parseFloat(totalAcUnit);
//
                    float PDAPFTVV=(totalTarget/(monthMaxDays*24));

                    float PDAPATVV;

                    if (totalActargetV==0.00){
                        PDAPATVV=  0.00f;
                    }
                    else {
                        if (min>30)
                            PDAPATVV=totalActargetV/(hours+1);
                        else {
                            PDAPATVV=(totalActargetV/hours);
                        }
                    }
                    float PDAPPTVV=PDAPFTVV-PDAPATVV;

                    float TMPDUFTVV=(totalUnit/((monthMaxDays-dateC)+1));
                    float TMPDUATVV=totAcUnitV;
                    float TMPDUPTVV=TMPDUFTVV-TMPDUATVV;
//
                    float PTPDFTVV=(totalUnit/(totalTarget/((monthMaxDays-dateC)+1)));
                    float PTPDATVV;
                    if (totalActargetV<1){
                        PTPDATVV=0.0f;
                    }
                    else {
                        PTPDATVV = totAcUnitV / totalActargetV;
                    }

                    float PTPDPTVV=PTPDFTVV-PTPDATVV;
//
                    float TTTTDFTVV=(1440/(((totalTarget/((monthMaxDays-dateC)+1))/15)/2));
                    float TTTTDATVV;
                    if (totalActargetV==0){
                        TTTTDATVV=0.00f;
                    }
                    else {
                        TTTTDATVV = (1440 / ((totalActargetV / 15) / 2));
                    }
                    float TTTTDPTVV=TTTTDFTVV-TTTTDATVV;
//
                    float PDAHNFTVV=((totalTarget/((monthMaxDays-dateC)+1))/15);
                    float PDAHNATVV=(totalActargetV/15);
                    float PDAHNPTVV=PDAHNFTVV-PDAHNATVV;



                    //Toast.makeText(getContext(),String.valueOf(totalTarget),Toast.LENGTH_LONG).show();


                    MFTV.setText(String.format("%.2f",(totalTarget/((monthMaxDays-dateC)+1)))+"\nTON");
                    MATV.setText(totalActarget+"\nTON");
                    MPTV.setText(String.format("%.2f",(totalTarget/((monthMaxDays-dateC)+1))-totalActargetV)+"\nTON");


                    PDAPFTV.setText(String.format("%.2f",PDAPFTVV )+"\nTON");
                    PDAPATV.setText(String.format("%.2f",PDAPATVV)+"\nTON");
                    PDAPPTV.setText(String.format("%.2f",PDAPPTVV)+"\nTON");

                    TMPDUFTV.setText(String.format("%.2f",TMPDUFTVV)+"\nUnit\n");
                    TMPDUATV.setText(String.format("%.2f",TMPDUATVV)+"\nUnit\n");
                    TMPDUPTV.setText(String.format("%.2f",TMPDUPTVV)+"\nUnit\n");

                    PTPDFTV.setText(String.format("%.2f",PTPDFTVV)+"\nUnit");
                    PTPDATV.setText(String.format("%.2f",PTPDATVV)+"\nUnit");
                    PTPDPTV.setText(String.format("%.2f",PTPDPTVV)+"\nUnit");

                    TTTTDFTV.setText(String.format("%.2f",TTTTDFTVV)+"\nMin");
                    TTTTDATV.setText(String.format("%.2f",TTTTDATVV)+"\nMin");
                    TTTTDPTV.setText(String.format("%.2f",TTTTDPTVV)+"\nMin");

                    PDAHNFTV.setText(String.format("%.2f",PDAHNFTVV)+"\nHEATS");
                    PDAHNATV.setText(String.format("%.2f",PDAHNATVV)+"\nHEATS");
                    PDAHNPTV.setText(String.format("%.2f",PDAHNPTVV)+"\nHEATS");



                    progressBarReport.setVisibility(View.INVISIBLE);
                } catch (JSONException e) {
                    progressBarReport.setVisibility(View.INVISIBLE);
                }

                requestQueue.stop();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBarReport.setVisibility(View.INVISIBLE);
                Toast.makeText(getContext(),"please check your internet connection",Toast.LENGTH_LONG).show();
                requestQueue.stop();

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();


                params.put("date", monthnameF);
                params.put("month",monthId );
                params.put("year", YearValu);
                return params;
            }
        };
        AppController.getInstance(getContext()).addToRequestQueue(stringRequest);
        //requestQueue.add(stringRequest);

    }




}

