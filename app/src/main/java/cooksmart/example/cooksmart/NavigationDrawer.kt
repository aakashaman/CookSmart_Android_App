package cooksmart.example.cooksmart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.dutyleavemanagmentsystem.R
import com.google.android.material.navigation.NavigationView

class NavigationDrawer :  AppCompatActivity(),
    NavigationView.OnNavigationItemSelectedListener{
    lateinit var  drawer: DrawerLayout
    lateinit var navigationView: NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_drawer)
        var toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        var actionBarDrawerToggle = ActionBarDrawerToggle(this,drawer,toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, recipe()).commit()
            navigationView.setCheckedItem(R.id.menu_home)
        }
    }
    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {

            R.id.menu_events -> supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container,
                Events()
            )
                .commit()
            R.id.menu_history -> supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container,
                recipe()
            )
                .commit()

            R.id.menu_home -> supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container,
                Account()
            )
                .commit()
            R.id.menu_logout -> {
                val intent  = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }

        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}