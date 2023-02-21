package com.lotte.smart.emp.domain.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.lotte.smart.emp.base.widget.BaseText
import com.lotte.smart.emp.domain.analysis.AnalysisScreen
import com.lotte.smart.emp.domain.calendar.CalendarScreen
import com.lotte.smart.emp.ui.theme.LightBlu500
import com.lotte.smart.emp.ui.theme.LightGray400

@Composable
fun HomeBottomNavigation(
    navController: NavHostController,
) {
    val items = listOf(
        BottomNavItem.Analysis,
        BottomNavItem.Calendar,
        /*BottomNavItem.Timeline,
        BottomNavItem.Settings*/
    )

    BottomNavigation() {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEachIndexed { index, item ->
            if (index == items.count() / 2) {
                Spacer(Modifier.weight(1f))
            }
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = "",
                        modifier = Modifier.size(22.dp)
                    )
                },
                enabled = true,
                selectedContentColor = LightBlu500,
                unselectedContentColor = LightGray400,
                selected = currentRoute == item.screenRoute,
                alwaysShowLabel = false,
                label = { BaseText(text = item.screenRoute) },
                onClick = {
                    navController.navigate(item.screenRoute) {
                        navController.graph.startDestinationRoute?.let {
                            popUpTo(it) { saveState = true }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

sealed class BottomNavItem(
    val icon: ImageVector, val screenRoute: String
) {
    object Analysis : BottomNavItem(Icons.Filled.Home, "analysis_screen")
    object Calendar : BottomNavItem(Icons.Filled.CalendarToday, "calendar_screen")
    /*object Timeline : BottomNavItem(Icons.Filled.Timeline, "TIMELINE")
    object Settings : BottomNavItem(Icons.Filled.Settings, "SETTINGS")*/
}

@Composable
fun HomeBottomNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Analysis.screenRoute
    ) {
        composable(BottomNavItem.Analysis.screenRoute) {
            AnalysisScreen()
        }
        composable(BottomNavItem.Calendar.screenRoute) {
            CalendarScreen()
        }
        /*composable(BottomNavItem.Timeline.screenRoute) {
            AnalysisScreen()
        }
        composable(BottomNavItem.Settings.screenRoute) {
            AnalysisScreen()
        }*/
    }
}