package com.example.contactapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter  extends BaseAdapter {
    Context con ;
    ArrayList<Contact> data ;
    public ContactAdapter( Context con, ArrayList<Contact> data){
  this.con= con;
  this.data = data;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //creation d'un view
        LayoutInflater inf = LayoutInflater.from(con);
        LinearLayout LayoutView = (LinearLayout) inf.inflate(R.layout.contact_view,null);
      //get the elements from the contact viw layout and put it in the data(contact)

        //get the componenets from the contact view
        TextView txt_name = LayoutView.findViewById(R.id.contact_view_name);
        TextView txt_lastname = LayoutView.findViewById(R.id.contact_view_lastname);
        TextView txt_number = LayoutView.findViewById(R.id.contact_view_number);

        //put the data in contact 'data'
        Contact CT = data.get(position);
        txt_name.setText(CT.getName());
        txt_lastname.setText(CT.getLastname());
        txt_number.setText(CT.getNumber());




        return LayoutView;
    }
}
