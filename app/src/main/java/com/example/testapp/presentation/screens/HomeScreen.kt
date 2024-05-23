package com.example.testapp.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.testapp.R
import com.example.testapp.presentation.viewmodel.PostViewModdel
import com.swayy.cooperativebank.util.Route

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavController,
    postViewModel: PostViewModdel = hiltViewModel()
) {

    val state = postViewModel.post.value

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {

        }
    ) { _ ->

        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 40.dp)
            ) {

                Row(
                    modifier = Modifier
                        .height(57.dp)
                        .fillMaxWidth()
                        .background(Color.White),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(id = R.drawable.user),
                            contentDescription = "person one"
                        )
                    }

                    Text(
                        text = "Hello UserName",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Medium
                        ),
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                    )


                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(id = R.drawable.logout),
                            contentDescription = "logout"
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .background(Color(0xFF68AB00))
                        .padding(8.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.Bottom
                ) {


                    Text(
                        text = "15% off if you pay via MCoopCash!",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Normal
                        ),
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                            .background(Color(0xFF68AB00))
                    )
                }
                val usernameValue = remember {
                    mutableStateOf("")
                }

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(min = 12.dp)
                        .padding(vertical = 4.dp, horizontal = 10.dp),
                    value = usernameValue.value,
                    onValueChange = {
                        usernameValue.value = it
                    },
                    leadingIcon = {

                    },
                    trailingIcon = {

                    },
                    label = { Text(text = "Search products") },
                    colors = OutlinedTextFieldDefaults.colors(
                        cursorColor = Color.Black,
                        focusedBorderColor = Color.Black,
                        unfocusedBorderColor = Color.Black,
                        focusedLabelColor = Color.Black,
                        unfocusedLabelColor = Color.Black,
                    ),
                    textStyle = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    ),
                    keyboardOptions = KeyboardOptions.Default,


                    )
                Row {
                    Text(
                        text = "Best Selling", style = TextStyle(
                            color = Color.Black,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier
                            .padding(8.dp)
                    )
                }

                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier,
                ) {
                    items(items = state.posts) { data ->
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp)
                                .wrapContentHeight()
                                .background(Color.White)
                                .clickable(onClick = {
                                    navController.navigate(Route.POST_SCREEN + "/${data.id.toString()}")
                                }),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            AsyncImage(
                                model = "https://picsum.photos/200/30${data.id}",
                                contentDescription = "items",
                                modifier = Modifier
                                    .width(180.dp)
                                    .height(200.dp)
                                    .padding(top = 16.dp),
                                contentScale = ContentScale.Crop
                            )

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(0.8f)
                                    .padding(top = 4.dp)
                            )
                            {
                                Text(
                                    text = data.title, style = TextStyle(
                                        color = Color.Black,
                                        fontSize = 17.sp,
                                        fontWeight = FontWeight.Bold,

                                        ),
                                    maxLines = 2
                                )
                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(0.8f)
                            )
                            {
                                Text(
                                    text = "KES " + data.id.toString(), style = TextStyle(
                                        color = Color.Black,
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Normal
                                    )
                                )
                            }
                        }
                    }
                }

            }
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }

    }

}