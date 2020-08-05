package com.wade.stylish.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.wade.grilled.R
import com.wade.grilled.databinding.FragmentHomeBinding



/**
 * A simple [Fragment] subclass.
 */
class HomeFragment :Fragment() {
    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//      or  val binding = FragmentHomeBinding.inflate(inflater, container, false)

        val binding: FragmentHomeBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home, container, false
        )

        binding.lifecycleOwner = this
        binding.viewModel = viewModel







        return binding.root
    }
}
