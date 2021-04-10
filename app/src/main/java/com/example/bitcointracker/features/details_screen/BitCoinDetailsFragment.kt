package com.example.bitcointracker.features.details_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.bitcointracker.databinding.FragmentBitCoinDetailsBinding
import com.example.bitcointracker.features.SharedViewModel

class BitCoinDetailsFragment : Fragment() {
    lateinit var binding: FragmentBitCoinDetailsBinding
    lateinit var viewModel: SharedViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBitCoinDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
        viewModel.bitCoinPriceDetails.observe(viewLifecycleOwner, { currencies ->
            binding.dateTV.text = currencies.first().date
            binding.dollarCurrency.text = currencies[0].rate.toString()
            binding.euroCurrency.text = currencies[1].rate.toString()
            binding.gbpCurrency.text = currencies[2].rate.toString()
        })
    }
}