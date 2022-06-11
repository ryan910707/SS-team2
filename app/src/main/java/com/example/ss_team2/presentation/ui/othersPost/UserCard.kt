package com.example.ss_team2.presentation.ui.othersPost

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ss_team2.presentation.ui.PickImageFromGallery
import com.example.ss_team2.presentation.viewModel.UserViewModel

@Composable
fun UserCard(
    modifier: Modifier = Modifier,
    userName: String,
    @DrawableRes drawable: Int,
    userViewModel: UserViewModel
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
//        Image(
//            painter = painterResource(drawable),
//            contentDescription = null,
//            contentScale = ContentScale.Crop,
//            modifier = Modifier
//                .size(60.dp)
//                .padding(8.dp)
//                .clip(CircleShape)
//        )
        PickImageFromGallery(userViewModel = userViewModel)
        Text(
            text = userName,
            fontSize = 16.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )

    }
}