package com.example.learncompose.BottomNavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.learncompose.BottomNavigation.ui.theme.LearnComposeTheme
import com.example.learncompose.BottomNavigation.bottomNavItem

class bottomNavigation : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    //    enableEdgeToEdge()
        setContent {
            var selected by remember {
                mutableStateOf(0)
            }

            Scaffold (
                bottomBar = {
                    NavigationBar {
                        bottomNavItem.forEachIndexed { index, bottomNavItem ->
                            NavigationBarItem(
                                selected =  index == selected,
                                onClick = {
                                    selected = index
                                },
                                icon = {
                                    BadgedBox(
                                        badge = {
                                            if (bottomNavItem.badges != 0){
                                                Badge{
                                                    Text(
                                                        text = bottomNavItem.badges.toString()
                                                    )
                                                }
                                            }else if (bottomNavItem.hasNews){
                                                Badge()
                                            }
                                        }
                                    ) {
                                        Icon(
                                            imageVector = if (index == selected) {
                                                bottomNavItem.selectedicon
                                            } else bottomNavItem.unselectedicon,
                                            contentDescription = bottomNavItem.title
                                        )
                                    }
                                },
                                label = {
                                    Text(text = bottomNavItem.title)
                                }
                            )
                        }
                    }

                },
                floatingActionButton = {
                    FloatingActionButton(onClick = { /*TODO*/ }) {}
                }
            ){
                val padding = it
            }
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
val bottomNavItem = listOf(
    BottomNavItem(
        title = "Home",
        route = "home",
        selectedicon = Icons.Default.Home,
        unselectedicon = Icons.Default.Home,
        hasNews = false,
        badges = 0

    ),
    BottomNavItem(
        title = "Posts",
        route = "posts",
        selectedicon = Icons.Filled.Call,
        unselectedicon = Icons.Filled.Call,
        hasNews = false,
        badges = 0

    ),
    BottomNavItem(
        title = "Notifications",
        route = "notifications",
        selectedicon = Icons.Filled.Notifications,
        unselectedicon = Icons.Outlined.Notifications,
        hasNews = false,
        badges = 5

    ),
    BottomNavItem(
        title = "Profile",
        route = "profile",
        selectedicon = Icons.Filled.AccountCircle,
        unselectedicon = Icons.Outlined.AccountCircle,
        hasNews = true,
        badges = 0

    ),
)
