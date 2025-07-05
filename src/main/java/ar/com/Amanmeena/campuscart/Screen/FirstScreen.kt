package ar.com.Amanmeena.campuscart.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ar.com.Amanmeena.campuscart.R
import java.nio.file.WatchEvent

@Composable
fun FirstScreen(navController: NavHostController) {
    val bgclr = colorResource(id = R.color.my_background_color)
    Column(modifier = Modifier.fillMaxSize().background(bgclr).padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

        ) {

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",

        )
        Text(
            text = "Welcome to CampusCart",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            color = Color.White
        )
        Spacer(modifier = Modifier.padding(30.dp))
        Text(
            text = "Best shopping app for your campus",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.Monospace,
            color = Color.White
        )
        Spacer(modifier = Modifier.padding(30.dp))
        Button(onClick = {navController.navigate("login")},
            modifier = Modifier.fillMaxWidth().height(60.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Gray,       // Background color
                contentColor = Color.White                // Text/icon color
            )

        )
        {
            Text("Continue to login",
                fontSize = 20.sp,
                )
        }
        Spacer(modifier = Modifier.padding(8.dp))
        OutlinedButton(onClick = {navController.navigate("signup")},
            modifier = Modifier.fillMaxWidth().height(60.dp)
            )
        {
            Text("New to campus cart? Sign up",
                fontSize = 20.sp,

                color = Color.White
            )

        }
        Text("Explore the app",

            modifier = Modifier.clickable{
                navController.navigate("home")
            }
        )
    }


}