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
 * Created by Ashik on 11/2/2017.
 */
//user adapter for set user list in list view
public class UserAdapter extends ArrayAdapter {

    List list = new ArrayList();

    static class  DataHandler{
        TextView userId;
        TextView userName;
        TextView userAccess;
    }

    public UserAdapter(@NonNull Context context, @LayoutRes int resource) {
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
        DataHandler dataHandler;
        if(convertView==null){
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view= layoutInflater.inflate(R.layout.userlist,parent,false);
            dataHandler = new DataHandler();
            dataHandler.userId = (TextView) view.findViewById(R.id.tvUIV);
            dataHandler.userName = (TextView) view.findViewById(R.id.tvNV);
            dataHandler.userAccess = (TextView) view.findViewById(R.id.tvALV);
            view.setTag(dataHandler);
        }
        else {
            dataHandler= (DataHandler) view.getTag();
        }
        userList userlist;
        userlist= (userList) this.getItem(position);

        dataHandler.userId.setText(userlist.getUserId());
        dataHandler.userName.setText(userlist.getNameA());
        dataHandler.userAccess.setText(userlist.getAccessLevelA());

        return view;
    }
}
