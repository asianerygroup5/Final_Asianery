package com.example.asianery5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class comment extends AppCompatActivity {
    private Button btnback;
    OpenHelper dbHelper;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter userAdapter;
    private RecyclerView.LayoutManager layoutManager;
    Button btnRegister;

    List<POJO> asianerytDetails;
    SQLiteDatabase sqLiteDatabase;

    public comment() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        btnback = (Button) findViewById(R.id.btnback);
        dbHelper = new OpenHelper(this);
        sqLiteDatabase= dbHelper.getReadableDatabase();
        recyclerView = (RecyclerView) findViewById(R.id.recycler);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent=new Intent(getApplicationContext(),home.class);
                startActivity(startIntent);
                finish();
            }
        });

       asianerytDetails = new ArrayList<POJO>();
       asianerytDetails.clear();
        Cursor c1 = sqLiteDatabase.query(DatabaseInfo.TABLE_NAME,null,null,null,null,null,null);
        if(c1 != null && c1.getCount() != 0) {
            asianerytDetails.clear();
            while (c1.moveToNext()) {
                POJO asiaDetails = new POJO();

                asiaDetails.setS_id(c1.getInt(c1.getColumnIndex(DatabaseInfo._ID)));
                asiaDetails.setC_name(c1.getString(c1.getColumnIndex(DatabaseInfo.CountryName)));
                asiaDetails.setC_description(c1.getString(c1.getColumnIndex(DatabaseInfo.CountryDescription)));
                asiaDetails.setC_experience(c1.getString(c1.getColumnIndex(DatabaseInfo.CountryExperience)));
                asiaDetails.setP_name(c1.getString(c1.getColumnIndex(DatabaseInfo.PersonName)));
                asianerytDetails.add(asiaDetails);
            }
        }

        c1.close();
        layoutManager = new LinearLayoutManager(this);
        userAdapter = new RecycleAdapter(asianerytDetails);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(userAdapter);
    }
    //    @Override
//    protected void onDestory() {
//        sqLiteDatabase.close();
//        super.onDestroy();
//    }
    public void clickAddStudent (View view) {
        startActivity(new Intent(this, add.class));
        this.finish();
    }


}