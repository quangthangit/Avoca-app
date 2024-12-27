package com.example.avoca_app.fragment

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.PopupMenu
import android.widget.TextView
import com.example.avoca_app.R
import java.util.Calendar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MissionPage.newInstance] factory method to
 * create an instance of this fragment.
 */
class MissionPage : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_mission_page, container, false)


        val mission_type = view.findViewById<EditText>(R.id.mission_type_edittext)
        val mission_status = view.findViewById<EditText>(R.id.mission_status_edittext)
        val mission_start_date = view.findViewById<EditText>(R.id.mission_create_at_edittext)
        val reset_button = view.findViewById<Button>(R.id.reset_button)
        val search = view.findViewById<EditText>(R.id.mission_searching)

        mission_type.setOnClickListener {
            showTypePopup(it, mission_type)
        }
        mission_status.setOnClickListener {
            showStatusPopup(it, mission_type)
        }
        mission_start_date.setOnClickListener {
            showDatePickerDialog(mission_start_date)
        }
        reset_button.setOnClickListener {
            search.setText("")
            mission_type.setText("")
            mission_status.setText("")
            mission_start_date.setText("")
        }

        return view
    }

    private fun showTypePopup(anchor: View, editText: EditText) {
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

    private fun showStatusPopup(anchor: View, editText: EditText) {
        val popupMenu = PopupMenu(requireContext(), anchor)
        popupMenu.menuInflater.inflate(R.menu.mission_status_menu, popupMenu.menu)

        popupMenu.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_published -> {
                    editText.setText("Published")
                    true
                }
                R.id.menu_unpublished -> {
                    editText.setText("Unpublished")
                    true
                }
                R.id.menu_draft -> {
                    editText.setText("Draft")
                    true
                }
                else -> false
            }
        }
        popupMenu.show()
    }

    private fun showDatePickerDialog(textView: TextView) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(requireContext(), { _, selectedYear, selectedMonth, selectedDay ->
            val formattedDate = "$selectedDay-${selectedMonth + 1}-$selectedYear"
            textView.setText(formattedDate)
        }, year, month, day)

        datePickerDialog.show()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MissionPage.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MissionPage().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}