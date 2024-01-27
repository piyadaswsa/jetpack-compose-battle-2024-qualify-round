package com.github.thailandandroiddeveloper.common.ui.screen.qualify2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.thailandandroiddeveloper.common.R
import com.github.thailandandroiddeveloper.common.ui.preview.Pixel7
import com.github.thailandandroiddeveloper.common.ui.theme.AppTheme

@Composable
fun Qualify2Screen() {
    Scaffold(
        modifier = Modifier,
        topBar = { TopBar() },
        containerColor = MaterialTheme.colorScheme.onPrimary
    ) {
        TutorialContent(
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
        navigationIcon = {},
        actions = {
            TextButton(
                onClick = {}
            ) {
                Text(
                    text = "Skip",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp)
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.onPrimary,
        )
    )
}

@Composable
fun TutorialContent(modifier: Modifier) {
    Column(modifier = modifier) {
        TutorialHeaderText()

        TutorialDescriptionText()

        TutorialImage(modifier = Modifier.weight(1f))

        PageIndicator()

        NextButton()
    }
}

@Composable
private fun TutorialHeaderText() {
    Box(modifier = Modifier.padding(horizontal = 32.dp)) {
        Text(
            text = "Lorem ipsum dolor sit amet",
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun TutorialImage(modifier: Modifier) {
    Image(
        modifier = modifier
            .fillMaxWidth()
            .padding(all = 32.dp),
        painter = painterResource(R.drawable.img_qualify_2_onboard),
        contentDescription = "tutorial image",
        contentScale = ContentScale.FillBounds,
    )
}


@Composable
private fun TutorialDescriptionText() {
    Box(
        modifier = Modifier
            .padding(horizontal = 32.dp)
            .padding(top = 16.dp)
    ) {
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec egestas dictum lacinia. Integer arcu neque, porttitor ac metus quis, iaculis molestie magna. Vivamus molestie justo sed nulla lacinia, quis fringilla lorem imperdiet. Proin in quam vel odio iaculis fringilla",
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
private fun PageIndicator() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 48.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
    ) {
        repeat(5) { index ->
            PageIndicatorItem(index == 3)
        }
    }
}

@Composable
private fun PageIndicatorItem(isSelected: Boolean) {
    val width = if (isSelected) 32.dp else 16.dp
    val color =
        if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.primaryContainer

    Box(
        modifier = Modifier
            .height(16.dp)
            .width(width)
            .background(color, shape = RoundedCornerShape(size = 16.dp))
    )
}

@Composable
fun NextButton() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primaryContainer),
        contentAlignment = Alignment.Center,
    ) {
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 80.dp, vertical = 31.dp),
            contentPadding = PaddingValues(horizontal = 24.dp, vertical = 10.dp),
            onClick = { },
        ) {
            Text(
                text = "Next",
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.labelLarge,
            )
        }
    }
}


// region Read-only because we use this to process your score.
@Composable
@Preview(group = Pixel7.name, device = Pixel7.spec, showBackground = true)
fun Qualify2ScreenPreview() = AppTheme {
    Qualify2Screen()
}
// endregion