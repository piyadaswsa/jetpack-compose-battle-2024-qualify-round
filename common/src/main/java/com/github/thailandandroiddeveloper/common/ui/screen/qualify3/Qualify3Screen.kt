package com.github.thailandandroiddeveloper.common.ui.screen.qualify3

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.thailandandroiddeveloper.common.R
import com.github.thailandandroiddeveloper.common.ui.preview.Pixel7
import com.github.thailandandroiddeveloper.common.ui.theme.AppTheme

@Composable
fun Qualify3Screen() {
    Scaffold(
        modifier = Modifier,
        topBar = { TopBar() },
        containerColor = MaterialTheme.colorScheme.onPrimary
    ) {
        ProfileContent(
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
        title = {
            Text(text = "John Doe")
        },
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_qualify_3_back),
                    contentDescription = "navigation icon",
                    modifier = Modifier.size(48.dp)
                )
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_qualify_3_copy),
                    contentDescription = "action copy",
                    modifier = Modifier.size(48.dp)
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_qualify_3_calendar),
                    contentDescription = "action calendar",
                    modifier = Modifier.size(48.dp)
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_qualify_3_menu),
                    contentDescription = "action menu",
                    modifier = Modifier.size(48.dp)
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            containerColor = MaterialTheme.colorScheme.primaryContainer,
        )
    )
}

@Composable
private fun ProfileContent(modifier: Modifier) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(vertical = 16.dp),
    ) {
        val descriptions = listOf(
            "Duis dignissim pulvinar lectus imperdiet tempus. Curabitur fringilla commodo consectetur. Sed congue blandit nibh.",
            "Morbi sed sagittis justo, at pulvinar ipsum. Praesent massa metus, interdum at suscipit a, interdum vel orci. Pellentesque in sapien. Integer faucibus mauris ac luctus aliquam accumsan.",
            "Duis dignissim pulvinar lectus imperdiet tempus. Curabitur fringilla commodo.",
            "Ut hendrerit neque nec accumsan hendrerit. Fusce lobortis rhoncus erat, a blandit nibh molestie vel. Cras commodo ligula ex, vitae venenatis lacus facilisis eget."
        )

        item {
            ProfileImages()
        }

        item {
            ProfileTags()
        }

        items(descriptions) { description ->
            ProfileDescriptionCards(description)
        }
    }
}

@Composable
private fun ProfileImages() {
    val imagesResId = listOf(
        R.drawable.img_qualify_3_photo_1,
        R.drawable.img_qualify_3_photo_2,
        R.drawable.img_qualify_3_photo_3
    )

    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        itemsIndexed(imagesResId) { index, resId ->
            ProfileImageItem(resId = resId, isSelected = index == 0)
        }
    }
}

@Composable
private fun ProfileImageItem(
    resId: Int,
    isSelected: Boolean
) {
    val unselectedColor = MaterialTheme.colorScheme.primaryContainer
    val selectedColor = MaterialTheme.colorScheme.primary

    Image(
        painter = painterResource(resId),
        contentDescription = "profile image",
        modifier = Modifier
            .border(
                width = 2.dp,
                color = if (isSelected) selectedColor else unselectedColor,
                shape = RoundedCornerShape(size = 16.dp)
            )
            .height(320.dp)
            .clip(RoundedCornerShape(size = 16.dp)),
    )
}

@Composable
private fun ProfileTags() {
    val tags = listOf(
        "Tag 1",
        "Tag 2",
        "Tag 3",
        "Tag 4"
    )

    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        itemsIndexed(tags) { index, tag ->
            ProfileTagItem(tagName = tag, isSelected = index == 0)
        }
    }
}

@Composable
private fun ProfileTagItem(
    tagName: String,
    isSelected: Boolean
) {
    val unselectedColor = MaterialTheme.colorScheme.outline
    val selectedColor = MaterialTheme.colorScheme.primary

    Box(
        modifier = Modifier.border(
            width = 1.dp,
            color = if (isSelected) selectedColor else unselectedColor,
            shape = RoundedCornerShape(size = 8.dp)
        ),
    ) {
        Text(
            text = tagName,
            color = if (isSelected) selectedColor else unselectedColor,
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)
        )
    }
}

@Composable
private fun ProfileDescriptionCards(description: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.surfaceVariant,
                shape = RoundedCornerShape(size = 16.dp)
            )
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(size = 16.dp)
            )
    ) {
        ProfileDescriptionCardContent(description)
    }
}

@Composable
private fun ProfileDescriptionCardContent(
    description: String
) {
    Row(
        modifier = Modifier.padding(all = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_qualify_3_sender),
            contentDescription = "sender image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
        )

        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Lorem Ipsum",
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = description,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.bodyMedium,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2,
            )
        }
    }
}

// region Read-only because we use this to process your score.
@Composable
@Preview(group = Pixel7.name, device = Pixel7.spec, showBackground = true)
fun Qualify3ScreenPreview() = AppTheme {
    Qualify3Screen()
}
// endregion