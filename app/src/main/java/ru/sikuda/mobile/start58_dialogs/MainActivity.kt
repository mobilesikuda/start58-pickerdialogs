package ru.sikuda.mobile.start58_dialogs

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    var tvDate: TextView? = null
    var tvTime: TextView? = null
    //private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvTime = findViewById<View>(R.id.tvTime) as TextView
        tvDate = findViewById<View>(R.id.tvDate) as TextView

        val cal = Calendar.getInstance()
        val sdf = SimpleDateFormat("dd.MM.yyyy", Locale("ru", "RU"))
        //tvDate?.text = "Set date now: "+sdf.format(cal.time)

        val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            tvDate?.text = "Set date now: "+sdf.format(cal.time)
        }

        tvDate?.setOnClickListener {
            DatePickerDialog(this@MainActivity, dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)).show()
        }

        val timeSetListener = TimePickerDialog.OnTimeSetListener { view, hour, min ->
            tvTime?.text = "Set time now: "+hour+":"+min
        }

        tvTime?.setOnClickListener {
            TimePickerDialog(this@MainActivity, timeSetListener,
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                true).show()
        }
    }
}
