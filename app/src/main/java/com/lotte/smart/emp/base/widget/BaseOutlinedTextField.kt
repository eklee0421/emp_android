package com.lotte.smart.emp.base.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lotte.smart.emp.ui.theme.*

@Preview(group = "Test")
@Composable
fun showBaseOutlinedTextField() {
    BaseOutlinedTextField(value = "test", placeholder = "hint")
}

@Composable
fun BaseOutlinedTextField(
    value: String = "",
    onValueChange: (String) -> Unit = {},
    modifier: Modifier = Modifier.fillMaxWidth(),
    enabled: Boolean = true,
    readOnly: Boolean = false,
    label: String = "",
    placeholder: String = "",
    isError: Boolean = false,
    isPassword: Boolean = false,
    leadingIcon: ImageVector = Icons.Filled.Info,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val inputValue = remember { mutableStateOf(value) }
    val isPasswordType = remember { mutableStateOf(isPassword) }
    val focusRequester = FocusRequester()
    val focusManager = LocalFocusManager.current
    OutlinedTextField(
        value = inputValue.value,
        onValueChange = {
            inputValue.value = it
            onValueChange(it)
        },
        modifier = modifier
            .height(72.dp)
            .defaultMinSize(minWidth = 1.dp, minHeight = 1.dp)
            .focusRequester(focusRequester),
        enabled = enabled,
        readOnly = readOnly,
        textStyle = Typography.body2,
        label = { Text(label, color = LightGray400, style = Typography.body2) },
        placeholder = { Text(placeholder, color = LightGray400, style = Typography.body2) },
        leadingIcon = {
            if (isPassword) {
                Icon(imageVector = if (isPasswordType.value) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                    contentDescription = null,
                    modifier = Modifier
                        .width(20.dp)
                        .height(20.dp)
                        .clickable {
                            isPasswordType.value = !isPasswordType.value
                        })
            } else {
                Icon(
                    imageVector = leadingIcon,
                    contentDescription = null,
                    modifier = Modifier
                        .width(20.dp)
                        .height(20.dp)
                )
            }
        },
        trailingIcon = {
            if (value.isNotEmpty()) {
                IconButton(onClick = { }) {
                    Icon(imageVector = Icons.Filled.Close,
                        contentDescription = null,
                        modifier = Modifier
                            .width(20.dp)
                            .height(20.dp)
                            .clickable {
                                inputValue.value = ""
                                onValueChange("")
                                focusRequester.requestFocus()
                            })
                }
            }

        },
        isError = isError,
        visualTransformation = if (isPasswordType.value) PasswordVisualTransformation() else VisualTransformation.None,
        singleLine = true,
        keyboardOptions = keyboardOptions,
        keyboardActions = KeyboardActions(
            onNext = { focusManager.moveFocus(FocusDirection.Down) },
            onDone = { focusManager.clearFocus() }),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = LightGray300,
            focusedBorderColor = LightBlu500,
            backgroundColor = Color.White,
            textColor = LightGray700
        ),
        shape = RoundedCornerShape(4.dp)
    )
}

