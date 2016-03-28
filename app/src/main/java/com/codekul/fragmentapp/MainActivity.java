package com.codekul.fragmentapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        runFragmentTransaction(R.id.frameMenuContainer, BlankFragment.getInstance());

        runFragmentTransaction(R.id.frameContentContainer, ContentFragment.getInstance("India"));
    }

    public void runFragmentTransaction(Integer containerId, Fragment fragment){

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction txn = manager.beginTransaction();
        txn.replace(containerId,fragment);
        txn.commit();
    }
}
