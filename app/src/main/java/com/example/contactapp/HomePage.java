package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {
private TextView txtWelcome;
Button btnShow, btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        txtWelcome = findViewById(R.id.txt_home_WC);
        btnAdd= findViewById(R.id.btn_add_home);
        btnShow = findViewById(R.id.btn_list_contact);
        //intent get the name from the sign in
        Intent x = this.getIntent();
        Bundle b = x.getExtras();
        String n = b.getString("Username");
        txtWelcome.setText("Hello there, Welcome "+n);

   btnShow.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           Intent in = new Intent(HomePage.this,ContactPage.class);
           startActivity(in);
       }
   });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(HomePage.this, AddContact.class);
                 startActivity(in);

            }
        });
    }
}