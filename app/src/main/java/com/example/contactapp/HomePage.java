package com.example.contactapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class HomePage extends AppCompatActivity {
    boolean write_permission = false;
private TextView txtWelcome;
Button btnShow, btnAdd;
    static ArrayList<Contact> data = new ArrayList<Contact>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        //a test for the  file permission

        if(ContextCompat.checkSelfPermission(HomePage.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
        {
            write_permission=true;
        }
        // else sauvegarder();
        importer();

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


//pour le sauvegarder sauvegarder le tableau dans un fichier
public  void sauvegarder(){
        if(write_permission){
        //sauvegarder(enregistrement dans le fichier)
        String chemin = Environment.getExternalStorageDirectory().getPath();
        //declaration d'un fichier
        File f = new File(chemin,"fichier.txt");

        try {
        //ouverture /creation du fichier
        FileWriter fw = new FileWriter(f,false);
        BufferedWriter bw = new BufferedWriter(fw);
        for(int i=0 ; i<HomePage.data.size(); i++)
        {
        bw.write(HomePage.data.get(i).name+","
        +HomePage.data.get(i).lastname+","
        +HomePage.data.get(i).number+"\n");

        }
        bw.close();
        fw.close();
        } catch (IOException e) {
        Log.e("error","erreur de sauvgarde"+e.getMessage());
        }
        }
        else{
        //demande d'autorisation permssion de type string tableau
        ActivityCompat.requestPermissions(HomePage.this,
        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        //requestPermissions: sert a affiche la boite de dialogue soit accepter soit refuser
        //gestion de resultat :voir onrequestpermssionResult
        }
        }
//lire from the file
public  void importer(){
        String chemin = Environment.getExternalStorageDirectory().getPath();
        //declaration d'un fichier
        File f = new File(chemin,"fichier.txt");
        if(f.exists()){
        try {
       FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        String ligne = null;
        while ((ligne = br.readLine())!=null) //lecture de ligne
        {
        String [] t = ligne.split(",");
        HomePage.data.add(new Contact(t[0],t[1],t[2]));
        }

        br.close();
        fr.close();

        } catch (IOException e) {
        Log.e("error","Fichier n'existe pas "+e.getMessage());
        }
        }
        }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==1){
            if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                write_permission=true;
                sauvegarder();
                //permission accordee
            }
            else{
                write_permission=false;
                Toast.makeText(this,"persmisssion non accordee, pas de sauvegarde",Toast.LENGTH_SHORT).show();
            }
        }



    }
}