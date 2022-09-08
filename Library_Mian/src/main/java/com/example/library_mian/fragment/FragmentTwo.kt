package com.example.library_mian.fragment


import com.example.library_base.base.BaseFragment
import com.example.library_mian.R

import com.example.library_mian.databinding.FragmentTwoBinding

class FragmentTwo : BaseFragment<FragmentTwoBinding>() {

    companion object {
        @JvmStatic
        fun newInstance() = FragmentTwo()
    }

    override fun getLayoutResId(): Int {
        return R.layout.fragment_two
    }

    override fun initView() {

    }

    override fun initData() {

    }


}