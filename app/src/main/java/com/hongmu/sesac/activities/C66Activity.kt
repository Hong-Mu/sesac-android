package com.hongmu.sesac.activities

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import com.hongmu.sesac.databinding.ActivityC66Binding
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class C66Activity : AppCompatActivity() {

    private val binding by lazy { ActivityC66Binding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            val bitmap = it.data?.extras?.get("data") as Bitmap
            bitmap?.let {
                binding.imageResult.setImageBitmap(bitmap)
            }
        }

        binding.btnData.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            launcher.launch(intent)
        }

        var filePath = ""
        val fileLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            val option = BitmapFactory.Options().apply {
                inSampleSize = 3
            }

            val bitmap = BitmapFactory.decodeFile(filePath, option)
            bitmap?.let {
                binding.imageResult.setImageBitmap(bitmap)
            }
        }

        binding.btnFile.setOnClickListener {
            val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
            val storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
            val file = File.createTempFile(
                "JPEG_${timeStamp}_",
                ".jpg",
                storageDir
            )

            filePath = file.absolutePath
            val uri = FileProvider.getUriForFile(
                this,
                "com.hongmu.sesac.fileprovider",
                file
            )
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply {
                putExtra(MediaStore.EXTRA_OUTPUT, uri)
            }
            fileLauncher.launch(intent)
        }
    }
}