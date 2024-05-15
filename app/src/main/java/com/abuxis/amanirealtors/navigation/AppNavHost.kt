package com.abuxis.amanirealtors.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.abuxis.amanirealtors.ui.theme.screens.login.Login
import com.abuxis.amanirealtors.ui.theme.screens.buying.Buying
import com.abuxis.amanirealtors.ui.theme.screens.home.Home
import com.abuxis.amanirealtors.ui.theme.screens.open.Opening
import com.abuxis.amanirealtors.ui.theme.screens.products.AddProductsScreen
import com.abuxis.amanirealtors.ui.theme.screens.products.ViewProductsScreen
import com.abuxis.amanirealtors.ui.theme.screens.registration.Register
import com.abuxis.amanirealtors.ui.theme.screens.splash.Splash

@Composable
fun AppNavHost(modifier: Modifier = Modifier, navController: NavHostController = rememberNavController(), startDestination:String= ROUTE_SPLASH) {

    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = startDestination
    ) {
        composable(ROUTE_LOGIN) {
            Login(navController)
        }
        composable(ROUTE_REGISTER) {
            Register(navController)
        }

        composable(ROUTE_OPEN){
            Opening(navController)
        }
        composable(ROUTE_SPLASH) {
            Splash(navController)
        }
        composable(ROUTE_BUYING) {
            Buying(navController)
        }
        composable(LOGIN_URL){
            Login(navController = navController)
        }
        composable(SIGNUP_URL){
            Register(navController = navController)
        }
        composable(HOME_URL){
            Home(navController = navController)
        }
        composable(ADD_PRODUCTS_URL){
            AddProductsScreen(navController = navController)
        }
        composable(VIEW_PRODUCTS_URL){
            ViewProductsScreen(navController = navController)
        }
    }
}