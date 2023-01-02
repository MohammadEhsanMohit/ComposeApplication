package com.example.composeapplication.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeapplication.R

@Composable
fun ProfilePage() {
    Card(
        elevation = CardDefaults.outlinedCardElevation(),
        modifier = Modifier
            .wrapContentSize()
            .padding(
                bottom = 100.dp, top = 100.dp,
                end = 16.dp, start = 16.dp
            )
            .border(
                width = 2.dp,
                color = Color.White,
                shape = RoundedCornerShape(30.dp)
            )
    ) {
        Column(
            Modifier
                .verticalScroll(rememberScrollState())
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile_img),
                contentDescription = "Test Profile",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .border(
                        width = 2.dp,
                        color = Color.Red,
                        shape = CircleShape
                    ),
                contentScale = ContentScale.Crop
            )
            Text(text = "Ehsan Mohit")
            Text(text = "IRAN")
            DrawRow(mapOf("Followers" to 150, "Following" to 100, "Posts" to 32))
            DrawButton(listData = listOf("Follow User", "Direct Message"))
        }
    }
}

@Composable
fun DrawRow(info: Map<String, Int>) =
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        for (item in info) {
            DrawColumn(item.key, item.value)
        }
    }

@Composable
fun DrawColumn(title: String, count: Int) =
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "$count",
            fontWeight = FontWeight.Bold
        )
        Text(text = title)
    }

@Composable
fun DrawButton(listData: List<String>) = Row(
    horizontalArrangement = Arrangement.SpaceEvenly,
    modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
) {
    for (btnText in listData) {
        Button(onClick = { /*TODO*/ }) {
            Text(btnText)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfilePage() {
    ProfilePage()
}