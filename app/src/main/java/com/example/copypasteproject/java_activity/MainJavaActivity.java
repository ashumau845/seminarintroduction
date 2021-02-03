package com.example.copypasteproject.java_activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.copypasteproject.R;
import com.example.copypasteproject.utils.AppConstant;


public class MainJavaActivity extends AppCompatActivity {


    private EditText edt_username;
    private EditText edt_password;
    private TextView txt_signin;
    private TextView txt_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_java);

        // Initialize the variables
        loadlayoutviews();

        // clicklisteners
        loadclicklistener();
    }


    private void loadlayoutviews() {
        //Edittext
        edt_username = findViewById(R.id.editEmailID);
        edt_password = findViewById(R.id.edt_useridpassword);

        //TextView
        txt_signin = findViewById(R.id.textViewSigninBtn);
        txt_register = findViewById(R.id.textViewRegisterBtn);
    }

    private void loadclicklistener() {

        txt_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("admin@gmail.com".equals(edt_username.getText().toString().trim()) && "admin".equals(edt_password.getText().toString())) {

                    AppConstant.showtoast("Login Successful", getApplicationContext());
                    AppConstant.hideKeyboard(MainJavaActivity.this);
                }
            }
        });


        txt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainJavaActivity.this, RegistrationJavaActivty.class);
                startActivity(intent);
                finish();
            }
        });
    }


}