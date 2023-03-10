package com.lotte.smart.emp.domain.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.rounded.HorizontalRule
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.lotte.smart.emp.R
import com.lotte.smart.emp.base.widget.BaseAppBar
import com.lotte.smart.emp.base.widget.BaseScaffold
import com.lotte.smart.emp.ui.theme.LightGray500
import com.lotte.smart.emp.ui.theme.LightGray700
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RegisterView(modalSheetState: ModalBottomSheetState) {

    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(36.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier.size(56.dp),
                imageVector = Icons.Rounded.HorizontalRule,
                contentDescription = "",
                tint = LightGray500
            )
        }
        BaseScaffold(
            backgroundColor = Color.White,
            topBar = {
                BaseAppBar(
                    title = stringResource(R.string.register_title),
                    backgroundColor = Color.White
                )
            },
            bottomBar = {
                Box(
                    modifier = Modifier
                        .height(78.dp)
                        .fillMaxWidth()
                ) {
                    FloatingActionButton(
                        modifier = Modifier
                            .size(48.dp)
                            .align(Alignment.TopCenter),
                        onClick = { coroutineScope.launch { modalSheetState.hide() } },
                        backgroundColor = LightGray700,
                        contentColor = Color.White
                    ) {
                        Icon(Icons.Default.Close, "")
                    }
                }
            }
        ) {

        }
    }
}