package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private EditText nameEdit;
    private Button saveBtn, returnBtn;
    private SharedPreferences sh;
    private String nameStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        nameEdit = findViewById(R.id.nameEdit);
        saveBtn = findViewById(R.id.saveBtn);
        returnBtn = findViewById(R.id.returnBtn);

        sh =  getSharedPreferences("UsersPrefs", Context.MODE_PRIVATE);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameStr = nameEdit.getText().toString();
                SharedPreferences.Editor editor = sh.edit();

                editor.putString("name", nameStr);
                editor.apply();
                Toast.makeText(SecondActivity.this, "Information Saved", Toast.LENGTH_LONG).show();
            }
        });

        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondActivity.this, MainActivity.class));
            }
        });

    }

}