package com.example.contactapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter  extends BaseAdapter implements Filterable {
    Context con ;
    ArrayList<Contact> data ;
    ArrayList<Contact> Filterlist;
     ValueFilter valueFilter;
    public ContactAdapter( Context con, ArrayList<Contact> data){
  this.con= con;
  this.data = data;
  Filterlist= data;
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

    @Override
    public Filter getFilter() {
        if (valueFilter == null){
            valueFilter = new ValueFilter();
        }
        return valueFilter;
    }
//we create an inner class extends the filter class
    private class ValueFilter extends Filter {

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        //constraint it's the value that the user should type to filter
        //instance de filterResults
        FilterResults results = new FilterResults();
        //check if the user has typed a constraint
        if(constraint != null && constraint.length()>0){
            //the user typed so we create a new arraylist of contact that will hold our new filter
            ArrayList<Contact> filters = new ArrayList<Contact>();
            //get the specific items
            for (int i=0; i<Filterlist.size();i++){
                //if our constraint is matches our item in the filterlist then we add that data
                // (we filter by name nd we check that particular item with contains)
                if((Filterlist.get(i).getName().toUpperCase()).contains(constraint.toString().toUpperCase())){
                  //so get the name nd the other items
                   Contact con = new Contact(Filterlist.get(i).getName(),Filterlist.get(i).getLastname(),Filterlist.get(i).getNumber());
                    filters.add(con);
                }
            }
            results.count = filters.size();
            results.values = filters;
        }
        else{
            results.count = Filterlist.size();
            results.values = Filterlist;

        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        //to publish our result
     data = (ArrayList<Contact>) results.values;
     notifyDataSetChanged();// refresh
    }
}
}
