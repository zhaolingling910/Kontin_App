package com.example.library_mian.fragment

import com.example.library_base.base.BaseFragment
import com.example.library_mian.R
import com.example.library_mian.databinding.FragmentFiveBinding

class FragmentFive : BaseFragment<FragmentFiveBinding>() {

    companion object {
        @JvmStatic
        fun newInstance() = FragmentFive()
    }

    override fun getLayoutResId(): Int {
        return  R.layout.fragment_five
    }


    override fun initView() {

    }

    override fun initData() {

    }
}