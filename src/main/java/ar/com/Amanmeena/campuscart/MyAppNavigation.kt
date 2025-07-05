package ar.com.Amanmeena.campuscart

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ar.com.Amanmeena.campuscart.Screen.FirstScreen
import ar.com.Amanmeena.campuscart.Screen.HomeScreen
import ar.com.Amanmeena.campuscart.Screen.LoginScreen
import ar.com.Amanmeena.campuscart.Screen.SignUpScreen
import ar.com.Amanmeena.campuscart.ViewModels.AuthenticationViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

@Composable
fun MyAppNavigation(authenticationViewModel: AuthenticationViewModel) {

    val navController = rememberNavController()
    val isLoggedin = Firebase.auth.currentUser != null
    val firstPage = if(isLoggedin) "home" else "first"

    NavHost(navController = navController, startDestination = firstPage) {
        composable ("first"){ FirstScreen(navController)  }
        composable ("login"){ LoginScreen(navController,authenticationViewModel)}
        composable ("signup"){ SignUpScreen(navController,authenticationViewModel) }
        composable ("home"){ HomeScreen(navController)}


    }
}