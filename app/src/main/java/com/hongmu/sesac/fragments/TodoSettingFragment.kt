package com.hongmu.sesac.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.preference.EditTextPreference
import androidx.preference.ListPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.hongmu.sesac.R


class TodoSettingFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings_todo, rootKey)

        findPreference<EditTextPreference>("KEY_ID")?.run {
            summaryProvider = Preference.SummaryProvider<EditTextPreference>{
                if(it.text?.isEmpty() != false) "설정 되지 않음"
                else "설정된 ID: ${it.text}"
            }
        }

        findPreference<ListPreference>("KEY_COLOR")?.run {
            summaryProvider = ListPreference.SimpleSummaryProvider.getInstance()
        }
    }

}