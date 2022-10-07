package com.hongmu.sesac.activities

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.hongmu.sesac.databinding.ActivityC53Binding

class C53Activity : AppCompatActivity() {

    private val binding by lazy { ActivityC53Binding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnAlertDialog.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("test")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setMessage("종료할거야")
                .setPositiveButton("종료", null)
                .setNegativeButton("취소", null)
                .show()
        }

        binding.btnListDialog.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("과일 먹자 얘들아")
                .setItems(arrayOf("포도", "복숭아", "사과")){_, i ->
                    Toast.makeText(this@C53Activity, i.toString(), Toast.LENGTH_SHORT).show()
                }
                .setPositiveButton("확인", null)
                .show()
        }

        binding.btnTimeDialog.setOnClickListener {
            TimePickerDialog(this, object: TimePickerDialog.OnTimeSetListener{
                override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
                    Toast.makeText(this@C53Activity, "$p1 $p2", Toast.LENGTH_SHORT).show()
                }
            }, 15, 0, true).show()
        }

        binding.btnDateDialog.setOnClickListener {
            DatePickerDialog(this, object: DatePickerDialog.OnDateSetListener{
                override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
                    Toast.makeText(this@C53Activity, "$p1 ${p2+1} $p3", Toast.LENGTH_SHORT).show()
                }
            }, 2022, 8, 21).show()
        }
    }
}