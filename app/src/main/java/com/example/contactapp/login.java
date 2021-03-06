package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class login extends AppCompatActivity implements View.OnClickListener {
    //private TextInputEditText txtUsername, txtPasswd ;
    private TextInputLayout inputUsername, inputPasswd;
    Button btnGo, btnLeave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        inputUsername = findViewById(R.id.txt_username);
        inputPasswd = findViewById(R.id.txt_password);
        btnGo = findViewById(R.id.btn_go);
        btnLeave = findViewById(R.id.btn_leave);

        /*txtUsername = findViewById(R.id.txt_username);
        txtPasswd = findViewById(R.id.txt_password);
        TextInputLayout textInputLayout = findViewById(R.id.custom_end_icon);
         String text = textInputLayout.getEditText().getText();
        btnGo = findViewById(R.id.btn_go);
        btnLeave = findViewById(R.id.btn_leave);
*/

        btnGo.setOnClickListener(this);
        btnLeave.setOnClickListener(this);
    }

   @Override
    public void onClick(View v) {
        if(v==btnLeave){
            this.finish();
        }else {
            String nom = inputUsername.getEditText().getText().toString();
            String pswd =  inputPasswd.getEditText().getText().toString();
            if(nom.equalsIgnoreCase("oumaima")&&pswd.equals("0000")){
                Intent inte = new Intent(login.this,HomePage.class);
                inte.putExtra("Username", nom);
                startActivity(inte);
            }
            else{
                //lancer un msg d'errreur
                Toast.makeText(login.this,"wrong username or password",Toast.LENGTH_SHORT).show();
            }
        }
    }
}