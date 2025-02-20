package com.navin.shopify

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.navin.shopify.screens.Navigation
import com.navin.shopify.ui.theme.Pink80
import com.navin.shopify.ui.theme.Purple40
import com.navin.shopify.ui.theme.Purple80
import com.navin.shopify.ui.theme.PurpleGrey40
import com.navin.shopify.ui.theme.ShopifyTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()

        setContent {
            val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
            ShopifyTheme {

                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        ModalDrawerSheet { /* Drawer content */ }
                    },
                ) {

                    Scaffold(modifier = Modifier.fillMaxSize(),
/*
                        topBar = { TopAppBar( colors = topAppBarColors(
                            containerColor = Purple40,
                            titleContentColor = Color.White,
                        ),title = {Text("App")}, ) } ,*/





                        ) {




                         Surface (modifier = Modifier.fillMaxSize() ) {

                             Navigation()
                        }



                    }



                }




            }
        }



    }



}






@Preview(name = "Create First Screen")
@Composable
fun CreateFirstScreen(){

    Column(verticalArrangement = Arrangement.SpaceAround,modifier = Modifier.fillMaxHeight()
        .fillMaxWidth().verticalScroll(rememberScrollState())
       ) {
        Text("Welcome to Compose Project")
        Text("First Session of Compose")
        Text(stringResource(R.string.app_name),
            fontSize = 20.sp, color = Color.Blue)
        Button(onClick = {

        }, shape = CircleShape) {
            Text("Visit Website")
        }
        LoginButton()
        Features()
        var painter = painterResource(R.drawable.jetpack_compose)
        Image(painter =painter, contentDescription = "" )
    }

}
@Composable
fun LoginButton() {
    var context = LocalContext.current
    OutlinedButton (onClick = {

        var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://amooznegar.com"))
        context.startActivity(intent);
    }){
        Text("Visit Website")
    }
}

@Composable
fun Features(){
    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()){
        Text("1")
        Text("2")
        Text("3")
    }
}


@Preview(name = "Gradient")
@Composable
fun CreateGradient() {

 val brush = Brush.horizontalGradient(

     colors = listOf(
         Purple80,
         Pink80,
         PurpleGrey40

     )
 )

    Box(modifier = Modifier.height(200.dp).width(200.dp).
        background(brush = brush)
        ){

    }

}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ShopifyTheme {

    }
}