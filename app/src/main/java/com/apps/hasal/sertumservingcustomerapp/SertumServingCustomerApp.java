package com.apps.hasal.sertumservingcustomerapp;

import android.app.Application;

import com.firebase.client.Firebase;

public class SertumServingCustomerApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
