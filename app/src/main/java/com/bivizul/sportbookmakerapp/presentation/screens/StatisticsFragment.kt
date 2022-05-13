package com.bivizul.sportbookmakerapp.presentation.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bivizul.sportbookmakerapp.R
import com.bivizul.sportbookmakerapp.databinding.FragmentStatisticsBinding
import com.bivizul.sportbookmakerapp.presentation.adapters.StatisticAttackAdapter
import com.bivizul.sportbookmakerapp.presentation.adapters.StatisticDefenseAdapter
import com.bivizul.sportbookmakerapp.presentation.viewmodels.StatisticAttackViewModel
import com.bivizul.sportbookmakerapp.presentation.viewmodels.StatisticDefenseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StatisticsFragment : Fragment(R.layout.fragment_statistics) {

    private lateinit var defenseViewModel: StatisticDefenseViewModel
    private lateinit var attackViewModel: StatisticAttackViewModel

    private var _binding: FragmentStatisticsBinding? = null
    private val binding: FragmentStatisticsBinding
        get() = _binding ?: throw RuntimeException("FragmentStatisticsBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStatisticsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btDefense.setOnClickListener {
            val adapter = StatisticDefenseAdapter()
            binding.rvStatistic.adapter = adapter
            defenseViewModel = ViewModelProvider(this)[StatisticDefenseViewModel::class.java]
            defenseViewModel.getAllStatisticDefense()
            binding.tvStTittle1.text = getString(R.string.team)
            binding.tvStTittle2.text = getString(R.string.tournament)
            binding.tvStTittle3.text = getString(R.string.strikes_z_i)
            binding.tvStTittle4.text = getString(R.string.selections_z_i)
            binding.tvStTittle5.text = getString(R.string.interceptions_z_i)
            binding.tvStTittle6.text = getString(R.string.fouls_z_i)
            binding.tvStTittle7.text = getString(R.string.offsides_z_i)
            binding.tvStTittle8.text = getString(R.string.rating)
            defenseViewModel.allStatisticDefense.observe(viewLifecycleOwner) {
                adapter.submitList(it)
            }
        }
        binding.btAttack.setOnClickListener {
            val adapter = StatisticAttackAdapter()
            binding.rvStatistic.adapter = adapter
            attackViewModel = ViewModelProvider(this)[StatisticAttackViewModel::class.java]
            attackViewModel.getAllStatisticAttack()
            binding.tvStTittle1.text = getString(R.string.team)
            binding.tvStTittle2.text = getString(R.string.tournament)
            binding.tvStTittle3.text = getString(R.string.strikes_z_i)
            binding.tvStTittle4.text = getString(R.string.strikes_vstv_z_i)
            binding.tvStTittle5.text = getString(R.string.dribling_z_i)
            binding.tvStTittle6.text = getString(R.string.fouls_given_z_i)
            binding.tvStTittle7.text = getString(R.string.rating)
            binding.tvStTittle8.text = ""
            attackViewModel.allStatisticAttack.observe(viewLifecycleOwner) {
                adapter.submitList(it)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}