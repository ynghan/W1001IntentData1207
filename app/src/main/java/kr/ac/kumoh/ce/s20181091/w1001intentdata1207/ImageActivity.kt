package kr.ac.kumoh.ce.s20181091.w1001intentdata1207

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.ac.kumoh.ce.s20181091.w1001intentdata1207.databinding.ActivityImageBinding

class ImageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val res = when (intent.getStringExtra(MainActivity.keyName)) {
            "messi" -> R.drawable.messi
            "mbappe" -> R.drawable.mbappe
            else -> R.drawable.ic_launcher_foreground
        }
        binding.imgGundam.setImageResource(res)
    }
}