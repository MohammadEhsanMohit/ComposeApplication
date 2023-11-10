package com.example.composeapplication.feature.register.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.example.composeapplication.R
import com.example.composeapplication.ui.theme.ComposeApplicationTheme

private const val LOGO_VIEW_ID = "logoView"
@Composable
fun UserLoginScreen() {
    BoxWithConstraints(modifier =
    Modifier.fillMaxSize()
        .background(MaterialTheme.colorScheme.primary)) {
        ConstraintLayout(
            modifier=Modifier.matchParentSize(),
            constraintSet = getLoginConstrainSet()) {
            Image(
                painterResource(id = R.drawable.jet_pack_compose),
                contentDescription = "Logo",
                modifier = Modifier
                    .height(150.dp)
                    .layoutId(LOGO_VIEW_ID)
            )
        }
    }
}

private fun getLoginConstrainSet() = ConstraintSet {
    val logoHolder = createRefFor(LOGO_VIEW_ID)

    constrain(logoHolder) {
        top.linkTo(parent.top)
        start.linkTo(parent.start)
        end.linkTo(parent.end)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    ComposeApplicationTheme {
        UserLoginScreen()
    }
}