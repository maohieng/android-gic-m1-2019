package edu.itc.gic.m1.firstapp.implicit_intent;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.app.ShareCompat;

import edu.itc.gic.m1.firstapp.R;
import edu.itc.gic.m1.firstapp.ui.BaseActivity;

/**
 * This class is used for ...
 *
 * @autor MAO Hieng 1/7/2020
 */
public class ImplicitIntentDemoActivity extends BaseActivity {

    private static final String TAG = "ImplicitIntentDemo";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);
        setTitle("Implicit Intents");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_share, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menuShare) {
            clickShareText(null);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ImageView imageView = findViewById(R.id.imageView1);
            imageView.setImageBitmap(imageBitmap);
        }
    }

    public void clickOpenWeb(View view) {
        TextView websiteText = findViewById(R.id.edit1);
        String url = websiteText.getText().toString();
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.e(TAG, "Cannot handle this intent.");
        }
    }

    public void clickOpenLocation2(View view) {
        TextView locationText = findViewById(R.id.edit3);
        String location = locationText.getText().toString();
        Uri uri = Uri.parse("geo:0,0?q=" + location);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.e(TAG, "Cannot handle this intent.");
        }
    }

    public void clickShareText(View view) {
        TextView shareText = findViewById(R.id.edit4);
        String text = shareText.getText().toString();
        String mimetype = "text/plain";

        // Start all share choosers
//        ShareCompat.IntentBuilder.from(this)
//                .setType(mimetype)
//                .setChooserTitle("Share with:")
//                .setText(text)
//                .startChooser();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, text);
        intent.putExtra(Intent.EXTRA_MIME_TYPES, mimetype);

        // Send specific app
        intent.setPackage("org.telegram.messenger");

        startActivity(Intent.createChooser(intent, "Share with:"));

    }

    static final int REQUEST_IMAGE_CAPTURE = 1;

    public void clickOpenCamera(View view) {
        //https://developer.android.com/training/camera/photobasics
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }


    public void clickOpenLocation(View view) {
        //https://developers.google.com/maps/documentation/urls/android-intents

        TextView locationText = findViewById(R.id.edit2);
        String location = locationText.getText().toString();
        Uri uri = Uri.parse("geo:" + location+"?z=20");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.e(TAG, "Cannot handle this intent.");
        }
    }


}
