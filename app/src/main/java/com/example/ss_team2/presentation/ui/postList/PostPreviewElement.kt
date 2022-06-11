package com.example.ss_team2.presentation.ui.postList

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.ss_team2.R
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
import com.example.ss_team2.data.data_source.Post
import com.example.ss_team2.presentation.ui.PickImageFromGallery2
import com.example.ss_team2.presentation.ui.utility.WhatAndWhereColElement
import com.example.ss_team2.presentation.viewModel.PostViewModel
import com.example.ss_team2.ui.theme.TextGray

@Composable
fun PostPreviewElement(
    post: Post,
    onClick: () -> Unit,
    postViewModel: PostViewModel
) {
    val context = LocalContext.current
    val bitmap = remember {
        mutableStateOf<Bitmap?>(null)
    }

    OutlinedButton(
        modifier = Modifier
            .width(360.dp)
            .height(140.dp),
        shape = RoundedCornerShape(12),
        onClick = onClick,
        border = BorderStroke(1.dp, Color(0x66, 0x70, 0x80))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(24.dp),
            modifier = Modifier
                .width(280.dp)
                .fillMaxHeight()
        ) {
//            Image(
//                painter = painterResource(R.drawable.umbrella1),
//                contentDescription = null,
//                contentScale = ContentScale.Crop,
//                modifier = Modifier
//                    .size(100.dp)
//                    .clip(RectangleShape)
//            )
            PickImageFromGallery2(postViewModel = postViewModel)
//            if (post.itemImage == null) {
//                bitmap.value = BitmapFactory.decodeResource(
//                    context.getResources(),
//                    R.drawable.defaultpicture
//                )
//            } else {
//                if (Build.VERSION.SDK_INT < 28) {
//                    Log.d("Args", "15802170751841")
//
//                    bitmap.value = MediaStore.Images
//                        .Media.getBitmap(context.contentResolver, Uri.parse(post.itemImage))
//                    Log.d("Args", "1")
//                } else {
//                    val source =
//                        ImageDecoder.createSource(context.contentResolver, Uri.parse(post.itemImage))
//                    bitmap.value = ImageDecoder.decodeBitmap(source)
//                }
//
//            }
//            bitmap.value?.let { btm ->
//                Image(
//                    bitmap = btm.asImageBitmap(),
//                    contentDescription = null,
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier
//                        .size(100.dp)
//                        .clip(RectangleShape)
//                )
//            }

            WhatAndWhereColElement(post.itemType, post.location, modifier = Modifier.fillMaxHeight())
            Text(
                text = post.postDescribe!!,
                fontSize = 12.sp,
                color = TextGray,
                fontWeight = FontWeight.Bold
            )
        }
        if (post.postType != "Lost") {
            Text(
                text = "+${post.rewardCoin}",
                fontSize = 12.sp,
                modifier = Modifier.align(Alignment.Bottom)
            )
        }
    }
}