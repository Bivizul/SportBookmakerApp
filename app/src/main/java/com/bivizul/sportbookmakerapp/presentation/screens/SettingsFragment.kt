package com.bivizul.sportbookmakerapp.presentation.screens

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import androidx.fragment.app.Fragment
import com.bivizul.sportbookmakerapp.R
import com.bivizul.sportbookmakerapp.databinding.FragmentSettingsBinding
import com.bivizul.sportbookmakerapp.utils.Constants.APP_PREFERENCES
import com.bivizul.sportbookmakerapp.utils.Constants.PREF_DARK_SWITCH
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding: FragmentSettingsBinding
        get() = _binding ?: throw RuntimeException("FragmentSettingsBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val blackTheme = binding.swBlackTheme
        val preferences = this.activity?.getSharedPreferences(
            APP_PREFERENCES,
            Context.MODE_PRIVATE
        )
        val backgroundActivity = this.activity?.findViewById<LinearLayout>(R.id.main_activity)

        blackTheme.isChecked = preferences?.getBoolean(PREF_DARK_SWITCH, false) ?: false
        blackTheme.setOnCheckedChangeListener { button, isChecked ->

            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
                preferences?.edit()?.putBoolean(PREF_DARK_SWITCH, isChecked)?.apply()
            } else {
                AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
                preferences?.edit()?.putBoolean(PREF_DARK_SWITCH, isChecked)?.apply()
            }
        }

        binding.btWallpaper.setOnClickListener {
            val images = mutableListOf(
                R.drawable.background_1,
                R.drawable.background_2,
                R.drawable.background_3
            )
            backgroundActivity?.setBackgroundResource(images.random())
        }
    }
}