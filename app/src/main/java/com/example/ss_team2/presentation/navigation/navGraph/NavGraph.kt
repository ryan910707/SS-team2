package com.example.ss_team2.presentation.navigation.navGraph

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ss_team2.EditPost
import com.example.ss_team2.MyPostApp
import com.example.ss_team2.Notification
import com.example.ss_team2.presentation.navigation.ROOT_GRAPH_ROUTE
import com.example.ss_team2.presentation.navigation.Screen
import com.example.ss_team2.presentation.ui.Confirmation
import com.example.ss_team2.presentation.ui.chatList.ChatList
import com.example.ss_team2.presentation.ui.chatRoom.Dialog
import com.example.ss_team2.presentation.ui.firstpage.FirstPage
import com.example.ss_team2.presentation.ui.homepage.Homepage
import com.example.ss_team2.presentation.ui.homepage.HomepageScreen
import com.example.ss_team2.presentation.ui.mapScreen.MapScreen
import com.example.ss_team2.presentation.ui.profile.MyProfile
import com.example.ss_team2.presentation.ui.rankPage.Rank
import com.example.ss_team2.presentation.ui.registerPage.RegisterPage
import com.example.ss_team2.presentation.ui.shop.Shop
import com.example.ss_team2.presentation.ui.taskList.Quest
import com.example.ss_team2.presentation.ui.welcome.Welcome
import com.example.ss_team2.ui.theme.SSteam2Theme

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.First.route,
        route = ROOT_GRAPH_ROUTE
    ) {
        findNavGraph(navController = navController)
        lostNavGraph(navController = navController)
        composable(
            route = Screen.First.route
        ){
            FirstPage(navController = navController)
        }
        composable(
            route = Screen.Register.route
        ){
            RegisterPage(navController = navController)
        }
        composable(
            route = Screen.Login.route
        ){
            Welcome(navController = navController)
        }
        composable(
            route = Screen.Home.route
        ){
            Homepage(navController)
        }
        composable(
            route = Screen.Map.route
        ){
            MapScreen(navController = navController)
        }
        composable(
            route = Screen.ChatList.route
        ){
            ChatList(navController = navController)
        }
        composable(
            route = Screen.Shop.route
        ){
            Shop(navController = navController)
        }
        composable(
            route = Screen.ChatRoom.route
        ){
            Dialog(navController = navController)
        }
        composable(
            route = Screen.MyPost.route
        ){
            MyPostApp(navController)
        }
        composable(
            route = Screen.Profile.route
        ){
            MyProfile(navController = navController)
        }
        composable(
            route = Screen.Notification.route
        ){
            Notification(navController = navController)
        }
        composable(
            route = Screen.Quest.route
        ){
           Quest(navController = navController)
        }
        composable(
            route = Screen.Rank.route
        ){
            Rank(navController = navController)
        }
        composable(
            route = Screen.Confirmation.route
        ){
            Confirmation(navController = navController)
        }
        composable(
            route = Screen.EditPost.route
        ){
            EditPost(navController = navController)
        }
    }
}
