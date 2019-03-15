package com.apps.hasal.sertumservingcustomerapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class display_Activity extends AppCompatActivity {

    TextView t;
    Button mBackToThMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_);

        t = findViewById(R.id.disConfMsg);

        Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "fonts/FRADMCN.TTF");
        t.setTypeface(myCustomFont);

        mBackToThMenu = findViewById(R.id.backToTheMenu);
        mBackToThMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(display_Activity.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }
}
