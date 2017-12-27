package com.technotalkative.beproject;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

public class Login extends AppCompatActivity implements View.OnClickListener {
    EditText user, pass, association;
    Button blogin, bregister;
    String associate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        user = (EditText) findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.pass);
        association = (EditText) findViewById(R.id.association);
        blogin = (Button) findViewById(R.id.blogin);
        bregister = (Button) findViewById(R.id.bregister);
        bregister.setOnClickListener(this);
        blogin.setOnClickListener(this);

    }

    public void onClick(View v) {

        int i = v.getId();
        switch (i) {
            case R.id.blogin:
                System.out.println("CLICKED ");
                String username = user.getText().toString();
                String password = pass.getText().toString();
                associate = association.getText().toString();
                String type = "login";
                BackgroundWorker backgroundWorker = new BackgroundWorker(this);
                backgroundWorker.execute(type, username, password, associate);
                break;

            case R.id.bregister:
                Intent in = new Intent(Login.this, Register.class);
                startActivity(in);
                break;
        }

    }


    @Override
    public  void onBackPressed() {
// TODO Auto-generated method stub
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // builder.setCancelable(false);
        builder.setMessage("Do you want to Exit?");
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                Toast.makeText(Login.this, "Yes i wanna exit", Toast.LENGTH_LONG).show();
                moveTaskToBack(true);
                Login.this.finish();
                System.exit(0);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                Toast.makeText(Login.this, "T want stay on this page", Toast.LENGTH_LONG).show();
                dialog.cancel();

            }
        });
        AlertDialog alert = builder.create();
        alert.show();
        //super.onBackPressed();
    }
}
