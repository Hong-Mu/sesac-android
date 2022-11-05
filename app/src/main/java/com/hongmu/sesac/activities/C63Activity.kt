package com.hongmu.sesac.activities

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.hongmu.sesac.databinding.ActivityC63Binding

class C63Activity : AppCompatActivity() {

    private val binding by lazy { ActivityC63Binding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 전화번호 선택
        val requestActivity = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ){
            // 결과
            val cursor = contentResolver.query(
                it.data!!.data!!,
                arrayOf(
                    ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                    ContactsContract.CommonDataKinds.Phone.NUMBER
                ),
                null, null, null
            )

            var name = "None"
            var phone = "None"
            if(cursor!!.moveToFirst()){
                name = cursor.getString(0)
                phone = cursor.getString(1)
            }

            binding.textResult.text = "이름: $name, 전화번호: $phone"
        }

        // 권한
        val permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ){ isGranted ->
            if(isGranted){
                Toast.makeText(this, "권한 허용", Toast.LENGTH_SHORT).show()
                val intent = Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI)
                requestActivity.launch(intent)
            }
        }

        binding.btnOpenContract.setOnClickListener {
            val status = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
            if(status == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "픽", Toast.LENGTH_SHORT).show()
                val intent = Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI)
                requestActivity.launch(intent)
            } else {
                Toast.makeText(this, "권한 요청", Toast.LENGTH_SHORT).show()
                permissionLauncher.launch(Manifest.permission.READ_CONTACTS)
            }
        }
    }
}