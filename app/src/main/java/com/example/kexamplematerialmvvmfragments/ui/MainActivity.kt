package com.example.kexamplematerialmvvmfragments.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kexamplematerialmvvmfragments.R
import com.example.kexamplematerialmvvmfragments.ui.fragment_main.MainFragment

class MainActivity : AppCompatActivity() {

    companion object {
        var themeFlag = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        // важно перед onCreate
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

    // подключение кнопки "Назад" при работе с фрагментами
    override fun onBackPressed() {
        val count = supportFragmentManager.backStackEntryCount
        if (count == 0) {
            super.onBackPressed()
            //additional code
        } else {
            supportFragmentManager.popBackStack()
        }
    }
}