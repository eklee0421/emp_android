package com.lotte.smart.emp.domain.login


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lotte.smart.emp.R
import com.lotte.smart.emp.base.*
import com.lotte.smart.emp.model.LoginModel
import com.lotte.smart.emp.ui.theme.LightBlu500
import com.lotte.smart.emp.ui.theme.LightGray100

@Preview()
@Composable
fun LoginView() {
    val loginModel = remember { mutableStateOf(LoginModel()) }
    val isAutoChecked = remember { mutableStateOf(false) }
    Scaffold(backgroundColor = LightGray100,
        topBar = { BaseAppBar(title = stringResource(R.string.login_title)) },
        content = {
            Column {
                LoginTextLayout(title = stringResource(R.string.login_title_id),
                    placeholder = stringResource(R.string.login_hint_id),
                    text = loginModel.value.id,
                    onChange = { loginModel.value.id = it })
                LoginTextLayout(
                    title = stringResource(R.string.login_title_pw),
                    placeholder = stringResource(R.string.login_hint_pw),
                    text = loginModel.value.password,
                    onChange = { loginModel.value.password = it },
                    isPassword = true
                )
                BaseCheckBox(
                    text = stringResource(R.string.login_auto_check),
                    checked = isAutoChecked.value,
                    onCheckedChange = { isAutoChecked.value = it })

                Text(text=loginModel.value.id)
            }
        },
        bottomBar = {
            BaseBottomButton(text = stringResource(R.string.login_title))
        }

    )

}


@Composable
fun LoginTextLayout(
    title: String = "",
    text: String = "",
    onChange: (String) -> Unit = {},
    placeholder: String = "",
    isPassword: Boolean = false
) {
    val inputValue = remember { mutableStateOf(text) }
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        BaseText(
            text = title,
            fontSize = 14.sp,
        )
        BaseOutlinedTextField(
            value = inputValue.value,
            onValueChange = {
                inputValue.value = it
                onChange(it)
            },
            placeholder = placeholder,
            isPassword = isPassword,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(onDone = { }),
        )
    }
}