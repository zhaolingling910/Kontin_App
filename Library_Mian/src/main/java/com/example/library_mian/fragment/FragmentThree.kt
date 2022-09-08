package com.example.library_mian.fragment

import com.example.library_base.base.BaseFragment
import com.example.library_mian.R
import com.example.library_mian.databinding.FragmentThreeBinding

class FragmentThree : BaseFragment<FragmentThreeBinding>() {

    companion object {
        @JvmStatic
        fun newInstance() = FragmentThree()
    }

    override fun getLayoutResId(): Int {
        return  R.layout.fragment_three
    }



    override fun initView() {

    }

    override fun initData() {

    }
}