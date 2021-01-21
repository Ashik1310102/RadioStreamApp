package com.example.ashik.bpc;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.BreakIterator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static android.R.style.Theme_Holo_Dialog_MinWidth;
import static android.content.ContentValues.TAG;

/**
 * Created by Ashik on 9/28/2017.
 */


public class Home extends Fragment {

    //home tab works

    ScrollView svV;
    Button show,bcpFSubmit;
    RelativeLayout r;
    TextView bcpFDate,MPTQ,bcpFNofPI;
    TextView MFTV,MATV,MPTV,TPODFTV,TPODATV,TPODPTV,PDAPFTV,PDAPATV,PDAPPTV,TMPDUFTV,TMPDUATV,TMPDUPTV,PTPDFTV,PTPDATV,PTPDPTV,TTTTDFTV,TTTTDATV,TTTTDPTV,PDAHNFTV,PDAHNATV,PDAHNPTV;
    EditText bcpFRenark,bcpFBSLP,bcpFBSLI,bcpFBLLBP,bcpFBLLBI,bcpFBLLAP,bcpFBLLAI,bcpFCCPH,bcpFPUPTTTH,bcpFFHKW,bcpFFHT,bcpFFST,bcpFHMT,bcpFRHN,bcpFRCLLN;
    RadioGroup bcpFShift,bcpFRCPN,bcpFRCN;
    ProgressBar progressBarHome;

    boolean submitOrnot;


    String date,shift,nameOfPraductionIncharge,RunningCruciblePanelNo,RunningCrucibleNo,RunningCrucibleLiningLifeno,RunningHeatNo,id;
    String HeatMeltingTime,FurnaceStopTime,FurnaceHoldingTime,FurnaceHoldingKW,PowerUnitPanelTotalTillThisHeat,ChemicalConsumptionPerHeat;
    String BilletLongLengthAInch,BilletLongLengthAPcs,BilletLongLengthBInch,BilletLongLengthBPcs,BilletShortLengthInch,BilletShortLengthPcs,Remarks,time;


    private DatePickerDialog.OnDateSetListener mDateSetListener;


    private void formInputChack(){

        //error mass. set

        if(bcpFHMT.getText().length()==0) {
            bcpFHMT.setError("Place Input Some Value...");
            submitOrnot=false;
        }
        if(bcpFRHN.getText().length()==0) {
            bcpFRHN.setError("Place Input Some Value...");
            submitOrnot=false;
        }
        if(bcpFRCLLN.getText().length()==0) {
            bcpFRCLLN.setError("Place Input Some Value...");
            submitOrnot=false;
        }

    }



    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        progressBarHome = (ProgressBar) rootView.findViewById(R.id.progressBarHome);

        bcpFShift= (RadioGroup) rootView.findViewById(R.id.bcpFShift);
        bcpFRCPN= (RadioGroup) rootView.findViewById(R.id.bcpFRCPN);
        bcpFRCN= (RadioGroup) rootView.findViewById(R.id.bcpFRCN);

        bcpFRenark= (EditText) rootView.findViewById(R.id.bcpFRenark);
        bcpFBSLP= (EditText) rootView.findViewById(R.id.bcpFBSLP);
        bcpFBSLI= (EditText) rootView.findViewById(R.id.bcpFBSLI);
        bcpFBLLBP= (EditText) rootView.findViewById(R.id.bcpFBLLBP);
        bcpFBLLBI= (EditText) rootView.findViewById(R.id.bcpFBLLBI);
        bcpFBLLAP= (EditText) rootView.findViewById(R.id.bcpFBLLAP);
        bcpFBLLAI= (EditText) rootView.findViewById(R.id.bcpFBLLAI);
        bcpFCCPH= (EditText) rootView.findViewById(R.id.bcpFCCPH);
        bcpFPUPTTTH= (EditText) rootView.findViewById(R.id.bcpFPUPTTTH);
        bcpFFHKW= (EditText) rootView.findViewById(R.id.bcpFFHKW);
        bcpFFHT= (EditText) rootView.findViewById(R.id.bcpFFHT);
        bcpFHMT= (EditText) rootView.findViewById(R.id.bcpFHMT);
        bcpFRHN= (EditText) rootView.findViewById(R.id.bcpFRHN);
        bcpFRCLLN= (EditText) rootView.findViewById(R.id.bcpFRCLLN);
        bcpFFST= (EditText) rootView.findViewById(R.id.bcpFFST);

        svV = (ScrollView) rootView.findViewById(R.id.svV);


