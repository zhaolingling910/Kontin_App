package com.example.library_mian.fragment

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager

import com.example.library_base.base.BaseFragment
import com.example.library_base.bean.GoodListBean
import com.example.library_base.bean.SelectMallShopRecord
import com.example.library_base.utils.ToastUtils
import com.example.library_mian.R
import com.example.library_mian.adapter.GoodListAdapter
import com.example.library_mian.databinding.FragmentOneAlLBinding
import com.example.library_mian.module.GoodListModule
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class OneAlLFragment : BaseFragment<FragmentOneAlLBinding>() {
    private lateinit var name: String
    private lateinit var adapter: GoodListAdapter
    private val mGoodListViewModel: GoodListModule by viewModel(clazz = GoodListModule::class)

    companion object {
        @JvmStatic
        fun newInstance(name: String) =
            OneAlLFragment().apply {
                arguments = Bundle().apply {
                    putString("name", name)
                }
            }
    }

    override fun getLayoutResId(): Int {
        return R.layout.fragment_one_al_l
    }

    override fun initData() {
        val staggerGridLayoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        mViewBinding.recyclerView.layoutManager = staggerGridLayoutManager
        mViewBinding.recyclerView.setHasFixedSize(false)
        adapter = GoodListAdapter(R.layout.layout_good_itme)
        mViewBinding.recyclerView.adapter = adapter

        mGoodListViewModel.getGoodList()
            .observe(this, Observer { goodList ->
                if (goodList is GoodListBean) {
                    adapter.addData(goodList.records)
                }
            })
    }

    override fun initView() {

    }
}