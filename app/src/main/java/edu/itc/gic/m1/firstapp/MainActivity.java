package edu.itc.gic.m1.firstapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import edu.itc.gic.m1.firstapp.ui.DetailActivity;
import edu.itc.gic.m1.firstapp.ui.LoginActivity;
import edu.itc.gic.m1.firstapp.ui.ScrollingTextActivity;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    Button mButton;
    Button mBtnScrollingText;

    Button mButtonDetail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mButton = findViewById(R.id.button2); // object of button2
        mBtnScrollingText = findViewById(R.id.btnScrollingText);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startLogin();
            }
        });

        mButtonDetail = findViewById(R.id.buttonDetail);
        mButtonDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        mBtnScrollingText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScrollingTextActivity.class);
                startActivity(intent);
            }
        });

    }

    private void startLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivityForResult(intent, 12);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 12) { // result ok from login
                Log.i(TAG, "RESULT OK FROM LOGIN");
                finish();
            }
        }
    }

    //    public void clickRoll(View v) {
//        Toast.makeText(this, "Button roll is clicked.", Toast.LENGTH_SHORT).show();
//    }
}
