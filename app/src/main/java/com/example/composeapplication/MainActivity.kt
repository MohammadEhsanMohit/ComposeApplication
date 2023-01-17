package com.example.composeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeapplication.ui.theme.ComposeApplicationTheme
import com.example.composeapplication.view.mainactivity.ApplicationHomeScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeApplicationTheme {
                ApplicationHomeScreen()
            }
        }
    }

    @Composable
    @Preview(showBackground = true)
    private fun ShowMainHome() {
        ComposeApplicationTheme {
            ApplicationHomeScreen()
        }
    }
}
