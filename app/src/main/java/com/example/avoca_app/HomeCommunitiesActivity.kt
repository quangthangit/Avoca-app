package com.example.avoca_app


import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.avoca_app.fragment.Dashboard
import com.google.android.material.navigation.NavigationView

class HomeCommunitiesActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var btnMenu: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_communities)
        drawerLayout = findViewById(R.id.drawer_layout)

        ViewCompat.setOnApplyWindowInsetsListener(drawerLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnMenu = findViewById<ImageView>(R.id.btnMenu)

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        btnMenu.setOnClickListener {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                drawerLayout.openDrawer(GravityCompat.START)
            }
        }

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Dashboard()).commit()
            navigationView.setCheckedItem(R.id.nav_home)
        }
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Dashboard()).commit()
//            R.id.missions -> supportFragmentManager.beginTransaction()
//                .replace(R.id.fragment_container, SettingsFragment()).commit()
//            R.id.lesson_category -> supportFragmentManager.beginTransaction()
//                .replace(R.id.fragment_container, ShareFragment()).commit()
//            R.id.lessons -> supportFragmentManager.beginTransaction()
//                .replace(R.id.fragment_container, AboutFragment()).commit()
            else -> return false
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}