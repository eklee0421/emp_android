package com.lotte.smart.emp.domain.personal

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.lotte.smart.emp.base.widget.BaseAppBar
import com.lotte.smart.emp.base.widget.BaseScaffold
import com.lotte.smart.emp.ui.theme.LightGray200

@Composable
fun PersonalView(viewModel: PersonalViewModel = hiltViewModel()) {
    BaseScaffold(
        backgroundColor = LightGray200,
        topBar = {
            BaseAppBar(rightIconImage = Icons.Outlined.Settings, rightIconAction = {
                viewModel.onChangeSetting()
            }, backgroundColor = LightGray200)
        }
    ) {
        Column() {

        }
    }
}