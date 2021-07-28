package com.example.olaystasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.olaystasks.databinding.ToastFragmentBinding

class ToastFragment: Fragment() {
    private lateinit var binding:ToastFragmentBinding

    private val text = "Welcome"


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ToastFragmentBinding.inflate(inflater, container, false)
        binding.toastButton.setOnClickListener {
            showToast()
            findNavController().navigate(R.id.action_toastFragment_to_numberListFragment)
        }
        return binding.root
    }

    fun showToast(){
        Toast.makeText(context?.applicationContext,text,Toast.LENGTH_LONG).show()
    }

}
