package ar.com.Amanmeena.campuscart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val authenticationViewModel = ar.com.Amanmeena.campuscart.ViewModels.AuthenticationViewModel()
        setContent {
            MyAppNavigation(authenticationViewModel)
        }
    }
}