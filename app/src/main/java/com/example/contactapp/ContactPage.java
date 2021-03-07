package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.material.textfield.TextInputLayout;

public class ContactPage extends AppCompatActivity {
 ListView ContactListV;
    TextInputLayout inputReKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_page);
        ContactListV = findViewById(R.id.listViewContact);
        inputReKey = findViewById(R.id.txt_search);

        //creation de l'adapter
        ContactAdapter Con_AD = new ContactAdapter(ContactPage.this,HomePage.data);
        ContactListV.setAdapter(Con_AD);
    }
}