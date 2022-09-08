package com.example.library_base.bean

data class CustomActivityBean (
    var code: Int,
    var mesg: String,
    val data: List<DataBean>
)

data  class DataBean (
        var id :String,
        var name: String,
        var type:String,
        var banner: String,
        var detailBanner: String
)
