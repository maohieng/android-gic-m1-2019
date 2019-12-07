package edu.itc.gic.m1.firstapp.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import edu.itc.gic.m1.firstapp.R;

/**
 * This class is used for ...
 *
 * @autor MAO Hieng 12/4/2019
 */
public class DetailActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        setTitle("Detail Activity");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("DetailActivity", "onStart()--------");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("DetailActivity", "onResume()--------");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("DetailActivity", "onPause()--------");
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
