package com.navin.shopify.screens.about

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController


@Composable
fun AboutScreen(navController: NavController) {

    Column {

        Text("About")

        Button(onClick = {

            navController.popBackStack()

        }){

            Text("Back")
        }

    }

}