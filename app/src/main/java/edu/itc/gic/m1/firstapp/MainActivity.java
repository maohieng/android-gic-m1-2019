package edu.itc.gic.m1.firstapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import edu.itc.gic.m1.firstapp.model.Message;
import edu.itc.gic.m1.firstapp.ui.DetailActivity;
import edu.itc.gic.m1.firstapp.ui.LoginActivity;
import edu.itc.gic.m1.firstapp.ui.MessagingActivity;
import edu.itc.gic.m1.firstapp.ui.ScrollingTextActivity;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    public static final String EXTRA_MESSAGE_NAME = "EXTRA_MESSAGE";

    Button mButton;
    Button mBtnScrollingText;

    Button mButtonDetail;

    EditText editMessage;
    TextView textReply;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mButton = findViewById(R.id.button2); // object of button2
        mBtnScrollingText = findViewById(R.id.btnScrollingText);

        editMessage = findViewById(R.id.editMessage);
        textReply = findViewById(R.id.textReply);

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
            switch (requestCode) {
                case 12:
                    Log.i(TAG, "RESULT OK FROM LOGIN");
                    finish();
                    break;
                case 72:
                    assert data != null;
                    String reply = data.getStringExtra(MessagingActivity.EXTRA_REPLY_MESSAGE);
                    textReply.setText(reply);
                    break;
            }
        }
    }

    public void clickSendMessage(View view) {
        String message = editMessage.getText().toString();

        Message messageModel = new Message(message);

        if (!message.isEmpty()) {

            Intent intent = new Intent(this, MessagingActivity.class);
            intent.putExtra(EXTRA_MESSAGE_NAME, messageModel);
            startActivityForResult(intent, 72);
        }
    }

    //    public void clickRoll(View v) {
//        Toast.makeText(this, "Button roll is clicked.", Toast.LENGTH_SHORT).show();
//    }
}
