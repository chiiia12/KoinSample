package com.chiiia12.koinsample

import android.app.Application
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(myModule)
        }
    }
}

val myModule = module {
    viewModel { MainViewModel(get()) }
    single { MainRepository(get()) }
    single { UserProvider() }
    single {
        OkHttpClient.Builder().build()
    }
    single {
        Retrofit.Builder()
            .baseUrl("http://dummy.restapiexample.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get()).build().create(ApiService::class.java)
    }
}
