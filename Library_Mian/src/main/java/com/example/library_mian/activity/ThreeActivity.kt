package com.example.library_mian.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.library_base.api.ARouterPath
import com.example.library_base.base.BaseActivity
import com.example.library_base.bean.CustomActivityBean
import com.example.library_base.bean.GoodListBean
import com.example.library_mian.R
import com.example.library_mian.adapter.GoodListAdapter
import com.example.library_mian.adapter.ThreeAdapter
import com.example.library_mian.databinding.ActivityThreeBinding
import com.example.library_mian.module.GoodListModule
import com.example.library_mian.module.ThreeModule
import org.koin.androidx.viewmodel.ext.android.viewModel

@Route(path = ARouterPath.Three_ACTIVITY)
class ThreeActivity : BaseActivity<ActivityThreeBinding>() {

    lateinit var adapter: ThreeAdapter
    override fun getLayoutResId(): Int {
        return R.layout.activity_three
    }

    private val threeModule: ThreeModule by viewModel(clazz = ThreeModule::class)
    override fun initView() {

    }
    override fun initData() {
        mViewDataBinding.threeRecyclerView.layoutManager = LinearLayoutManager(this)
        mViewDataBinding.threeRecyclerView.setHasFixedSize(false)
        adapter = ThreeAdapter(R.layout.layout_three_itme)
        mViewDataBinding.threeRecyclerView.adapter = adapter
        threeModule.getThreeList()
            .observe(this, Observer { goodList ->
                if (goodList is CustomActivityBean) {
                    adapter.addData(goodList.data)
                }
            })
    }
}