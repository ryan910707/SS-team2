package com.example.ss_team2.presentation.ui.profile

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.ss_team2.R
import androidx.compose.ui.unit.dp
import com.example.ss_team2.presentation.ui.PickImageFromGallery
import com.example.ss_team2.ui.theme.TextGray

@Composable
fun PersonalInfo(
     image: String?,
    schoolName: String,
    toolAmount: Int,
    point: Int
) {


    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        modifier = Modifier.padding(top = 20.dp)
    ) {
        PickImageFromGallery(BackendUri = image)
        Text(
            text = schoolName
        )
    }

    Row(
        horizontalArrangement = Arrangement.spacedBy(80.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(top = 32.dp, bottom = 12.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.width(80.dp)
        ) {
            Text(
                text = toolAmount.toString()
            )
            Text(
                text = stringResource(id = R.string.own_tool),
                fontWeight = FontWeight.Bold,
                color = TextGray
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.width(80.dp)
        ) {
            Text(
                text = point.toString()
            )
            Text(
                text = stringResource(id = R.string.point),
                fontWeight = FontWeight.Bold,
                color = TextGray
            )
        }
    }

}