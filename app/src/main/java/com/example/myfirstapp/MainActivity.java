package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView firstTextView = findViewById(R.id.first_text);
        firstTextView.setText("Primer mensaje de la app");

        Button firstButton = findViewById(R.id.first_button);
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listIntent = new Intent(view.getContext(), ListActivity.class);
                startActivity(listIntent);
            }
        });

    }


}
