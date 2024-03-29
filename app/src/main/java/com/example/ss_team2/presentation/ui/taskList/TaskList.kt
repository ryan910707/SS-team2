package com.example.ss_team2.presentation.ui.taskList

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.CheckCircleOutline
import androidx.compose.material.icons.filled.Storefront
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ss_team2.ui.theme.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.RadioButtonUnchecked
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ss_team2.presentation.navigation.Screen
import com.example.ss_team2.presentation.ui.homepage.HomepageScreen
import com.example.ss_team2.presentation.ui.utility.BottomBar
import com.example.ss_team2.presentation.viewModel.ChatViewModel
import com.example.ss_team2.presentation.viewModel.PostViewModel
import com.example.ss_team2.presentation.viewModel.UserViewModel


@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun TaskList(
    navController: NavController,
    userViewModel: UserViewModel,
) {

    val user by userViewModel.user.collectAsState()

    var finish2 = userViewModel.userQuest.value.quest2 >= 1
    var received2 by remember {mutableStateOf(userViewModel.userQuest.value.quest2Done)}
    var finish3 = userViewModel.userQuest.value.quest3 >= 1
    var received3 by remember {mutableStateOf(userViewModel.userQuest.value.quest3Done)}

    userViewModel.getUserQuest(user.userName)

    Column {
        Title()
        Divider(startIndent = 0.dp, thickness = 2.dp, color = TextGray)
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.AttachMoney,
                    contentDescription = null,
                    modifier = Modifier
                        .size(60.dp),
                    tint = TextGray
                )
                Text(
                    text = user.userCoin.toString(),
                    fontSize = 32.sp, //may bug,
                    fontWeight = FontWeight.Bold,
                    color = TextGray
                )
            }
            Icon(
                imageVector = Icons.Default.Storefront,
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .clickable() {
                        navController.navigate(route = Screen.Shop.route)
                    },
                tint = TextGray
            )
        }


        Card(
            modifier = Modifier
                .padding(start = 24.dp, end = 24.dp, top = 16.dp, bottom = 16.dp)
                .height(72.dp),
            shape = RoundedCornerShape(15.dp),
            elevation = 3.dp,    //shadow
            backgroundColor = Iris60
        ) {

            var received1 by remember {mutableStateOf(userViewModel.userQuest.value.quest1Done)}

            val icon = if(received1)Icons.Default.CheckCircleOutline
                        else Icons.Default.RadioButtonUnchecked

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(start = 10.dp),
                ) {
                    Text(
                        text = "每日登入",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(top = 12.dp),
                        color = White
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    LinearProgressIndicator(
                        backgroundColor = Purple200,
                        progress = 1.0f,
                        color = Purple700,
                        modifier = Modifier.height(6.dp)
                    )
                }
                Column() {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        modifier = Modifier
                            .size(48.dp)
                            .clickable(
                                enabled = !received1
                            ) {
                                userViewModel.updateCoin(user.userName,500)
                                userViewModel.doneUserQuest(user.userName,"quest1")
                                received1 = !received1
                            }
                    )
                    Row() {
                        Icon(
                            imageVector = Icons.Default.AttachMoney,
                            contentDescription = null,
                            modifier = Modifier
                                .size(20.dp)
                        )
                        Text(text = "+500")
                    }
                }
            }
        }

        Card(
            modifier = Modifier
                .padding(start = 24.dp, end = 24.dp, top = 16.dp, bottom = 16.dp)
                .height(72.dp),
            shape = RoundedCornerShape(15.dp),
            elevation = 3.dp,    //shadow
            backgroundColor = if(finish2) Iris60 else Gray
        ) {

            val icon = if(received2)Icons.Default.CheckCircleOutline
                        else Icons.Default.RadioButtonUnchecked

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(start = 10.dp),
                ) {
                    Text(
                        text = "發布一則遺失物貼文",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(top = 12.dp),
                        color = White
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    LinearProgressIndicator(
                        backgroundColor = Purple200,
                        progress = if(finish2) 1.0f else 0.0f,
                        color = Purple700,
                        modifier = Modifier.height(6.dp)
                    )
                }
                Column() {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        modifier = Modifier
                            .size(48.dp)
                            .clickable(
                                enabled = finish2 && !received2
                            ) {
                                received2 = !received2
                                userViewModel.updateCoin(user.userName,999)
                                userViewModel.doneUserQuest(user.userName,"quest2")
                            }
                    )
                    Row() {
                        Icon(
                            imageVector = Icons.Default.AttachMoney,
                            contentDescription = null,
                            modifier = Modifier
                                .size(20.dp)
                        )
                        Text(text = "+999")
                    }
                }
            }
        }

        Card(
            modifier = Modifier
                .padding(start = 24.dp, end = 24.dp, top = 16.dp, bottom = 16.dp)
                .height(72.dp),
            shape = RoundedCornerShape(15.dp),
            elevation = 3.dp,    //shadow
            backgroundColor = if(finish3) Iris60 else Gray
        ) {



            val icon = if(received3)Icons.Default.CheckCircleOutline
                        else Icons.Default.RadioButtonUnchecked

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(start = 10.dp),
                ) {
                    Text(
                        text = "塗鴉一次",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(top = 12.dp),
                        color = White
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    LinearProgressIndicator(
                        backgroundColor = Purple200,
                        progress = if(finish3) 1.0f else 0.0f,
                        color = Purple700,
                        modifier = Modifier.height(6.dp)
                    )
                }
                Column() {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        modifier = Modifier
                            .size(48.dp)
                            .clickable(
                                enabled = finish3 && !received3
                            ) {
                                received3 = !received3
                                userViewModel.updateCoin(user.userName,2000)
                                userViewModel.doneUserQuest(user.userName,"quest3")
                            }
                    )
                    Row() {
                        Icon(
                            imageVector = Icons.Default.AttachMoney,
                            contentDescription = null,
                            modifier = Modifier
                                .size(20.dp)
                        )
                        Text(text = "+200")
                    }
                }
            }
        }
        //BottomNavigation
    }
}


