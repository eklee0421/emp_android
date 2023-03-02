package com.lotte.smart.emp.domain.analysis

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.lotte.smart.emp.R
import com.lotte.smart.emp.base.widget.BaseAppBar
import com.lotte.smart.emp.base.widget.BaseScaffold
import com.lotte.smart.emp.base.widget.BaseText

@Composable
fun AnalysisScreen() {
    BaseScaffold(topBar = {
        BaseAppBar(rightIconImage = R.drawable.ic_notification)
    }) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray)
        ) {
            BaseText(text = "전체")
        }
    }

}