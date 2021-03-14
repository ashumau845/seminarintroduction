package com.example.copypasteproject.kotlin_activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.copypasteproject.R
import com.example.copypasteproject.utils.AppConstant
import com.example.copypasteproject.utils.LanguageConstant
import com.example.copypasteproject.utils.LanguageUtils
import kotlinx.android.synthetic.main.activity_registration_java_activty.*

class RegistrationKotlinActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_java_activty)

        edt_pincode.addListener { edt_pincode.setText("") }
        loadclicklistener()
        init_language()
    }

    private fun init_language() {
        txtName.text = LanguageUtils.getLanguageString(LanguageConstant.enterName)
        edtName.hint = LanguageUtils.getLanguageString(LanguageConstant.enterName)
        txtcontactnumber.text = LanguageUtils.getLanguageString(LanguageConstant.enterMobileNumber)
        txtgender.text = LanguageUtils.getLanguageString(LanguageConstant.gender)
        radio_male.text = LanguageUtils.getLanguageString(LanguageConstant.male)
        radio_female.text = LanguageUtils.getLanguageString(LanguageConstant.female)
        txtaddress.text = LanguageUtils.getLanguageString(LanguageConstant.address)
        txtpincode.text = LanguageUtils.getLanguageString(LanguageConstant.pincode)
        edt_pincode.hint = LanguageUtils.getLanguageString(LanguageConstant.pincode)
        txtsubmit.text = LanguageUtils.getLanguageString(LanguageConstant.submit)
    }

    override fun onBackPressed() {
        startActivity(Intent(this, MainKotlinActivity::class.java))
    }

    private fun loadclicklistener() {
        txtsubmit.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            txtsubmit -> {
                if (validation()) {
                    AppConstant.hideKeyboard(this@RegistrationKotlinActivity)
                    AppConstant.showtoast(
                        LanguageUtils.getLanguageString(LanguageConstant.newCustomerAddedSuccessfully),
                        applicationContext
                    )
                    onBackPressed()
                } else {
                    AppConstant.showtoast(
                        LanguageUtils.getLanguageString(LanguageConstant.somethingWentWrong),
                        applicationContext
                    )

                }
            }
        }
    }

    private fun validation(): Boolean {
        var status = true

        if (!AppConstant.NAME_PATTERN.matcher(edtName.text.toString().trim()).matches()) {
            status = false
        }

        if (!AppConstant.MOBILE_PATTERN.matcher(edt_contactnumber.text.toString().trim())
                .matches()
        ) {
            status = false
        }

        if (!radio_male.isChecked && !radio_female.isChecked) {
            status = false
        }

        if (edt_address.text.toString().trim().length <= 10) {
            status = false
        }

        if (!AppConstant.INDIANPINCODE.matcher(edt_pincode.text.toString().trim()).matches()) {
            status = false
        }

        return status
    }


}