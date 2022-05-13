package com.bivizul.sportbookmakerapp.presentation.screens

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bivizul.sportbookmakerapp.databinding.FragmentTablesBinding
import com.bivizul.sportbookmakerapp.presentation.adapters.TableAdapter
import com.bivizul.sportbookmakerapp.presentation.viewmodels.TableViewModel
import com.bivizul.sportbookmakerapp.utils.Constants.TAG
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TablesFragment : Fragment() {

    private lateinit var viewModel: TableViewModel

    private var _binding: FragmentTablesBinding? = null
    private val binding: FragmentTablesBinding
        get() = _binding ?: throw RuntimeException("FragmentTablesBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTablesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = TableAdapter()
        val countryNum = arguments?.getInt(COUNTRYNUMBER)
        val countryName = arguments?.getString(COUNTRYNAME)

        binding.tvTitleTables.text = countryName

        binding.rvStatistic.adapter = adapter
        viewModel = ViewModelProvider(this)[TableViewModel::class.java]
        viewModel.getAllTable(countryNum!!)
        viewModel.allTable.observe(viewLifecycleOwner) {
            adapter.submitList(it)
            Log.d(TAG, "$it")
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object{
        const val COUNTRYNUMBER = "COUNTRYNUMBER"
        const val COUNTRYNAME = "COUNTRYNAME"
    }

}