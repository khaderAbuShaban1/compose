package com.example.learncompose.BottomSheet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BottomSheetDefults1()
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun BottomSheetDefults1(){
    val scaffoldState = rememberBottomSheetScaffoldState()

    val sheetState = scaffoldState.bottomSheetState
    val scope = rememberCoroutineScope()


    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetContent = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Bottom sheet",
                    fontSize = 32.sp
                )
            }
        },

        sheetPeekHeight = 0.dp
    ) { padding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {

            Button(
                onClick = {
                    scope.launch {
                        if (sheetState.currentValue == SheetValue.Hidden ||
                            sheetState.currentValue == SheetValue.PartiallyExpanded
                        ) {
                            sheetState.expand()
                        } else {
                            sheetState.partialExpand()
//                                 if (sheetState.currentValue == SheetValue.Expanded) {
//                                     sheetState.hide()
//                                 }
                        }
                    }
                }
            ) {
                Text("Toggle Bottom Sheet")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldWithBottomSheet() {

    val sheetState = rememberModalBottomSheetState()
    var showSheet by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Scaffold + BottomSheet") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showSheet = true }
            ) {
                Icon(Icons.Default.Add, contentDescription = null)
            }
        }
    ) { padding ->

        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("اضغطي الزر لفتح Bottom Sheet")
        }
    }

    // ✅ Bottom Sheet
    if (showSheet) {
        ModalBottomSheet(
            onDismissRequest = {
                showSheet = false
            },
            sheetState = sheetState
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("هذا Bottom Sheet", style = MaterialTheme.typography.titleLarge)

                Spacer(Modifier.height(16.dp))

                Button(
                    onClick = { showSheet = false }
                ) {
                    Text("اغلاق")
                }
            }
        }
    }
}
