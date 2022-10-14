package com.hongmu.sesac.fragments

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.hongmu.sesac.R

class C56Fragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings_c56, rootKey)
    }
}