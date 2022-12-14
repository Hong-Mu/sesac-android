package com.hongmu.sesac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hongmu.sesac.activities.*
import com.hongmu.sesac.activities.assignments.NotificationResponseActivity
import com.hongmu.sesac.activities.background.C79Activity
import com.hongmu.sesac.activities.geolocation.C81Activity
import com.hongmu.sesac.activities.notification.C74Activity
import com.hongmu.sesac.adapters.ActivityAdapter
import com.hongmu.sesac.activities.geolocation.C82Activity
import com.hongmu.sesac.activities.geolocation.C83Activity
import com.hongmu.sesac.activities.network.C85Activity
import com.hongmu.sesac.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recyclerView.adapter = ActivityAdapter(listOf(
            C100Activity::class.java,
            C85Activity::class.java,
            C83Activity::class.java,
            C82Activity::class.java,
            C81Activity::class.java,
            NotificationResponseActivity::class.java,
            C79Activity::class.java,
            C74Activity::class.java,
            C72Activity::class.java,
            C71Activity::class.java,
            C68Activity::class.java,
            C66Activity::class.java,
            C65Activity::class.java,
            C64Activity::class.java,
            C63Activity::class.java,
            C60Activity::class.java,
            C59Activity::class.java,
            C57Activity::class.java,
            C56Activity::class.java,
            C55Activity::class.java,
            C53Activity::class.java,
            C52Activity::class.java,
            C51Activity::class.java,
            C49Activity::class.java,
            C48Activity::class.java,
            C47Activity::class.java,
            TodoListActivity::class.java,
            C45Activity::class.java,
            C43Activity::class.java,
            C42Activity::class.java,
            C41Activity::class.java,
            C40Activity::class.java,
            C38Activity::class.java,
            C37Activity::class.java,
            C36Activity::class.java,
            MessengerIntroActivity::class.java,
            C35Activity::class.java,
            C34Activity::class.java,
            C33Activity::class.java,
            C32Activity::class.java,
            C31Activity::class.java,
            C29Activity::class.java,
            C28Activity::class.java,
            C27Activity::class.java,
            C25Activity::class.java,
            C23Activity::class.java,
            C24Activity::class.java,
            CallKeypadActivity::class.java,
            KakaoConfirmPasswordActivity::class.java,
            C21Activity::class.java,
            C20Activity::class.java,
            C19Activity::class.java,
            C18Activity::class.java,
            C16Activity::class.java,
            C15Activity::class.java,
            C14Activity::class.java,
            C13Activity::class.java,
            C12Activity::class.java,
            C11Activity::class.java,
        ))
    }
}