package com.example.ss_team2.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.Icon
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ss_team2.R
import com.example.ss_team2.presentation.navigation.Screen
import com.example.ss_team2.presentation.ui.othersPost.PostListLazyScreen
import com.example.ss_team2.presentation.ui.utility.TopBar
import com.example.ss_team2.presentation.ui.utility.TopBarButton
import com.example.ss_team2.presentation.viewModel.HelperViewModel
import com.example.ss_team2.presentation.viewModel.PostViewModel
import com.example.ss_team2.presentation.viewModel.UserViewModel
import com.example.ss_team2.ui.theme.TextGray
import okhttp3.internal.userAgent

@Composable
fun MyPostFinalScreen(
    helperViewModel: HelperViewModel,
    userViewModel: UserViewModel,
    postViewModel: PostViewModel,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val user by userViewModel.user.collectAsState()

    Column(
        modifier = Modifier
    ) {
        TopBar(
            leftButton = {
                TopBarButton(
                    imageVector = Icons.Filled.ArrowBack,
                    onClick = {
                        postViewModel.getMyPosts(user.userName)
                        navController.popBackStack()
                    }
                )
            },
            text = "我的貼文",
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
            postOwner = user.userName,
            helperViewModel = helperViewModel,
            postViewModel = postViewModel,
            userViewModel = userViewModel
        )
    }
}

@Composable
fun MyPostApp(
    helperViewModel: HelperViewModel,
    postViewModel: PostViewModel,
    userViewModel: UserViewModel,
    navController: NavController
) {
    val post by postViewModel.post.collectAsState()

    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = MaterialTheme.colors.background,
                modifier = Modifier
            ) {
                BottomNavigationItem(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = null
                        )
                    },
                    label = {
                        Text("編輯")
                    },
                    selected = true,
                    onClick = {
                        navController.navigate(
                            route = Screen.EditPost.passWhatAndWhereAndDescribe(
                                what = post.itemType,
                                where = post.location,
                                describe = post.postDescribe!!
                            )
                        )
                    }
                )
                BottomNavigationItem(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = null
                        )
                    },
                    label = {
                        Text("已找回")
                    },
                    selected = false,
                    onClick = {
                        navController.navigate(route = Screen.Confirmation.route)
                    }
                )
                BottomNavigationItem(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(text = "刪除貼文", color = Color.Red)
                    },
                    selected = false,
                    onClick = {
                        navController.navigate(route = Screen.Profile.route)
                        postViewModel.deletePost(post.postId)
                    }
                )
            }
        }
    ) {
        MyPostFinalScreen(
            helperViewModel = helperViewModel,
            postViewModel = postViewModel,
            userViewModel = userViewModel,
            navController = navController
        )
    }
}

@Composable
private fun MyPostBottomNavigation(
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
                    imageVector = Icons.Default.Edit,
                    contentDescription = null
                )
            },
            label = {
                Text("編輯")
            },
            selected = true,
            onClick = {
                navController.navigate(
                    route = Screen.EditPost.passWhatAndWhereAndDescribe(
                        what = "hi",
                        where = "ho",
                        describe = "ii"
                    )
                )
            }
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null
                )
            },
            label = {
                Text("已找回")
            },
            selected = false,
            onClick = {
                navController.navigate(route = Screen.Confirmation.route)
            }
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = null
                )
            },
            label = {
                Text(text = "刪除貼文", color = Color.Red)
            },
            selected = false,
            onClick = {}
        )
    }
}
