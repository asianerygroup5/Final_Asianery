package com.example.asianery5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class pakistan extends AppCompatActivity {
    private Button btnback,btnlandmark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pakistan);

        btnback=(Button)findViewById(R.id.btnback);
        btnlandmark=(Button)findViewById(R.id.btnlandmark);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent=new Intent(getApplicationContext(),countrieschoices.class);
                startActivity(startIntent);
                finish();
            }
        });
        btnlandmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent=new Intent(getApplicationContext(),lpakistan.class);
                startActivity(startIntent);
                finish();
            }
        });
    }
}