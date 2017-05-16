package com.example.manishjoshi.kotlin

import android.content.DialogInterface
import android.net.Uri
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.customtabs.CustomTabsIntent
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.nio.channels.Selector
import android.text.TextUtils
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.LinearLayout




class MainActivity : AppCompatActivity() {

    val price = 5
    var button: Button? = null;
    val lastname: String? = null
    val firstname: String = "manish"
    var edittext: EditText? = null
    val url = "https://paul.kinlan.me/"
    var PACKAGE_NAME = "com.android.chrome"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edittext = findViewById(R.id.edittext) as EditText
        button = findViewById(R.id.button) as Button


        button!!.setOnClickListener {
            Toast.makeText(this, "" + checkTextLength(edittext!!), Toast.LENGTH_LONG).show()
           // openBrowser(url)
            openAlertDialog("")
        }
    }

    fun checkTextLength(edittext: EditText): Int {
        var length = edittext.length()

        return length;
    }

    fun openAlertDialog(name: String) {
        val countries = listOf<String>("ua", "es", "ea", "uk", "us")
        val builder = AlertDialog.Builder(this)
        val password = EditText(builder.context)
        builder.setView(password)
        val lp = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT)
        password.setLayoutParams(lp)
        password.imeOptions=EditorInfo.IME_ACTION_DONE
       password.setOnEditorActionListener { v, actionId, event ->
           if (actionId == EditorInfo.IME_ACTION_SEARCH ||
                   actionId == EditorInfo.IME_ACTION_DONE ||
                   event.getAction() == KeyEvent.ACTION_DOWN &&
                           event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
               Toast.makeText(this,"go",Toast.LENGTH_LONG).show()

                true
           }
            false
        }

        builder.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
            Toast.makeText(this,"clicked",Toast.LENGTH_LONG).show()

        })
        builder.show()
    }

    fun openBrowser(url: String) {
        val intentBuilder = CustomTabsIntent.Builder()
        intentBuilder.setToolbarColor(ContextCompat.getColor(this, R.color.colorPrimary))
        intentBuilder.setSecondaryToolbarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark))

        var customTabsIntent = intentBuilder.build()
        customTabsIntent.intent.setData(Uri.parse(url))

        val resolveInfoList = packageManager.getInstalledApplications(PackageManager.GET_META_DATA)

        for (applicationInfo in resolveInfoList) {
            val packageName = applicationInfo.packageName
            if (TextUtils.equals(packageName, PACKAGE_NAME)) {
                customTabsIntent.intent.`package` = PACKAGE_NAME
                break
            }
        }
        customTabsIntent.launchUrl(this, Uri.parse(url))


    }

    /* fun openAlertDialog(name: String, phoneNumber: String) {

         val countries = listOf("Russia", "India", "USA", "Japan", "China")

         selector("Where are you from?", countries) { i ->
             //toast("So you're living in ${countries[i]}, right?")
             alert("One more thing! You have entered this number " + phoneNumber, name + "! So you're living in ${countries[i]}, right?") {
                 customView {
                     verticalLayout {
                         positiveButton("AWESOME!") {
                             longToast("Thank you!")
                         }
                     }
                 }

             }.show()

         }
     }*/
}
