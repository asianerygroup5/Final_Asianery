package com.example.asianery5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class lbahrain extends AppCompatActivity {
    private Button btnback,btnhome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lbahrain);

        btnback=(Button)findViewById(R.id.btnback);
        btnhome=(Button)findViewById(R.id.btnhome);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent=new Intent(getApplicationContext(),bahrain.class);
                startActivity(startIntent);
                finish();
            }
        });
        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent=new Intent(getApplicationContext(),home.class);
                startActivity(startIntent);
                finish();
            }
        });
    }
}