package com.hongmu.sesac.activities.network

import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.hongmu.sesac.R

class C85Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c85)

        val textResult: TextView = findViewById(R.id.textResult)
        textResult.text = isNetworkAvailable()
    }

    private fun isNetworkAvailable(): String {
        val connectivityManager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val currentNetwork = connectivityManager.activeNetwork
            val caps = connectivityManager.getNetworkCapabilities(currentNetwork)
            val result = caps?.run {
                when {
                    hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> "WiFi Online"
                    hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> "Cellular Online"
                    hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> "Ethernet Online"
                    else -> "Offline"
                }
            } ?: "Offline"
            return result
        } else {
            val result = when (connectivityManager.activeNetworkInfo?.type) {
                ConnectivityManager.TYPE_WIFI -> "WiFi Online"
                ConnectivityManager.TYPE_MOBILE -> "Cellular Online"
                ConnectivityManager.TYPE_ETHERNET -> "Ethernet Online"
                else -> "Offline"
            }
            return result
        }
    }
}