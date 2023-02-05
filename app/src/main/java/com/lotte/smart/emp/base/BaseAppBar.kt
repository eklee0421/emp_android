package com.lotte.smart.emp.base

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.lotte.smart.emp.ui.theme.LightGray100
import com.lotte.smart.emp.ui.theme.LightGray300
import com.lotte.smart.emp.ui.theme.LightGray700

@Preview()
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
    val modifier = Modifier.size(width = 56.dp, height = 56.dp)
    TopAppBar(
        title = {
            Box(
                Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = title,Modifier.padding(17.dp))
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

