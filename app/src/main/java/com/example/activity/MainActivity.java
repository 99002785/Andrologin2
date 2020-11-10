package com.example.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = HomeActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i(TAG,"onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"onpause");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"onresume");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"onstop");

    }

    public void clickHandler(View view) {
        Log.e(TAG,"clickHandler");
        switch(view.getId()){
            case R.id.login:
                startHome();
                break;
            case R.id.cancel:
                dailermeth();
                break;
        }


    }

    private void dailermeth() {
        Intent intentNew = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:12345678"));
        startActivity(intentNew);
    }

    private void startHome() {
        Intent hIntent = new Intent(MainActivity.this, HomeActivity.class);
        hIntent.putExtra("myKey","Visva");
        int c = add(10,20);
        startActivity(hIntent);
    }

    private  int add(int a, int b){
        return a+b;
    }
}