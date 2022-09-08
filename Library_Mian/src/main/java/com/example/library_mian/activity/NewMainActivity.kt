package com.example.library_mian.activity

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.library_base.api.ARouterPath
import com.example.library_base.base.BaseActivity
import com.example.library_mian.R
import com.example.library_mian.databinding.ActivityNewMainBinding
import com.example.library_mian.fragment.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.FragmentTransaction


@Route(path = ARouterPath.MAIN_ACTIVITY)
class NewMainActivity : BaseActivity<ActivityNewMainBinding>() {
    private var fragmentone: FragmentOne? = null
    private var fragmenttwo: FragmentTwo? = null
    private var fragmentthree: FragmentThree? = null
    private var fragmentfour: FragmentFour? = null
    private var fragmentfive: FragmentFive? = null
    private lateinit var mSupportFragmentManager: FragmentManager
    private lateinit var mTransaction: FragmentTransaction
    private var mFragments: List<Fragment> = ArrayList()
    override fun getLayoutResId(): Int {
        return R.layout.activity_new_main
    }

    override fun initView() {

        mSupportFragmentManager = supportFragmentManager
        mTransaction = mSupportFragmentManager.beginTransaction()
        //默认先加载首页
        fragmentone = FragmentOne.newInstance()
        mFragments += fragmentone!!
        hide(fragmentone!!, true)
        mViewDataBinding.navView.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    if (fragmentone == null) {
                        fragmentone = FragmentOne.newInstance()
                        hide(fragmentone!!, true)
                    } else {
                        hide(fragmentone!!, false)
                    }
                }
                R.id.navigation_ingot_mall -> {
                    if (fragmenttwo == null) {
                        fragmenttwo = FragmentTwo.newInstance()
                        hide(fragmenttwo!!, true)
                        mFragments += fragmenttwo!!
                    } else {
                        hide(fragmenttwo!!, false)
                    }
                }
                R.id.navigation_select_mall -> {
                    if (fragmentthree == null) {
                        fragmentthree = FragmentThree.newInstance()
                        mFragments += fragmentthree!!
                        hide(fragmentthree!!, true)
                    } else {
                        hide(fragmentthree!!, false)
                    }
                }
                R.id.navigation_select_shop -> {
                    if (fragmentfour == null) {
                        fragmentfour = FragmentFour.newInstance()
                        mFragments += fragmentfour!!

                        hide(fragmentfour!!, true)

                    } else {
                        hide(fragmentfour!!, false)
                    }
                }
                R.id.navigation_class -> {
                    if (fragmentfive == null) {
                        fragmentfive = FragmentFive.newInstance()
                        mFragments += fragmentfive!!
                        hide(fragmentfive!!, true)
                    } else {
                        hide(fragmentfive!!, false)
                    }
                }
            }
            true
        })
    }

    private fun hide(
        fragment: Fragment,
        add: Boolean
    ) {
        mTransaction = mSupportFragmentManager.beginTransaction()
        if (add) {
            mTransaction.add(R.id.fragment, fragment)
        }
        for (fragments in mFragments) {
            if (fragment == fragments) {
                mTransaction.show(fragments)
            } else {
                mTransaction.hide(fragments)
            }
        }
        mTransaction.commit()
    }
    override fun initData() {

    }
}