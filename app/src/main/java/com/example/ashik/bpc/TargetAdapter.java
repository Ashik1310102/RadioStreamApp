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
 * Created by Ashik on 11/4/2017.
 */

public class TargetAdapter extends ArrayAdapter {
    List listT = new ArrayList();
    static class  DataHandlerT{
        TextView monthYera;
        TextView targetTon;
        TextView targetUnit;
    }
    public TargetAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    @Override
    public void add(@Nullable Object object) {
        listT.add(object);
        super.add(object);

    }

    @Override
    public int getCount() {
        return this.listT.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return this.listT.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view;
        view = convertView;
        DataHandlerT dataHandler;
        if(convertView==null){
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view= layoutInflater.inflate(R.layout.turgerlist,parent,false);
            dataHandler = new DataHandlerT();
            dataHandler.monthYera= (TextView) view.findViewById(R.id.tvMAYV);
            dataHandler.targetTon = (TextView) view.findViewById(R.id.tvTTV);
            dataHandler.targetUnit = (TextView) view.findViewById(R.id.tvTUV);
            view.setTag(dataHandler);
        }
        else {
            dataHandler= (DataHandlerT) view.getTag();
        }
        TargetList targetList;
        targetList= (TargetList) this.getItem(position);

        dataHandler.monthYera.setText(targetList.getmonthYear());
        dataHandler.targetTon.setText(targetList.getTargetTon());
        dataHandler.targetUnit.setText(targetList.getTargetUnit());

        return view;
    }
}

