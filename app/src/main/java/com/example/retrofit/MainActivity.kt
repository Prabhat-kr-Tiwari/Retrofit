package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.retrofit.api.ApiInterface
import com.example.retrofit.api.RetrofitHelper
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val userApi=RetrofitHelper.getInstance().create(ApiInterface::class.java)

        GlobalScope.launch {

            val result=userApi.getUsers()
            if (result.body()!=null){
                Log.d("PRABHAT", "onCreate: ${result.body()}")

                result.body()!!.iterator().forEach {
                    Log.d("PRABHAT", "onCreate: ${it.login}")
                }
            }
        }
    }
}