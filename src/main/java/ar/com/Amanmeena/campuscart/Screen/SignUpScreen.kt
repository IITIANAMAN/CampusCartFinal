package ar.com.Amanmeena.campuscart.Screen

import androidx.navigation.NavHostController
import androidx.compose.runtime.Composable
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import java.nio.file.WatchEvent


import androidx.compose.material.icons.Icons

import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.painter.Painter
import androidx.navigation.NavController

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import ar.com.Amanmeena.campuscart.R
import ar.com.Amanmeena.campuscart.ViewModels.AuthenticationViewModel


@Composable
fun SignUpScreen(navController: NavController, authViewModel: AuthenticationViewModel) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var name by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current
    var isLoading by remember {
        mutableStateOf(false)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()

            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Hello!",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace
            )

            Text("Create an account",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
            )

            Spacer(modifier = Modifier.padding(10.dp))
            Image(
                painter = painterResource(id = R.drawable.login),
                contentDescription = "Logo",
                modifier = Modifier.size(300.dp)

            )

                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Name", fontWeight = FontWeight.Bold,
                        color = Color.Black) },
                    modifier = Modifier.fillMaxWidth()
                )




            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email Address / Mobile number",fontWeight = FontWeight.Bold,
                    color = Color.Black) },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password",fontWeight = FontWeight.Bold,
                    color = Color.Black) },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),

                modifier = Modifier.fillMaxWidth()
            )


            Spacer(modifier = Modifier.padding(10.dp))

            Button(onClick = {
                authViewModel.signIn(email,password,name){success,errormessage->
                    if(success)
                    {
                        isLoading = true
                        navController.navigate("home"){
                            popUpTo("first"){inclusive = true}
                        }
                    }else
                    {
                        isLoading = true
                        Toast.makeText(context, errormessage, Toast.LENGTH_SHORT).show()
                    }

                }
            }, enabled = !isLoading, modifier = Modifier.fillMaxWidth().height(60.dp))

             {
                Text(if(isLoading)"Creating an account .." else "Create Account")
            }

            Spacer(modifier = Modifier.padding(5.dp))

            TextButton(onClick = { navController.navigate("login") }) {
                Text("Back to login ?", fontWeight = FontWeight.Bold,
                    color = Color.Red)
            }

            Spacer(modifier = Modifier.padding(10.dp))


        }
    }
}
