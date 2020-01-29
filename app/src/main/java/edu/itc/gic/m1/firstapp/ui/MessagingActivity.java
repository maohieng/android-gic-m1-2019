package edu.itc.gic.m1.firstapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import edu.itc.gic.m1.firstapp.MainActivity;
import edu.itc.gic.m1.firstapp.R;
import edu.itc.gic.m1.firstapp.model.Message;

/**
 * This class is used for ...
 *
 * @autor MAO Hieng 12/25/2019
 */
public class MessagingActivity extends BaseActivity {

    TextView receivedText;
    TextView createdDateText;
    EditText replyText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messaging);

        receivedText = findViewById(R.id.textMessageReceived);
        createdDateText = findViewById(R.id.textDate);
        replyText = findViewById(R.id.editReply);

        // receive object from MainActivity
//        String message = getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE_NAME);
        Message message = (Message) getIntent().getSerializableExtra(MainActivity.EXTRA_MESSAGE_NAME);

        // set UIs
        receivedText.setText(message.getMessage());
        createdDateText.setText(message.getCreatedDate().toString());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static final String EXTRA_REPLY_MESSAGE = "EXTRA-REPLY-MESSAGE";

    public void clickReplyMessage(View view) {
        String replyMessage = replyText.getText().toString();

        if (!replyMessage.isEmpty()) {
            Intent data = new Intent();
            data.putExtra(EXTRA_REPLY_MESSAGE, replyMessage);
            setResult(RESULT_OK, data);
            finish();
        }
    }
}
