package com.wade.stylish.male

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.wade.grilled.VegetableAdapter

import com.wade.grilled.databinding.FragmentVegetableBinding
import com.wade.grilled.NavigationDirections
/**
 * A simple [Fragment] subclass.
 */


class VegetableFragment : Fragment() {


    private val viewModel: VegetableViewModel by lazy {
        ViewModelProvider(this).get(VegetableViewModel::class.java)
    }

    /**
     * Inflates the layout with Data Binding, sets its lifecycle owner to the OverviewFragment
     * to enable Data Binding to observe LiveData, and sets up the RecyclerView with an adapter.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentVegetableBinding.inflate(inflater)

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        // Giving the binding access to the OverviewViewModel
        binding.vegetable = viewModel


        binding.recyclerviewVegetable.adapter =
            VegetableAdapter(VegetableAdapter.OnClickListener {
                viewModel.displayPropertyDetails(it)
            })
        viewModel.navigateToSelectedProperty.observe(viewLifecycleOwner, Observer {
            if ( it != null ) {
                // Must find the NavController from the Fragment
                findNavController().navigate(NavigationDirections.actionGlobalShopingCartFragment(it    ))
                // Tell the ViewModel we've made the navigate call to prevent multiple navigation
                viewModel.displayPropertyDetailsComplete()
            }
        })





        return binding.root
    }

    /**
     * Inflates the overflow menu that contains filtering options.
     */
}


//data  binding xml的另外做法
//        viewModel.products.observe(viewLifecycleOwner, Observer {
//            it?.let{
//                adapter.submitList(it)
//            }
//        })