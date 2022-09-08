package com.example.kontin_app.activity

import android.app.Dialog
import android.view.View
import com.alibaba.android.arouter.launcher.ARouter
import com.example.kontin_app.R
import com.example.kontin_app.databinding.ActivityStartBinding
import com.example.library_base.api.ARouterPath
import com.example.library_base.base.BaseActivity
import com.example.library_base.utils.DialogUtils

class StartActivity : BaseActivity<ActivityStartBinding>() {
     var showPrivacyDialog: Dialog?=null
    override fun initView() {
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_start
    }

    override fun initData() {
        if (showPrivacyDialog==null){
            showPrivacyDialog = DialogUtils.showPrivacyDialog(this,
                "隐私政策",
                "隐私政策，各种权限，请您同意，不同意将无法使用该app！隐私政策，各种权限，请您同意，不同意将无法使用该app！隐私政策，各种权限，请您同意，不同意将无法使用该app！隐私政策，各种权限，请您同意，不同意将无法使用该app！隐私政策，各种权限，请您同意，不同意将无法使用该app！隐私政策，各种权限，请您同意，不同意将无法使用该app！隐私政策，各种权限，请您同意，不同意将无法使用该app！",
                "同意",
                "不同意",
                noOnClickListener = View.OnClickListener {
                    finish()
                },
                okOnclicklistener = View.OnClickListener {
                    ARouter.getInstance().build(ARouterPath.LOGIN_ACTIVITY).navigation()
                    finish()
                })!!
            showPrivacyDialog!!.show()
        }else{
            showPrivacyDialog!!.show()
        }

    }

}
