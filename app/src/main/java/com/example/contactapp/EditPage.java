package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class EditPage extends AppCompatActivity {
    private TextInputLayout inputedit_name, inputedit_lastname, inputedit_number;
    Button btnE_Edit , btnE_Leave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_page);
        inputedit_name = findViewById(R.id.txt_Edit_name);
        inputedit_lastname = findViewById(R.id.txt_Edit_lastname);
        inputedit_number = findViewById(R.id.txt_Edit_number);
        btnE_Edit = findViewById(R.id.btn_Contact_Edit);
        btnE_Leave = findViewById(R.id.btn_Edit_Leave);
        //we get the data from the contactpage
       Intent x = this.getIntent();
       Bundle b = x.getExtras();
       String name = b.getString("name");
       String lastname = b.getString("lastname");
       String number = b.getString("number");
       int indice = b.getInt("indice",0);

       inputedit_name.getEditText().setText(name);
       inputedit_lastname.getEditText().setText(lastname);
       inputedit_number.getEditText().setText(number);


        btnE_Leave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnE_Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String na = inputedit_name.getEditText().getText().toString();
                String lastname = inputedit_lastname.getEditText().getText().toString();
                String num = inputedit_number.getEditText().getText().toString();
              HomePage.data.set(indice,new Contact(na,lastname,num));
              Intent i = new Intent(EditPage.this,ContactPage.class);
              startActivity(i);




            }
        });
    }
}