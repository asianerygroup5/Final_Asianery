package com.example.asianery5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class add extends AppCompatActivity {
   private Button btnback;
    OpenHelper openHelper;
    String CName;
    String CDescription;
    String CExperience;
    String PName;
    SQLiteDatabase sqLiteDatabase;
    EditText editName;
    EditText editDescription;
    EditText editExperience;
    EditText editPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);


        openHelper = new OpenHelper(this);
        sqLiteDatabase = openHelper.getWritableDatabase();
        editName = findViewById(R.id.countryName);
        editDescription = findViewById(R.id.countryDescription);
        editExperience = findViewById(R.id.countryExperience);
        editPerson = findViewById(R.id.personName);
        btnback = (Button) findViewById(R.id.btnback);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent=new Intent(getApplicationContext(),comment.class);
                startActivity(startIntent);
                finish();
            }
        });

    }


    public void clickAdd(View view) {
        CName= editName.getText().toString();
        CDescription = editDescription.getText().toString();
        CExperience = editExperience.getText().toString();
        PName = editPerson.getText().toString();


        if(TextUtils.isEmpty(CName) || TextUtils.isEmpty(CDescription) || TextUtils.isEmpty(CExperience) || TextUtils.isEmpty(PName)) {
            Toast.makeText(this, "Required Fields", Toast.LENGTH_SHORT).show();
        }
        else
        {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DatabaseInfo._ID, (byte[]) null);
            contentValues.put(DatabaseInfo.CountryName, CName);
            contentValues.put(DatabaseInfo.CountryDescription, CDescription);
            contentValues.put(DatabaseInfo.CountryExperience, CExperience);
            contentValues.put(DatabaseInfo.PersonName, PName);
            long rowId = sqLiteDatabase.insert(DatabaseInfo.TABLE_NAME, null, contentValues);

            if (rowId != -1) {
                Toast.makeText(this, "Record Added",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,comment.class));
                finish();
            }
            else {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
            }
        }


    }
}