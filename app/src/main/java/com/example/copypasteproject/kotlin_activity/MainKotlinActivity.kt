package com.example.copypasteproject.kotlin_activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.copypasteproject.R
import com.example.copypasteproject.utils.AppConstant
import com.example.copypasteproject.utils.LanguageConstant
import com.example.copypasteproject.utils.LanguageUtils
import com.example.copypasteproject.utils.PreferenceManager
import kotlinx.android.synthetic.main.activity_main_java.*


class MainKotlinActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_java)

        if (PreferenceManager.getStringForKey(
                applicationContext,
                LanguageConstant.PREFERENCE_LANGUAGECODE,
                null
            ) == null
        ) {
            LanguageUtils.setLanguage(applicationContext, 1)
        }

        init_language()
        loadclicklistener()
    }


    private fun init_language() {
        textViewSignin.text = LanguageUtils.getLanguageString(LanguageConstant.signIn)
        tvLabelEmailId.text = LanguageUtils.getLanguageString(LanguageConstant.enterEmailID)
        editEmailID.hint = LanguageUtils.getLanguageString(LanguageConstant.enterEmailID)
        tvLabelpin.text = LanguageUtils.getLanguageString(LanguageConstant.enterPIN)
        textViewSigninBtn.text = LanguageUtils.getLanguageString(LanguageConstant.signIn)
        textForgotPassword.text = LanguageUtils.getLanguageString(LanguageConstant.forgotPin)
        textViewRegisterBtn.text = LanguageUtils.getLanguageString(LanguageConstant.signUpRegister)


    }

    private fun loadclicklistener() {
        textViewSigninBtn.setOnClickListener(this)
        textViewRegisterBtn.setOnClickListener(this)
        rdg_language.setOnCheckedChangeListener { _, checkedId -> // find which radio button is selected
            when (checkedId) {
                R.id.chk_hindi -> {
                    LanguageUtils.setLanguage(applicationContext, 2)
                    init_language()
                }
                R.id.chk_english -> {
                    LanguageUtils.setLanguage(applicationContext, 1)
                    init_language()
                }

            }
        }
    }

    override fun onClick(v: View?) {
        when (v) {
            textViewSignin -> {
                if ("admin@gmail.com" == editEmailID.text.toString().trim()
                    && "admin" == edt_useridpassword.text.toString()
                ) {
                    AppConstant.showtoast(
                        LanguageUtils.getLanguageString(LanguageConstant.loginSuccess),
                        applicationContext
                    )
                } else {
                    AppConstant.showtoast(
                        LanguageUtils.getLanguageString(LanguageConstant.somethingWentWrong),
                        applicationContext
                    )
                }
                AppConstant.hideKeyboard(this@MainKotlinActivity)

            }

            textViewRegisterBtn -> {
                var intent = Intent(this, RegistrationKotlinActivity::class.java)
                startActivity(intent)
            }
        }
    }
}