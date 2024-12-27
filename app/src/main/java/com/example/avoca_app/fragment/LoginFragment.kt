package com.example.avoca_app.fragment

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.avoca_app.HomeActivity
import com.example.avoca_app.R

class LoginFragment : Fragment() {

    private lateinit var pass: EditText
    private lateinit var eyeIcon: ImageView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        val btnLogin: Button = view.findViewById(R.id.btn_login)
        val email = view.findViewById<EditText>(R.id.email_input)
        pass = view.findViewById<EditText>(R.id.password_input)
        eyeIcon = view.findViewById<ImageView>(R.id.eye_icon)

        eyeIcon.setOnClickListener { togglePasswordVisibility() }

        btnLogin.setOnClickListener {
            if(email.text.toString() == ("admin@gmail.com") && pass.text.toString() == ("123456")){
                val intent = Intent(activity, HomeActivity::class.java)
                startActivity(intent)
                Toast.makeText(context, "Login success", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(context, "Account does not exist or the password is incorrect", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }

    private fun togglePasswordVisibility() {
        if (pass.transformationMethod == PasswordTransformationMethod.getInstance()) {
            pass.transformationMethod = HideReturnsTransformationMethod.getInstance()
        } else {
            pass.transformationMethod = PasswordTransformationMethod.getInstance()
        }
        pass.setSelection(pass.text.length)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}
