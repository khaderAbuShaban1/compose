package com.example.learncompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learncompose.ui.theme.LearnComposeTheme

class CardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

//            Card(
//                modifier = Modifier .padding(16.dp),
//                shape = RoundedCornerShape(16.dp),
//                elevation = CardDefaults.cardElevation(
//                    5.dp
//                ),
//                colors = CardDefaults.cardColors(
//                    containerColor = Color.White,
//                    contentColor = Color.Green
//                )
//            ) {
//                Column(
//                    modifier = Modifier.padding(13.dp)
//                ) {
//                    Text(text = "Hello", fontWeight = FontWeight.Bold)
//                    Text(text = "World")
//                }
//            }

            val title ="gggggggggggggggg"
            val contant ="hhhhhhhhhhhhhhhhhhhhhh"
            val painter = painterResource(R.drawable.ic_launcher_background)

            Box(
                modifier = Modifier.width(200.dp).padding(16.dp)
            ){
                ImageCard(title, contant, painter)

            }


        }
    }
}
@Composable
fun ImageCard(title : String, contant : String,painter : Painter ){
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(
                defaultElevation = 5.dp,
                pressedElevation = 8.dp,
                focusedElevation = 6.dp,

        )
    ) {
        Box(
            modifier = Modifier.height(200.dp)
        ){
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painter,
                contentScale = ContentScale.Crop,
                contentDescription = contant,
            )
            Box(
                modifier = Modifier
                    .fillMaxSize().background(brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        )
                        , startY = 300f
                    ))
                ,contentAlignment = Alignment.BottomStart

            ){
                Text(title, modifier = Modifier.padding(12.dp), style = TextStyle(color = Color.White, fontWeight = FontWeight.Bold , fontSize = 16.sp))
                Box(
                    modifier = Modifier
                        .fillMaxSize().background(brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Red
                            )
                            , startY = 300f
                        ))
                    ,contentAlignment = Alignment.BottomStart

                ) {
                    Text(contant, modifier = Modifier.padding(12.dp), style = TextStyle(color = Color.White, fontWeight = FontWeight.Bold , fontSize = 16.sp))

                }
            }


        }
    }

}

