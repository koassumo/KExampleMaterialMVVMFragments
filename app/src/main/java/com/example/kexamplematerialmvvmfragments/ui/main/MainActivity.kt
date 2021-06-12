package com.example.kexamplematerialmvvmfragments.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kexamplematerialmvvmfragments.R

class MainActivity : AppCompatActivity() {

    companion object {
        var themeFlag = 3
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        when (themeFlag) {
            0 -> setTheme(R.style.IndigoAppTheme)
            1 -> setTheme(R.style.GreenAppTheme)
            2 -> setTheme(R.style.BrownAppTheme)
            3 -> setTheme(R.style.YellowAppTheme)
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }
    }
}