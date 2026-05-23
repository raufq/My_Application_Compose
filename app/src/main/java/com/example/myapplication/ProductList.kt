package com.example.myapplication

import android.annotation.SuppressLint
import android.net.Network
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapplication.network.NetworkApi
import com.example.myapplication.network.model.ResponseData
import com.example.myapplication.network.model.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Response



@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun productList(navController: NavController){
   var viewModel:MyViewModel = viewModel()
    viewModel.fetchData()
    val list by viewModel.resultLiveData.observeAsState(emptyList())

    LazyColumn{
        items(list){item->
            singleItem(item)
        }
    }

}

@Composable
fun singleItem(item:Result){
    Card(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        Column(
            modifier=Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = item.id.toString())
            Text(text = item.title)
            Text(text = item.userId.toString())
            Text(text = item.completed)
        }
    }


}
