package jp.techacademy.yuki.miyamoto3.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import jp.techacademy.yuki.miyamoto3.calcapp.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.textView.text = intent.getStringExtra("VALUE")
    }
}