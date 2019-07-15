package com.example.android.alc4phase1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Button aboutButton;
    Button myProfileButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        aboutButton = findViewById(R.id.about_alc_button);
        aboutButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
               openWebpage();
            }
        });

        myProfileButton = findViewById(R.id.profile_button);
        myProfileButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                openProfilePage();
            }
        });

        }

        public void openWebpage(){
            Intent intent = new Intent(this, WebViewActivity.class);
            startActivity(intent);
    }

        public void openProfilePage(){
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
    }
        }




