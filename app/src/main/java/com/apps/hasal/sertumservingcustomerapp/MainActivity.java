package com.apps.hasal.sertumservingcustomerapp;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout myLayout;
    AnimationDrawable animationDrawable;
    TextView t;

    private EditText mKeyValue;
    private EditText mValueField;
    private EditText mtable;
    private Button mAddBtn;

    private TextView mtextView2_2;
    private TextView mtextView2_3;
    private TextView mtextView3_2;
    private TextView mtextView3_3;
    private TextView mtextView4_2;
    private TextView mtextView4_3;
    private TextView mtextView5_2;
    private TextView mtextView5_3;
    private TextView mtextView6_2;
    private TextView mtextView6_3;

    private TextView mtextView2_2_2;
    private TextView mtextView2_2_3;
    private TextView mtextView2_3_2;
    private TextView mtextView2_3_3;
    private TextView mtextView2_4_2;
    private TextView mtextView2_4_3;
    private TextView mtextView2_5_2;
    private TextView mtextView2_5_3;
    private TextView mtextView2_6_2;
    private TextView mtextView2_6_3;

    private Firebase mRootRef;
    private Firebase mRootRef1;
    private Firebase mRootRef2;
    private Firebase mRootRef3;
    private Firebase mRootRef4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        t = (TextView) findViewById(R.id.sertum);

        Typeface myCustomFont = Typeface.createFromAsset(getAssets(),"fonts/ALGER.TTF");
        t.setTypeface(myCustomFont);
