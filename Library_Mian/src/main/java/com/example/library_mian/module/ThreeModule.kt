package com.example.library_mian.module

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.library_base.bean.CustomActivityBean
import com.example.library_base.netWork.NetResult
import com.example.library_base.utils.ToastUtils
import com.example.library_mian.repository.ThreeRepositry
import kotlinx.coroutines.launch

class ThreeModule(private var reposity: ThreeRepositry) : ViewModel() {

    private var threeRepos = MutableLiveData<CustomActivityBean>()
    fun getThreeList(): MutableLiveData<CustomActivityBean>{
           viewModelScope.launch {
             var repos=  reposity.getThreeList()
               if (repos is NetResult.ThirdResult){
                   threeRepos.postValue(repos.result!!)
               }else if (repos is NetResult.Error){
                   repos.exception.msg?.let { ToastUtils.shorts(it) }
               }
           }
        return  threeRepos
    }
}