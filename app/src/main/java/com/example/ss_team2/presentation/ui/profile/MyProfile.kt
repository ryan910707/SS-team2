package com.example.ss_team2.presentation.ui.profile

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ss_team2.R
import com.example.ss_team2.presentation.navigation.Screen
import com.example.ss_team2.ui.theme.SSteam2Theme
import com.example.ss_team2.presentation.ui.utility.BottomBar
import com.example.ss_team2.presentation.ui.utility.TopBar
import com.example.ss_team2.presentation.ui.utility.TopBarButton
import com.example.ss_team2.presentation.viewModel.ChatViewModel
import com.example.ss_team2.presentation.viewModel.HelperViewModel
import com.example.ss_team2.presentation.viewModel.PostViewModel
import com.example.ss_team2.presentation.viewModel.UserViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MyProfileScreen(
    modifier: Modifier = Modifier,
    helperViewModel: HelperViewModel,
    userViewModel: UserViewModel,
    postViewModel: PostViewModel,
    navController: NavController
) {

    val myUser by userViewModel.user.collectAsState()
    val myUserItem by userViewModel.userItem.collectAsState()

    val posts by postViewModel.myPosts.collectAsState()

    val pagerState = rememberPagerState(pageCount = 2)
    val scope = rememberCoroutineScope()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        TopBar(
            leftButton = {
                TopBarButton(
                    imageVector = Icons.Default.Storefront,
                    onClick = {
                        navController.navigate(route = Screen.Shop.route)
                    }
                )
            },
            text = myUser.userName,
            rightButton = {
                Spacer(modifier = Modifier.size(40.dp))
            }
        )

        PersonalInfo(
            image = myUser.userHead,
            schoolName = myUser.userSchool,
            toolAmount = myUserItem.orangeFlag + myUserItem.purpleFlag + myUserItem.yellowFlag + myUserItem.blueFlag + myUserItem.shit + myUserItem.vaccine,
            point = myUser.userCoin
        )

        ProfileTabBar(
            tabPage = pagerState.currentPage,
            onTabSelected = {
                scope.launch {
                    pagerState.animateScrollToPage(it)
                }
            }
        )

        HorizontalPager(state = pagerState) { index ->
            UserPostCardList(
                helperViewModel = helperViewModel,
                postViewModel = postViewModel,
                tabPage = index,
                posts = posts,
                modifier = Modifier,
                navController = navController
            )
        }
    }
}


@Composable
fun MyProfile(
    helperViewModel: HelperViewModel,
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
            MyProfileScreen(
                helperViewModel = helperViewModel,
                userViewModel = userViewModel,
                postViewModel = postViewModel,
                modifier = Modifier,
                navController = navController
            )
        }
    }
}

