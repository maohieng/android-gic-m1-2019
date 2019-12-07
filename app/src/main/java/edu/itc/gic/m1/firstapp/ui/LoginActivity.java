package edu.itc.gic.m1.firstapp.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;

import edu.itc.gic.m1.firstapp.R;

/**
 * This class is used for ...
 *
 * @autor MAO Hieng 12/4/2019
 */
public class LoginActivity extends BaseActivity {

    Button mButtonSubmit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setTitle("Login");

        mButtonSubmit = findViewById(R.id.btnSubmit);
        mButtonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });
    }
}
