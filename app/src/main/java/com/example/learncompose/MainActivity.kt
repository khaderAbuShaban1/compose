package com.example.learncompose

import android.R.attr.shape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learncompose.ui.theme.LearnComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Column(
                modifier = Modifier.background(Color.Green)
                        .fillMaxSize(0.50f)
//                    .width(200.dp)
//                    .height(200.dp)
//                    .requiredWidth(600.dp)
//                    .fillMaxWidth()
//                    .fillMaxHeight()
                    .border(2.dp, Color.Red)

                    .padding(10.dp)

                    .border(2.dp, Color.Blue)
                    .clickable(onClick = {
                        println("Clicked")
                    })

            ) {
                Text(
                    modifier = Modifier//.offset(y = 30.dp)
                  ,
                text = "Hello",
                color = Color.Red,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
            )
                    Text(
                        modifier = Modifier//.offset(y = -30.dp)
                                ,

                text = "Jetpack",
                color = Color.Red,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
            )
            }




//            Row(
//                modifier = Modifier.fillMaxSize(),
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.Absolute.spacedBy(40.dp)
//
//            ) { Text(
//                text = "Hello",
//                color = Color.Red,
//                fontSize = 30.sp,
//                textAlign = TextAlign.Center,
//            )
//                Text(
//                    text = "World",
//                    color = Color.Red,
//                    fontSize = 30.sp,
//                    textAlign = TextAlign.Center,
//                )
//            }
//            Column(modifier = Modifier.fillMaxSize(),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Center
//            ) {
//
//                Text(
//                    text = "Hello World",
//                    color = Color.Red,
//                    fontSize = 30.sp,
//                    textAlign = TextAlign.Center,
//                )
//                Text(
//                    text = "World",
//                    color = Color.Red,
//                    fontSize = 30.sp,
//                    textAlign = TextAlign.Center,
//                )
//                Text(
//                    text = "Hello",
//                    color = Color.Red,
//                    fontSize = 30.sp,
//                    textAlign = TextAlign.Center,
//                )
//            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearnComposeTheme {
        Greeting("Android")
    }
}
