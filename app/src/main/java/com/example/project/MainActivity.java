package com.example.project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private SharedPreferences sh;
    private SharedPreferences.Editor myPreferenceEditor;
    private TextView  name;
    private String nameStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });

        name = findViewById(R.id.showName);
        SharedPreferences sh = getApplicationContext().getSharedPreferences("UsersPrefs", Context.MODE_PRIVATE);
        nameStr = sh.getString("name", "");

        name.setText(nameStr);

    }
}
