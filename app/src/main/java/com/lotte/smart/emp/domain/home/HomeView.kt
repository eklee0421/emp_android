package com.lotte.smart.emp.domain.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.lotte.smart.emp.base.widget.BaseAppBar
import com.lotte.smart.emp.base.widget.BaseScaffold
import com.lotte.smart.emp.domain.analysis.AnalysisScreen
import com.lotte.smart.emp.domain.calendar.CalendarScreen
import com.lotte.smart.emp.ui.theme.LightBlu500
import com.lotte.smart.emp.ui.theme.LightGray400
import kotlinx.coroutines.launch

@Preview(group = "Test")
@Composable
fun ShowHomeView() {
    HomeView()
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeView() {
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    val items = listOf(
        TabRowItem.Analysis,
        TabRowItem.Calendar,
        /*TabRowItem.Reorder,
        TabRowItem.Settings*/
    )

    BaseScaffold(
        topBar = {
            BaseAppBar(rightIconImage = Icons.Filled.MoreHoriz)
        },
        bottomBar = {
            BoxWithConstraints(
                modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth(),
            ) {
                /*Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(id = R.drawable.bg_home_tab),
                    contentDescription = ""
                )*/
                TabRow(
                    divider = {},
                    backgroundColor = Color.Transparent,
                    selectedTabIndex = pagerState.currentPage,
                    indicator = { }) {
                    items.forEachIndexed { index, item ->
                        /*if (index == items.count() / 2) {
                        Spacer(Modifier.weight(1f))
                    }*/
                        Tab(
                            modifier = Modifier.height(56.dp),
                            selected = pagerState.currentPage == index,
                            onClick = { coroutineScope.launch { pagerState.scrollToPage(index) } },
                            icon = {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = "",
                                    modifier = Modifier.size(26.dp)
                                )
                            },
                            /*text = {
                                BaseText(text = item.title)
                            },*/
                            selectedContentColor = LightBlu500,
                            unselectedContentColor = LightGray400
                        )
                    }
                }
            }
        }
    ) {
        Box(Modifier.padding(it)) {
            HorizontalPager(
                count = items.size,
                state = pagerState,
            ) {
                items[pagerState.currentPage].screen()
            }
        }
    }
}

sealed class TabRowItem(
    val title: String,
    val icon: ImageVector,
    val screen: @Composable () -> Unit
) {
    object Analysis : TabRowItem("홈", Icons.Filled.Home, { AnalysisScreen() })
    object Calendar : TabRowItem("달력", Icons.Filled.CalendarToday, { CalendarScreen() })
    /*object Reorder : TabRowItem("목록", Icons.Filled.Reorder, { CalendarScreen() })
    object Settings : TabRowItem("설정", Icons.Filled.Settings, { AnalysisScreen() })*/
}