package com.apps.hasal.sertumservingcustomerapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Button;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;


public class SelectItems extends AppCompatActivity {

    ConstraintLayout myLayout;
    AnimationDrawable animationDrawable;

    TextView t;

    TextView display_Result1;
    TextView display_Result2;
    TextView display_Result3;
    TextView display_Result4;
    TextView display_Result5;
    TextView mdisplayTableNum;

    Spinner sp1_1;
    Spinner sp1_2;
    Spinner sp2_1;
    Spinner sp2_2;
    Spinner sp3_1;
    Spinner sp3_2;
    Spinner sp4_1;
    Spinner sp4_2;
    Spinner sp5_1;
    Spinner sp5_2;
    Spinner mspTbl;

    private Firebase mRootRef;
    private Firebase mChildRef;

    String names[] = {" ","Chicken Burger","Fish Bun","Fish Puff","Hot Dog","Chicken Puff","Iced Coffee","Orange Juice","Falooda","Apple Juice","Mixed-Fruit Juice"};
    String numbers[] = {" ","1","2","3","4","5","6","7","8","9","10"};
    String tNums[] = {"1","2","3","4"};

    ArrayAdapter<String> adapter1;
    ArrayAdapter<String> adapter2;
    ArrayAdapter<String> adapter3;
    ArrayAdapter<String> adapter4;
    ArrayAdapter<String> adapter5;
    ArrayAdapter<String> adapter6;
    ArrayAdapter<String> adapter7;
    ArrayAdapter<String> adapter8;
    ArrayAdapter<String> adapter9;
    ArrayAdapter<String> adapter10;
    ArrayAdapter<String> adapterTbl;


    String record= null;
    String record1= null;
    String record2= null;
    String record3= null;
    String record4= null;
    String record5= null;
    String record6= null;
    String record7= null;
    String record8= null;
    String record9= null;
    String recordTbl = null;


