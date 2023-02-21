package com.lotte.smart.emp.base.widget

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lotte.smart.emp.ui.theme.LightBlu500
import com.lotte.smart.emp.ui.theme.LightGray300
import com.lotte.smart.emp.ui.theme.LightGray500
import com.lotte.smart.emp.ui.theme.Typography

@Preview(group = "Test")
@Composable
fun showBaseCheckBox() {
    BaseCheckBox(text = "test", checked = true)
}

@Composable
fun BaseCheckBox(
    text: String = "",
    checked: Boolean = false,
    onCheckedChange: ((Boolean) -> Unit) = {},
) {
    val checkedState = remember { mutableStateOf(checked) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(start = 16.dp)
    ) {
        Checkbox(
            checked = checkedState.value,
            onCheckedChange = {
                checkedState.value = it
                onCheckedChange(it)
            },
            colors = CheckboxDefaults.colors(
                checkedColor = LightBlu500,
                uncheckedColor = LightGray300
            )
        )
        Text(text = text, color = LightGray500, style = Typography.body2)
    }


}

