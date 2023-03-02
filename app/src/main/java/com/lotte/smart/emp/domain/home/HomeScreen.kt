package com.lotte.smart.emp.domain.home

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.lotte.smart.emp.R
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
    val icon: Int,
    val screen: @Composable () -> Unit,
) {
    object Analysis : TabRowItem("홈", R.drawable.ic_home, { AnalysisScreen() })
    object Calendar : TabRowItem("달력", R.drawable.ic_calendar, { CalendarScreen() })

    data class Chat(val navController: NavController) :
        TabRowItem("채팅", R.drawable.ic_chat, { ChatScreen(navController = navController) })

    data class Personal(val navController: NavController) :
        TabRowItem("개인", R.drawable.ic_user, { PersonalScreen(navController = navController) })
}