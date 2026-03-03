package com.example.learncompose

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class LazyGrid : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val stateVar = rememberLazyGridState(
                initialFirstVisibleItemIndex = 90
            )
            LazyVerticalGrid(
//                columns = GridCells.FixedSize(100.dp),
                columns = GridCells.Adaptive(100.dp),
//                columns = GridCells.Fixed(4),
                state = stateVar,
                modifier = Modifier.fillMaxSize(),

                ) {
                items(100){ i ->
                    Box(modifier = Modifier.padding(8.dp).
                    aspectRatio(1f).
                    clip(RoundedCornerShape(20.dp))
                        .background(Color.Green),
                        contentAlignment = Alignment.Center){
                        Text("item $i")
                    }


                }
            }
        }
    }
}

