package kr.ac.kumoh.ce.s20181091.w1001intentdata1207

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kr.ac.kumoh.ce.s20181091.w1001intentdata1207.databinding.ActivityImageBinding

class ImageActivity : AppCompatActivity(),
        View.OnClickListener {

        companion object {
            const val imageName = "image"
            const val resultName = "result"

            const val LIKE = 10
            const val DISLIKE = 20
            const val NONE = 0
        }
        private lateinit var binding: ActivityImageBinding
        private var image: String? = null

        override fun onClick(v: View?) {
            val intent = Intent()
            val value = when (v?.id) {
                binding.btnLike.id -> LIKE
                binding.btnDislike.id -> DISLIKE
                else -> NONE
            }
            intent.putExtra(imageName, image)
            intent.putExtra(resultName, value)
            setResult(RESULT_OK, intent)
            finish()
        }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityImageBinding.inflate(layoutInflater)
            setContentView(binding.root)


            image = intent.getStringExtra(MainActivity.keyName)
            val res = when (image) {
                "messi" -> R.drawable.messi
                "mbappe" -> R.drawable.mbappe
                else -> R.drawable.ic_launcher_foreground
            }
            binding.imgPlayer.setImageResource(res)

            binding.btnLike.setOnClickListener(this)
            binding.btnDislike.setOnClickListener(this)
        }
}