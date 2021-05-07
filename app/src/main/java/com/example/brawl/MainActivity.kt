package com.example.brawl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    //====================================TAMPILAN SLIDE===================================
    private lateinit var drawerLayout : DrawerLayout
    private lateinit var actionBar : ActionBarDrawerToggle
    private lateinit var navDrawerView : NavigationView

    // ====================Bottom Bar=======================
    private lateinit var bottomNavigation : BottomNavigationView

    private fun setCurrentFragment(fragment:Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer,fragment)
            commit()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //call fragment from bottom navigation view
        val firstFragment = Home()
        val secondFragment = Song()
        val threeFragment = Album()
        val fourthFragment = Artist()

        setCurrentFragment(firstFragment)
        bottomNavigation = findViewById(R.id.nav_bottom)
        bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.navigation_home->setCurrentFragment(firstFragment)
                R.id.navigation_song->setCurrentFragment(secondFragment)
                R.id.navigation_albums->setCurrentFragment(threeFragment)
                R.id.navigation_artist-> setCurrentFragment(fourthFragment)
            }
            true
        }

        //========================================================================

        // Call findViewById on the DrawerLayout
        drawerLayout = findViewById(R.id.activity_main)

        // pass the ActionBarToogle actio into the drawerlistener
        actionBar = ActionBarDrawerToggle(this , drawerLayout , 0 , 0 )
        drawerLayout.addDrawerListener(actionBar)

        //display the hamburger icon to launch the drawer
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //call synstace() on the action bar so it'll automatically
        // change to the back button wthen the drawer layout is open
        actionBar.syncState()

        // call findViewById on the NavigationView
        navDrawerView = findViewById(R.id.navDrawer)

        //call setNavigationItemSelectedListener on the NavigationView
        // to detect when items are clicked
        navDrawerView.setNavigationItemSelectedListener { MenuItem ->
            when (MenuItem.itemId) {
                R.id.myprofile -> {
                    Toast.makeText(this ,"Go To My Profile" ,
                    Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.myEmployee -> {
                    Toast.makeText(this , "Go to Out Employee" ,
                    Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.register -> {
                    val intent = Intent(applicationContext, register::class.java)
                    startActivity(intent)
                    true
                }

                else -> {
                    false
                }

            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START) // Close drawable
        } else {
            this.drawerLayout.openDrawer(GravityCompat.START) // Open drawer
        }
        return true
    }

    //=============================================================================================

    //===============TOOL BAR=========================
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu , menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if(id == R.id.favourit) {
            Toast.makeText(this , "Thank Yout make me yout Favourit" , Toast.LENGTH_SHORT).show()
            return true
        }
        else if (id == R.id.setting) {
            Toast.makeText(this , "Go to Setting" , Toast.LENGTH_SHORT).show()
            return true
        }
        else if (id == R.id.search) {
            Toast.makeText(this , "Search Clicked" , Toast.LENGTH_SHORT).show()
            return true
        }
        else if (id == R.id.logout) {
            Toast.makeText(this , "Log Out" , Toast.LENGTH_SHORT).show()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    //=================================================


}