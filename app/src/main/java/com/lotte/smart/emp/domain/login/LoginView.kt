package com.lotte.smart.emp.domain.login


import android.graphics.Paint
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lotte.smart.emp.R
import com.lotte.smart.emp.base.*
import com.lotte.smart.emp.model.LoginModel
import com.lotte.smart.emp.ui.theme.DarkBlu500
import com.lotte.smart.emp.ui.theme.LightBlu500
import com.lotte.smart.emp.ui.theme.LightGray100
import com.lotte.smart.emp.ui.theme.Typography

@Preview
@Composable
fun LoginView() {
    val loginModel = remember { mutableStateOf(LoginModel()) }
    val isAutoChecked = remember { mutableStateOf(false) }
    /*val infinityTransition = rememberInfiniteTransition()
    val alpha by infinityTransition.animateFloat(
        initialValue = 0.0f, targetValue = 1f, animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 1000
                0.7f at 500
            },
            repeatMode = RepeatMode.Reverse
        )
    )*/
    val transition = rememberInfiniteTransition()

    val scale by transition.animateFloat(
        initialValue = 0.9f,
        targetValue = 1.1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 5000),
            repeatMode = RepeatMode.Reverse
        )
    )

    Scaffold(backgroundColor = LightGray100,
        topBar = { BaseAppBar(title = stringResource(R.string.login_title)) },
        bottomBar = {
            Box(modifier = Modifier.padding(16.dp)) {
                BaseBottomButton(text = stringResource(R.string.login_title))
            }
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_appicon_adaptive_circle),
                    contentDescription = null,
                    modifier = Modifier.scale(scale = scale)
                )
            }
            LoginTextLayout(
                title = stringResource(R.string.login_title_id),
                placeholder = stringResource(R.string.login_hint_id),
                text = loginModel.value.id,
                onChange = { loginModel.value.id = it },
                leadingIcon = Icons.Filled.Person
            )
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
        }
    }
}


@Composable
fun LoginTextLayout(
    title: String = "",
    text: String = "",
    onChange: (String) -> Unit = {},
    placeholder: String = "",
    isPassword: Boolean = false,
    leadingIcon: ImageVector = Icons.Filled.Info
) {
    val inputValue = remember { mutableStateOf(text) }
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        BaseText(
            text = title,
            style = Typography.body1
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
            leadingIcon = leadingIcon
        )
    }
}