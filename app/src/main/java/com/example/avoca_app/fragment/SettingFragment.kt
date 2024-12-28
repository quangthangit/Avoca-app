package com.example.avoca_app.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.avoca_app.R

class SettingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.setting_layout, container, false)

        // Initialize UI components
        val tvSettingHeader = view.findViewById<TextView>(R.id.tvSettingHeader)
        val ivOrganizationLogo = view.findViewById<ImageView>(R.id.ivOrganizationLogo)
        val btnUploadLogo = view.findViewById<Button>(R.id.btnUploadLogo)
        val etOrganizationName = view.findViewById<EditText>(R.id.etOrganizationName)
        val tvOrganizationURL = view.findViewById<TextView>(R.id.tvOrganizationURL)
        val btnEditURL = view.findViewById<Button>(R.id.btnEditURL)
        val btnCopyURL = view.findViewById<Button>(R.id.btnCopyURL)
        val etOrganizationDescription = view.findViewById<EditText>(R.id.etOrganizationDescription)
        val etFacebook = view.findViewById<EditText>(R.id.etFacebook)
        val etTwitter = view.findViewById<EditText>(R.id.etTwitter)
        val etDiscord = view.findViewById<EditText>(R.id.etDiscord)
        val etInstagram = view.findViewById<EditText>(R.id.etInstagram)

        // Set listeners for buttons
        btnUploadLogo.setOnClickListener {
            Toast.makeText(requireContext(), "Upload Logo clicked", Toast.LENGTH_SHORT).show()
        }

        btnEditURL.setOnClickListener {
            Toast.makeText(requireContext(), "Edit URL clicked", Toast.LENGTH_SHORT).show()
        }

        btnCopyURL.setOnClickListener {
            Toast.makeText(requireContext(), "URL copied to clipboard", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}
