package com.lotte.smart.emp.domain.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.lotte.smart.emp.base.widget.BaseAppBar
import com.lotte.smart.emp.base.widget.BaseScaffold

@Preview(group = "Test")
@Composable
fun ShowHomeView() {
    HomeView()
}

@Composable
fun HomeView() {
    val bottomNavController = rememberNavController()
    BaseScaffold(
        topBar = {
            BaseAppBar(rightIconImage = Icons.Filled.MoreHoriz)
        },
        bottomBar = {
            HomeBottomNavigation(bottomNavController)
        }
    ) {
        Box(Modifier.padding(it)) {
            HomeBottomNavigationGraph(bottomNavController)
        }
    }
}