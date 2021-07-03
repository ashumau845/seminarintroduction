package com.example.copypasteproject.kotlin_activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.copypasteproject.R
import com.example.copypasteproject.databinding.ActivityRegistrationJavaActivtyBinding
import com.example.copypasteproject.utils.AppConstant
import com.example.copypasteproject.utils.LanguageConstant
import com.example.copypasteproject.utils.LanguageUtils


class RegistrationKotlinActivity : AppCompatActivity(), View.OnClickListener {


    private lateinit var binding: ActivityRegistrationJavaActivtyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_registration_java_activty)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_registration_java_activty)

        binding.edtPincode.addListener { binding.edtPincode.setText("") }
        loadclicklistener()
        init_language()
    }

    private fun init_language() {
        binding.apply {
            txtName.text = LanguageUtils.getLanguageString(LanguageConstant.enterName)
            edtName.hint = LanguageUtils.getLanguageString(LanguageConstant.enterName)
            txtcontactnumber.text = LanguageUtils.getLanguageString(LanguageConstant.enterMobileNumber)
            txtgender.text = LanguageUtils.getLanguageString(LanguageConstant.gender)
            radioMale.text = LanguageUtils.getLanguageString(LanguageConstant.male)
            radioFemale.text = LanguageUtils.getLanguageString(LanguageConstant.female)
            txtaddress.text = LanguageUtils.getLanguageString(LanguageConstant.address)
            txtpincode.text = LanguageUtils.getLanguageString(LanguageConstant.pincode)
            edtPincode.hint = LanguageUtils.getLanguageString(LanguageConstant.pincode)
            txtsubmit.text = LanguageUtils.getLanguageString(LanguageConstant.submit)
        }

    }

    override fun onBackPressed() {
        startActivity(Intent(this, MainKotlinActivity::class.java))
    }

    private fun loadclicklistener() {
        binding.txtsubmit.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.txtsubmit -> {
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

        binding.apply {
            if (!AppConstant.NAME_PATTERN.matcher(edtName.text.toString().trim()).matches()) {
                status = false
            }

            if (!AppConstant.MOBILE_PATTERN.matcher(edtContactnumber.text.toString().trim())
                    .matches()
            ) {
                status = false
            }

            if (!radioMale.isChecked && !radioFemale.isChecked) {
                status = false
            }

            if (edtAddress.text.toString().trim().length <= 10) {
                status = false
            }

            if (!AppConstant.INDIANPINCODE.matcher(edtPincode.text.toString().trim()).matches()) {
                status = false
            }

            return status
        }

    }


}