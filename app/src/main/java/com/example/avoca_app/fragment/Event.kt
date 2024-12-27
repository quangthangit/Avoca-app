package com.example.avoca_app.fragment

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.avoca_app.R
import kotlinx.coroutines.SupervisorJob
import java.util.Calendar

class Event : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val view = inflater.inflate(R.layout.fragment_event, container, false)
        val startDate = view.findViewById<EditText>(R.id.startDate)
        val endDate = view.findViewById<EditText>(R.id.endDate)
        val statusEditText = view.findViewById<EditText>(R.id.status_edittext)

        startDate.setOnClickListener {
            showDatePickerDialog(startDate)
        }
        endDate.setOnClickListener {
            showDatePickerDialog(endDate)
        }
        statusEditText.setOnClickListener {
            showStatusPopup(it, statusEditText)
        }
        
        // Inflate the layout for this fragment
        return view
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

    private fun showStatusPopup(anchor: View, editText: EditText) {
        val popupMenu = PopupMenu(requireContext(), anchor)
        popupMenu.menuInflater.inflate(R.menu.status_menu, popupMenu.menu)

        popupMenu.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_ongoing -> {
                    editText.setText("On Going")
                    true
                }
                R.id.menu_done -> {
                    editText.setText("Completed")
                    true
                }
                else -> false
            }
        }
        popupMenu.show()
    }


    companion object {
        /**
         * Create a new instance of this fragment.
         * You no longer need parameters as this is a simple fragment.
         */
        @JvmStatic
        fun newInstance() = Event()
    }
}
