package com.example.mobileapp_master

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mobileapp_master.databinding.ActivityMainBinding
import com.example.mobileapp_master.ui.home.HomeFragment
import com.example.mobileapp_master.ui.onboarding.ViewPagerFragment

class MainActivity : AppCompatActivity() {



    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration //go back

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding  = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)










        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        binding.bottomAppBar.setupWithNavController(navController)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.locationFragment,
                R.id.episodeFragment,

            )
        )

        navHostFragment.navController.addOnDestinationChangedListener {
                _, destination,_ ->
            when (destination.id) {
                R.id.homeFragment -> binding.bottomAppBar.show()
                R.id.locationFragment -> binding.bottomAppBar.show()
                R.id.episodeFragment -> binding.bottomAppBar.show()
                R.id.secondFragment -> binding.bottomAppBar.show()
                R.id.locationDetail -> binding.bottomAppBar.show()
                else -> binding.bottomAppBar.notShow()
            }

        }




        setupActionBarWithNavController(navController, appBarConfiguration)


    }

    override fun onSupportNavigateUp(): Boolean {
        return super.onSupportNavigateUp() || navController.navigateUp(appBarConfiguration)
    }
}