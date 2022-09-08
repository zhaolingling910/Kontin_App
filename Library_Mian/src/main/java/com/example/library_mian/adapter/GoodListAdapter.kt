package com.example.library_mian.adapter


import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

import com.example.library_base.bean.SelectMallShopRecord
import com.example.library_base.utils.DensityUtil
import com.example.library_mian.R


class GoodListAdapter(layoutResId: Int) :
    BaseQuickAdapter<SelectMallShopRecord, BaseViewHolder>(layoutResId) {
    override fun convert(holder: BaseViewHolder, item: SelectMallShopRecord) {
        val name = holder.getView<TextView>(R.id.good_name)
        val money = holder.getView<TextView>(R.id.good_money)
        val iv_img = holder.getView<ImageView>(R.id.iv_img)
        name.text = item.productName
        money.text = "￥" + item.originalPrice + "元"
        Glide.with(context)
            .load(item.pic)
            .apply(
                RequestOptions().transform(
                    CenterCrop(),
                    RoundedCorners(DensityUtil.dip2px(10f))
                )
            )
            .into(iv_img)
    }

}