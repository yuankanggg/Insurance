package com.example.insurance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.insurance.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    //TODO2: Create an instance of View Binding
    //lateinit = late initialize
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //TODO 3: Initialize binding object
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root) //root refer to layout

        binding.buttonCalculate.setOnClickListener{
            val age = binding.spinnerAge.selectedItemPosition
            val gender = binding.radioGroupGender.checkedRadioButtonId
            val smoker = binding.checkBoxSmoker.isChecked

            var premium = when(age){
                0 -> 60
                1 -> 70
                2 -> 90
                3 -> 120
                4,5 -> 150
                else -> 0
            }

            if(gender == binding.radioButtonMale.id){

                val maleFee = when(age){
                    0 -> 0
                    1 -> 50
                    2 -> 100
                    3 -> 150
                    4,5 -> 200
                    else -> 0
                }

                premium += maleFee
            }

            if(smoker){
                val smokerFee = when(age){
                    0 -> 0
                    1 -> 100
                    2 -> 150
                    3 -> 200
                    4 -> 250
                    5 ->300
                    else -> 0
                }
                premium += smokerFee
            }

            val premium_output = NumberFormat.getCurrencyInstance().format(premium)
            binding.textViewPremium.text = premium_output
        }
        binding.buttonReset.setOnClickListener {

        }
    }
}