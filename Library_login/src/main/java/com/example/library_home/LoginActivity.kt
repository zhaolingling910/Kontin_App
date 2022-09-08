package com.example.library_home

import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.library_base.api.ARouterPath
import com.example.library_base.base.BaseActivity
import com.example.library_home.databinding.ActivityLoginBinding

@Route(path = ARouterPath.LOGIN_ACTIVITY)
class LoginActivity : BaseActivity<ActivityLoginBinding>() {

    override fun getLayoutResId(): Int {
        return R.layout.activity_login
    }

    override fun initView() {
    }

    override fun initData() {
        mViewDataBinding.button.setOnClickListener {
            val checked = mViewDataBinding.checkBox.isChecked
            if (checked) {
                ARouter.getInstance().build(ARouterPath.MAIN_ACTIVITY).navigation()
                finish()
            } else {
                Toast.makeText(this, "请同意隐私协议", Toast.LENGTH_LONG).show()
            }
        }
    }
}