package ar.com.Amanmeena.campuscart.Screen

import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.clickable
import androidx.compose.material3.HorizontalDivider
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text(
                    text = "Account",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                )

                Text(
                    text = "Profile",
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { /* Navigate to profile */ }
                        .padding(16.dp),
                    fontSize = 20.sp
                )
                Text(
                    text = "Settings",
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { /* Navigate to settings */ }
                        .padding(16.dp),
                    fontSize = 20.sp
                )
                Text(
                    text = "Logout",
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { Firebase.auth.signOut()
                        navController.navigate("first")}
                        .padding(16.dp),
                    color = Color.Red,
                    fontSize = 20.sp
                )
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Home") },
                    actions = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(
                                imageVector = Icons.Default.AccountCircle,
                                contentDescription = "Account"
                            )
                        }
                    }
                )
            }
        ) { innerPadding ->
            // Main screen content

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                Text("Welcome to Home Screen")
            }


            Row() {
                NavigationBar() {

                }
            }
        }
    }
}
