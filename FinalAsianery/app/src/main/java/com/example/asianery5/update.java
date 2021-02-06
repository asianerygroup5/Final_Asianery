package com.example.asianery5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class update extends AppCompatActivity {
    private Button btnback;
    EditText updateCName;
    EditText updateCDescription;
    EditText updateCExperience;
    EditText updatePName;
    String CName;
    String CDescription;
    String CExperience;
    String PName;

    List<POJO> asianeryDetails;
    OpenHelper openHelper;
    SQLiteDatabase sqLiteDatabase;

    int rowId=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update);


        openHelper = new OpenHelper(this);
        sqLiteDatabase = openHelper.getWritableDatabase();
        updateCName = findViewById(R.id.update_countryName);
        updateCDescription = findViewById(R.id.update_countryDescription);
        updateCExperience = findViewById(R.id.update_countryExperience);
        updatePName = findViewById(R.id.update_personName);
        btnback = (Button) findViewById(R.id.btnback);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent=new Intent(getApplicationContext(),comment.class);
                startActivity(startIntent);
                finish();
            }
        });


        rowId = getIntent().getIntExtra("stuId", -1);

        Cursor cursor = sqLiteDatabase.query(DatabaseInfo.TABLE_NAME, null, DatabaseInfo._ID + " = " + rowId, null, null,null, null);
        asianeryDetails = new ArrayList<POJO>();
        asianeryDetails.clear();

        if(cursor != null && cursor.getCount() != 0) {
            while(cursor.moveToNext()) {
                updateCName.setText(cursor.getString(cursor.getColumnIndex(DatabaseInfo.CountryName)));
                updateCDescription.setText(cursor.getString(cursor.getColumnIndex(DatabaseInfo.CountryDescription)));
                updateCExperience.setText(cursor.getString(cursor.getColumnIndex(DatabaseInfo.CountryExperience)));
                updatePName.setText(cursor.getString(cursor.getColumnIndex(DatabaseInfo.PersonName)));
            }
        }
        else {
            Toast.makeText(this, "No Data Found!", Toast.LENGTH_SHORT).show();
        }

    }
    public void clickUpdate(View view) {
        CName = updateCName.getText().toString();
        CDescription = updateCDescription.getText().toString();
        CExperience = updateCExperience.getText().toString();
        PName = updatePName.getText().toString();

        if (TextUtils.isEmpty(CName) || TextUtils.isEmpty(CDescription) || TextUtils.isEmpty(CExperience) || TextUtils.isEmpty(PName)) {
            Toast.makeText(this, "Check the Empty Fields", Toast.LENGTH_LONG).show();
        }
        else {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DatabaseInfo.CountryName, CName);
            contentValues.put(DatabaseInfo.CountryDescription, CDescription);
            contentValues.put(DatabaseInfo.CountryExperience, CExperience);
            contentValues.put(DatabaseInfo.PersonName, PName);

            int updateId = sqLiteDatabase.update(DatabaseInfo.TABLE_NAME, contentValues, DatabaseInfo._ID + " = " + rowId, null);
            if(updateId != -1) {
                Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, comment.class));
                finish();
            }
            else {
                Toast.makeText(this, "Not Updated!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onDestroy() {
        sqLiteDatabase.close();
        super.onDestroy();



    }
}