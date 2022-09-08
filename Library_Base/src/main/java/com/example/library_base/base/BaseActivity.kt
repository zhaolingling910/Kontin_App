package com.example.library_base.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

//抽象类可以被引用
abstract class BaseActivity<M : ViewDataBinding> : AppCompatActivity() {
    lateinit var mViewDataBinding: M
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutResId())
        initView()
        initData()
    }
    /**
     * 布局
     */
    abstract fun getLayoutResId(): Int
    /**
     * 控件处理
     */
    abstract fun initView()
    /**
     * 数据处理
     */
    abstract fun initData()

}