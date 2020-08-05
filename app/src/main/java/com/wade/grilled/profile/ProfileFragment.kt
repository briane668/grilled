package com.wade.friedfood.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.wade.grilled.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {



//    private val viewModel by viewModels<ProfileViewModel> { getVmFactory() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentProfileBinding.inflate(inflater)
        binding.lifecycleOwner = this
//        binding.viewModel = viewModel


        













        return binding.root


    }


}
