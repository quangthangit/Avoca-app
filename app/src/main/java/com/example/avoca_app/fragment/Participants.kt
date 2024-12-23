package com.example.avoca_app.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.avoca_app.R
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import java.text.SimpleDateFormat
import java.util.*

class Participants : Fragment() {
    private lateinit var lineChart: LineChart

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_participants, container, false)

        // Initialize the chart
        lineChart = view.findViewById(R.id.lineChart)
        setupChart()

        return view
    }

    private fun setupChart() {
        // Customize chart appearance
        lineChart.apply {
            description.isEnabled = false
            legend.isEnabled = false
            setTouchEnabled(true)
            setDrawGridBackground(false)

            // Customize X axis
            xAxis.apply {
                position = XAxis.XAxisPosition.BOTTOM
                setDrawGridLines(true)
                gridColor = Color.LTGRAY
                gridLineWidth = 0.5f
                valueFormatter = DateAxisValueFormatter() // Use custom date formatter
            }

            // Customize Y axis
            axisLeft.apply {
                setDrawGridLines(true)
                gridColor = Color.LTGRAY
                gridLineWidth = 0.5f
                axisMaximum = 100f
                axisMinimum = 0f
            }
            axisRight.isEnabled = false
        }

        // Add data
        setChartData()
    }

    private fun setChartData() {
        // Create sample data
        val participated = ArrayList<Entry>()
        val avgCompletion = ArrayList<Entry>()
        val accuracy = ArrayList<Entry>()
        val avgPoint = ArrayList<Entry>()

        // Add your data points here
        // Data points with 2-day intervals
        val startDate = Calendar.getInstance()
        startDate.set(2024, 12, 20)  // Start date: 23-12-2024

        // Add data points for each 2-day interval
        for (i in 0 until 4) {
            val date = startDate.clone() as Calendar
            date.add(Calendar.DAY_OF_YEAR, i * 2)  // Add 2 days for each iteration
            val dateInMillis = date.timeInMillis.toFloat() // Convert to float timestamp
            val value = (Math.random() * 100).toFloat() // Random data value for example

            participated.add(Entry(dateInMillis, value)) // Add entry for "Participated"
        }

        // Create datasets
        val dataSets = ArrayList<ILineDataSet>()

        // LineDataSet for "Participated"
        LineDataSet(participated, "Participated").apply {
            color = Color.parseColor("#FFB800")
            setCircleColor(Color.parseColor("#FFB800"))
            lineWidth = 2f
            circleRadius = 4f
            setDrawCircleHole(false)
            mode = LineDataSet.Mode.CUBIC_BEZIER
            dataSets.add(this)
        }

        // Add other datasets similarly...

        // Set data to chart
        lineChart.data = LineData(dataSets)
        lineChart.invalidate()
    }

    // Custom date formatter for X axis
    class DateAxisValueFormatter : ValueFormatter() {
        private val sdf = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())

        override fun getFormattedValue(value: Float): String {
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = value.toLong()

            return sdf.format(calendar.time) // Format the date as dd-MM-yyyy
        }
    }
}
