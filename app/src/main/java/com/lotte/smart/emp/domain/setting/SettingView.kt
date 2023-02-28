package com.lotte.smart.emp.domain.setting

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.Alarm
import androidx.compose.material.icons.rounded.Logout
import androidx.compose.material.icons.rounded.PersonRemove
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.lotte.smart.emp.R
import com.lotte.smart.emp.base.theme.ClearRippleTheme
import com.lotte.smart.emp.base.widget.BaseAppBar
import com.lotte.smart.emp.base.widget.BaseScaffold
import com.lotte.smart.emp.base.widget.BaseText
import com.lotte.smart.emp.ui.theme.*

@Composable
fun SettingView(viewModel: SettingViewModel = hiltViewModel()) {

    val scrollState = rememberScrollState()

    BaseScaffold(topBar = {
        BaseAppBar(
            leftIconImage = Icons.Default.KeyboardArrowLeft,
            leftIconAction = { viewModel.onChangeHome() },
            title = stringResource(R.string.setting_title)
        )
    }) {
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .padding(horizontal = 16.dp)
        ) {
            Alarm()
            Secure()
        }
    }
}

@Composable
fun Alarm(viewModel: SettingViewModel = hiltViewModel()) {
    BaseBtnListTool(title = stringResource(id = R.string.setting_alarm_title)) {
        Column() {
            BaseListSwitchBtn(
                title = stringResource(id = R.string.setting_alarm_set),
                imageVector = Icons.Rounded.Alarm,
                isToggle = viewModel.isAlarm.value
            ) {
                viewModel.isAlarm.value = !viewModel.isAlarm.value
                viewModel.setAlarm()
            }
        }
    }
}

@Composable
fun Secure() {
    BaseBtnListTool(title = stringResource(id = R.string.setting_secure_title)) {
        Column() {
            BaseListBtn(
                title = stringResource(id = R.string.setting_secure_logout),
                imageVector = Icons.Rounded.Logout
            ) {}
            BaseListBtn(
                title = stringResource(id = R.string.setting_secure_remove_person),
                imageVector = Icons.Rounded.PersonRemove
            ) {}
        }
    }
}

@Composable
fun BaseBtnListTool(title: String, content: @Composable () -> Unit) {
    Column() {
        Spacer(modifier = Modifier.height(16.dp))
        BaseText(text = title, color = LightGray500, modifier = Modifier.height(32.dp))
        content()
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun BaseListSwitchBtn(
    title: String,
    imageVector: ImageVector,
    isToggle: Boolean,
    click: () -> Unit
) {
    CompositionLocalProvider(
        LocalRippleTheme provides ClearRippleTheme
    ) {
        Row(
            modifier = Modifier
                .height(48.dp)
                .fillMaxWidth()
        ) {
            Icon(
                modifier = Modifier
                    .size(26.dp)
                    .align(Alignment.CenterVertically),
                imageVector = imageVector,
                contentDescription = "",
                tint = LightGray600
            )
            Spacer(modifier = Modifier.width(12.dp))
            BaseText(
                text = title,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .width(300.dp),
                fontSize = 16.sp
            )
            Switch(
                checked = isToggle,
                colors = SwitchDefaults.colors(
                    checkedThumbColor = LightBlu500,
                    checkedTrackColor = LightBlu100,
                    uncheckedThumbColor = LightGray300,
                    uncheckedTrackColor = LightGray500
                ),
                onCheckedChange = { click() })
            Spacer(modifier = Modifier.width(16.dp))
        }
    }
}

@Composable
fun BaseListBtn(title: String, imageVector: ImageVector, click: () -> Unit) {
    CompositionLocalProvider(
        LocalRippleTheme provides ClearRippleTheme
    ) {
        Row(
            modifier = Modifier
                .height(48.dp)
                .fillMaxWidth()
                .clickable { click() }
        ) {
            Icon(
                modifier = Modifier
                    .size(26.dp)
                    .align(Alignment.CenterVertically),
                imageVector = imageVector,
                contentDescription = "",
                tint = LightGray600
            )
            Spacer(modifier = Modifier.width(12.dp))
            BaseText(
                text = title,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .fillMaxWidth(),
                fontSize = 16.sp
            )
        }
    }
}