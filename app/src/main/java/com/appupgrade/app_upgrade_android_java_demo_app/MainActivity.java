package com.appupgrade.app_upgrade_android_java_demo_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppUpgrade appUpgrade = new AppUpgrade();
        appUpgrade.checkForUpdate(this);
    }
}