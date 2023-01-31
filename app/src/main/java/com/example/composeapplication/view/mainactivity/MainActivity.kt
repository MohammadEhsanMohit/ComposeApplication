package com.example.composeapplication.view.mainactivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeapplication.common.view.BurgerMenuScreen
import com.example.composeapplication.ui.theme.ComposeApplicationTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeApplicationTheme {
                MainActivityCustomView()
            }
        }
    }

    @Composable
    @Preview(showBackground = true)
    private fun ShowMainHome() {
        ComposeApplicationTheme {
            BurgerMenuScreen()
        }
    }
}