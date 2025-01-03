package com.example.avoca_app.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.PopupMenu
import com.example.avoca_app.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MissionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MissionFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_mission, container, false)

        val typeEdittext = view.findViewById<EditText>(R.id.type_edittext)

        typeEdittext.setOnClickListener {
            showStatusPopup(it, typeEdittext)
        }


        return view
    }

    private fun showStatusPopup(anchor: View, editText: EditText) {
        val popupMenu = PopupMenu(requireContext(), anchor)
        popupMenu.menuInflater.inflate(R.menu.type_menu, popupMenu.menu)

        popupMenu.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_quiz -> {
                    editText.setText("Quiz")
                    true
                }
                R.id.menu_survey -> {
                    editText.setText("Survey")
                    true
                }
                R.id.menu_social -> {
                    editText.setText("Social")
                    true
                }
                R.id.menu_proof_of_work -> {
                    editText.setText("Proof of work")
                    true
                }
                R.id.menu_referral -> {
                    editText.setText("Referral")
                    true
                }
                R.id.menu_assessment -> {
                    editText.setText("Assessment")
                    true
                }
                R.id.menu_test -> {
                    editText.setText("Test")
                    true
                }
                else -> false
            }
        }
        popupMenu.show()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MissionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MissionFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}