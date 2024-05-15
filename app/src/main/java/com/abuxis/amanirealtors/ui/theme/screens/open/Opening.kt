package com.abuxis.amanirealtors.ui.theme.screens.open

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.abuxis.amanirealtors.R
import com.abuxis.amanirealtors.navigation.ROUTE_LOGIN
import com.abuxis.amanirealtors.navigation.ROUTE_REGISTER

@Composable
fun Opening(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                // Replace with your image id
                painterResource(id = R.drawable.opening1),
                contentScale = ContentScale.FillBounds
            ),
    )
    { Column(modifier = Modifier
        .fillMaxSize()
        .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {

        Text(text = "Welcome To Amani Realtors",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Default,
            fontSize = 35.sp)
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Welcome!! Get access to the most luxurious properties money can buy.",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Default,
            fontSize = 15.sp,)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            navController.navigate(ROUTE_REGISTER)
        }, modifier = Modifier
            .fillMaxWidth(),colors = ButtonDefaults.buttonColors(Color.DarkGray)){
            Text(color = Color.White, text = "Sign Up")
        }
        Button(onClick = {
            navController.navigate(ROUTE_LOGIN)
        }, modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(Color.DarkGray)) {
            Text(color = Color.White, text = "Sign in")
        }
    }
    }
}
@Preview
@Composable
fun OpeningPreview() {
    Opening(rememberNavController())
}