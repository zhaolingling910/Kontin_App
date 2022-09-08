package com.example.library_base

import com.example.library_mian.module.GoodListModule
import com.example.library_mian.module.ThreeModule
import com.example.library_mian.repository.GoodListRepository
import com.example.library_mian.repository.ThreeRepositry
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
//注入module
var mainRepoModule  = module{
    single { GoodListRepository(get()) }
    single { ThreeRepositry(get()) }

}

var mainViewModelModule= module {
    viewModel { GoodListModule(get()) }
    viewModel { ThreeModule(get()) }
}