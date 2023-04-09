package com.aralb.foodapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.aralb.foodapplication.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private lateinit var navHostFragment: NavHostFragment
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        setTheme(R.style.Theme_FoodApplication)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        initViews()
        navigation()
    }


    private fun initViews() {
        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
    }


    private fun navigation(){
        binding.listScopeImageView.setOnClickListener {
            navHostFragment.findNavController().navigate(R.id.mainToSearch)
        }
        binding.backIcon.setOnClickListener {
            navHostFragment.findNavController().popBackStack()
        }
    }
    fun backNavigation(visibility: Boolean) {
        if (visibility) {
            binding.backIcon.visibility = View.VISIBLE
        } else {
            binding.backIcon.visibility = View.INVISIBLE
        }
    }

    fun search(visibility: Boolean) {
        if (visibility) {
            binding.listScopeImageView.visibility = View.VISIBLE
        } else {
            binding.listScopeImageView.visibility = View.INVISIBLE
        }
    }
}