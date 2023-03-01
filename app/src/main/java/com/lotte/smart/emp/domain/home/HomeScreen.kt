package com.lotte.smart.emp.domain.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Reorder
import androidx.compose.material.icons.rounded.Chat
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.lotte.smart.emp.domain.analysis.AnalysisScreen
import com.lotte.smart.emp.domain.calendar.CalendarScreen
import com.lotte.smart.emp.domain.chat.ChatScreen
import com.lotte.smart.emp.domain.personal.PersonalScreen


@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel = hiltViewModel()) {
    
    val items = listOf(
        TabRowItem.Analysis,
        TabRowItem.Calendar,
        TabRowItem.Chat(navController),
        TabRowItem.Personal(navController)
    )

    HomeView(items)

}

sealed class TabRowItem(
    val title: String,
    val icon: ImageVector,
    val screen: @Composable () -> Unit,
) {
    object Analysis : TabRowItem("홈", Icons.Filled.Home, { AnalysisScreen() })
    object Calendar : TabRowItem("달력", Icons.Filled.CalendarToday, { CalendarScreen() })

    data class Chat(val navController: NavController) :
        TabRowItem("채팅", Icons.Rounded.Chat, { ChatScreen(navController = navController) })

    data class Personal(val navController: NavController) :
        TabRowItem("개인", Icons.Filled.Person, { PersonalScreen(navController = navController) })
}