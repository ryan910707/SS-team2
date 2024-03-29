package com.example.ss_team2.presentation.ui.utility

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.CollectionsBookmark
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.ss_team2.R
import com.example.ss_team2.presentation.navigation.Screen
import com.example.ss_team2.presentation.viewModel.ChatViewModel
import com.example.ss_team2.presentation.viewModel.PostViewModel
import com.example.ss_team2.presentation.viewModel.UserViewModel

@Composable
fun BottomBar(
    postViewModel: PostViewModel,
    userViewModel: UserViewModel,
    chatViewModel: ChatViewModel,
    modifier: Modifier = Modifier,
    navController: NavController
) {

    val user by userViewModel.user.collectAsState()

    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        modifier = modifier
    ) {
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_home))
            },
            selected = false,
            onClick = {
                chatViewModel.chatsByReceive(user.userName)
                navController.navigate(route = Screen.Home.route)
            }
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Outlined.CollectionsBookmark,
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_mission))
            },
            selected = false,
            onClick = {
                navController.navigate(route = Screen.Quest.route)
            }
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.WorkspacePremium,
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_scoreboard))
            },
            selected = false,
            onClick = {
                navController.navigate(route = Screen.Rank.route)
            }
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_profile))
            },
            selected = false,
            onClick = {
                postViewModel.getMyPosts(user.userName)
                navController.navigate(route = Screen.Profile.route)
            }
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_notification))
            },
            selected = false,
            onClick = {
                navController.navigate(route = Screen.Notification.route)
            }
        )
    }
}