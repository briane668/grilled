package com.wade.stylish.shopingcart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.wade.grilled.R



/**
 * A simple [Fragment] subclass.
 * Use the [AddSuccessFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddSuccessFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_success, container, false)
    }


}
