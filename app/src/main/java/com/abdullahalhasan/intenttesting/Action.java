package com.abdullahalhasan.intenttesting;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Action extends AppCompatActivity {

    TextView mobileNumberTV;
    TextView emailAddressTV;
    TextView webUrlTV;

    String mobile;
    String email;
    String web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);

        mobileNumberTV = (TextView) findViewById(R.id.showPhnTV);
        emailAddressTV = (TextView) findViewById(R.id.showMailTV);
        webUrlTV = (TextView) findViewById(R.id.showURLTV);

        Intent newIntent = getIntent();
        mobile = newIntent.getStringExtra("Mobile");
        email = newIntent.getStringExtra("Email");
        web = newIntent.getStringExtra("Web");

        mobileNumberTV.setText(mobile);
        emailAddressTV.setText(email);
        webUrlTV.setText(web);
    }


    public void call(View view) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:"+mobile));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(callIntent);
    }

    public void send(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, email);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }


    }

    public void visit(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://"+web));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
