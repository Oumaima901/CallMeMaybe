package com.example.contactapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class ContactPage extends AppCompatActivity implements AdapterView.OnItemClickListener, DialogInterface.OnClickListener, AdapterView.OnItemLongClickListener {
 ListView ContactListV;
    SearchView searchContact;
int indice =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_page);
        ContactListV = findViewById(R.id.listViewContact);
        searchContact = findViewById(R.id.txt_search);

        //creation de l'adapter
        ContactAdapter Con_AD = new ContactAdapter(ContactPage.this,HomePage.data);
        ContactListV.setAdapter(Con_AD);

        //events for the click one for the edit delete,nd delete all
        ContactListV.setOnItemClickListener(this);
        //events for the call
        ContactListV.setOnItemLongClickListener(this);

        searchContact.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //we call the getfilter method
                Con_AD.getFilter().filter(newText);
                return false;
            }
        });

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


    indice=position;
    //the alert dialog
    AlertDialog.Builder alert = new AlertDialog.Builder(ContactPage.this);
        alert.setTitle("Edition");
        alert.setMessage("Please choose an action :");
    //3 bouttons
        alert.setPositiveButton("Delete",this);
        alert.setNegativeButton("Edit",this);
        alert.setNeutralButton("Delete All",this);
        alert.show();

}


    @Override
    public void onClick(DialogInterface dialog, int which) {
        if(which== dialog.BUTTON_POSITIVE) {

            HomePage.data.remove(indice);
            ContactListV.invalidateViews();//update the list
        }
         if(which== dialog.BUTTON_NEGATIVE){
         //put the data in the editpage
             Intent i = new Intent(ContactPage.this, EditPage.class);
             //get the contact data from the homepage
             Contact c =HomePage.data.get(indice);
             String name = c.getName();
             String lastname = c.getLastname();
             String number = c.getNumber();

             i.putExtra("name",name);
             i.putExtra("lastname",lastname);
             i.putExtra("number",number);
             i.putExtra("indice",indice);

             startActivity(i);

        }
        if(which== dialog.BUTTON_NEUTRAL){
            HomePage.data.clear();
            ContactListV.invalidateViews();//update the list

        }
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
       //call the number selected
        String number = HomePage.data.get(position).getNumber();
        //call begin
        Intent i = new Intent(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel:"+number));
        startActivity(i);

        return false;
    }
}