@Composable
fun Title() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 20.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "任務清單",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = TextGray,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun TitlePreview() {
    SSteam2Theme { Title() }
}

@Composable
fun MoneyAndShop(
    modifier: Modifier = Modifier,
    money: String,
    navController: NavController
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.AttachMoney,
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp),
                tint = TextGray
            )
            Text(
                text = money,
                fontSize = 32.sp, //may bug,
                fontWeight = FontWeight.Bold,
                color = TextGray
            )
        }
        Icon(
            imageVector = Icons.Default.Storefront,
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .clickable() {
                    navController.navigate(route = Screen.Shop.route)
                },
            tint = TextGray
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun MoneyAndShopPreview() {
    SSteam2Theme { MoneyAndShop(money = "520", navController = rememberNavController()) }
}

var tasks = listOf(
    "每日登入",
    "查看一則遺失物貼文",
    "塗鴉其他學校五次",
    "幫助他人找回遺失物三次"
)

@Composable
fun TaskCard(
    modifier: Modifier = Modifier,
    Yourtask: String
) {
    var progress by remember { mutableStateOf(0.3f) } //just for testing

    Card(
        modifier = Modifier
            .padding(start = 24.dp, end = 24.dp, top = 16.dp, bottom = 16.dp)
            .height(72.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = 3.dp,    //shadow
        backgroundColor = Iris60
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(start = 10.dp),
            ) {
                Text(
                    text = Yourtask,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(top = 12.dp),
                    color = White
                )
                Spacer(modifier = Modifier.height(16.dp))
                LinearProgressIndicator(
                    backgroundColor = Purple200,
                    progress = progress,
                    color = Purple700,
                    modifier = Modifier.height(6.dp)
                )
            }
            Column() {
                Icon(
                    imageVector = Icons.Default.CheckCircleOutline,
                    contentDescription = null,
                    modifier = Modifier
                        .size(48.dp)
                        .clickable() {}
                )
                Row() {
                    Icon(
                        imageVector = Icons.Default.AttachMoney,
                        contentDescription = null,
                        modifier = Modifier
                            .size(20.dp)
                    )
                    Text(text = "+40")
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun TaskCardPreview() {
    SSteam2Theme { TaskCard(Yourtask = "每日登入") }
}

@Composable
fun TaskCards(
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(tasks) { item ->
            TaskCard(Modifier, item)
        }
    }
}

@Composable
fun Quest(
    postViewModel: PostViewModel,
    userViewModel: UserViewModel,
    chatViewModel: ChatViewModel,
    navController: NavController
) {
    SSteam2Theme {
        Scaffold(
            bottomBar = {
                BottomBar(
                    postViewModel = postViewModel,
                    userViewModel = userViewModel,
                    chatViewModel = chatViewModel,
                    modifier = Modifier,
                    navController = navController
                )
            }
        ) {
            TaskList(navController = navController,userViewModel)
        }
    }
}


@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun TaskCardsPreview() {
    SSteam2Theme { TaskCards() }
}