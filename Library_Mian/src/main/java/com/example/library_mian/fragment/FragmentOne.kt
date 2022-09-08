package com.example.library_mian.fragment

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.alibaba.android.arouter.launcher.ARouter
import com.example.library_base.api.ARouterPath
import com.example.library_base.base.BaseFragment
import com.example.library_mian.R
import com.example.library_mian.databinding.FragmentOneBinding
import com.google.android.material.tabs.TabLayoutMediator

class FragmentOne : BaseFragment<FragmentOneBinding>() {


    companion object {
        @JvmStatic
        fun newInstance() = FragmentOne()

    }

    override fun getLayoutResId(): Int {
        return R.layout.fragment_one
    }

    override fun initView() {
    }

    override fun initData() {
        var nameList: List<String> =
            listOf<String>("精选", "美食", "家电", "居家用品", "衣服", "女装", "男装", "户外", "运动", "家具")
        initViewpager(nameList)
        mViewBinding.threeList.setOnClickListener {
             ARouter.getInstance().build(ARouterPath.Three_ACTIVITY).navigation()
        }
    }
    private fun initViewpager(nameList: List<String>) {
        mViewBinding.viewPage.offscreenPageLimit = ViewPager2.OFFSCREEN_PAGE_LIMIT_DEFAULT
        mViewBinding.viewPage.adapter =
            object : FragmentStateAdapter(childFragmentManager, lifecycle) {
                override fun getItemCount(): Int {
                    return if (nameList.isNotEmpty()) {
                        nameList.size
                    } else {
                        0
                    }
                }

                override fun createFragment(position: Int): Fragment {
                    return createChildFragment(position, nameList)
                }
            }
        val tabLayoutMediator = TabLayoutMediator(
            mViewBinding.tabLayout,
            mViewBinding.viewPage,
            true,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                tab.text = nameList[position]
            })
        tabLayoutMediator.attach()

    }

    private fun createChildFragment(position: Int, nameList: List<String>): Fragment {
        return OneAlLFragment.newInstance(name = nameList.get(position))
    }


}