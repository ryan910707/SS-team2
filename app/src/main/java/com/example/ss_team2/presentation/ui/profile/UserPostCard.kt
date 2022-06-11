package com.example.ss_team2.presentation.ui.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.ss_team2.R
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ss_team2.presentation.navigation.Screen
import com.example.ss_team2.presentation.ui.PickImageFromGallery2
import com.example.ss_team2.presentation.viewModel.PostViewModel
import com.example.ss_team2.ui.theme.FindHint
import com.example.ss_team2.ui.theme.FindHintDark
import com.example.ss_team2.ui.theme.LostHint
import com.example.ss_team2.ui.theme.LostHintDark

@Composable
fun UserPostCard(
    what: String,
    where: String,
    type: String,
    onClick: () -> Unit,
    modifier: Modifier,
    postViewModel: PostViewModel
) {

    Surface(
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(10.dp)
            )
            .clickable { onClick() }
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
        ) {
            PickImageFromGallery2(postViewModel = postViewModel)
//            Image(
//                painter = painterResource(id = R.drawable.umbrella1),
//                contentDescription = null,
//                contentScale = ContentScale.Crop,
//                modifier = Modifier.size(72.dp)
//            )
            PostInfo(
                text = "What",
                tags = what,
                modifier = Modifier
                    .offset(x = 20.dp)
                    .width(60.dp)
            )
            PostInfo(
                text = "Where",
                tags = where,
                modifier = Modifier.offset(x = 60.dp)
            )
        }
    }
    PostTypeHint(
        type = type,
        modifier = modifier
            .offset(x = (-10).dp, y = (-82).dp)
            .size(20.dp)
    )
}

@Composable
fun PostInfo(
    text: String,
    tags: String,
    modifier: Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = text,
            style = MaterialTheme.typography.h6,
            fontSize = 8.sp,
            modifier = Modifier
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            item {
                Text(
                    text = tags,
                    style = MaterialTheme.typography.h6,
                    fontSize = 12.sp,
                )
            }
        }
    }
}

@Composable
fun PostTypeHint(
    type: String,
    modifier: Modifier
) {
    val color: Color =
        if (MaterialTheme.colors.isLight) {
            if (type == "find") FindHint else LostHint
        } else {
            if (type == "find") FindHintDark else LostHintDark
        }

    val text: String = if (type == "find") "撿" else "遺"

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.background(color = color, shape = CircleShape)
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 10.sp,
            textAlign = TextAlign.Center
        )
    }
}