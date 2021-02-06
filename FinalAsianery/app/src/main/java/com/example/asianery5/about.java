package com.example.asianery5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class about extends AppCompatActivity {
    private Button btnback,btnreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        btnback=(Button)findViewById(R.id.btnback);
        btnreferences=(Button)findViewById(R.id.btnreferences);


        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent=new Intent(getApplicationContext(),home.class);
                startActivity(startIntent);
                finish();
            }
        });

        btnreferences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent=new Intent(getApplicationContext(),references.class);
                startActivity(startIntent);
                finish();
            }
        });
    }
}