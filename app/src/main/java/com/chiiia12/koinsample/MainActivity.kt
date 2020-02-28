package com.chiiia12.koinsample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()
    private val userProvider: UserProvider by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.init()
        userProvider.getActiveUser()
    }
}

class MainViewModel(private val repository: MainRepository) : ViewModel() {
    fun init() {
        Log.d(MainViewModel::class.java.simpleName, "init() is called")
        repository.getMainModel()
    }

}

class MainRepository() {
    fun getMainModel() {
        Log.d(MainRepository::class.java.simpleName, "getMainModel()")
    }
}

class UserProvider {
    fun getActiveUser() {
        Log.d(UserProvider::class.java.simpleName, "getActiveUser()")
    }
}