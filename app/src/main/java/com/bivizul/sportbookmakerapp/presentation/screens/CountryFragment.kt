package com.bivizul.sportbookmakerapp.presentation.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bivizul.sportbookmakerapp.R
import com.bivizul.sportbookmakerapp.databinding.FragmentCountryBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CountryFragment : Fragment() {

    private var _binding: FragmentCountryBinding? = null
    private val binding: FragmentCountryBinding
        get() = _binding ?: throw RuntimeException("FragmentCountryBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCountryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btRussia.setOnClickListener {
            findNavController().navigate(
                R.id.action_countryFragment_to_tablesFragment,
                bundleOf(
                    TablesFragment.COUNTRYNUMBER to 1,
                    TablesFragment.COUNTRYNAME to getString(R.string.russia_u)
                )
            )
        }
        binding.btEngland.setOnClickListener {
            findNavController().navigate(
                R.id.action_countryFragment_to_tablesFragment,
                bundleOf(
                    TablesFragment.COUNTRYNUMBER to 0,
                    TablesFragment.COUNTRYNAME to getString(R.string.england_u)
                )
            )
        }
        binding.btGermany.setOnClickListener {
            findNavController().navigate(
                R.id.action_countryFragment_to_tablesFragment,
                bundleOf(
                    TablesFragment.COUNTRYNUMBER to 2,
                    TablesFragment.COUNTRYNAME to getString(R.string.germany_u)
                )
            )
        }
        binding.btSpain.setOnClickListener {
            findNavController().navigate(
                R.id.action_countryFragment_to_tablesFragment,
                bundleOf(
                    TablesFragment.COUNTRYNUMBER to 3,
                    TablesFragment.COUNTRYNAME to getString(R.string.spain_u)
                )
            )
        }
    }
}