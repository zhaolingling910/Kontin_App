package com.example.kontin_app.activity

import com.example.library_base.mainRepoModule
import com.example.library_base.mainViewModelModule
import com.example.library_base.netWork.RetrofitClient
import org.koin.dsl.module

val otherModule = module {
    single {
        RetrofitClient.instance
    }
}

val allModule = listOf(
    otherModule,
    mainRepoModule, mainViewModelModule
)