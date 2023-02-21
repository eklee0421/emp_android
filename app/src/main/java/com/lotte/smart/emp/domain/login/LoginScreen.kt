package com.lotte.smart.emp.domain.login


import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.lotte.smart.emp.R
import com.lotte.smart.emp.base.widget.*
import com.lotte.smart.emp.model.LoginModel
import com.lotte.smart.emp.ui.theme.Typography

@Composable
fun LoginScreen(navController: NavController, viewModel: LoginViewModel = viewModel()) {

    val transition = rememberInfiniteTransition()
    val scale by transition.animateFloat(
        initialValue = 0.9f,
        targetValue = 1.0f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 3500),
            repeatMode = RepeatMode.Reverse
        )
    )

    BaseScaffold(
        topBar = { BaseAppBar(title = stringResource(R.string.login_title)) },
        bottomBar = {
            Box(modifier = Modifier.padding(16.dp)) {
                BaseBottomButton(text = stringResource(R.string.login_title),
                    onClick = { viewModel.procLogin(navController) })
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
                text = viewModel.loginModel.value.id,
                onChange = {
                    viewModel.loginModel.value =
                        LoginModel(id = it, password = viewModel.loginModel.value.password)
                },
                leadingIcon = Icons.Filled.Person
            )
            LoginTextLayout(
                title = stringResource(R.string.login_title_pw),
                placeholder = stringResource(R.string.login_hint_pw),
                text = viewModel.loginModel.value.password,
                onChange = {
                    viewModel.loginModel.value =
                        LoginModel(id = viewModel.loginModel.value.id, password = it)
                },
                isPassword = true,
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done)
            )
            BaseCheckBox(
                text = stringResource(R.string.login_auto_check),
                checked = viewModel.isAutoChecked.value,
                onCheckedChange = { viewModel.isAutoChecked.value = it })
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
    leadingIcon: ImageVector = Icons.Filled.Info,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next)
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
            leadingIcon = leadingIcon,
            keyboardOptions = keyboardOptions
        )
    }
}