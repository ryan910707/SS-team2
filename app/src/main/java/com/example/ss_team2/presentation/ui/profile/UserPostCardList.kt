package com.example.ss_team2.presentation.ui.profile

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ss_team2.data.data_source.Post
import com.example.ss_team2.presentation.navigation.Screen
import com.example.ss_team2.presentation.viewModel.HelperViewModel
import com.example.ss_team2.presentation.viewModel.PostViewModel

@Composable
fun UserPostCardList(
    helperViewModel: HelperViewModel,
    postViewModel: PostViewModel,
    posts: List<Post>,
    tabPage: Int,
    modifier: Modifier,
    navController: NavController
) {

    LazyColumn(
        contentPadding = PaddingValues(vertical = 10.dp, horizontal = 20.dp),
        modifier = modifier
            .fillMaxWidth()
    ) {
        items(posts) { item ->
            if ((tabPage == 0 && !item.hasDone) || (tabPage == 1 && item.hasDone)) {
                UserPostCard(
                    what = item.itemType,
                    where = item.location,
                    postViewModel = postViewModel,
                    type = item.postType,
                    onClick = {
                        helperViewModel.getAllPostHelpers(item.postId)
                        postViewModel.getPostById(item.postId)
                        navController.navigate(route = Screen.MyPost.route)
                    },
                    modifier = Modifier
                )
            }
        }
    }
}