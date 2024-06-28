package com.example.bluelockfinal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bluelockfinal.LoginForm

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            val viewModel = ViewModelProvider(this).get(TodoViewModel::class.java)

            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "screen_a", builder = {
                composable("screen_a") {
                    ScreenA(navController)
                }

                composable("login_form") {
                    val context = LocalContext.current
                    LoginForm(context, navController)
                }

                composable("home_page") {
                    Homepage(navController)
                }

                composable("todo_list_page") {
                    TodoListPage(navController = navController, viewModel = viewModel)
                }

                composable("lazy_column") {
                    DesignPage(navController)
                }

                composable("character_page") {
                    CharactersPage(navController)
                }

            })

        }
    }
}

