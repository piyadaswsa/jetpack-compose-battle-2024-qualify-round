package com.github.thailandandroiddeveloper.common.ui.screen.qualify1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.thailandandroiddeveloper.common.R
import com.github.thailandandroiddeveloper.common.ui.preview.Pixel7
import com.github.thailandandroiddeveloper.common.ui.theme.AppTheme
import com.github.thailandandroiddeveloper.common.ui.theme.LightColors.Primary

@Composable
fun Qualify1Screen() {
    Scaffold(
        modifier = Modifier,
        topBar = { TopBar() },
        containerColor = colorScheme.onPrimary
    ) {
        MainContent(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar() {
    TopAppBar(
        title = {},
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_qualify_1_menu),
                    contentDescription = "navigation icon",
                    modifier = Modifier.size(48.dp)
                )
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_qualify_1_profile),
                    contentDescription = "actions",
                    modifier = Modifier.size(48.dp)
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            navigationIconContentColor = colorScheme.onPrimaryContainer,
            actionIconContentColor = colorScheme.onPrimaryContainer,
            containerColor = colorScheme.primaryContainer,
        )
    )
}

@Composable
private fun MainContent(modifier: Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .padding(top = 16.dp, bottom = 48.dp)
    ) {
        MainContentBox()

        Row(
            horizontalArrangement = Arrangement.spacedBy(43.dp),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset(y = 24.dp),
        ) {
            ButtonThumbDown()
            ButtonThumbUp()
        }
    }
}

@Composable
private fun MainContentBox() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(size = 16.dp)),
        contentAlignment = Alignment.BottomStart
    ) {
        MainImage()
        MainInfo()
    }
}

@Composable
private fun ButtonThumbDown() {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(colorScheme.errorContainer),
        shape = RoundedCornerShape(100.dp),
        modifier = Modifier
            .width(120.dp)
            .height(48.dp),
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_qualify_1_thumb_down),
            contentDescription = "button thumb down",
            tint = colorScheme.onErrorContainer,
            modifier = Modifier,
        )
    }
}

@Composable
private fun ButtonThumbUp() {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(colorScheme.primaryContainer),
        shape = RoundedCornerShape(100.dp),
        modifier = Modifier
            .width(120.dp)
            .height(48.dp),
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_qualify_1_thumb_up),
            contentDescription = "button thumb up",
            tint = colorScheme.onPrimaryContainer,
            modifier = Modifier,
        )
    }
}

@Composable
private fun MainImage() {
    Image(
        painter = painterResource(id = R.drawable.img_qualify_1_profile),
        contentDescription = "main image",
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
    )
}

@Composable
private fun MainInfo() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .drawBehind {
                drawRect(color = Primary, alpha = 0.75f)
            },
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        ProfileName()
        ProfileGender()
        ProfileDescription()
    }
}

@Composable
private fun ProfileName() {
    Text(
        text = "John Doe",
        color = colorScheme.onPrimary,
        style = typography.headlineMedium,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(top = 20.dp)
    )
}

@Composable
private fun ProfileGender() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_qualify_1_gender_male),
            contentDescription = "gender icon",
            tint = colorScheme.onPrimary,
            modifier = Modifier,
        )

        Text(
            text = "Male",
            color = colorScheme.onPrimary,
            style = typography.bodyMedium
        )
    }
}

@Composable
private fun ProfileDescription() {
    Text(
        text = "Lorem ipsum dolor sit amet, cd nulla lacinia, quis fringilla lorem imperdiet. Proin in quam vel odio iaculis fringilla.",
        color = colorScheme.onPrimary,
        style = typography.bodyMedium,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(bottom = 40.dp)
    )
}

// region Read-only because we use this to process your score.
@Composable
@Preview(group = Pixel7.name, device = Pixel7.spec, showBackground = true)
fun Qualify1ScreenPreview() = AppTheme {
    Qualify1Screen()
}
// endregion