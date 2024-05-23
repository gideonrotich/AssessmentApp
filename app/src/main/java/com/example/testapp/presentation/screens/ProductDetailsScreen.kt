package com.example.testapp.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.Button
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.testapp.presentation.viewmodel.PostDetailViewModel
import com.example.testapp.presentation.viewmodel.PostViewModdel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProductDetailsScreen(
    id: String,
    navController: NavController,
    viewModel: PostDetailViewModel = hiltViewModel()
) {

    val uiState = viewModel.postDetail.value

    LaunchedEffect(key1 = Unit) {
        viewModel.getPostDetail()
    }


    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp)
    ) { _ ->
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
            ) {
                uiState.post?.let { post ->
                    Row(
                        modifier = Modifier
                            .height(60.dp)
                            .fillMaxWidth()
                            .background(Color.White),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {

                        IconButton(onClick = { }) {
                            Icon(
                                Icons.Default.ArrowBack,
                                contentDescription = "Back",
                                tint = Color.Black
                            )

                        }

                        Text(
                            text = post.title,
                            style = TextStyle(
                                color = Color.Black,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium
                            ),
                            modifier = Modifier
                                .padding(bottom = 8.dp),
                            maxLines = 1
                        )


                        IconButton(onClick = { }) {
                            Icon(
                                Icons.Default.Close,
                                contentDescription = "Close",
                                tint = Color.Black
                            )

                        }
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White),
                        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
                    ) {

                        AsyncImage(
                            model = "https://picsum.photos/200/30${post.id}",
                            contentDescription = "items",
                            modifier = Modifier
                                .width(280.dp)
                                .height(300.dp)
                                .padding(top = 16.dp),
                            contentScale = ContentScale.Crop
                        )

                        Spacer(modifier = Modifier.height(16.dp))


                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                        ) {
                            Text(
                                text = post.title,
                                style = TextStyle(
                                    color = Color.Black,
                                    fontSize = 20.sp,
                                    fontWeight = androidx.compose.ui.text.font.FontWeight.Medium
                                ),
                                modifier = Modifier.padding(horizontal = 16.dp)
                            )

                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                        ) {
                            Text(
                                text = post.id.toString() + " KES",
                                style = TextStyle(
                                    color = Color.Green,
                                    fontSize = 20.sp,
                                    fontWeight = androidx.compose.ui.text.font.FontWeight.Medium
                                ),
                                modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
                            )
                            Text(
                                text = " VAT Inclusive",
                                style = TextStyle(
                                    color = Color.Gray,
                                    fontSize = 15.sp,
                                    fontWeight = androidx.compose.ui.text.font.FontWeight.Medium
                                ),
                                modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)
                            )

                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                        ) {
                            Text(
                                text = "Apparel",
                                style = TextStyle(
                                    color = Color.Black,
                                    fontSize = 18.sp,
                                    fontWeight = androidx.compose.ui.text.font.FontWeight.Normal
                                ),
                                modifier = Modifier.padding(horizontal = 16.dp)
                            )

                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 16.dp),
                        ) {
                            Text(
                                text = post.body,
                                style = TextStyle(
                                    color = Color.Black,
                                    fontSize = 17.sp,
                                    fontWeight = androidx.compose.ui.text.font.FontWeight.Medium
                                ),
                                modifier = Modifier.padding(horizontal = 16.dp)
                            )
                        }

                        Button(
                            onClick = {},
                            modifier = Modifier
                                .fillMaxWidth(0.95f)
                                .height(75.dp)
                                .padding(
                                    start = 0.dp,
                                    top = 15.dp,
                                    end = 0.dp,
                                    bottom = 10.dp
                                ),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF68AB00),
                                disabledContainerColor = Color(0xFF68AB00)
                            ),
                            shape = RoundedCornerShape(10),
                            contentPadding = ButtonDefaults.ContentPadding,
                            enabled = true

                        ) {
                            Text(
                                style = TextStyle(
                                    color = Color.White,
                                    fontSize = 17.sp,

                                    ),
                                text = "Add to cart"
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))


                    }
                }

            }
            if (uiState.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }

    }

}