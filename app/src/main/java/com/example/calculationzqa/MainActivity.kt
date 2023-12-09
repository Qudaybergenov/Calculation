package com.example.calculationzqa


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.calculationzqa.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.san0Id.setOnClickListener{ SetTextFields("0")}
        binding.san1Id.setOnClickListener{ SetTextFields("1")}
        binding.san2Id.setOnClickListener{ SetTextFields("2")}
        binding.san3Id.setOnClickListener{ SetTextFields("3")}
        binding.san4Id.setOnClickListener{ SetTextFields("4")}
        binding.san5Id.setOnClickListener{ SetTextFields("5")}
        binding.san6Id.setOnClickListener{ SetTextFields("6")}
        binding.san7Id.setOnClickListener{ SetTextFields("7")}
        binding.san8Id.setOnClickListener{ SetTextFields("8")}
        binding.san9Id.setOnClickListener{ SetTextFields("9")}

        binding.azaituId.setOnClickListener{ SetTextFields("-")}
        binding.kosuId.setOnClickListener{ SetTextFields("+")}
        binding.kobeituId.setOnClickListener{ SetTextFields("*")}
        binding.boluId.setOnClickListener{ SetTextFields("/")}
        binding.skobkazhabuId.setOnClickListener{ SetTextFields(")")}
        binding.tochkaId.setOnClickListener { SetTextFields(".") }


        binding.acId.setOnClickListener{
            binding.operacia.text=""
            binding.resultat.text=""
        }
        binding.backId.setOnClickListener {
            val str = binding.operacia.text.toString()
            if(str.isNotEmpty()){
                binding.operacia.text= str.substring(0, str.length-1)

                binding.resultat.text= ""
            }

        }
        binding.resId.setOnClickListener {
            try
            {
                val ex = ExpressionBuilder(binding.operacia.text.toString()).build()
                val result = ex.evaluate()

                val longR= result.toLong()
                if(result== longR.toDouble())
                    binding.resultat.text = longR.toString()
                else
                    binding.resultat.text = result.toString()
            }
            catch (e: Exception){
                Log.d("Ошибка","сообщение: ${e.message}")

            }
        }
    }

    fun SetTextFields(str: String) {
        if(binding.resultat.text!=""){
            binding.operacia.text=binding.resultat.text
            binding.resultat.text=""
        }
        binding.operacia.append(str)
    }
}