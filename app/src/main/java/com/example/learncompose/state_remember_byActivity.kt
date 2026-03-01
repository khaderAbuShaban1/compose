package com.example.learncompose

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learncompose.ui.theme.LearnComposeTheme
import java.time.format.TextStyle

class state_remember_byActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {


        }
    }
}


@Composable
private fun MyText(){
    var count = 0
    println("counter redeawn")
    Text("number is $count",
        style = androidx.compose.ui.text.TextStyle(color = Color.White),
        modifier = Modifier.background(color = Color.Red).
    clickable(onClick = {
        println("counter cliked")
        count++
    }))


}