package com.lotte.smart.emp.base

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
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
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.lotte.smart.emp.ui.theme.LightBlu500
import com.lotte.smart.emp.ui.theme.LightGray300
import com.lotte.smart.emp.ui.theme.Typography

@Preview()
@Composable
fun showBaseBottomButton() {
    BaseBottomButton(text = "test")
}

@Composable
fun BaseBottomButton(
    onClick: () -> Unit = {},
    text : String = "",
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = LightBlu500),
        modifier = Modifier.fillMaxWidth().height(48.dp),
        elevation = ButtonDefaults.elevation(0.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(text=text, color = Color.White, style= Typography.button)
    }
}

