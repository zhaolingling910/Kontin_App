package com.example.library_mian.module


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.library_base.bean.GoodListBean
import com.example.library_base.netWork.NetResult
import com.example.library_base.utils.RequestBodyUtils
import com.example.library_base.utils.ToastUtils
import com.example.library_mian.repository.GoodListRepository
import kotlinx.coroutines.launch
import org.json.JSONObject

class GoodListModule(private var goodListRepository: GoodListRepository) : ViewModel() {
    private val mGoodList = MutableLiveData<GoodListBean>()
    fun getGoodList(
    ): MutableLiveData<GoodListBean> {
        viewModelScope.launch {
            var json = JSONObject()
            json.put("pageNum", "1")
            json.put("pageSize", "10")
            json.put("versions", "1.0.3")
            var toRequestBody = RequestBodyUtils.toRequestBody(json = json.toString())
            val goodList = goodListRepository.getGoodList(toRequestBody)
            if (goodList is NetResult.Success) {
                mGoodList.postValue(goodList.data!!)
            } else if (goodList is NetResult.Error) {
                goodList.exception.msg?.let { ToastUtils.shorts(it) }
            }
        }
        return mGoodList
    }
}