package com.example.learncompose

import android.content.ClipData
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learncompose.ui.theme.LearnComposeTheme

class ListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
   //     enableEdgeToEdge()
        setContent {
            val scrollState = rememberScrollState()

//            Row(modifier =  Modifier.fillMaxSize().horizontalScroll(scrollState)){
//                for (i in 1..50){
//                    Text("item $i", modifier = Modifier.padding(16.dp))
//
//                }
//            }

            LazyColumn(modifier = Modifier.fillMaxSize()) {
//                item {
//                    for (i in 1..50){
//                    Text("item $i", modifier = Modifier.padding(16.dp))
//
//                }
//                }
//                items(listOf("a","b","c","a","b","c")){
//                    Text("item $it", modifier = Modifier.padding(16.dp))
//
//                }

                itemsIndexed(listOf("a","b","c","a","b","c")){
                    index, item ->
                    Text("item $item , index $index", modifier = Modifier.padding(16.dp))

                }

            }




        }
    }
}

@Composable
fun Greeting3(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    LearnComposeTheme {
        Greeting3("Android")
    }
}