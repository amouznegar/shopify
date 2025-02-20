package com.navin.shopify.screens.dashboard

import android.annotation.SuppressLint
import android.provider.CalendarContract
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.navin.shopify.viewModel.ProductsViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.navin.shopify.R


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DashboardScreen(navController: NavController,viewModel : ProductsViewModel = hiltViewModel() ) {


    var response = viewModel.products.value.data

        if(viewModel.products.value.loading==true) {

            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                CircularProgressIndicator()
            }
        }else {
            Column(horizontalAlignment = Alignment.End) {
                Text("جدیدترین محصولات")

                Log.e("","")

                if(response.isNullOrEmpty()) {
                    Text("Error")
                }else {
                    LazyRow() {
                        items(items = response!!) {item->

                            Card(
                                colors = CardDefaults.cardColors(
                                    containerColor = Color.White, //Card background color
                                    contentColor = Color.White  //Card content color,e.g.text
                                ),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(250.dp).width(160.dp).padding(all = 8.dp) ) {
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {

                                    if(item.images.size>0){
                                        // AsyncImage(model = "${item.images[0]}", contentDescription = null)

                                        GlideImage(
                                            model = "${item.images[0]}",
                                            contentDescription = "",
                                            modifier = Modifier.height(160.dp).height(220.dp)

                                        )

                                    }else {
                                        Image(painter = painterResource(R.drawable.jetpack_compose), contentDescription = "",
                                            modifier = Modifier.height(160.dp).height(220.dp))
                                    }


                                    Text(text = "${item.name}", color = Color.Black)

                                }
                            }

                        }
                    }
                }




            }
        }


}