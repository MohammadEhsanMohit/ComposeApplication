package com.example.composeapplication.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.composeapplication.R
import com.example.composeapplication.data.model.Recipe
import com.example.composeapplication.ui.theme.PurpleGrey40

@Composable
fun RecipeImage(recipe: Recipe) {
    with(recipe) {
        if(imageResource != null) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(144.dp)
                    .border(1.dp, PurpleGrey40)
                    .layoutId("recipe_${recipe.title}"),
                imageVector = ImageVector.vectorResource(id = recipe.imageResource?:R.drawable.logo_vector),
                contentScale = ContentScale.Crop,
                contentDescription = "image_${recipe.title}")
        } else if(!imageUrl.isNullOrEmpty()){
            AsyncImage(model = imageUrl,

                contentDescription = "image_${recipe.title}",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(144.dp)
                    .border(1.dp, PurpleGrey40)
                    .layoutId("recipe_${recipe.id}"),
                contentScale = ContentScale.FillWidth
            )
        } else {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(144.dp)
                    .border(1.dp, PurpleGrey40)
                    .layoutId("recipe_${recipe.id}"),
                imageVector = ImageVector.vectorResource(id = R.drawable.logo_vector),
                contentScale = ContentScale.FillBounds,
                contentDescription = "image_${recipe.title}")
        }
    }
}
@Composable
fun ImageView(imageVector: ImageVector,
              shape: Shape,
              size: Dp,
              borderSize :Dp,
              layoutId:Any,
              borderColor: Color,
              contentScale: ContentScale
) {
    Image(
        modifier = Modifier
            .size(size)
            .clip(shape)
            .border(borderSize, borderColor)
            .layoutId(layoutId),
        imageVector = imageVector,
        contentScale = contentScale,
        contentDescription = "image_$layoutId")
}

@Composable
fun ImageView(
    borderColor: Color = Color.Red,
    shape: Shape = CircleShape,
    resourceId: Int = R.drawable.profile_img,
    size: Dp = 100.dp,
    borderSize :Dp = 1.dp,
    layoutId:Any = "image",
    contentScale: ContentScale = ContentScale.Crop
) {
    Image(
        modifier = Modifier
            .size(size)
            .clip(shape)
            .border(borderSize, borderColor, shape)
            .layoutId(layoutId),
        painter = painterResource(id = resourceId)/*ImageVector.vectorResource(id = R.drawable.logo_vector)*/,
        contentScale = contentScale,
        contentDescription = "Logo",
    )
}


@Composable
@Preview
fun SplashViewPreview() {
    ImageView()
}