        r= (RelativeLayout) rootView.findViewById(R.id.rlBCPF);

        show = (Button) rootView.findViewById(R.id.btSubmissionforn);
        bcpFSubmit = (Button) rootView.findViewById(R.id.bcpFSubmit);

        bcpFDate= (TextView) rootView.findViewById(R.id.bcpFDate);
        bcpFNofPI= (TextView) rootView.findViewById(R.id.bcpFNofPI);

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

        LogerInfo logerInfo = new LogerInfo(getContext());


        //form set for PI user

        if(logerInfo.getaccessLevel().equals("Production Incharge")){
            r.setVisibility(View.INVISIBLE);
        }

        nameOfPraductionIncharge= logerInfo.getName();
        bcpFNofPI.setText(nameOfPraductionIncharge);
        id=logerInfo.getId();

        String monthnameF =(String)android.text.format.DateFormat.format("yyyy-MM-dd", new Date());
        bcpFDate.setText(monthnameF);
        date=monthnameF;




        //month name set in table

        String monthname=(String)android.text.format.DateFormat.format("MMMM", new Date());
        MPTQ.setText(monthname+" month\nproduction target Qty");

        //table data from db
        tabData();


        //form button show

        if(logerInfo.getaccessLevel().equals("Production Incharge")){
            show.setVisibility(View.VISIBLE);
        }


        bcpFSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitOrnot=true;
                formInputChack();
                if (submitOrnot==true){

                    //form data receive

                    Remarks = bcpFRenark.getText().toString();
                    BilletShortLengthPcs = bcpFBSLP.getText().toString();
                    BilletShortLengthInch = bcpFBSLI.getText().toString();
                    BilletLongLengthBPcs = bcpFBLLBP.getText().toString();
                    BilletLongLengthBInch = bcpFBLLBI.getText().toString();
                    BilletLongLengthAPcs = bcpFBLLAP.getText().toString();
                    BilletLongLengthAInch = bcpFBLLAI.getText().toString();
                    ChemicalConsumptionPerHeat = bcpFCCPH.getText().toString();
                    PowerUnitPanelTotalTillThisHeat = bcpFPUPTTTH.getText().toString();
                    FurnaceHoldingKW = bcpFFHKW.getText().toString();

                    FurnaceHoldingTime = bcpFFHT.getText().toString();
                    FurnaceStopTime = bcpFFST.getText().toString();
                    HeatMeltingTime = bcpFHMT.getText().toString();
                    RunningHeatNo = bcpFRHN.getText().toString();
                    //RunningHeatNo = bcpFRHN.getText().toString();
                    RunningCrucibleLiningLifeno = bcpFRCLLN.getText().toString();
                    DateFormat df = new SimpleDateFormat("HH:mm");
                    time = df.format(java.util.Calendar.getInstance().getTime());


                    //form data up lode  in db
                    rquInDataBase();


                    //form clear

                    bcpFRenark.setText("");
                    bcpFBSLI.setText("");

                    bcpFBSLP.setText("");
                    bcpFBLLBP.setText("");
                    bcpFBLLBI.setText("");
                    bcpFBLLAP.setText("");
                    bcpFBLLAI.setText("");
                    bcpFCCPH.setText("");
                    bcpFPUPTTTH.setText("");
                    bcpFFHKW.setText("");

                    bcpFFHT.setText("");
                    bcpFFST.setText("");
                    bcpFHMT.setText("");
                    bcpFRHN.setText("");
                    bcpFRCLLN.setText("");
                    bcpFFHKW.setText("");

                    //form hide
                    r.setVisibility(View.GONE);

                }

            }
        });


        bcpFShift.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                int checked;

                //radio button data receive

                checked = bcpFShift.indexOfChild(rootView.findViewById(checkedId));
                switch (checked) {
                    case 0:
                        shift= "Day";
                        break;
                    case 1:
                        shift= "Night";
                        break;
                    default:

                        break;
                }
            }
        });

        bcpFRCPN.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                int checked;
                //radio button data receive

                checked = bcpFRCPN.indexOfChild(rootView.findViewById(checkedId));
                switch (checked) {
                    case 0:
                        RunningCruciblePanelNo= "Old";
                        break;
                    case 1:
                        RunningCruciblePanelNo= "New";
                        break;
                    default:

                        break;
                }
            }
        });

        bcpFRCN.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                int checked;
                //radio button data receive

                checked = bcpFRCN.indexOfChild(rootView.findViewById(checkedId));
                switch (checked) {
                    case 0:
                        RunningCrucibleNo= "A";
                        break;
                    case 1:
                        RunningCrucibleNo= "B";
                        break;
                    case 2:
                        RunningCrucibleNo= "C";
                        break;
                    default:

                        break;
                }
            }
        });


        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //radio button data set
                r.setVisibility(View.VISIBLE);
                try {


                    RunningCrucibleNo= "A";
                    RunningCruciblePanelNo= "Old";
                    shift= "Day";
                }
                catch (Exception e){

                }

                svV.smoothScrollBy(0,1000);
            }
        });

        bcpFDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //datepicker work

                Calendar calendar = Calendar.getInstance();
                int year= calendar.get(Calendar.YEAR);
                int month= calendar.get(Calendar.MONTH);
                int day= calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),android.R.style.Theme_Holo_Dialog_MinWidth,
                        mDateSetListener, year,month,day);
                //datePickerDialog.getDatePicker().setMinDate(calendar.getTimeInMillis());
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        mDateSetListener= new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month+=1;
                date=String.valueOf(year)+"-"+String.valueOf(month)+"-"+String.valueOf(dayOfMonth);
                bcpFDate.setText(date);
            }
        };

        return rootView;
    }


    private void rquInDataBase(){

        //db work

        String url = "http://www.rrmtrustfoundation.com/form_BCP.php";

        final RequestQueue requestQueue = Volley.newRequestQueue(getContext());

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String mass = jsonObject.getString("mass");
                    Toast.makeText(getContext(),mass,Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
//                    Toast.makeText(getContext(),"please check your internet connection",Toast.LENGTH_LONG).show();
                    Toast.makeText(getContext(),String.valueOf(e),Toast.LENGTH_LONG).show();

                }
                //Toast.makeText(getContext(),response,Toast.LENGTH_LONG).show();

                requestQueue.stop();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(),"please check your internet connection",Toast.LENGTH_LONG).show();
                requestQueue.stop();

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                //form uplode data
                params.put("id", id);
                params.put("date", date);
                params.put("shift", shift);
                params.put("nameOfPraductionIncharge", nameOfPraductionIncharge);
                params.put("RunningCruciblePanelNo", RunningCruciblePanelNo);
                params.put("RunningCrucibleNo", RunningCrucibleNo);
                params.put("RunningCrucibleLiningLifeno", RunningCrucibleLiningLifeno);
                params.put("RunningHeatNo", RunningHeatNo);
                params.put("HeatMeltingTime", HeatMeltingTime);
                params.put("FurnaceStopTime", FurnaceStopTime);
                params.put("FurnaceHoldingTime", FurnaceHoldingTime);
                params.put("FurnaceHoldingKW", FurnaceHoldingKW);
                params.put("PowerUnitPanelTotalTillThisHeat", PowerUnitPanelTotalTillThisHeat);
                params.put("ChemicalConsumptionPerHeat", ChemicalConsumptionPerHeat);
                params.put("BilletLongLengthAInch", BilletLongLengthAInch);
                params.put("time", time);
                params.put("BilletLongLengthAPcs", BilletLongLengthAPcs);
                params.put("BilletLongLengthBInch", BilletLongLengthBInch);
                params.put("BilletLongLengthBPcs", BilletLongLengthBPcs);
                params.put("BilletShortLengthInch", BilletShortLengthInch);
                params.put("BilletShortLengthPcs", BilletShortLengthPcs);
                params.put("Remarks", Remarks);
                return params;
            }
        };
        AppController.getInstance(getContext()).addToRequestQueue(stringRequest);
        //requestQueue.add(stringRequest);


    }
    private void tabData(){

        progressBarHome.setVisibility(View.VISIBLE);
        String url = "http://www.rrmtrustfoundation.com/hometab.php";

        final RequestQueue requestQueue = Volley.newRequestQueue(getContext());

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String mass = jsonObject.getString("mass");
                    if(mass.equals("OK")){

                        //table data set

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
                    progressBarHome.setVisibility(View.GONE);

                } catch (JSONException e) {
                    progressBarHome.setVisibility(View.GONE);
                    Toast.makeText(getContext(),"please check your internet connection",Toast.LENGTH_LONG).show();
                }

                requestQueue.stop();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBarHome.setVisibility(View.GONE);
                Toast.makeText(getContext(),"Problem in your internet connection",Toast.LENGTH_LONG).show();
                requestQueue.stop();

            }
        });
        AppController.getInstance(getContext()).addToRequestQueue(stringRequest);
        //requestQueue.add(stringRequest);


    }
}

