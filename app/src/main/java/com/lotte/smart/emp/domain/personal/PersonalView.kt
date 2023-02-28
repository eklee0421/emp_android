package com.lotte.smart.emp.domain.personal

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.lotte.smart.emp.base.widget.BaseAppBar
import com.lotte.smart.emp.base.widget.BaseScaffold
import com.lotte.smart.emp.ui.theme.LightGray200

@Composable
fun PersonalView(viewModel: PersonalViewModel = hiltViewModel()) {
    val scrollState = rememberScrollState()
    BaseScaffold(
        backgroundColor = LightGray200,
        topBar = {
            BaseAppBar(rightIconImage = Icons.Outlined.Settings, rightIconAction = {
                viewModel.onChangeSetting()
            }, backgroundColor = LightGray200)
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            PersonalInfo({})
        }
    }
}


@Composable
fun PersonalInfo(onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .clickable { onClick() },
        backgroundColor = Color.White,
        elevation = 26.dp
    ) {

    }
}