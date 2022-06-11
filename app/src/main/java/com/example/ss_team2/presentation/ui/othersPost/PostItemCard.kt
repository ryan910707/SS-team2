package com.example.ss_team2.presentation.ui.othersPost

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ss_team2.R
import com.example.ss_team2.presentation.ui.PickImageFromGallery2
import com.example.ss_team2.presentation.ui.utility.WhatAndWhereColElement
import com.example.ss_team2.presentation.viewModel.PostViewModel
import com.example.ss_team2.ui.theme.TextGray

@Composable
fun PostItemCard(
    modifier: Modifier = Modifier,
    postViewModel: PostViewModel
) {

    val post by postViewModel.post.collectAsState()
    val bitmap = remember {
        mutableStateOf<Bitmap?>(null)
    }
    val context = LocalContext.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(280.dp)
            .background(Color(220, 220, 220)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        PickImageFromGallery2(postViewModel = postViewModel)
//        Image(
//            painter = painterResource(id = R.drawable.defaultpicture),
//            contentDescription = null,
//            contentScale = ContentScale.Crop,
//            modifier = Modifier
//                .fillMaxHeight()
//                .width(200.dp)
//                .clip(RectangleShape)
//        )
//        if (post.itemImage == null) {
//            bitmap.value = BitmapFactory.decodeResource(
//                context.getResources(),
//                R.drawable.defaultpicture
//            )
//        } else {
//            if (Build.VERSION.SDK_INT < 28) {
//                Log.d("Args", "15802170751841")
//
//                bitmap.value = MediaStore.Images
//                    .Media.getBitmap(context.contentResolver, Uri.parse(post.itemImage))
//                Log.d("Args", "1")
//            } else {
//                val source =
//                    ImageDecoder.createSource(context.contentResolver, Uri.parse(post.itemImage))
//                bitmap.value = ImageDecoder.decodeBitmap(source)
//            }
//
//        }
//        bitmap.value?.let { btm ->
//            Image(
//                bitmap = btm.asImageBitmap(),
//                contentDescription = null,
//                contentScale = ContentScale.Crop,
//                modifier = Modifier
//                    .fillMaxHeight()
//                    .width(200.dp)
//                    .clip(RectangleShape)
//            )
//        }

        Column(modifier = Modifier) {
            WhatAndWhereColElement(
                what = post.itemType,
                where = post.location,
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 12.dp, bottom = 24.dp)
            )
            Text(
                text = post.postDescribe!!,
                color = TextGray,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.weight(1f)
            )
        }

    }
}