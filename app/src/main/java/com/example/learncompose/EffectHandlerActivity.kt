package com.example.learncompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.inc

class EffectHandlerActivity : ComponentActivity() {
    private var i = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  enableEdgeToEdge()
        setContent {
            var text by remember {
                mutableStateOf("")
            }
            Button(onClick = {
                text +="#"
            }){
                i++
                Text(text)
            }
        }
    }
}

@SuppressLint("ProduceStateDoesNotAssignValue")
@Composable
fun EffectHandler(countUpTo:Int): State<Int> {
//LaunchedEffect
    var text by remember {
        mutableStateOf("")
    }
    LaunchedEffect(key1 =text ) {
        delay(1000L)
        println("text is $text")
    }

    //rememberCoroutineScope
    val scope = rememberCoroutineScope()
    Button(onClick = {
        scope.launch {
            delay(1000L)
            println("hello world")
        }

    }){

    }

    //rememberUpdateState
//    @Composable
//    fun DataStreamSubscriptionExample(key: String) {
//        val currentKey by rememberUpdatedState(key)
//
//        DisposableEffect(currentKey) {
//            val subscription = subscribeToDataStream(currentKey) { data ->
//                // Handle the data received from the stream
//                println("Data received for key $currentKey: $data")
//            }
//
//            onDispose {
//                subscription.cancel() // Clean up when the composable is removed or the key changes
//            }
//        }
//    }
//
//    fun subscribeToDataStream(key: String, onDataReceived: (String) -> Unit): Subscription {
//        // Simulate subscribing to a data stream with the given key
//        println("Subscribed to data stream with key: $key")
//        return Subscription { /* Implementation to cancel the subscription */ }
//    }
//
//    class Subscription(private val onCancel: () -> Unit) {
//        fun cancel() = onCancel()
//    }

    //SideEffect
    SideEffect {
        println("Runs after recomposition")
    }

    //produceState
    return  produceState(initialValue = 0) {
        while (value < countUpTo){
            delay(1000L)
            value++
        }
    }
}

