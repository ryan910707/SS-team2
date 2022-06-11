package com.example.ss_team2.presentation.ui.shop

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ss_team2.R
import com.example.ss_team2.presentation.viewModel.UserViewModel
import com.example.ss_team2.ui.theme.Iris60
import com.example.ss_team2.ui.theme.SSteam2Theme
import com.example.ss_team2.ui.theme.TextGray


@Composable
fun Shop(
    navController: NavController,
    userViewModel: UserViewModel,
) {
    val user by userViewModel.user.collectAsState()
//    val myMoney by userViewModel.userCoin.collectAsState()

    Column {
        Title(money = user.userCoin, navController = navController)
        Divider(startIndent = 0.dp, thickness = 3.dp, color = Color.Black)

        LazyColumn {

            item {
                Card(
                    modifier = Modifier
                        .padding(start = 24.dp, end = 24.dp, top = 16.dp, bottom = 16.dp)
                        .height(84.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(15.dp),
                    elevation = 3.dp,    //shadow
                    backgroundColor = Color.White
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceAround,
                    ) {
                        Column() {
                            Spacer(modifier = Modifier.height(12.dp))
                            Image(
                                painter = painterResource(R.drawable.orange_flag),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .height(40.dp)
                                    .width(40.dp)
                            )
                            Text(
                                text = "台大旗"
                            )
                        }
                        Text(
                            text = "台大專屬旗子",
                            modifier = Modifier.padding(top = 30.dp)
                        )

                        Column() {
                            Row() {
                                Icon(
                                    imageVector = Icons.Default.AttachMoney,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(32.dp)
                                )
                                Text(
                                    text = "500",
                                    fontSize = 25.sp //may bug
                                )
                            }
                            Button(
                                onClick = {
                                    userViewModel.updateCoin(
                                        userViewModel.user.value.userName,
                                        -500
                                    )
                                    userViewModel.updateUserItem(
                                        userViewModel.user.value.userName,
                                        "orangeFlag",
                                        1
                                    )
                                },
                                colors = ButtonDefaults.textButtonColors(
                                    backgroundColor = Iris60
                                ),
                                enabled = user.userCoin >= 500,
                                modifier = Modifier.padding(start = 8.dp)
                            ) {
                                Text(
                                    text = "購買",
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }
            item {
                Card(
                    modifier = Modifier
                        .padding(start = 24.dp, end = 24.dp, top = 16.dp, bottom = 16.dp)
                        .height(84.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(15.dp),
                    elevation = 3.dp,    //shadow
                    backgroundColor = Color.White
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceAround,
                    ) {
                        Column() {
                            Spacer(modifier = Modifier.height(12.dp))
                            Image(
                                painter = painterResource(R.drawable.purple_flag),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .height(40.dp)
                                    .width(40.dp)
                            )
                            Text(
                                text = "清大旗"
                            )
                        }
                        Text(
                            text = "清大專屬旗子",
                            modifier = Modifier.padding(top = 30.dp)
                        )

                        Column() {
                            Row() {
                                Icon(
                                    imageVector = Icons.Default.AttachMoney,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(32.dp)
                                )
                                Text(
                                    text = "500",
                                    fontSize = 25.sp //may bug
                                )
                            }
                            Button(
                                onClick = {
                                    userViewModel.updateCoin(
                                        userViewModel.user.value.userName,
                                        -500
                                    )
                                    userViewModel.updateUserItem(
                                        userViewModel.user.value.userName,
                                        "purpleFlag",
                                        1
                                    )
                                },
                                colors = ButtonDefaults.textButtonColors(
                                    backgroundColor = Iris60
                                ),
                                enabled = user.userCoin >= 500,
                                modifier = Modifier.padding(start = 8.dp)
                            ) {
                                Text(
                                    text = "購買",
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }
            item {


                Card(
                    modifier = Modifier
                        .padding(start = 24.dp, end = 24.dp, top = 16.dp, bottom = 16.dp)
                        .height(84.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(15.dp),
                    elevation = 3.dp,    //shadow
                    backgroundColor = Color.White
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceAround,
                    ) {
                        Column() {
                            Spacer(modifier = Modifier.height(12.dp))
                            Image(
                                painter = painterResource(R.drawable.yellow_flag),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .height(40.dp)
                                    .width(40.dp)
                            )
                            Text(
                                text = "交大旗"
                            )
                        }
                        Text(
                            text = "交大專屬旗子",
                            modifier = Modifier.padding(top = 30.dp)
                        )

                        Column() {
                            Row() {
                                Icon(
                                    imageVector = Icons.Default.AttachMoney,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(32.dp)
                                )
                                Text(
                                    text = "500",
                                    fontSize = 25.sp //may bug
                                )
                            }
                            Button(
                                onClick = {
                                    userViewModel.updateCoin(
                                        userViewModel.user.value.userName,
                                        -500
                                    )
                                    userViewModel.updateUserItem(
                                        userViewModel.user.value.userName,
                                        "yellowFlag",
                                        1
                                    )
                                },
                                colors = ButtonDefaults.textButtonColors(
                                    backgroundColor = Iris60
                                ),
                                enabled = user.userCoin >= 500,
                                modifier = Modifier.padding(start = 8.dp)
                            ) {
                                Text(
                                    text = "購買",
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }

            item {

                Card(
                    modifier = Modifier
                        .padding(start = 24.dp, end = 24.dp, top = 16.dp, bottom = 16.dp)
                        .height(84.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(15.dp),
                    elevation = 3.dp,    //shadow
                    backgroundColor = Color.White
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceAround,
                    ) {
                        Column() {
                            Spacer(modifier = Modifier.height(12.dp))
                            Image(
                                painter = painterResource(R.drawable.blue_flag),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .height(40.dp)
                                    .width(40.dp)
                            )
                            Text(
                                text = "政大旗"
                            )
                        }
                        Text(
                            text = "政大專屬旗子",
                            modifier = Modifier.padding(top = 30.dp)
                        )

                        Column() {
                            Row() {
                                Icon(
                                    imageVector = Icons.Default.AttachMoney,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(32.dp)
                                )
                                Text(
                                    text = "500",
                                    fontSize = 25.sp //may bug
                                )
                            }
                            Button(
                                onClick = {
                                    userViewModel.updateCoin(
                                        userViewModel.user.value.userName,
                                        -500
                                    )
                                    userViewModel.updateUserItem(
                                        userViewModel.user.value.userName,
                                        "blueFlag",
                                        1
                                    )
                                },
                                colors = ButtonDefaults.textButtonColors(
                                    backgroundColor = Iris60
                                ),
                                enabled = user.userCoin >= 500,
                                modifier = Modifier.padding(start = 8.dp)
                            ) {
                                Text(
                                    text = "購買",
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }

            item {

                Card(
                    modifier = Modifier
                        .padding(start = 24.dp, end = 24.dp, top = 16.dp, bottom = 16.dp)
                        .height(84.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(15.dp),
                    elevation = 3.dp,    //shadow
                    backgroundColor = Color.White
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceAround,
                    ) {
                        Column() {
                            Spacer(modifier = Modifier.height(12.dp))
                            Image(
                                painter = painterResource(R.drawable.poopoo),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .height(40.dp)
                                    .width(40.dp)
                            )
                            Text(
                                text = "大便"
                            )
                        }
                        Text(
                            text = "要臭他們就用這個",
                            modifier = Modifier.padding(top = 30.dp)
                        )

                        Column() {
                            Row() {
                                Icon(
                                    imageVector = Icons.Default.AttachMoney,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(32.dp)
                                )
                                Text(
                                    text = "800",
                                    fontSize = 25.sp //may bug
                                )
                            }
                            Button(
                                onClick = {
                                    userViewModel.updateCoin(
                                        userViewModel.user.value.userName,
                                        -800
                                    )
                                    userViewModel.updateUserItem(
                                        userViewModel.user.value.userName,
                                        "shit",
                                        1
                                    )
                                },
                                colors = ButtonDefaults.textButtonColors(
                                    backgroundColor = Iris60
                                ),
                                enabled = user.userCoin >= 800,
                                modifier = Modifier.padding(start = 8.dp)
                            ) {
                                Text(
                                    text = "購買",
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }

            item {

                Card(
                    modifier = Modifier
                        .padding(start = 24.dp, end = 24.dp, top = 16.dp, bottom = 16.dp)
                        .height(84.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(15.dp),
                    elevation = 3.dp,    //shadow
                    backgroundColor = Color.White
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceAround,
                    ) {
                        Column() {
                            Spacer(modifier = Modifier.height(12.dp))
                            Image(
                                painter = painterResource(R.drawable.bnt),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .height(40.dp)
                                    .width(40.dp)
                            )
                            Text(
                                text = "BNT"
                            )
                        }
                        Text(
                            text = "記得打疫苗",
                            modifier = Modifier.padding(top = 30.dp)
                        )

                        Column() {
                            Row() {
                                Icon(
                                    imageVector = Icons.Default.AttachMoney,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(32.dp)
                                )
                                Text(
                                    text = "999",
                                    fontSize = 25.sp //may bug
                                )
                            }
                            Button(
                                onClick = {
                                    userViewModel.updateCoin(
                                        userViewModel.user.value.userName,
                                        -999
                                    )
                                    userViewModel.updateUserItem(
                                        userViewModel.user.value.userName,
                                        "vaccine",
                                        1
                                    )
                                },
                                colors = ButtonDefaults.textButtonColors(
                                    backgroundColor = Iris60
                                ),
                                enabled = user.userCoin >= 999,
                                modifier = Modifier.padding(start = 8.dp)
                            ) {
                                Text(
                                    text = "購買",
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Title(
    modifier: Modifier = Modifier,
    money: Int,
    navController: NavController
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 20.dp)
            .fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBackIos,
            contentDescription = null,
            tint = TextGray,
            modifier = Modifier
                .size(32.dp)
                .padding(start = 8.dp)
                .clickable() {
                    navController.popBackStack()
                }
        )
        Text(
            text = "購買道具",
            fontSize = 32.sp,
            color = TextGray,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 70.dp, end = 16.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = Icons.Default.AttachMoney,
                contentDescription = null,
                tint = TextGray,
                modifier = Modifier
                    .size(50.dp)
            )
            Text(
                text = money.toString(),
                fontSize = 25.sp //may bug
            )
        }
    }
}

//@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
//@Composable
//fun TitlePreview(){
//    SSteam2Theme() {
//        Title(money = 8888)
//    }
//}
