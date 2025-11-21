package com.example.ucp1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ucp1.view.FormPage
import com.example.ucp1.view.LoginPage
import com.example.ucp1.view.ProfilePage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val nav = rememberNavController()

            NavHost(navController = nav, startDestination = "login") {

                composable("login") {
                    LoginPage(
                        onLoginSuccess = { nav.navigate("profile") }
                    )
                }

                composable("profile") {
                    ProfilePage(
                        onLogout = { nav.navigate("login") },
                        onAdd = { nav.navigate("form") }
                    )
                }

                composable("form") {
                    FormPage(
                        onBack = { nav.navigate("profile") }
                    )
                }
            }
        }
    }
}