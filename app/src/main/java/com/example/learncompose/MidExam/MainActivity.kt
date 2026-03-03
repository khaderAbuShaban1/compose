package com.example.learncompose.MidExam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learncompose.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomePage()
        }
    }
}

data class Faculty(
    val name: String,
    val image: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage() {

    val faculties = listOf(
        Faculty("تكنولوجيا المعلومات", R.drawable.logo),
        Faculty("الهندسة و النظم الذكية", R.drawable.logo),
        Faculty("التمريض و علوم الصحة", R.drawable.logo),
        Faculty("إدارة المال و الأعمال", R.drawable.logo),
        Faculty("التربية", R.drawable.logo),
        Faculty("تكنولوجيا المعلومات", R.drawable.logo),
        Faculty("الهندسة و النظم الذكية", R.drawable.logo),
        Faculty("التمريض و علوم الصحة", R.drawable.logo),
        Faculty("إدارة المال و الأعمال", R.drawable.logo),
        Faculty("التربية", R.drawable.logo)

    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "UCAS - Faculties",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menu",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Blue
                )
            )
        }
    ) { paddingValues ->

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(faculties) { faculty ->
                FacultyCard(faculty)
            }
        }
    }
}

@Composable
fun FacultyCard(faculty: Faculty) {

    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier.fillMaxWidth(),
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = faculty.image),
                contentDescription = faculty.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .background(Color.LightGray),
                contentScale = ContentScale.Fit
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(12.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = faculty.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}