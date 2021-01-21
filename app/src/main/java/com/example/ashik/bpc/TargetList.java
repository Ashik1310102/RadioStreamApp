package com.example.ashik.bpc;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Ashik on 11/4/2017.
 */

public class TargetList {

    private Context context;
    private String monthYear;
    private String TargetTon;
    private String TargetUnit;

    public void setContext(Context context) {
        this.context = context;
    }

    public void setmonthYear(String monthYear) {
        this.monthYear = monthYear;
    }

    public void setTargetTon(String TargetTon) {
        this.TargetTon = TargetTon;
    }
    public void setTargetUnit(String TargetUnit) {
        this.TargetUnit = TargetUnit;
    }

    public String getmonthYear() {
        return monthYear;
    }

    public String getTargetTon() {
        return TargetTon;
    }

    public String getTargetUnit() {
        return TargetUnit;
    }

    public TargetList(Context context, String monthYear, String TargetUnit,String TargetTon){

        this.context= context;
        this.monthYear = monthYear;
        this.TargetTon = TargetTon;
        this.TargetUnit = TargetUnit;

    }
}
