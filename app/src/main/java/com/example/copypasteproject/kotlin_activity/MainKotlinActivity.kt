package com.example.copypasteproject.kotlin_activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.copypasteproject.R
import com.example.copypasteproject.java_activity.RegistrationJavaActivty
import com.example.copypasteproject.utils.AppConstant
import kotlinx.android.synthetic.main.activity_main_java.*


class MainKotlinActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_java)

        loadclicklistener()
    }

    private fun loadclicklistener() {
        textViewSigninBtn.setOnClickListener(this)
        textViewRegisterBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            textViewSignin -> {
                if ("admin@gmail.com" == editEmailID.text.toString().trim()
                    && "admin" == edt_useridpassword.text.toString()
                ) {
                    AppConstant.showtoast("Login Successfull", applicationContext)
                    AppConstant.hideKeyboard(this@MainKotlinActivity)
                }
            }

            textViewRegisterBtn -> {
                var intent = Intent(this, RegistrationJavaActivty::class.java)
                startActivity(intent)
            }
        }
    }
}