package com.hongmu.sesac.fragments

import android.os.Bundle
import android.widget.Toast
import androidx.preference.EditTextPreference
import androidx.preference.ListPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.hongmu.sesac.R

class C57Fragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings_c57, rootKey)

        val idPref = findPreference<EditTextPreference>("KEY_SERVER_ID")
        val soundPref = findPreference<ListPreference>("KEY_SOUND_LIST")

        idPref?.setOnPreferenceChangeListener { preference, newValue ->
            Toast.makeText(activity, "$newValue", Toast.LENGTH_SHORT).show()
            true
        }

        soundPref!!.summaryProvider = ListPreference.SimpleSummaryProvider.getInstance()
        idPref!!.summaryProvider = Preference.SummaryProvider<EditTextPreference>{
            if(it.text?.isEmpty() != false) "설정 되지 않음"
            else "설정된 ID는 ${it.text}"
        }
    }
}