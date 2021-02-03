package com.example.copypasteproject.java_activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.copypasteproject.R;
import com.example.copypasteproject.utils.AppConstant;

public class RegistrationJavaActivty extends AppCompatActivity {

    private EditText edt_name, edt_contactno, edt_address, edt_pincode;
    private TextView txt_submit;
    private RadioGroup rdggroup;
    private RadioButton rdbMale, rdbFemale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_java_activty);

        // Initialize the variables
        loadlayoutviews();

        // clicklisteners
        loadclicklistener();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainJavaActivity.class));
    }

    private void loadclicklistener() {
        txt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validation()) {
                    AppConstant.hideKeyboard(RegistrationJavaActivty.this);
                    AppConstant.showtoast("Registered Successfully", getApplicationContext());
                    onBackPressed();
                } else {
                    AppConstant.showtoast("Something is Wrong!!", getApplicationContext());
                }
            }
        });
    }


    private void loadlayoutviews() {
        edt_name = findViewById(R.id.edtName);
        edt_contactno = findViewById(R.id.edt_contactnumber);
        edt_address = findViewById(R.id.edt_address);
        edt_pincode = findViewById(R.id.edt_pincode);

        txt_submit = findViewById(R.id.txtsubmit);
        rdggroup = findViewById(R.id.rdggroup);
        rdbMale = findViewById(R.id.radio_male);
        rdbFemale = findViewById(R.id.radio_female);
    }

    private boolean validation() {
        boolean status = true;
        if (!AppConstant.NAME_PATTERN.matcher(edt_name.getText().toString().trim()).matches()) {
            status = false;
        }

        if (!AppConstant.MOBILE_PATTERN.matcher(edt_contactno.getText().toString().trim()).matches()) {
            status = false;
        }

        if (!rdbFemale.isChecked() && !rdbMale.isChecked()) {
            status = false;
        }

        if (edt_address.getText().toString().trim().length() <= 10) {
            status = false;
        }

        if (!AppConstant.INDIANPINCODE.matcher(edt_pincode.getText().toString().trim()).matches()) {
            status = false;
        }

        return status;

    }

}