package com.lotte.smart.emp.domain.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.lotte.smart.emp.R
import com.lotte.smart.emp.base.BaseModel
import com.lotte.smart.emp.base.theme.ClearRippleTheme
import com.lotte.smart.emp.base.widget.BaseScaffold
import com.lotte.smart.emp.domain.register.RegisterScreen
import com.lotte.smart.emp.ui.theme.LightBlu500
import com.lotte.smart.emp.ui.theme.LightGray400
import com.lotte.smart.emp.ui.theme.LightGray700
import kotlinx.coroutines.launch

@Preview(group = "Test")
@Composable
fun ShowHomeView() {
    HomeView()
}

@OptIn(ExperimentalPagerApi::class, ExperimentalMaterialApi::class)
@Composable
fun HomeView(items: List<TabRowItem> = emptyList(), viewModel: HomeViewModel = hiltViewModel()) {
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()
    val modalBottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)

    val initHomeIndex = viewModel.initHomeIndex.observeAsState()
    LaunchedEffect(initHomeIndex.value) {
        pagerState.scrollToPage(initHomeIndex.value ?: 0)
    }

    RegisterScreen(modalSheetState = modalBottomSheetState) {
        BaseScaffold(
            bottomBar = {
                BoxWithConstraints(
                    modifier = Modifier
                        .height(78.dp)
                        .fillMaxWidth()
                        .paint(
                            painter = painterResource(id = R.drawable.bg_home_tab),
                            contentScale = ContentScale.FillWidth
                        ),
                ) {
                    FloatingActionButton(
                        modifier = Modifier
                            .size(48.dp)
                            .align(Alignment.TopCenter),
                        onClick = {
                            coroutineScope.launch {
                                modalBottomSheetState.animateTo(
                                    ModalBottomSheetValue.Expanded
                                )
                            }
                        },
                        backgroundColor = LightBlu500,
                        contentColor = Color.White
                    ) {
                        Icon(Icons.Filled.Add, "")
                    }

                    CompositionLocalProvider(
                        LocalRippleTheme provides ClearRippleTheme
                    ) {
                        TabRow(
                            modifier = Modifier
                                .height(56.dp)
                                .fillMaxWidth()
                                .align(Alignment.BottomCenter),
                            divider = {},
                            backgroundColor = Color.Transparent,
                            selectedTabIndex = pagerState.currentPage,
                            indicator = { }) {
                            items.forEachIndexed { index, item ->
                                if (index == items.count() / 2) {
                                    Column {
                                        Spacer(Modifier.weight(1f))
                                    }
                                }

                                Tab(
                                    modifier = Modifier
                                        .height(56.dp),
                                    selected = pagerState.currentPage == index,
                                    onClick = {
                                        coroutineScope.launch {
                                            pagerState.scrollToPage(
                                                index
                                            )
                                            BaseModel.setHomeIndex(index)
                                        }
                                    },
                                    icon = {
                                        Icon(
                                            imageVector = item.icon,
                                            contentDescription = "",
                                            modifier = Modifier.size(26.dp)
                                        )
                                    },
                                    selectedContentColor = LightGray700,
                                    unselectedContentColor = LightGray400
                                )
                            }
                        }
                    }
                }
            }
        ) {
            Box() {
                HorizontalPager(
                    count = items.size,
                    state = pagerState,
                ) {
                    items[pagerState.currentPage].screen()
                    BaseModel.setHomeIndex(pagerState.currentPage)
                }
            }
        }
    }
}

