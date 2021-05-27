package com.example.parcial3final

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.parcial3final.databinding.ActivityTabsBinding
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController


class TabsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityTabsBinding>(this, R.layout.activity_tabs)

        //Definir el NavController
        val navController = findNavController(R.id.nav_host_fragment)

        //Configurar el TabBar
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.locationFragment))
        setSupportActionBar(binding.toolbar)

        //Configuramos la navegación con la TabBar y el NavController
        setSupportActionBar(binding.toolbar)

        //Configuramos la navegación con la BottomView y el NavController
        setupActionBarWithNavController(navController,appBarConfiguration)

        //Configuramos la navegación con la BottomView y el NavController
        binding.navView.setupWithNavController(navController)


    }
}