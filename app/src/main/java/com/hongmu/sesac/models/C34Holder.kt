package com.hongmu.sesac.models

import android.media.Image
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.hongmu.sesac.R
import kotlinx.coroutines.SupervisorJob

class C34Holder(root: View){
    var imageType: ImageView
    var textTitle: TextView
    var textDate: TextView
    var imageMenu: ImageView

    init {
        imageType = root.findViewById(R.id.imageType)
        textTitle = root.findViewById(R.id.textTitle)
        textDate = root.findViewById(R.id.textDate)
        imageMenu = root.findViewById(R.id.imageMenu)
    }
}
