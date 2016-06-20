package com.abdullahalhasan.intenttesting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Home extends AppCompatActivity {
    EditText mobileNumberET;
    EditText emailAddressET;
    EditText webUrlET;
    String mobileNumber;
    String emailAddress;
    String webUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mobileNumberET = (EditText) findViewById(R.id.phoneNoET);
        emailAddressET = (EditText) findViewById(R.id.emailAddET);
        webUrlET = (EditText) findViewById(R.id.webUrlET);
    }

    public void submit(View view) {
        mobileNumber = mobileNumberET.getText().toString();
        emailAddress = emailAddressET.getText().toString();
        webUrl = webUrlET.getText().toString();

        Intent intent = new Intent(this,Action.class)
                .putExtra("Mobile",mobileNumber)
                .putExtra("Email",emailAddress)
                .putExtra("Web",webUrl);

        startActivity(intent);

    }
}
