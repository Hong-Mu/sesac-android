package com.hongmu.sesac.activities.network

import android.app.usage.NetworkStatsManager
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.hongmu.sesac.R
import java.net.ConnectException

class C85Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c85)

        val textResult: TextView = findViewById(R.id.textResult)
        textResult.text = isNetworkAvailable()
    }

    private fun isNetworkAvailable(): String{
        val connectivityManager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val currentNetwork = connectivityManager.activeNetwork ?: return "Offline"
            val caps = connectivityManager.getNetworkCapabilities(currentNetwork) ?: return "Offline"
            return when {
                caps.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                    return "WiFi Online"
                }
                caps.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                    return "Cellular Online"
                }
                else -> "Offline"
            }

        } else {
            if(connectivityManager.activeNetworkInfo?.isConnected ?: false){
                return "Online"
            } else {
                return "Offline"
            }
        }
    }
}