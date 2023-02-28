package com.lotte.smart.emp.domain.setting

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.lotte.smart.emp.R
import com.lotte.smart.emp.base.widget.BaseAppBar
import com.lotte.smart.emp.base.widget.BaseScaffold

@Composable
fun SettingView(viewModel: SettingViewModel = hiltViewModel()) {
    BaseScaffold(topBar = {
        BaseAppBar(
            leftIconImage = Icons.Default.KeyboardArrowLeft,
            leftIconAction = { viewModel.onChangeHome() },
            title = stringResource(R.string.setting_title)
        )
    }) {

    }
}