package jp.techacademy.yuki.miyamoto3.calcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import jp.techacademy.yuki.miyamoto3.calcapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.addButton.setOnClickListener(this)
        binding.subButton.setOnClickListener(this)
        binding.divButton.setOnClickListener(this)
        binding.mulButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            if (binding.editText1.text.isNotEmpty() && binding.editText2.text.isNotEmpty()) {
                val number1 = binding.editText1.text.toString().toFloat()
                val number2 = binding.editText2.text.toString().toFloat()


                var result: Float? = null
                when (v.id) {
                    R.id.addButton -> result = number1 + number2
                    R.id.subButton -> result = number1 - number2
                    R.id.mulButton -> result = number1 * number2
                    R.id.divButton -> {
                        if (number2 != 0f) result = number1 / number2
                        else binding.textView.text = "ゼロ除算"
                    }
                }

                if (result != null) {
                    val intent = Intent(this, SecondActivity::class.java)

                    intent.putExtra("VALUE", result.toString())
                    startActivity(intent)
                }
            } else {
                binding.textView.text = "数値入力なし"
            }
        }
    }
}