package com.wade.stylish.shopingcart

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.wade.grilled.R
import com.wade.grilled.databinding.FragmentShopingCartBinding

import com.wade.stylish.room.SelectedDatabase

/**
 * A simple [Fragment] subclass.
 */

private lateinit var navController: NavController

class ShopingCartFragment : BottomSheetDialogFragment() {



//    private val shopingCartViewModel: ShopingCartViewModel by lazy {
//        ViewModelProvider(this).get(ShopingCartViewModel::class.java)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(
            DialogFragment.STYLE_NO_FRAME,
            R.style.LoginDialog
        )

    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val order = ShopingCartFragmentArgs.fromBundle(requireArguments()).order
        val application = requireNotNull(activity).application
        val database = SelectedDatabase.getInstance(application).selectedDatabaseDao
        val viewModelFactory = ShopingCartFactory(order, application,database )
//        用factory來創建viewmodel
        val viewModel = ViewModelProviders.of(
            this, viewModelFactory).get(ShopingCartViewModel::class.java)




        val binding: FragmentShopingCartBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoping_cart, container, false
        )

        binding.lifecycleOwner = this
        binding.shopingcart = viewModel






        binding.imageView5.setOnClickListener{
            dismiss()
        }








        viewModel.input.observe(viewLifecycleOwner, androidx.lifecycle.Observer {

            Log.d("wade","${viewModel.input.value}=input")


        })

//        binding.minusButton.setOnClickListener { viewModel.input.value?.minus(1) }


        fun plus() {
            viewModel.input.value = viewModel.input.value?.plus(1)
        }
        fun minus() {
            viewModel.input.value = viewModel.input.value?.minus(1)
        }


        binding.plusButton.setOnClickListener {
            plus()
        }

        binding.minusButton.setOnClickListener {
            minus()
        }



//因為viewmodel保存資料?
        binding.cartButton.setOnClickListener {
            viewModel.addToCart()
//            findNavController().navigate(R.id.addSuccessFragment)

//            var success= Runnable { findNavController().navigate(R.id.clothseFragment) }
//            var hand= Handler()
//            hand.postDelayed(success,2000)
        }


        viewModel.selectedproducts.observe(viewLifecycleOwner, Observer{
            Log.d("wade","${viewModel.selectedproducts.value}=database")
        })


        return binding.root

    }

}

