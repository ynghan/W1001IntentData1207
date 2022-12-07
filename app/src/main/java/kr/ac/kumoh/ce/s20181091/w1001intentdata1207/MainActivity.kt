package kr.ac.kumoh.ce.s20181091.w1001intentdata1207

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kr.ac.kumoh.ce.s20181091.w1001intentdata1207.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        const val keyName = "image"
    }

    private lateinit var binding: ActivityMainBinding

    override fun onClick(v: View?) {
        val intent = Intent(this, ImageActivity::class.java)
        val value = when(v?.id) {
            binding.btnMessi.id -> "messi"
            binding.btnMbappe.id -> "mbappe"
            else -> return
        }
        intent.putExtra(keyName, value)
        startActivity(intent)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMessi.setOnClickListener(this)
        binding.btnMbappe.setOnClickListener(this)

        }
    }
