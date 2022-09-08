package com.example.library_mian.fragment


import com.example.library_base.base.BaseFragment
import com.example.library_mian.R
import com.example.library_mian.databinding.FragmentFourBinding


class FragmentFour : BaseFragment<FragmentFourBinding>() {

    companion object {

        fun newInstance() = FragmentFour()

    }

    override fun getLayoutResId(): Int {
        return  R.layout.fragment_four
    }


    override fun initView() {

    }

    override fun initData() {

    }
}