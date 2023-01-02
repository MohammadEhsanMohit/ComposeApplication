package com.example.composeapplication.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import kotlinx.coroutines.launch
import com.example.composeapplication.R
@Composable
fun ProfilePageNew() {
    Card(
        elevation = CardDefaults.cardElevation(),
        modifier = Modifier
            .fillMaxSize()
            .padding(
                bottom = 100.dp, top = 100.dp,
                end = 8.dp, start = 8.dp
            )
    ) {
        BoxWithConstraints {
            val scope = rememberCoroutineScope()
            val constraint = if (maxWidth < 600.dp) {
                portraitConstraintSet(16.dp)
            } else {
                landscapeConstraintSet(16.dp)
            }
            ConstraintLayout(
                constraint,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                /*val image,
                    nameText, countryText,
                    followersCount, followersText,
                    followingCount, followingText,
                    postCount, postText,
                    btnFollowUser, btnMessage) = createRefs()*/
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
                        )
                        .layoutId("image"),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "Ehsan Mohit",
                    modifier = Modifier.layoutId("nameText")
                )
                Text(
                    text = "IRAN",
                    modifier = Modifier.layoutId("countryText")
                )
                Text(
                    text = "150",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.layoutId("followersCount")
                )
                Text(
                    text = "Followers",
                    modifier = Modifier.layoutId("followersText")
                )
                Text(
                    text = "100",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.layoutId("followingCount")
                )
                Text(
                    text = "Following",
                    modifier = Modifier.layoutId("followingText")
                )
                Text(
                    text = "32",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.layoutId("postCount")
                )
                Text(
                    text = "Posts",
                    modifier = Modifier.layoutId("postText")
                )
                Button(
                    onClick = {
                        scope.launch {

                        }
                    },
                    modifier = Modifier.layoutId("btnFollowUser")
                ) {
                    Text(text = "Follow User")
                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.layoutId("btnMessage")
                ) {
                    Text(text = "Direct Message")
                }
                //DrawRowText(countryText,mapOf("Followers" to 150, "Following" to 100, "Posts" to 32))
            }
        }

    }
}

private fun portraitConstraintSet(margin: Dp) = ConstraintSet {
    val image = createRefFor("image")
    val nameText = createRefFor("nameText")
    val countryText = createRefFor("countryText")
    val followersCount = createRefFor("followersCount")
    val followersText = createRefFor("followersText")
    val followingCount = createRefFor("followingCount")
    val followingText = createRefFor("followingText")
    val postCount = createRefFor("postCount")
    val postText = createRefFor("postText")
    val btnFollowUser = createRefFor("btnFollowUser")
    val btnMessage = createRefFor("btnMessage")

    constrain(image) {
        top.linkTo(parent.top, 8.dp)
        start.linkTo(parent.start)
        end.linkTo(parent.end)
    }
    constrain(nameText) {
        top.linkTo(image.bottom, 4.dp)
        start.linkTo(parent.start)
        end.linkTo(parent.end)
    }
    constrain(countryText) {
        top.linkTo(nameText.bottom, 2.dp)
        start.linkTo(nameText.start)
        end.linkTo(nameText.end)
    }
    constrain(followersCount) {
        top.linkTo(countryText.bottom, margin = 16.dp)
        start.linkTo(parent.start)
        end.linkTo(followingCount.start)
        width = Dimension.wrapContent
    }
    constrain(followersText) {
        top.linkTo(followersCount.bottom, margin = 2.dp)
        start.linkTo(followersCount.start)
        end.linkTo(followersCount.end)
    }
    constrain(followingCount) {
        top.linkTo(followersCount.top)
        start.linkTo(followersCount.end)
        end.linkTo(postCount.start)
    }
    constrain(followingText) {
        top.linkTo(followingCount.bottom, margin = 2.dp)
        start.linkTo(followingCount.start)
        end.linkTo(followingCount.end)
    }

    constrain(postCount) {
        top.linkTo(followingCount.top)
        start.linkTo(followingCount.end)
        end.linkTo(parent.end)
    }
    constrain(postText) {
        top.linkTo(postCount.bottom, margin = 2.dp)
        start.linkTo(postCount.start)
        end.linkTo(postCount.end)
    }

    constrain(btnFollowUser) {
        top.linkTo(followersCount.bottom, margin = 32.dp)
        start.linkTo(parent.start, margin = 4.dp)
        end.linkTo(btnMessage.start)
        width = Dimension.wrapContent
    }
    constrain(btnMessage) {
        top.linkTo(btnFollowUser.top)
        start.linkTo(btnFollowUser.end, margin = 32.dp)
        end.linkTo(parent.end, margin = 4.dp)
        width = Dimension.wrapContent
    }


}

private fun landscapeConstraintSet(margin: Dp) = ConstraintSet {
    val image = createRefFor("image")
    val nameText = createRefFor("nameText")
    val countryText = createRefFor("countryText")
    val followersCount = createRefFor("followersCount")
    val followersText = createRefFor("followersText")
    val followingCount = createRefFor("followingCount")
    val followingText = createRefFor("followingText")
    val postCount = createRefFor("postCount")
    val postText = createRefFor("postText")
    val btnFollowUser = createRefFor("btnFollowUser")
    val btnMessage = createRefFor("btnMessage")

    constrain(image) {
        top.linkTo(parent.top, margin)
        start.linkTo(parent.start)
    }
    constrain(nameText) {
        top.linkTo(image.bottom, margin)
        start.linkTo(image.start)
        end.linkTo(image.end)
    }
    constrain(countryText) {
        top.linkTo(nameText.bottom, margin)
        start.linkTo(nameText.start)
        end.linkTo(nameText.end)
        bottom.linkTo(parent.bottom, margin)
    }
    constrain(followersCount) {
        top.linkTo(image.top)
        start.linkTo(image.end, margin = margin)
        end.linkTo(followingCount.start)
        width = Dimension.wrapContent
    }
    constrain(followersText) {
        top.linkTo(followersCount.bottom, margin = 2.dp)
        start.linkTo(followersCount.start)
        end.linkTo(followersCount.end)
    }
    constrain(followingCount) {
        top.linkTo(followersCount.top)
        start.linkTo(followersCount.end)
        end.linkTo(postCount.start)
    }
    constrain(followingText) {
        top.linkTo(followingCount.bottom, margin = 2.dp)
        start.linkTo(followingCount.start)
        end.linkTo(followingCount.end)
    }

    constrain(postCount) {
        top.linkTo(followingCount.top)
        start.linkTo(followingCount.end)
        end.linkTo(parent.end)
    }
    constrain(postText) {
        top.linkTo(postCount.bottom, margin = 2.dp)
        start.linkTo(postCount.start)
        end.linkTo(postCount.end)
    }

    constrain(btnFollowUser) {
        top.linkTo(followersCount.bottom, margin = 32.dp)
        start.linkTo(image.end, margin = 4.dp)
        end.linkTo(btnMessage.start)
        width = Dimension.wrapContent
    }
    constrain(btnMessage) {
        top.linkTo(btnFollowUser.top)
        start.linkTo(btnFollowUser.end, margin = 32.dp)
        end.linkTo(parent.end, margin = 4.dp)
        width = Dimension.wrapContent
    }


}

@Preview(showBackground = true)
@Composable
fun PreviewNewProfile() {
    ProfilePageNew()
}
