package com.hongmu.sesac.activities

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContracts
import com.hongmu.sesac.databinding.ActivityC64Binding

class C64Activity : AppCompatActivity() {

    private val binding by lazy { ActivityC64Binding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val imageLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult())
        {
            try {
                // 이미지 스케일링
                val option = BitmapFactory.Options()
                option.inSampleSize = 5

                // ContentResolver 에서 제공하는 스트림
                val inputStream = contentResolver.openInputStream(it.data!!.data!!)
                val bitmap = BitmapFactory.decodeStream(inputStream, null, option)
                inputStream!!.close()
                bitmap?.let {
                    binding.imageResult.setImageBitmap(bitmap)
                }
            } catch (e: Exception){
                e.printStackTrace()
            }
        }

        binding.btnLoadImage.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI).apply {
                type = "image/*"
            }
            imageLauncher.launch(intent)
        }
    }
}