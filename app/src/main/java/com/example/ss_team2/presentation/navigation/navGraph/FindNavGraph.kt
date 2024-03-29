package com.example.ss_team2.presentation.navigation.navGraph

import android.util.Log
import androidx.navigation.*
import androidx.navigation.compose.composable
import com.example.ss_team2.presentation.navigation.FIND_GRAPH_ROUTE
import com.example.ss_team2.presentation.navigation.Screen
import com.example.ss_team2.presentation.navigation.WHAT_ARGUMENT_KEY
import com.example.ss_team2.presentation.navigation.WHERE_ARGUMENT_KEY
import com.example.ss_team2.presentation.ui.AddFindList
import com.example.ss_team2.presentation.ui.postList.FindListFinalScreen
import com.example.ss_team2.presentation.ui.othersPost.OthersFindListApp
import com.example.ss_team2.presentation.ui.whatYouFind.WhatYouFind
import com.example.ss_team2.presentation.ui.whereYouFind.WhereYouFind
import com.example.ss_team2.presentation.viewModel.ChatViewModel
import com.example.ss_team2.presentation.viewModel.HelperViewModel
import com.example.ss_team2.presentation.viewModel.PostViewModel
import com.example.ss_team2.presentation.viewModel.UserViewModel


fun NavGraphBuilder.findNavGraph(
    chatViewModel: ChatViewModel,
    helperViewModel: HelperViewModel,
    userViewModel: UserViewModel,
    postViewModel: PostViewModel,
    navController: NavController
) {
    navigation(
        startDestination = Screen.WhatYouFind.route,
        route = FIND_GRAPH_ROUTE
    ) {
        composable(
            route = Screen.WhatYouFind.route
        ) {
            WhatYouFind(navController = navController)
        }
        composable(
            route = Screen.WhereYouFind.route,
        ) { entry ->
            WhereYouFind(
                navController = navController,
                postViewModel = postViewModel,
                what = entry.arguments?.getString(WHAT_ARGUMENT_KEY).toString()
            )
        }
        composable(
            route = Screen.FindList.route,
            arguments = listOf(
                navArgument(WHAT_ARGUMENT_KEY) {
                    type = NavType.StringType
                },
                navArgument(WHERE_ARGUMENT_KEY) {
                    type = NavType.StringType
                }
            )
        ) {
//            Log.d("Args" ,it.arguments?.getString("what").toString())
//            Log.d("Args" ,it.arguments?.getString("where").toString())
                entry ->
            FindListFinalScreen(
                userViewModel = userViewModel,
                helperViewModel = helperViewModel,
                postViewModel = postViewModel,
                navController = navController,
                what = entry.arguments?.getString("what").toString(),
                where = entry.arguments?.getString("where").toString()
            )
        }
        composable(
            route = Screen.AddFindList.route
        ) { entry ->
            AddFindList(
                navController = navController,
                postViewModel = postViewModel,
                userViewModel = userViewModel,
                what = entry.arguments?.getString(WHAT_ARGUMENT_KEY).toString(),
                where = entry.arguments?.getString(WHERE_ARGUMENT_KEY).toString()
            )
        }
        composable(
            route = Screen.OthersFindList.route
        ) {
            OthersFindListApp(
                chatViewModel = chatViewModel,
                helperViewModel = helperViewModel,
                userViewModel = userViewModel,
                postViewModel = postViewModel,
                navController = navController
            )
        }
    }
}