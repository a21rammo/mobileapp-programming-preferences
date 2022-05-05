package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private EditText nameEdit;
    private Button button;
    private SharedPreferences sh;
    private String nameStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        nameEdit = findViewById(R.id.nameEdit);
        button = findViewById(R.id.button);
        sh =  getSharedPreferences("UsersPrefs", Context.MODE_PRIVATE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameStr = nameEdit.getText().toString();
                SharedPreferences.Editor editor = sh.edit();

                editor.putString("name", nameStr);
                editor.commit();
                Toast.makeText(SecondActivity.this, "Information Saved", Toast.LENGTH_LONG).show();
            }
        });

    }

}