    private Button mAddBtn1;
    private Button mAddBtn2;
    private Button mAddBtn3;
    private Button mAddBtn4;
    private Button mAddBtn5;
    private Button mAddAnotherBtn1;
    private Button mAddAnotherBtn2;
    private Button mAddAnotherBtn3;
    private Button mAddAnotherBtn4;
    private Button mOrderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_items);

        display_Result1 = findViewById(R.id.displayResult1);
        display_Result2 = findViewById(R.id.displayResult2);
        display_Result3 = findViewById(R.id.displayResult3);
        display_Result4 = findViewById(R.id.displayResult4);
        display_Result5 = findViewById(R.id.displayResult5);
        mdisplayTableNum = findViewById(R.id.displayTableNum);
        mOrderButton = findViewById(R.id.OrderButton);

        t = findViewById(R.id.textView1);
        mspTbl = findViewById(R.id.tblSpin);

        Typeface myCustomFont = Typeface.createFromAsset(getAssets(),"fonts/FRADMCN.TTF");


        t.setTypeface(myCustomFont);
        display_Result1.setTypeface(myCustomFont);
        display_Result2.setTypeface(myCustomFont);
        display_Result3.setTypeface(myCustomFont);
        display_Result4.setTypeface(myCustomFont);
        display_Result5.setTypeface(myCustomFont);
        mdisplayTableNum.setTypeface(myCustomFont);



        sp1_1 = findViewById(R.id.spinner1_1);
        sp1_2 = findViewById(R.id.spinner1_2);

        mAddBtn1 = findViewById(R.id.addBtn1);
        mAddAnotherBtn1 = findViewById(R.id.addAnotherItem1);
        mAddAnotherBtn1.setVisibility(View.INVISIBLE);

        sp2_1 = findViewById(R.id.spinner2_1);
        sp2_2 = findViewById(R.id.spinner2_2);
        sp2_1.setVisibility(View.INVISIBLE);
        sp2_2.setVisibility(View.INVISIBLE);

        mAddBtn2 = findViewById(R.id.addBtn2);
        mAddBtn2.setVisibility(View.INVISIBLE);
        mAddAnotherBtn2 = findViewById(R.id.addAnotherItem2);
        mAddAnotherBtn2.setVisibility(View.INVISIBLE);

        sp3_1 = findViewById(R.id.spinner3_1);
        sp3_2 = findViewById(R.id.spinner3_2);
        sp3_1.setVisibility(View.INVISIBLE);
        sp3_2.setVisibility(View.INVISIBLE);

        mAddBtn3 = findViewById(R.id.addBtn3);
        mAddBtn3.setVisibility(View.INVISIBLE);
        mAddAnotherBtn3 = findViewById(R.id.addAnotherItem3);
        mAddAnotherBtn3.setVisibility(View.INVISIBLE);

        sp4_1 = findViewById(R.id.spinner4_1);
        sp4_2 = findViewById(R.id.spinner4_2);
        sp4_1.setVisibility(View.INVISIBLE);
        sp4_2.setVisibility(View.INVISIBLE);

        mAddBtn4 = findViewById(R.id.addBtn4);
        mAddBtn4.setVisibility(View.INVISIBLE);
        mAddAnotherBtn4 = findViewById(R.id.addAnotherItem4);
        mAddAnotherBtn4.setVisibility(View.INVISIBLE);

        sp5_1 = findViewById(R.id.spinner5_1);
        sp5_2 = findViewById(R.id.spinner5_2);
        sp5_1.setVisibility(View.INVISIBLE);
        sp5_2.setVisibility(View.INVISIBLE);

        mAddBtn5 = findViewById(R.id.addBtn5);
        mAddBtn5.setVisibility(View.INVISIBLE);

        mRootRef = new Firebase("https://sertum-serving-customer-app.firebaseio.com/Orders");

        adapterTbl = new ArrayAdapter(this, android.R.layout.simple_list_item_single_choice ,tNums);

        mspTbl.setAdapter(adapterTbl);
        mspTbl.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        recordTbl = "1";
                        break;
                    case 1:
                        recordTbl = "2";
                        break;
                    case 2:
                        recordTbl = "3";
                        break;
                    case 3:
                        recordTbl = "4";
                        break;
                    case 4:
                        recordTbl = "5";
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });


        adapter1 = new ArrayAdapter(this, android.R.layout.simple_list_item_1,names);

        sp1_1.setAdapter(adapter1);
        sp1_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        record = "0";
                        break;
                    case 1:
                        record = "Chicken Burger";
                        break;
                    case 2:
                        record = "Fish Bun";
                        break;
                    case 3:
                        record = "Fish Puff";
                        break;
                    case 4:
                        record = "Hot Dog";
                        break;
                    case 5:
                        record = "Chicken Puff";
                        break;
                    case 6:
                        record = "Iced Coffee";
                        break;
                    case 7:
                        record = "Orange Juice";
                        break;
                    case 8:
                        record = "Falooda";
                        break;
                    case 9:
                        record = "Apple Juice";
                        break;
                    case 10:
                        record = "Mixed-Fruit Juice";
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        adapter2 = new ArrayAdapter(this, android.R.layout.simple_list_item_1,numbers);

        sp1_2.setAdapter(adapter2);
        sp1_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        record1 = "0";
                        break;
                    case 1:
                        record1 = "1";
                        break;
                    case 2:
                        record1 = "2";
                        break;
                    case 3:
                        record1 = "3";
                        break;
                    case 4:
                        record1 = "4";
                        break;
                    case 5:
                        record1 = "5";
                        break;
                    case 6:
                        record1 = "6";
                        break;
                    case 7:
                        record1 = "7";
                        break;
                    case 8:
                        record1 = "8";
                        break;
                    case 9:
                        record1 = "9";
                        break;
                    case 10:
                        record1 = "10";
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        adapter3 = new ArrayAdapter(this, android.R.layout.simple_list_item_1,names);

        sp2_1.setAdapter(adapter3);
        sp2_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        record2 = "0";
                        break;
                    case 1:
                        record2 = "Chicken Burger";
                        break;
                    case 2:
                        record2 = "Fish Bun";
                        break;
                    case 3:
                        record2 = "Fish Puff";
                        break;
                    case 4:
                        record2 = "Hot Dog";
                        break;
                    case 5:
                        record2 = "Chicken Puff";
                        break;
                    case 6:
                        record2 = "Iced Coffee";
                        break;
                    case 7:
                        record2 = "Orange Juice";
                        break;
                    case 8:
                        record2 = "Falooda";
                        break;
                    case 9:
                        record2 = "Apple Juice";
                        break;
                    case 10:
                        record2 = "Mixed-Fruit Juice";
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        adapter4 = new ArrayAdapter(this, android.R.layout.simple_list_item_1,numbers);

        sp2_2.setAdapter(adapter4);
        sp2_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        record3 = "0";
                        break;
                    case 1:
                        record3 = "1";
                        break;
                    case 2:
                        record3 = "2";
                        break;
                    case 3:
                        record3 = "3";
                        break;
                    case 4:
                        record3 = "4";
                        break;
                    case 5:
                        record3 = "5";
                        break;
                    case 6:
                        record3 = "6";
                        break;
                    case 7:
                        record3 = "7";
                        break;
                    case 8:
                        record3 = "8";
                        break;
                    case 9:
                        record3 = "9";
                        break;
                    case 10:
                        record3 = "10";
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        adapter5 = new ArrayAdapter(this, android.R.layout.simple_list_item_1,names);

        sp3_1.setAdapter(adapter5);
        sp3_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        record4 = "0";
                        break;
                    case 1:
                        record4 = "Chicken Burger";
                        break;
                    case 2:
                        record4 = "Fish Bun";
                        break;
                    case 3:
                        record4 = "Fish Puff";
                        break;
                    case 4:
                        record4 = "Hot Dog";
                        break;
                    case 5:
                        record4 = "Chicken Puff";
                        break;
                    case 6:
                        record4 = "Iced Coffee";
                        break;
                    case 7:
                        record4 = "Orange Juice";
                        break;
                    case 8:
                        record4 = "Falooda";
                        break;
                    case 9:
                        record4 = "Apple Juice";
                        break;
                    case 10:
                        record4 = "Mixed-Fruit Juice";
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        adapter6 = new ArrayAdapter(this, android.R.layout.simple_list_item_1,numbers);

        sp3_2.setAdapter(adapter6);
        sp3_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        record5 = "0";
                        break;
                    case 1:
                        record5 = "1";
                        break;
                    case 2:
                        record5 = "2";
                        break;
                    case 3:
                        record5 = "3";
                        break;
                    case 4:
                        record5 = "4";
                        break;
                    case 5:
                        record5 = "5";
                        break;
                    case 6:
                        record5 = "6";
                        break;
                    case 7:
                        record5 = "7";
                        break;
                    case 8:
                        record5 = "8";
                        break;
                    case 9:
                        record5 = "9";
                        break;
                    case 10:
                        record5 = "10";
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        adapter7 = new ArrayAdapter(this, android.R.layout.simple_list_item_1,names);

        sp4_1.setAdapter(adapter7);
        sp4_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        record6 = "0";
                        break;
                    case 1:
                        record6 = "Chicken Burger";
                        break;
                    case 2:
                        record6 = "Fish Bun";
                        break;
                    case 3:
                        record6 = "Fish Puff";
                        break;
                    case 4:
                        record6 = "Hot Dog";
                        break;
                    case 5:
                        record6 = "Chicken Puff";
                        break;
                    case 6:
                        record6 = "Iced Coffee";
                        break;
                    case 7:
                        record6 = "Orange Juice";
                        break;
                    case 8:
                        record6 = "Falooda";
                        break;
                    case 9:
                        record6 = "Apple Juice";
                        break;
                    case 10:
                        record6 = "Mixed-Fruit Juice";
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        adapter8 = new ArrayAdapter(this, android.R.layout.simple_list_item_1,numbers);

        sp4_2.setAdapter(adapter8);
        sp4_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        record7 = "0";
                        break;
                    case 1:
                        record7 = "1";
                        break;
                    case 2:
                        record7 = "2";
                        break;
                    case 3:
                        record7 = "3";
                        break;
                    case 4:
                        record7 = "4";
                        break;
                    case 5:
                        record7 = "5";
                        break;
                    case 6:
                        record7 = "6";
                        break;
                    case 7:
                        record7 = "7";
                        break;
                    case 8:
                        record7 = "8";
                        break;
                    case 9:
                        record7 = "9";
                        break;
                    case 10:
                        record7 = "10";
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        adapter9 = new ArrayAdapter(this, android.R.layout.simple_list_item_1,names);

        sp5_1.setAdapter(adapter9);
        sp5_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        record8 = "0";
                        break;
                    case 1:
                        record8 = "Chicken Burger";
                        break;
                    case 2:
                        record8 = "Fish Bun";
                        break;
                    case 3:
                        record8 = "Fish Puff";
                        break;
                    case 4:
                        record8 = "Hot Dog";
                        break;
                    case 5:
                        record8 = "Chicken Puff";
                        break;
                    case 6:
                        record8 = "Iced Coffee";
                        break;
                    case 7:
                        record8 = "Orange Juice";
                        break;
                    case 8:
                        record8 = "Falooda";
                        break;
                    case 9:
                        record8 = "Apple Juice";
                        break;
                    case 10:
                        record8 = "Mixed-Fruit Juice";
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        adapter10 = new ArrayAdapter(this, android.R.layout.simple_list_item_1,numbers);

        sp5_2.setAdapter(adapter10);
        sp5_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        record9 = "0";
                        break;
                    case 1:
                        record9 = "1";
                        break;
                    case 2:
                        record9 = "2";
                        break;
                    case 3:
                        record9 = "3";
                        break;
                    case 4:
                        record9 = "4";
                        break;
                    case 5:
                        record9 = "5";
                        break;
                    case 6:
                        record9 = "6";
                        break;
                    case 7:
                        record9 = "7";
                        break;
                    case 8:
                        record9 = "8";
                        break;
                    case 9:
                        record9 = "9";
                        break;
                    case 10:
                        record9 = "10";
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        myLayout = findViewById(R.id.myLayout);
        animationDrawable = (AnimationDrawable) myLayout.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();

        mOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String key = recordTbl;
                String val1 = " ";
                String val2 = " ";
                String val3 = " ";
                String val4 = " ";
                String val5 = " ";

                if(Integer.parseInt(record1) != 1 && Integer.parseInt(record1) != 0) {
                    val1 = record1 + " " + record + "s, ";
                }
                else{
                    if(Integer.parseInt(record1) != 0){
                        val1 =record1 + " " + record+", ";
                    }
                }

                if(Integer.parseInt(record3) != 1 && Integer.parseInt(record3) != 0) {
                    val2 = record3 + " " + record2 + "s, ";
                }
                else{
                    if(Integer.parseInt(record3) != 0){
                    val2 = record3 + " " + record2+", ";
                    }
                 }

                if(Integer.parseInt(record5) != 1 && Integer.parseInt(record5) != 0) {
                    val3 = record5 + " " + record4 + "s, ";
                }
                else{
                    if(Integer.parseInt(record5) != 0){
                    val3 = record5 + " " + record4+", ";
                    }
                 }

                if(Integer.parseInt(record7) != 1 && Integer.parseInt(record7) != 0) {
                    val4 = record7 + " " + record6 + "s, ";
                }
                else{
                    if(Integer.parseInt(record7) != 0){
                    val4 = record7 + " " + record6+", ";
                    }
                 }

                if(Integer.parseInt(record9) != 1 && Integer.parseInt(record9) != 0) {
                    val5 = record9 + " " + record8 + "s";
                }
                else{
                    if(Integer.parseInt(record9) != 0){
                    val5 = record9 + " " + record8;
                    }
                 }

                String tVal = val1+val2+val3+val4+val5;

                mChildRef = mRootRef.child(key);
                mChildRef.setValue(tVal);
                String testText = display_Result1.toString();

                Intent intent = new Intent(SelectItems.this,display_Activity.class);
                startActivity(intent);



            }
        });

    }
