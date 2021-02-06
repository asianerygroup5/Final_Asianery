package com.example.asianery5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home extends AppCompatActivity {
    private Button btnCountries,btngames,btnComment,btnabout,btnquit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnCountries = (Button) findViewById(R.id.btncountries);
        btngames = (Button) findViewById(R.id.btngames);
        btnComment = (Button) findViewById(R.id.btnComment);
        btnabout = (Button) findViewById(R.id.btnabout);
        btnquit = (Button) findViewById(R.id.btnquit);

        btnCountries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent=new Intent(getApplicationContext(),countrieschoices.class);
                startActivity(startIntent);
                finish();
            }
        });

        btngames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent=new Intent(getApplicationContext(),games.class);
                startActivity(startIntent);
                finish();
            }
        });

        btnComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent=new Intent(getApplicationContext(),comment.class);
                startActivity(startIntent);
                finish();
            }
        });
        btnabout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent=new Intent(getApplicationContext(),about.class);
                startActivity(startIntent);
                finish();
            }
        });

btnquit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(home.this);
        builder.setMessage("Are you sure you want to quit?").setCancelable(false).setPositiveButton(
                "Yes", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        moveTaskToBack(true);
                        android.os.Process.killProcess(android.os.Process.myPid());
                        System.exit(1);
                    }
                }).setNegativeButton(
                "No", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.setTitle("Alert");
        alert.show();

    }
});

    }
}