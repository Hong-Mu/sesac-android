package com.hongmu.sesac.models

import android.media.Image
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.hongmu.sesac.R
import kotlinx.coroutines.SupervisorJob

class C34Holder(root: View){
    var imageType: ImageView = root.findViewById(R.id.imageType)
    var textTitle: TextView = root.findViewById(R.id.textTitle)
    var textDate: TextView = root.findViewById(R.id.textDate)
    var imageMenu: ImageView = root.findViewById(R.id.imageMenu)
}
