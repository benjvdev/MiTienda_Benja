package com.example.mitienda_benja.ui.screens

import androidx.annotation.experimental.Experimental
import androidx.compose.material.icons.Icons
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.IconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onGoProfile:() -> Unit,
    onOpenDrawer;() -> Unit,
){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Home") },
                navigationIcon = {
                    IconButton(onClick = onOpenDrawer) {
                        Icon(imageVector = Icons.Filled.Menu,
                        contentDescription = "Abrir Menu"
                        )
                    }
                }
            )
        }
    ){
        //padding ->
        // Column { }
    }
}