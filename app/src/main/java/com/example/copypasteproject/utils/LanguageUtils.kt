package com.example.copypasteproject.utils

import android.content.Context
import com.example.copypasteproject.R
import org.json.JSONObject
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream

class LanguageUtils {
    companion object {
        fun setLanguage(context: Context, code: Int) {

            var content: InputStream = if (code == 1) {
                context.resources.openRawResource(R.raw.english_language)
            } else {
                context.resources.openRawResource(R.raw.hindi_language)
            }

            var byteArrayOutputStream = ByteArrayOutputStream()
            var n: Int

            try {
                n = content.read()
                while (n != -1) {
                    byteArrayOutputStream.write(n)
                    n = content.read()
                }
                content.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }

            val jsonString: String = byteArrayOutputStream.toString()

            PreferenceManager.saveStringForKey(
                context,
                LanguageConstant.PREFERENCE_CURRENTLANGUAGE,
                jsonString
            )

            PreferenceManager.saveStringForKey(context, LanguageConstant.PREFERENCE_LANGUAGECODE, code.toString())
        }

        fun getLanguageString(tag: String): String {
            if (PreferenceManager.getStringForKey(
                    Application.appContext,
                    LanguageConstant.PREFERENCE_LANGUAGECODE,
                    null
                ) != null
            ) {
                var result = JSONObject(
                    PreferenceManager.getStringForKey(Application.appContext,
                        LanguageConstant.PREFERENCE_CURRENTLANGUAGE,
                        ""
                    )
                )

                var data = when {
                    result.has(tag) -> {
                        result.getString(tag)
                    }
                    else -> "?"
                }

                return data.toString().trim()
            } else {

                return "?"
            }
        }


    }
}