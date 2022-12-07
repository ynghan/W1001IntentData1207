package kr.ac.kumoh.ce.s20181091.w1001intentdata1207

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import kr.ac.kumoh.ce.s20181091.w1001intentdata1207.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        const val keyName = "image"
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var launcher: ActivityResultLauncher<Intent>



    override fun onClick(v: View?) {
        val intent = Intent(this, ImageActivity::class.java)
        val value = when(v?.id) {
            binding.btnMessi.id -> "messi"
            binding.btnMbappe.id -> "mbappe"
            else -> return
        }
        intent.putExtra(keyName, value)
        launcher.launch(intent)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMessi.setOnClickListener(this)
        binding.btnMbappe.setOnClickListener(this)

        launcher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) {

                    if(it.resultCode != RESULT_OK)
                        return@registerForActivityResult


                    val result = it.data?.getIntExtra(ImageActivity.resultName,
                            ImageActivity.NONE)


                    val str = when (result) {
                        ImageActivity.LIKE -> "좋아요"
                        ImageActivity.DISLIKE -> "싫어요"
                        else -> ""
                    }


                    val image = it.data?.getStringExtra(ImageActivity.imageName)



                    when(image) {
                        "messi" -> binding.btnMessi.text = "메시 ($str)"
                        "mbappe" -> binding.btnMbappe.text = "음바페 ($str)"
                    }
            }
    }
}
