package com.wade.stylish.female

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.wade.grilled.R
import com.wade.grilled.databinding.FragmentClothseBinding

import com.wade.stylish.access.AccessFragment

import com.wade.stylish.male.VegetableFragment

/**
 * A simple [Fragment] subclass.
 */
class OrderFragment : Fragment() {



    // When requested, this adapter returns a DemoObjectFragment,
    // representing an object in the collection.
    private lateinit var demoCollectionPagerAdapter: DemoCollectionPagerAdapter
    private lateinit var viewPager: ViewPager

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_clothse, container, false)



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        demoCollectionPagerAdapter =
            DemoCollectionPagerAdapter(
                childFragmentManager
            )
        viewPager = view.findViewById(R.id.pager)
        viewPager.adapter = demoCollectionPagerAdapter
}
}

// Since this is an object collection, use a FragmentStatePagerAdapter,
// and NOT a FragmentPagerAdapter.
class DemoCollectionPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getCount(): Int  = 3

    override fun getPageTitle(position: Int): CharSequence {
        when(position){
            0-> return "雜項"
            1-> return "蔬菜"
            else-> return "肉類"
        }
    }



override fun getItem(i: Int): Fragment {
    when (i){
        0-> return FemaleFragment()
        1-> return VegetableFragment()
        else-> return AccessFragment()
    }
}
}







class FemaleFragment : Fragment() {

    private val viewModel: OrderViewModel by lazy {
        ViewModelProvider(this).get(OrderViewModel::class.java)
    }


    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
            val binding = FragmentClothseBinding.inflate(inflater)

            // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
            binding.setLifecycleOwner(this)




            // Giving the binding access to the OverviewViewModel
            binding.female = viewModel





                return binding.root}

    }

