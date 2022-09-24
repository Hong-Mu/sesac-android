package com.hongmu.sesac.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import com.hongmu.sesac.R
import com.hongmu.sesac.models.C34Holder
import com.hongmu.sesac.models.C34Model

class C34Adapter(ctx: Context, val resId: Int, val data: MutableList<C34Model>) :
    ArrayAdapter<C34Model>(ctx, resId) {

    override fun getCount(): Int {
        return data.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        if (convertView == null) {
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(resId, null)
            val holder = C34Holder(convertView)
            convertView!!.tag = holder
        }

        val holder = convertView.tag as C34Holder

        val (title, date, type) = data[position]
        holder.apply {
            textTitle.text = title
            textDate.text = date
            if (type == "doc") {
                imageType.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        context.resources,
                        R.drawable.ic_type_doc,
                        null
                    )
                )
            } else if (type == "file") {
                imageType.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        context.resources,
                        R.drawable.ic_type_file,
                        null
                    )
                )
            } else if (type == "img") {
                imageType.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        context.resources,
                        R.drawable.ic_type_image,
                        null
                    )
                )
            }

            imageMenu.setOnClickListener {
                Toast.makeText(context, "$title 클릭", Toast.LENGTH_SHORT).show()
            }
        }

        return convertView
    }
}