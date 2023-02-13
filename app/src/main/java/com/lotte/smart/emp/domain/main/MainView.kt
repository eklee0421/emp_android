package com.lotte.smart.emp.domain.main

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.lotte.smart.emp.R
import com.lotte.smart.emp.base.widget.BaseAppBar
import com.lotte.smart.emp.base.widget.BaseBottomButton
import com.lotte.smart.emp.base.widget.BaseScaffold
import com.lotte.smart.emp.base.widget.BaseText
import com.lotte.smart.emp.ui.theme.LightGray100

@Preview
@Composable
fun MainView(){
    BaseScaffold(
    topBar = {
        BaseAppBar(rightIconImage = Icons.Filled.MoreHoriz)
    },

        ){}
}