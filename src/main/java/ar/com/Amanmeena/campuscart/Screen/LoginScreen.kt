package ar.com.Amanmeena.campuscart.Screen


import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton

import androidx.compose.runtime.Composable
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



import androidx.compose.material.icons.Icons

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavController
import ar.com.Amanmeena.campuscart.R
import ar.com.Amanmeena.campuscart.ViewModels.AuthenticationViewModel


@Composable
fun LoginScreen(navController: NavController,authViewModel: AuthenticationViewModel) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val bgclr = colorResource(id = R.color.my_background_color)
    var isLoading by remember {
        mutableStateOf(false)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Hello!",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace
            )

            Text("Login to your account",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                )

            Spacer(modifier = Modifier.padding(10.dp))
            Image(
                painter = painterResource(id = R.drawable.login),
                contentDescription = "Logo",
                modifier = Modifier.size(300.dp)

                )
            Spacer(modifier = Modifier.padding(10.dp))
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email address") },

            )

            Spacer(modifier = Modifier.padding(10.dp))
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),


            )


            Spacer(modifier = Modifier.padding(10.dp))

            Button(
                onClick = {
                    isLoading = true
                    authViewModel.login(email,password) { success, errormessage ->
                        if(success)
                        {

                            navController.navigate("home")
                            {
                                popUpTo("first"){inclusive = true}
                            }
                            isLoading = false
                        }else
                        {
                            Toast.makeText(context, errormessage,Toast.LENGTH_SHORT).show()
                            isLoading = false
                        }
                    }
                },
                modifier = Modifier.size(150.dp, 40.dp),
                enabled = !isLoading

            ) {
                Text("Login")
            }

            Spacer(modifier = Modifier.padding(5.dp))

            TextButton(onClick = { navController.navigate("forgetPassword") }) {
                Text("Forgot Password?", color = Color.Red)
            }

            Spacer(modifier = Modifier.padding(10.dp))

            Text("Or sign in with")
            Spacer(modifier = Modifier.padding(10.dp))

            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {



            }
        }
    }
}





