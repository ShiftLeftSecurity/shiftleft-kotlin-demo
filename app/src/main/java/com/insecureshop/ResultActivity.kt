package com.insecureshop

import android.os.Bundle
import android.app.Activity


class ResultActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setResult(-1, intent)
        finish()
    }

}