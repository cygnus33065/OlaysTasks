package com.example.olaystasks.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.olaystasks.databinding.NumberListFragmentBinding
import com.example.olaystasks.ui.adapters.NumberAdapter
import com.example.olaystasks.ui.viewmodel.NumberViewModel

class NumberListFragment: Fragment() {

    private var _binding: NumberListFragmentBinding? = null
    val binding: NumberListFragmentBinding get() = _binding!!

    private lateinit var numberViewModel: NumberViewModel

    private val numberAdapter:NumberAdapter by lazy { NumberAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = NumberListFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        numberViewModel = ViewModelProvider(this).get(NumberViewModel::class.java)

        with(binding){
            rvNumbers.apply{
                layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                adapter = numberAdapter
            }
            numberViewModel.numberList.observe(viewLifecycleOwner){
                numberAdapter.updateNumberList(it)
            }
        }

        binding.fabAddNext.setOnClickListener {
            numberViewModel.addNextNumber()
        }
    }

}