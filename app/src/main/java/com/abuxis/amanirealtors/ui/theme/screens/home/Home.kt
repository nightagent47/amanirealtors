package com.abuxis.amanirealtors.ui.theme.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.abuxis.amanirealtors.navigation.ADD_PRODUCTS_URL
import com.abuxis.amanirealtors.navigation.ROUTE_BUYING
import com.abuxis.amanirealtors.navigation.ROUTE_SPLASH
import com.abuxis.amanirealtors.navigation.VIEW_PRODUCTS_URL

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var selected by remember { mutableIntStateOf(0) }
        Scaffold(
            bottomBar = {
                NavigationBar {
                    bottomNavItems.forEachIndexed { index, bottomNavItem ->
                        NavigationBarItem(
                            selected = index == selected,
                            onClick = {
                                selected = index
                                navController.navigate(ROUTE_BUYING)
                            },
                            icon = {
                                BadgedBox(
                                    badge = {
                                        if (bottomNavItem.badges != 0) {
                                            Badge {
                                                Text(text = bottomNavItem.badges.toString())
                                            }
                                        } else if (bottomNavItem.hasNews) {
                                            Badge()
                                        }
                                    }
                                ) {
                                    Icon(imageVector =
                                    if (index == selected)
                                        bottomNavItem.selectedIcon
                                    else
                                        bottomNavItem.unselectedIcon,
                                        contentDescription = bottomNavItem.title)
                                }

                            },
                            label = {
                                Text(text = bottomNavItem.title)
                            })
                    }
                }
            },
            topBar = {
                TopAppBar(
                    title = {
                        Text(color = Color.Unspecified,
                            text = "Apartments",
                            fontFamily = FontFamily.Default,
                            fontWeight = FontWeight.Bold,
                            fontSize = 30.sp)
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            navController.navigate(ROUTE_SPLASH)
                        }) {
                            Icon(Icons.Filled.ArrowBack, "backIcon")
                        }
                    },



                    )
            },
            //Content Section
            content = @Composable {
                Column(
                    Modifier
                        .fillMaxSize()
                        .background(Color.Black)
                        .horizontalScroll(ScrollState(1)),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {

                    Button(onClick = {
                        navController.navigate(ADD_PRODUCTS_URL)
                    },  modifier = Modifier.size(width = 200.dp, height = 35.dp),colors = ButtonDefaults.buttonColors(
                        Color.White)) {
                        Text(text = "Add Your House ",
                            color = Color.Black)
                    }

                    Spacer(modifier = Modifier.height(100.dp))

                    Button(onClick = {
                        navController.navigate(VIEW_PRODUCTS_URL)
                    }, modifier = Modifier.size(width = 200.dp, height = 35.dp),colors = ButtonDefaults.buttonColors(
                        Color.White)) {
                        Text(text = "View Houses",
                            color = Color.Black)
                    }
                }

            },
        )
    }
}



val bottomNavItems = listOf(
    BottomNavItem(
        title = "Rental",
        route="rental",
        selectedIcon= Icons.Filled.Home,
        unselectedIcon= Icons.Outlined.Home,
        hasNews = false,
        badges=0
    ),



    BottomNavItem(
        title = "Buying",
        route="buying",
        selectedIcon= Icons.Filled.Home,
        unselectedIcon= Icons.Outlined.Home,
        hasNews = false,
        badges=0
    ),
)



data class BottomNavItem(
    val title :String,
    val route :String,
    val selectedIcon: ImageVector,
    val unselectedIcon : ImageVector,
    val hasNews :Boolean,
    val badges :Int
)

@Preview
@Composable
fun HomePreview() {
    Home(rememberNavController())
}