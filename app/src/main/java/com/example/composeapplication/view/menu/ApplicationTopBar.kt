package com.example.composeapplication.view.menu

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeapplication.R
import com.example.composeapplication.ui.theme.ComposeApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    onNavigationClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text(text = stringResource(id = R.string.app_name))
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary),
        navigationIcon = {
            IconButton(
                onClick = { onNavigationClick() }) {
                Icon(imageVector = Icons.Default.Menu,
                    tint = MaterialTheme.colorScheme.onPrimary,
                    contentDescription = "Menu Drawer")
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun AppBarPreview() {
    ComposeApplicationTheme {
        AppBar {
            println("click")
        }
    }
}