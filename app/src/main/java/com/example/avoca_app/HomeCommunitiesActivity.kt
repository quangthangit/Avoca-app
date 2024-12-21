package com.example.avoca_app

import android.annotation.SuppressLint
import android.graphics.Rect
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.navigation.NavigationView

class HomeCommunitiesActivity : AppCompatActivity() {
    private lateinit var btnShowNav: View
    private lateinit var navView: NavigationView
    private lateinit var mainLayout: ConstraintLayout
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_communities)
        ViewCompat.setOnApplyWindowInsetsListener(/* view = */ findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        btnShowNav = findViewById(R.id.btnShowNav)
        navView = findViewById(R.id.nav_view)
        mainLayout = findViewById(R.id.main)

        btnShowNav.setOnClickListener {
            navView.visibility = View.VISIBLE
        }
        mainLayout.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN && navView.visibility == View.VISIBLE) {
                val navRect = Rect()
                navView.getGlobalVisibleRect(navRect)

                if (!navRect.contains(event.rawX.toInt(), event.rawY.toInt())) {
                    navView.visibility = View.GONE
                }
            }
            false
        }

    }
}