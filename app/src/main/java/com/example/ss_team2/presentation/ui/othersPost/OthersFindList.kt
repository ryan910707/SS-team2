package com.example.ss_team2.presentation.ui.othersPost


import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.Icon
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ss_team2.R
import com.example.ss_team2.presentation.navigation.Screen
import com.example.ss_team2.presentation.ui.utility.TopBar
import com.example.ss_team2.presentation.ui.utility.TopBarButton
import com.example.ss_team2.presentation.viewModel.HelperViewModel
import com.example.ss_team2.presentation.viewModel.PostViewModel
import com.example.ss_team2.presentation.viewModel.UserViewModel
import com.example.ss_team2.ui.theme.TextGray

@Composable
fun OthersFindListFinalScreen(
    helperViewModel: HelperViewModel,
    userViewModel: UserViewModel,
    postViewModel: PostViewModel,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val otherUser by userViewModel.otherUser.collectAsState()

    Column(
        modifier = Modifier
    ) {
        TopBar(
            leftButton = {
                TopBarButton(
                    imageVector = Icons.Filled.ArrowBack,
                    onClick = { navController.popBackStack() }
                )
            },
            text = stringResource(id = R.string.FindList),
            rightButton = {
                Spacer(modifier = Modifier.size(40.dp))
            }
        )
        Divider(
            color = TextGray,
            thickness = 2.dp,
            modifier = Modifier
        )
        PostListLazyScreen(
            postOwner = otherUser.userName,
            helperViewModel = helperViewModel,
            postViewModel = postViewModel,
        )
    }
}

@Composable
private fun OthersFindListBottomNavigation(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        modifier = modifier
    ) {
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.LocationOn,
                    contentDescription = null
                )
            },
            label = {
                Text("地圖定位")
            },
            selected = true,
            onClick = {}
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null
                )
            },
            label = {
                Text("成功取回")
            },
            selected = false,
            onClick = {}
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = null
                )
            },
            label = {
                Text("發送訊息")
            },
            selected = false,
            onClick = {
                navController.navigate(route = Screen.ChatRoom.route)
            }
        )
    }
}

@Composable
fun OthersFindListApp(
    helperViewModel: HelperViewModel,
    userViewModel: UserViewModel,
    postViewModel: PostViewModel,
    navController: NavController
) {
    Scaffold(
        bottomBar = { OthersFindListBottomNavigation(navController = navController) }
    ) {
        OthersFindListFinalScreen(
            helperViewModel = helperViewModel,
            userViewModel = userViewModel,
            postViewModel = postViewModel,
            navController = navController
        )
    }
}
