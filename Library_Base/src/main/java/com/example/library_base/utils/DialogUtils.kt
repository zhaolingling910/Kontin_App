package com.example.library_base.utils


import android.app.Dialog
import android.content.Context
import android.text.TextUtils
import android.view.View
import android.widget.*
import java.util.*
import com.example.library_base.R

object DialogUtils {
    @JvmStatic
    fun showPrivacyDialog(
        activity: Context?,
        titleString:String?,
        contentString: String?,
        okString: String?,
        noString: String?,
        okOnclicklistener: View.OnClickListener?,
        noOnClickListener: View.OnClickListener?
    ): Dialog? {
        val dia = Dialog(activity!!, R.style.edit_AlertDialog_style)
        dia.setContentView(R.layout.dialog_privacy)
        val title = dia.findViewById<View>(R.id.title) as TextView
        val content = dia.findViewById<View>(R.id.content) as TextView
        val ok = dia.findViewById<View>(R.id.ok) as Button
        val no = dia.findViewById<View>(R.id.no) as Button
        if (!TextUtils.isEmpty(titleString)) {
            title.text = titleString
        }
        if (!TextUtils.isEmpty(contentString)) {
            content.text = contentString
        }
        if (!TextUtils.isEmpty(okString)) {
            ok.text = okString
        }
        if (!TextUtils.isEmpty(noString)) {
            no.text = noString
        }
        dia.setCanceledOnTouchOutside(true) // Sets whether this dialog is
        val w = dia.window
        val lp = w!!.attributes
        lp.x = 0
        lp.y = 0
        dia.onWindowAttributesChanged(lp)
        ok.setOnClickListener(okOnclicklistener)
        no.setOnClickListener(noOnClickListener)
        return dia
    }
}