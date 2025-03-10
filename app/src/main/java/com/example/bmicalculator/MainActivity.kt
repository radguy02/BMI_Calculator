package com.example.bmicalculator

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bmicalculator.ui.theme.BmiCalculatorTheme
import com.example.bmicalculator.screens.*
import com.yourapp.viewmodel.SharedViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BmiCalculatorTheme {

            }
        }
    }
}



@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val viewModel: SharedViewModel = viewModel() // ViewModel instance

    NavHost(navController, startDestination = "screen1") {
        composable("screen1") {
            LanderPage(navController)
        }
        composable("screen2") {
            Datapage(navController, viewModel)
        }
        composable("screen3") {
            LastPage(navController, viewModel)
        }
    }
}
