package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.network.NetworkApi
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var scope = rememberCoroutineScope()
            MyApplicationTheme {


                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    Column(Modifier.padding(innerPadding)) {

                        UsersApplication()
                    }
                    /*Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )*/
                }
            }


        }
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    var isShowDetails = remember{mutableStateOf(false) }
    var isShowList = remember { mutableStateOf(false) }
    if(isShowList.value){
    LazyColumn(modifier = modifier) {
        items(100) {
            singleItem(it, onClickItem = {
                isShowDetails.value = !isShowDetails.value
                isShowList.value = !isShowList.value
            })
        }
    }}
    if(isShowDetails.value){
        showDetails(modifier)
    }
}
@Composable
fun showDetails(modifier: Modifier){
    Row(modifier =  modifier) {
        Text(text = "Details")
    }

}
@Composable
fun singleItem(item:Int, onClickItem:()->Unit){
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable { onClickItem() } // Handles the click
        .padding(16.dp)
    ) {
        Text(text = "items "+item)
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}
