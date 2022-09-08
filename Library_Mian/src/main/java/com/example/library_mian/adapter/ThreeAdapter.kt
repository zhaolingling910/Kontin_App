package com.example.library_mian.adapter

import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

import com.example.library_base.bean.DataBean
import com.example.library_base.utils.DensityUtil
import com.example.library_mian.R

class ThreeAdapter(layout:Int) :BaseQuickAdapter<DataBean,BaseViewHolder>(layout) {
    override fun convert(holder: BaseViewHolder, item: DataBean) {
        val money = holder.getView<TextView>(R.id.money)
        val title = holder.getView<TextView>(R.id.title)
        val img = holder.getView<ImageView>(R.id.img)
        title.text=item.name
        money.text=item.id
        Glide.with(context)
            .load(item.banner)
            .apply(
                RequestOptions().transform(
                    CenterCrop(),
                    RoundedCorners(DensityUtil.dip2px(10f))
                )
            )
            .into(img)
    }

}