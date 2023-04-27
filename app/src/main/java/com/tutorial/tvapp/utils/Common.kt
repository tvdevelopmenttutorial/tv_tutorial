package com.tutorial.tvapp.utils

import android.app.Dialog
import android.content.Context
import android.view.Window
import android.widget.TextView
import com.tutorial.tvapp.R

class Common {

    companion object {
        fun getWidthInPercent(context: Context, percent: Int): Int {
            val width = context.resources.displayMetrics.widthPixels ?: 0
            return (width * percent) / 100
        }

        fun getHeightInPercent(context: Context, percent: Int): Int {
            val height = context.resources.displayMetrics.heightPixels ?: 0
            return (height * percent) / 100
        }

        fun TextView.isEllipsized(ellipsize: (isEllipsized: Boolean) -> Unit) {
            val lineCount = layout?.lineCount ?: 0
            if (lineCount > 0) {
                val ellipseCount = layout?.getEllipsisCount(lineCount - 1) ?: 0
                ellipsize.invoke(ellipseCount > 0)
            }
        }

        fun descriptionDialog(context: Context, title: String?, subtext: String, description: String) {
            val dialog = Dialog(context, R.style.Theme_TvApp)
            dialog.window?.setBackgroundDrawableResource(R.color.transparent)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.dialog_description)

            dialog.findViewById<TextView>(R.id.tvTitle).text = title
            dialog.findViewById<TextView>(R.id.tvSubTitle).text = subtext
            dialog.findViewById<TextView>(R.id.description).text = description

            dialog.findViewById<TextView>(R.id.closeBtn).setOnClickListener {
                dialog.dismiss()
            }

            dialog.show()
        }
    }

}