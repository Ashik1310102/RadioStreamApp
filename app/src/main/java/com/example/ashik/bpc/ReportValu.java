package com.example.ashik.bpc;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Ashik on 11/5/2017.
 */
//Report list works
public class ReportValu {

    Context context;
    private String todayRHNV,todayRtimeV,todayRdateV,todayRShiftV,todayRPIV,todayRRCPNV,todayRRCNV,todayRRCLNV,todayRRHNV,todayRHMTV,todayRFSTV,todayRFHTV,
            todayRTUFTHV,todayRPUPTV,todayRCCPTV,todayRBLLAIV,todayRBLLAPV,todayRBLLBIV,todayRBLLBPV,todayRBBSLIV,todayRBBSLPV,todayRRHPQV,todayRRV,todayRTTTTV,todayRFHKV;
    private String todayRPUPTTTH,todayRPUPTTTHV;

    public ReportValu(Context context, String[] a)
    {

        this.context=context;
        this.todayRHNV=a[6];

        this.todayRdateV=a[0];
        this.todayRShiftV=a[1];
        this.todayRPIV=a[2];
        this.todayRRCPNV=a[3];
        this.todayRRCNV=a[4];
        this.todayRRCLNV=a[5];
        this.todayRRHNV=a[6];
        this.todayRHMTV=a[7];
        this.todayRFSTV=a[8];
        this.todayRFHTV=a[9];
        this.todayRFHKV=a[10];
        this.todayRTTTTV=a[11];
        this.todayRPUPTTTH="Power Unit Panel \""+a[3]+"\" Total Till This heat";
        this.todayRPUPTTTHV=a[12];
        this.todayRTUFTHV=a[13];
        this.todayRPUPTV=a[14];
        this.todayRCCPTV=a[15];
        this.todayRBLLAIV=a[16];
        this.todayRBLLAPV=a[17];
        this.todayRBLLBIV=a[18];
        this.todayRBLLBPV=a[19];
        this.todayRBBSLIV=a[20];
        this.todayRBBSLPV=a[21];
        this.todayRRV=a[22];
        this.todayRtimeV=a[23];
        this.todayRRHPQV=a[24];




    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getTodayRHNV() {
        return todayRHNV;
    }

    public void setTodayRHNV(String todayRHNV) {
        this.todayRHNV = todayRHNV;
    }

    public String getTodayRtimeV() {
        return todayRtimeV;
    }

    public void setTodayRtimeV(String todayRtimeV) {
        this.todayRtimeV = todayRtimeV;
    }

    public String getTodayRdateV() {
        return todayRdateV;
    }

    public void setTodayRdateV(String todayRdateV) {
        this.todayRdateV = todayRdateV;
    }

    public String getTodayRShiftV() {
        return todayRShiftV;
    }

    public void setTodayRShiftV(String todayRShiftV) {
        this.todayRShiftV = todayRShiftV;
    }

    public String getTodayRPIV() {
        return todayRPIV;
    }

    public void setTodayRPIV(String todayRPIV) {
        this.todayRPIV = todayRPIV;
    }

    public String getTodayRRCPNV() {
        return todayRRCPNV;
    }

    public void setTodayRRCPNV(String todayRRCPNV) {
        this.todayRRCPNV = todayRRCPNV;
    }

    public String getTodayRRCNV() {
        return todayRRCNV;
    }

    public void setTodayRRCNV(String todayRRCNV) {
        this.todayRRCNV = todayRRCNV;
    }

    public String getTodayRRCLNV() {
        return todayRRCLNV;
    }

    public void setTodayRRCLNV(String todayRRCLNV) {
        this.todayRRCLNV = todayRRCLNV;
    }

    public String getTodayRRHNV() {
        return todayRRHNV;
    }

    public void setTodayRRHNV(String todayRRHNV) {
        this.todayRRHNV = todayRRHNV;
    }

    public String getTodayRHMTV() {
        return todayRHMTV;
    }

    public void setTodayRHMTV(String todayRHMTV) {
        this.todayRHMTV = todayRHMTV;
    }

    public String getTodayRFSTV() {
        return todayRFSTV;
    }

    public void setTodayRFSTV(String todayRFSTV) {
        this.todayRFSTV = todayRFSTV;
    }

    public String getTodayRFHTV() {
        return todayRFHTV;
    }

    public void setTodayRFHTV(String todayRFHTV) {
        this.todayRFHTV = todayRFHTV;
    }

    public String getTodayRTUFTHV() {
        return todayRTUFTHV;
    }

    public void setTodayRTUFTHV(String todayRTUFTHV) {
        this.todayRTUFTHV = todayRTUFTHV;
    }

    public String getTodayRPUPTV() {
        return todayRPUPTV;
    }

    public void setTodayRPUPTV(String todayRPUPTV) {
        this.todayRPUPTV = todayRPUPTV;
    }

    public String getTodayRCCPTV() {
        return todayRCCPTV;
    }

    public void setTodayRCCPTV(String todayRCCPTV) {
        this.todayRCCPTV = todayRCCPTV;
    }

    public String getTodayRBLLAIV() {
        return todayRBLLAIV;
    }

    public void setTodayRBLLAIV(String todayRBLLAIV) {
        this.todayRBLLAIV = todayRBLLAIV;
    }

    public String getTodayRBLLAPV() {
        return todayRBLLAPV;
    }

    public void setTodayRBLLAPV(String todayRBLLAPV) {
        this.todayRBLLAPV = todayRBLLAPV;
    }

    public String getTodayRBLLBIV() {
        return todayRBLLBIV;
    }

    public void setTodayRBLLBIV(String todayRBLLBIV) {
        this.todayRBLLBIV = todayRBLLBIV;
    }

    public String getTodayRBLLBPV() {
        return todayRBLLBPV;
    }

    public void setTodayRBLLBPV(String todayRBLLBPV) {
        this.todayRBLLBPV = todayRBLLBPV;
    }

    public String getTodayRBBSLIV() {
        return todayRBBSLIV;
    }

    public void setTodayRBBSLIV(String todayRBBSLIV) {
        this.todayRBBSLIV = todayRBBSLIV;
    }

    public String getTodayRBBSLPV() {
        return todayRBBSLPV;
    }

    public void setTodayRBBSLPV(String todayRBBSLPV) {
        this.todayRBBSLPV = todayRBBSLPV;
    }

    public String getTodayRRHPQV() {
        return todayRRHPQV;
    }

    public void setTodayRRHPQV(String todayRRHPQV) {
        this.todayRRHPQV = todayRRHPQV;
    }

    public String getTodayRRV() {
        return todayRRV;
    }

    public void setTodayRRV(String todayRRV) {
        this.todayRRV = todayRRV;
    }

    public String getTodayRTTTTV() {
        return todayRTTTTV;
    }

    public void setTodayRTTTTV(String todayRTTTTV) {
        this.todayRTTTTV = todayRTTTTV;
    }

    public String getTodayRFHKV() {
        return todayRFHKV;
    }

    public void setTodayRFHKV(String todayRFHKV) {
        this.todayRFHKV = todayRFHKV;
    }

    public String getTodayRPUPTTTH() {
        return todayRPUPTTTH;
    }

    public void setTodayRPUPTTTH(String todayRPUPTTTH) {
        this.todayRPUPTTTH = todayRPUPTTTH;
    }

    public String getTodayRPUPTTTHV() {
        return todayRPUPTTTHV;
    }

    public void setTodayRPUPTTTHV(String todayRPUPTTTHV) {
        this.todayRPUPTTTHV = todayRPUPTTTHV;
    }


}
