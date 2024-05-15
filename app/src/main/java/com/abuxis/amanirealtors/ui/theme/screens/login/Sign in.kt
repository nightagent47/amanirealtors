package com.abuxis.amanirealtors.ui.theme.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.abuxis.amanirealtors.data.AuthViewModel
import com.abuxis.amanirealtors.navigation.ROUTE_REGISTER

@Composable
fun Login(navController: NavHostController) {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var pass by remember { mutableStateOf(TextFieldValue("")) }
    val context= LocalContext.current
    Column(modifier = Modifier.run {
        fillMaxSize()
            .background(Color.Black)
    },
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Log In",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Default,
            fontSize = 30.sp)
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(value =email , onValueChange = {email=it},
            label = { Text(color = Color.White, text = "Enter Email") },
            shape = RoundedCornerShape(30.dp),
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription ="Email" ) },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedLeadingIconColor = Color.White,
                unfocusedBorderColor = Color.White,
            )

        )
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(value =pass , onValueChange = {pass=it},
            label = { Text(color = Color.White, text = "Enter Password") },
            shape = RoundedCornerShape(30.dp),
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription ="Password" ) },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color.White,
                unfocusedLeadingIconColor = Color.White,
            )
        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            val mylogin= AuthViewModel(navController, context )
            mylogin.login(email.text.trim(),pass.text.trim())
        }, modifier = Modifier.size(width = 350.dp, height = 35.dp),colors = ButtonDefaults.buttonColors(
            Color.White)) {
            Text(color = Color.Black, text = "Log In")
        }
        Spacer(modifier = Modifier.height(20.dp))

        TextButton(onClick = { navController.navigate(ROUTE_REGISTER)},
            colors = ButtonDefaults.buttonColors(containerColor = Color.Unspecified),
            modifier = Modifier.size(width = 250.dp, height = 35.dp)
        ) {
            Text(text = "Don't have an account? Register",
                fontSize = 15.sp,
                color = Color.White)
        }

    }
}
@Preview
@Composable
fun LoginPreview() {
    Login(rememberNavController())
}