/*    public void displayResult(View view){
        if(record9!=null && record8!=null) {
            display_Result.setText("You have ordered\n\n"+record1 + " " + record + "/s\n"+record3 + " " + record2 + "/s\n"+record5 + " " + record4 + "/s\n"+record7 + " " + record6 + "/s\n"+record9 + " " + record8 + "/s");
        }
        else if(record7!=null && record6!=null) {
            display_Result.setText("You have ordered\n\n"+record1 + " " + record + "/s\n"+record3 + " " + record2 + "/s\n"+record5 + " " + record4 + "/s\n"+record7 + " " + record6 + "/s\n");
        }
        else if(record5!=null && record4!=null) {
            display_Result.setText("You have ordered\n\n"+record1 + " " + record + "/s\n"+record3 + " " + record2 + "/s\n"+record5 + " " + record4 + "/s\n");
        }
        else if(record3!=null && record2!=null) {
            display_Result.setText("You have ordered\n\n"+record1 + " " + record + "/s\n"+record3 + " " + record2 + "/s\n");
        }
        else if(record1!=null && record!=null) {
            display_Result.setText("You have ordered\n\n"+record1 + " " + record+"/s");
        }

    }*/
    public void addBtn1Clicked(View view){

        if(Integer.parseInt(record1) != 1 && Integer.parseInt(record1) != 0) {
            String toPrint = "To Table "+recordTbl+", You have ordered\n" + record1 + " " + record + "s";
            display_Result1.setText(toPrint);
        }
        else{
            if(Integer.parseInt(record1) != 0){
            String toPrint ="To Table "+recordTbl+", You have ordered\n" + record1 + " " + record;
            display_Result1.setText(toPrint);
            }
        }
        mAddBtn1.setVisibility(View.GONE);
        mAddAnotherBtn1.setVisibility(View.VISIBLE);
    }

    public void addAnotherBtn1Clicked(View view){
        sp2_1.setVisibility(View.VISIBLE);
        sp2_2.setVisibility(View.VISIBLE);
        mAddBtn2.setVisibility(View.VISIBLE);
        mAddAnotherBtn1.setVisibility(View.GONE);
    }

    public void addBtn2Clicked(View view){
        if(Integer.parseInt(record3) != 1 && Integer.parseInt(record3) != 0) {
            String toPrint1 = record3 + " " + record2 + "s";
            display_Result2.setText(toPrint1);
        }
        else{
            if(Integer.parseInt(record3) != 0){
            String toPrint1 = record3 + " " + record2;
            display_Result2.setText(toPrint1);
            }
        }
        mAddBtn2.setVisibility(View.GONE);
        mAddAnotherBtn2.setVisibility(View.VISIBLE);
    }

    public void addAnotherBtn2Clicked(View view){
        sp3_1.setVisibility(View.VISIBLE);
        sp3_2.setVisibility(View.VISIBLE);
        mAddBtn3.setVisibility(View.VISIBLE);
        mAddAnotherBtn2.setVisibility(View.GONE);
    }

    public void addBtn3Clicked(View view){
        if(Integer.parseInt(record5) != 1 && Integer.parseInt(record5) != 0) {
            String toPrint2 = record5 + " " + record4 + "s";
            display_Result3.setText(toPrint2);
        }
        else{
            if(Integer.parseInt(record5) != 0){
            String toPrint2 =record5 + " " + record4;
            display_Result3.setText(toPrint2);
            }
        }
        mAddBtn3.setVisibility(View.GONE);
        mAddAnotherBtn3.setVisibility(View.VISIBLE);
    }

    public void addAnotherBtn3Clicked(View view){
        sp4_1.setVisibility(View.VISIBLE);
        sp4_2.setVisibility(View.VISIBLE);
        mAddBtn4.setVisibility(View.VISIBLE);
        mAddAnotherBtn3.setVisibility(View.GONE);
    }

    public void addBtn4Clicked(View view){
        if(Integer.parseInt(record7) != 1 && Integer.parseInt(record7) != 0) {
            String toPrint3 = record7 + " " + record6 + "s";
            display_Result4.setText(toPrint3);
        }
        else{
            if(Integer.parseInt(record7) != 0){
            String toPrint3 = record7 + " " + record6;
            display_Result4.setText(toPrint3);
            }
        }
        mAddBtn4.setVisibility(View.GONE);
        mAddAnotherBtn4.setVisibility(View.VISIBLE);
    }

    public void addAnotherBtn4Clicked(View view){
        sp5_1.setVisibility(View.VISIBLE);
        sp5_2.setVisibility(View.VISIBLE);
        mAddBtn5.setVisibility(View.VISIBLE);
        mAddAnotherBtn4.setVisibility(View.GONE);
    }

    public void addBtn5Clicked(View view){
        mAddBtn4.setVisibility(View.GONE);
        mAddBtn5.setVisibility(View.GONE);
        if(Integer.parseInt(record9) != 1 && Integer.parseInt(record9) != 0) {
            String toPrint4 = record9 + " " + record8 + "s";
            display_Result5.setText(toPrint4);
        }
        else{
            if(Integer.parseInt(record9) != 0){
            String toPrint4 =record9 + " " + record8;
            display_Result5.setText(toPrint4);
            }
        }
    }





}
