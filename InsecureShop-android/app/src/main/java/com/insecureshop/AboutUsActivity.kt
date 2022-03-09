package com.insecureshop

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.insecureshop.util.Prefs
import kotlinx.android.synthetic.main.activity_about_us.*


class AboutUsActivity : AppCompatActivity() {

    lateinit var receiver: CustomReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)
        receiver = CustomReceiver()
        registerReceiver(receiver, IntentFilter("com.insecureshop.CUSTOM_INTENT"))
    }

    override fun onDestroy() {
        unregisterReceiver(receiver)
        super.onDestroy()
    }

    // the following fn provides a longer dataflow for static analysis demos
    fun trimStr(s: String): String {
      val trimmed1 = s.trim()
      val trimmed2 = trimmed1.trimMargin()
      val trimmed3 = trimmed2.trimStart()
      val dropped4 = trimmed3.drop(0)
      return dropped4
    }

    fun onSendData(view: View) {
        val userName = Prefs.username!!
        val password = Prefs.password!!

        val trimmedUsername = trimStr(userName)
        val trimmedPassword = trimStr(password)

        val intent = Intent("com.insecureshop.action.BROADCAST")
        intent.putExtra("username", trimmedUsername)
        intent.putExtra("password", trimmedPassword)
        sendBroadcast(intent)

        textView.text = "InsecureShop is an intentionally designed vulnerable android app built in Kotlin."

    }


}