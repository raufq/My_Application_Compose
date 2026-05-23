package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.network.NetworkApi
import com.example.myapplication.network.model.Result
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class MyViewModel: ViewModel() {
    private val _resultLiveData = MutableLiveData<List<Result>>()
    val resultLiveData: LiveData<List<Result>> = _resultLiveData
    fun fetchData(){


        try{
            viewModelScope.launch {
                var networkCall = NetworkApi.getApiInterface()
                var response = networkCall.getUsers()

                response.enqueue(object : retrofit2.Callback<List<com.example.myapplication.network.model.Result>> {
                    override fun onResponse(
                        p0: Call<List<com.example.myapplication.network.model.Result>?>,
                        p1: Response<List<com.example.myapplication.network.model.Result>?>
                    ) {
                        println("result is   "+p1.body())
                        var result = p1.body()
                        _resultLiveData.postValue(result!!)

                    }

                    override fun onFailure(
                        p0: Call<List<Result>?>,
                        p1: Throwable
                    ) {
                        println(p1.message)
                    }

                })
            }


        }catch (e: Exception){
            e.message
        }

    }

}