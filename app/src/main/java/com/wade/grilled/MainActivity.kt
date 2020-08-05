package com.wade.grilled

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.wade.grilled.databinding.ActivityMainBinding

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }


    private lateinit var binding: ActivityMainBinding


    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.houseFragment -> {

                    Navigation.findNavController(this, R.id.main_fragment)
                        .navigate(R.id.homeFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.orderFragment -> {

                    Navigation.findNavController(this, R.id.main_fragment)
                        .navigate(R.id.orderFragment)
                    return@OnNavigationItemSelectedListener true
                }

                R.id.cartFragment -> {

                    Navigation.findNavController(this, R.id.main_fragment)
                        .navigate(R.id.cartFragment)
                    return@OnNavigationItemSelectedListener true
                }

                R.id.profileFragment -> {

                    Navigation.findNavController(this, R.id.main_fragment)
                        .navigate(R.id.profileFragment)
                    return@OnNavigationItemSelectedListener true
                }

            }
            false
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val db = FirebaseFirestore.getInstance()
//        db.collection("vender")
//            .get()
//            .addOnSuccessListener { documents ->


        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        setupBottomNav()



    }


//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        menuInflater.inflate(R.menu.current_place_menu, menu)
//        return true
//    }

    private fun setupBottomNav() {
        binding.bottomMenu.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)


        val menuView = binding.bottomMenu.getChildAt(0) as BottomNavigationMenuView
        val itemView = menuView.getChildAt(2) as BottomNavigationItemView

    }
}