/*
        Typeface myCustomFont2 = Typeface.createFromAsset(getAssets(),"fonts/FRADMCN.TTF");
        t = (TextView) findViewById(R.id.textView25);
        t.setTypeface(myCustomFont2);
        t = (TextView) findViewById(R.id.textView26);
        t.setTypeface(myCustomFont2);
        t = (TextView) findViewById(R.id.textView27);
        t.setTypeface(myCustomFont2);
        t = (TextView) findViewById(R.id.tableNum);
        t.setTypeface(myCustomFont2);
*/


        myLayout = (ConstraintLayout) findViewById(R.id.myLayout);
        animationDrawable = (AnimationDrawable) myLayout.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();

        mtextView2_2 = (TextView) findViewById(R.id.textView2_2);
        mtextView2_3 = (TextView) findViewById(R.id.textView2_3);

        mRootRef1 = new Firebase("https://sertum-serving-customer-app.firebaseio.com/S01");
        mRootRef1.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String, String> map = dataSnapshot.getValue(Map.class);

                String item = map.get("Item");
                String price = map.get("Price");
                mtextView2_2.setText(item);
                mtextView2_3.setText(price);


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mtextView2_2 = (TextView) findViewById(R.id.textView2_2);
        mtextView2_3 = (TextView) findViewById(R.id.textView2_3);

        mtextView3_2 = (TextView) findViewById(R.id.textView3_2);
        mtextView3_3 = (TextView) findViewById(R.id.textView3_3);

        mRootRef1 = new Firebase("https://sertum-serving-customer-app.firebaseio.com/S02");
        mRootRef1.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String, String> map = dataSnapshot.getValue(Map.class);

                String item = map.get("Item");
                String price = map.get("Price");

                mtextView3_2.setText(item);
                mtextView3_3.setText(price);


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mtextView3_2 = (TextView) findViewById(R.id.textView3_2);
        mtextView3_3 = (TextView) findViewById(R.id.textView3_3);

        mtextView4_2 = (TextView) findViewById(R.id.textView4_2);
        mtextView4_3 = (TextView) findViewById(R.id.textView4_3);

        mRootRef1 = new Firebase("https://sertum-serving-customer-app.firebaseio.com/S03");
        mRootRef1.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String, String> map = dataSnapshot.getValue(Map.class);

                String item = map.get("Item");
                String price = map.get("Price");

                mtextView4_2.setText(item);
                mtextView4_3.setText(price);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mtextView4_2 = (TextView) findViewById(R.id.textView4_2);
        mtextView4_3 = (TextView) findViewById(R.id.textView4_3);

        mtextView5_2 = (TextView) findViewById(R.id.textView5_2);
        mtextView5_3 = (TextView) findViewById(R.id.textView5_3);

        mRootRef1 = new Firebase("https://sertum-serving-customer-app.firebaseio.com/S04");
        mRootRef1.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String, String> map = dataSnapshot.getValue(Map.class);

                String item = map.get("Item");
                String price = map.get("Price");

                mtextView5_2.setText(item);
                mtextView5_3.setText(price);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mtextView5_2 = (TextView) findViewById(R.id.textView5_2);
        mtextView5_3 = (TextView) findViewById(R.id.textView5_3);

        mtextView6_2 = (TextView) findViewById(R.id.textView6_2);
        mtextView6_3 = (TextView) findViewById(R.id.textView6_3);

        mRootRef1 = new Firebase("https://sertum-serving-customer-app.firebaseio.com/S05");
        mRootRef1.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String, String> map = dataSnapshot.getValue(Map.class);

                String item = map.get("Item");
                String price = map.get("Price");

                mtextView6_2.setText(item);
                mtextView6_3.setText(price);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mtextView6_2 = (TextView) findViewById(R.id.textView6_2);
        mtextView6_3 = (TextView) findViewById(R.id.textView6_3);

        mtextView2_2_2 = (TextView) findViewById(R.id.textView2_2_2);
        mtextView2_2_3 = (TextView) findViewById(R.id.textView2_2_3);

        mRootRef1 = new Firebase("https://sertum-serving-customer-app.firebaseio.com/B01");
        mRootRef1.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String, String> map = dataSnapshot.getValue(Map.class);

                String item = map.get("Item");
                String price = map.get("Price");
                mtextView2_2_2.setText(item);
                mtextView2_2_3.setText(price);


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mtextView2_2_2 = (TextView) findViewById(R.id.textView2_2_2);
        mtextView2_2_3 = (TextView) findViewById(R.id.textView2_2_3);

        mtextView2_3_2 = (TextView) findViewById(R.id.textView2_3_2);
        mtextView2_3_3 = (TextView) findViewById(R.id.textView2_3_3);

        mRootRef1 = new Firebase("https://sertum-serving-customer-app.firebaseio.com/B02");
        mRootRef1.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String, String> map = dataSnapshot.getValue(Map.class);

                String item = map.get("Item");
                String price = map.get("Price");

                mtextView2_3_2.setText(item);
                mtextView2_3_3.setText(price);


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mtextView2_3_2 = (TextView) findViewById(R.id.textView2_3_2);
        mtextView2_3_3 = (TextView) findViewById(R.id.textView2_3_3);

        mtextView2_4_2 = (TextView) findViewById(R.id.textView2_4_2);
        mtextView2_4_3 = (TextView) findViewById(R.id.textView2_4_3);

        mRootRef1 = new Firebase("https://sertum-serving-customer-app.firebaseio.com/B03");
        mRootRef1.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String, String> map = dataSnapshot.getValue(Map.class);

                String item = map.get("Item");
                String price = map.get("Price");

                mtextView2_4_2.setText(item);
                mtextView2_4_3.setText(price);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mtextView2_4_2 = (TextView) findViewById(R.id.textView2_4_2);
        mtextView2_4_3 = (TextView) findViewById(R.id.textView2_4_3);

        mtextView2_5_2 = (TextView) findViewById(R.id.textView2_5_2);
        mtextView2_5_3 = (TextView) findViewById(R.id.textView2_5_3);

        mRootRef1 = new Firebase("https://sertum-serving-customer-app.firebaseio.com/B04");
        mRootRef1.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String, String> map = dataSnapshot.getValue(Map.class);

                String item = map.get("Item");
                String price = map.get("Price");

                mtextView2_5_2.setText(item);
                mtextView2_5_3.setText(price);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mtextView2_5_2 = (TextView) findViewById(R.id.textView2_5_2);
        mtextView2_5_3 = (TextView) findViewById(R.id.textView2_5_3);

        mtextView2_6_2 = (TextView) findViewById(R.id.textView2_6_2);
        mtextView2_6_3 = (TextView) findViewById(R.id.textView2_6_3);

        mRootRef1 = new Firebase("https://sertum-serving-customer-app.firebaseio.com/B05");
        mRootRef1.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String, String> map = dataSnapshot.getValue(Map.class);

                String item = map.get("Item");
                String price = map.get("Price");

                mtextView2_6_2.setText(item);
                mtextView2_6_3.setText(price);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mtextView2_6_2 = (TextView) findViewById(R.id.textView2_6_2);
        mtextView2_6_3 = (TextView) findViewById(R.id.textView2_6_3);

        mAddBtn = (Button) findViewById(R.id.Btn);

        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SelectItems.class);
                startActivity(intent);



            }
        });


/*
        mKeyValue = (EditText) findViewById(R.id.itemCode);
        mValueField = (EditText) findViewById(R.id.quantity);
        mtable = (EditText) findViewById(R.id.table);


*/


    }

/*    public void onBackPressed() {
        return;
    }
    @Override
    protected void onPause() {
        super.onPause();

        ActivityManager activityManager = (ActivityManager) getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);

                activityManager.moveTaskToFront(getTaskId(),0);
    }*/
}
