package com.lotte.smart.emp.domain.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.lotte.smart.emp.base.widget.BaseAppBar
import com.lotte.smart.emp.base.widget.BaseScaffold


@Composable
fun HomeScreen(navController: NavController){
    BaseScaffold(
    topBar = {
        BaseAppBar(rightIconImage = Icons.Filled.MoreHoriz)
    },

        ){}
}