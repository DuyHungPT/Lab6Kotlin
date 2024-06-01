package com.duyle.navhostkot104.screen

import android.content.Intent
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.duyle.navhostkot104.R

@Composable
fun LoginScreen(navController: NavHostController) {
    val context = LocalContext.current // getApplicationContext()
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val msg =
        navController.currentBackStackEntry?.savedStateHandle?.get<String>("msg")
    if (msg != null) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(painter = painterResource(id =
        R.drawable.ic_launcher_foreground), contentDescription =
        "Logo")
        // Username TextField
        OutlinedTextField(
            value = userName,
            onValueChange = { userName = it },
            label = { Text("Username") },
        )
        Spacer(modifier = Modifier.height(8.dp))
// Password TextField
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            if (userName.isNotBlank() && password.isNotBlank()) {
                Toast.makeText(context, "Login successful",
                    Toast.LENGTH_LONG).show()

                //navController.navigate("${NavigationItem.Home.route}/$userName/$password")

            } else {
                Toast.makeText(
                    context,

                    "Please enter username and password",
                    Toast.LENGTH_LONG

                ).show()
            }
        },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.DarkGray,
                contentColor = Color.White)
        ) {
            Text(text = "Login")
        }
    }
}