package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class AddContact extends AppCompatActivity {
    private TextInputLayout inputadd_name, inputadd_lastname, inputadd_number;
    Button btnA_Add , btnA_Leave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        inputadd_name = findViewById(R.id.txt_Add_name);
        inputadd_lastname = findViewById(R.id.txt_Add_lastname);
        inputadd_number = findViewById(R.id.txt_Add_number);
        btnA_Add = findViewById(R.id.btn_Contact_ADD);
       btnA_Leave= findViewById(R.id.btn_Contact_Leave);

       btnA_Leave.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               finish();
           }
       });
   btnA_Add.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           
       }
   });

    }
}