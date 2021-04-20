package com.example.thecatapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.example.thecatapi.api.RetrofitInstance
import retrofit2.HttpException
import java.io.IOException

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val api = RetrofitInstance.theCatApi
        lifecycleScope.launchWhenCreated {
            val response = try {
                api.getCat()
            } catch (e:IOException){
                Log.d(TAG, "IO exception")
                return@launchWhenCreated
            } catch (e:HttpException){
                Log.d(TAG, "Http exception")
                return@launchWhenCreated
            }
            if (response.isSuccessful){
                Log.d(TAG, "${response.body()}")
            }
        }
    }
}