package com.example.tugas2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var editText1 : EditText
    private lateinit var editText2 : EditText
    private lateinit var operasi : RadioGroup
    private lateinit var sum : RadioButton
    private lateinit var substract : RadioButton
    private lateinit var multiple : RadioButton
    private lateinit var divide : RadioButton
    private lateinit var buttonKalkulasi : Button
    private var result: Double? = null

    private fun initComponents(){
        editText1 = findViewById(R.id.editText1)
        editText2 = findViewById(R.id.editText2)
        operasi = findViewById(R.id.operasi)
        sum = findViewById(R.id.sum)
        substract = findViewById(R.id.substract)
        multiple = findViewById(R.id.multiple)
        divide = findViewById(R.id.divide)
        buttonKalkulasi = findViewById(R.id.buttonKalkulasi)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        initComponents()

        buttonKalkulasi.setOnClickListener(){
            val firstNumber = editText1.text.toString().toDoubleOrNull()
            val secondNumber = editText2.text.toString().toDoubleOrNull()
            if (firstNumber != null && secondNumber!=null){
                when(operasi.checkedRadioButtonId){
                    R.id.sum->
                        result = firstNumber + secondNumber
                    R.id.substract->
                        result = firstNumber - secondNumber
                    R.id.multiple->
                        result=firstNumber * secondNumber
                    R.id.divide->
                        if (secondNumber !=0.0){
                            result = firstNumber/secondNumber
                        }
                        else {
                            result = null
                        }
                }
            }
            else{
                result = null
            }
            if (result != null){
                val intentData = Intent(this@MainActivity,MainActivity2::class.java)
                intentData.putExtra("result",result)
                startActivity(intentData)
            }
        }
    }
}