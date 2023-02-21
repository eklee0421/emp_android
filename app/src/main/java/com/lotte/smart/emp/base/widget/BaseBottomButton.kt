package com.lotte.smart.emp.base.widget

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lotte.smart.emp.ui.theme.LightBlu500
import com.lotte.smart.emp.ui.theme.Typography

@Preview(group = "Test")
@Composable
fun showBaseBottomButton() {
    BaseBottomButton(text = "test")
}

@Composable
fun BaseBottomButton(
    onClick: () -> Unit = {},
    text: String = "",
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = LightBlu500),
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        elevation = ButtonDefaults.elevation(0.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(text = text, color = Color.White, style = Typography.button)
    }
}

