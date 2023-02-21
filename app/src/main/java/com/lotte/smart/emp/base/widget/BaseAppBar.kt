package com.lotte.smart.emp.base.widget

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lotte.smart.emp.ui.theme.LightGray100
import com.lotte.smart.emp.ui.theme.LightGray700
import com.lotte.smart.emp.ui.theme.Typography

@Preview(group = "Test")
@Composable
fun showBaseAppBar() {
    BaseAppBar(title = "title", leftIconImage = Icons.Default.ArrowBack)
}

@Composable
fun BaseAppBar(
    title: String = "",
    leftIconAction: (() -> Unit) = {},
    leftIconImage: ImageVector? = null,
    rightIconAction: (() -> Unit) = {},
    rightIconImage: ImageVector? = null,
    backgroundColor: Color = LightGray100,
) {
    val modifier = Modifier
        .size(width = 56.dp, height = 56.dp)
        .padding(0.dp)
    TopAppBar(
        title = {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(end = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = title, color = LightGray700, style = Typography.h2)
            }
        },
        backgroundColor = backgroundColor,
        contentColor = LightGray700,
        elevation = 0.dp,
        navigationIcon = {
            Box(modifier = modifier, contentAlignment = Alignment.Center) {
                if (leftIconImage != null) {
                    IconButton(onClick = leftIconAction) {
                        Icon(
                            imageVector = leftIconImage,
                            contentDescription = "",
                            tint = LightGray700
                        )
                    }
                }
            }
        },
        actions = {
            Box(modifier = modifier, contentAlignment = Alignment.Center) {
                if (rightIconImage != null) {
                    IconButton(onClick = rightIconAction) {
                        Icon(
                            imageVector = rightIconImage,
                            contentDescription = "",
                            tint = LightGray700
                        )
                    }
                }
            }
        }
    )

}

