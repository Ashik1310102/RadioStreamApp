package com.example.ashik.bpc;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashik on 11/5/2017.
 */
//Report list Adapter works
public class ReportAdapter extends ArrayAdapter {
    List list = new ArrayList();

    static class DataHandelarH{

        TextView todayRHNV,todayRtimeV,todayRdateV,todayRShiftV,todayRPIV,todayRRCPNV,todayRRCNV,todayRRCLNV,todayRRHNV,todayRHMTV,
                todayRFSTV,todayRFHTV,todayRTUFTHV,todayRPUPTV,todayRCCPTV,todayRBLLAIV,todayRBLLAPV,todayRBLLBIV,todayRBLLBPV,todayRBBSLIV,
                todayRBBSLPV,todayRRHPQV,todayRRV,todayRTTTTV,todayRFHKV,todayRPUPTTTHV,todayRPUPTTTH;

    }

    public ReportAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    @Override
    public void add(@Nullable Object object) {
        list.add(object);
        super.add(object);

    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view;
        view = convertView;



        DataHandelarH dataHandler;
        if(convertView==null){
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view= layoutInflater.inflate(R.layout.todayreport,parent,false);
            dataHandler = new DataHandelarH();

            dataHandler.todayRHNV = (TextView) view.findViewById(R.id.todayRHNV);
            dataHandler.todayRtimeV = (TextView) view.findViewById(R.id.todayRtimeV);
            dataHandler.todayRdateV = (TextView) view.findViewById(R.id.todayRdateV);
            dataHandler.todayRShiftV = (TextView) view.findViewById(R.id.todayRShiftV);
            dataHandler.todayRPIV = (TextView) view.findViewById(R.id.todayRPIV);
            dataHandler.todayRRCPNV = (TextView) view.findViewById(R.id.todayRRCPNV);
            dataHandler.todayRRCNV = (TextView) view.findViewById(R.id.todayRRCNV);
            dataHandler.todayRRCLNV = (TextView) view.findViewById(R.id.todayRRCLNV);
            dataHandler.todayRRHNV = (TextView) view.findViewById(R.id.todayRRHNV);
            dataHandler.todayRHMTV = (TextView) view.findViewById(R.id.todayRHMTV);

            dataHandler.todayRFSTV = (TextView) view.findViewById(R.id.todayRFSTV);
            dataHandler.todayRFHTV = (TextView) view.findViewById(R.id.todayRFHTV);
            dataHandler.todayRTUFTHV = (TextView) view.findViewById(R.id.todayRTUFTHV);
            dataHandler.todayRPUPTV = (TextView) view.findViewById(R.id.todayRPUPTV);
            dataHandler.todayRCCPTV = (TextView) view.findViewById(R.id.todayRCCPTV);
            dataHandler.todayRBLLAIV = (TextView) view.findViewById(R.id.todayRBLLAIV);
            dataHandler.todayRBLLAPV = (TextView) view.findViewById(R.id.todayRBLLAPV);
            dataHandler.todayRBLLBIV = (TextView) view.findViewById(R.id.todayRBLLBIV);
            dataHandler.todayRBLLBPV = (TextView) view.findViewById(R.id.todayRBLLBPV);
            dataHandler.todayRBBSLIV = (TextView) view.findViewById(R.id.todayRBBSLIV);

            dataHandler.todayRBBSLPV = (TextView) view.findViewById(R.id.todayRBBSLPV);
            dataHandler.todayRRHPQV = (TextView) view.findViewById(R.id.todayRRHPQV);
            dataHandler.todayRRV = (TextView) view.findViewById(R.id.todayRRV);
            dataHandler.todayRTTTTV = (TextView) view.findViewById(R.id.todayRTTTTV);
            dataHandler.todayRFHKV = (TextView) view.findViewById(R.id.todayRFHKV);
            dataHandler.todayRPUPTTTHV = (TextView) view.findViewById(R.id.todayRPUPTTTHV);
            dataHandler.todayRPUPTTTH = (TextView) view.findViewById(R.id.todayRPUPTTTH);

            view.setTag(dataHandler);
        }
        else {
            dataHandler= (DataHandelarH) view.getTag();
        }

        ReportValu reportValu;
        reportValu= (ReportValu) this.getItem(position);

        dataHandler.todayRHNV.setText(reportValu.getTodayRHNV());
        dataHandler.todayRtimeV.setText(reportValu.getTodayRtimeV());
        dataHandler.todayRdateV.setText(reportValu.getTodayRdateV());
        dataHandler.todayRShiftV.setText(reportValu.getTodayRShiftV());
        dataHandler.todayRPIV.setText(reportValu.getTodayRPIV());
        dataHandler.todayRRCPNV.setText(reportValu.getTodayRRCPNV());
        dataHandler.todayRRCNV.setText(reportValu.getTodayRRCNV());
        dataHandler.todayRRCLNV.setText(reportValu.getTodayRRCLNV());
        dataHandler.todayRRHNV.setText(reportValu.getTodayRRHNV());
        dataHandler.todayRHMTV.setText(reportValu.getTodayRHMTV());

        dataHandler.todayRFSTV.setText(reportValu.getTodayRFSTV());
        dataHandler.todayRFHTV.setText(reportValu.getTodayRFHTV());
        dataHandler.todayRTUFTHV.setText(reportValu.getTodayRTUFTHV());
        dataHandler.todayRPUPTV.setText(reportValu.getTodayRPUPTV());
        dataHandler.todayRCCPTV.setText(reportValu.getTodayRCCPTV());
        dataHandler.todayRBLLAIV.setText(reportValu.getTodayRBLLAIV());
        dataHandler.todayRBLLAPV.setText(reportValu.getTodayRBLLAPV());
        dataHandler.todayRBLLBIV.setText(reportValu.getTodayRBLLBIV());
        dataHandler.todayRBLLBPV.setText(reportValu.getTodayRBLLBPV());
        dataHandler.todayRBBSLIV.setText(reportValu.getTodayRBBSLIV());

        dataHandler.todayRBBSLPV.setText(reportValu.getTodayRBBSLPV());
        dataHandler.todayRRHPQV.setText(reportValu.getTodayRRHPQV());
        dataHandler.todayRRV.setText(reportValu.getTodayRRV());
        dataHandler.todayRTTTTV.setText(reportValu.getTodayRTTTTV());
        dataHandler.todayRFHKV.setText(reportValu.getTodayRFHKV());
        dataHandler.todayRPUPTTTHV.setText(reportValu.getTodayRPUPTTTHV());
        dataHandler.todayRPUPTTTH.setText(reportValu.getTodayRPUPTTTH());

        return view;
    }



}
