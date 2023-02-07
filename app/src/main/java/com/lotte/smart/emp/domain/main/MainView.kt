package com.lotte.smart.emp.domain.main

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.lotte.smart.emp.R
import com.lotte.smart.emp.base.BaseAppBar
import com.lotte.smart.emp.base.BaseBottomButton
import com.lotte.smart.emp.base.BaseText
import com.lotte.smart.emp.ui.theme.LightGray100

@Preview
@Composable
fun MainView(){
    Scaffold(backgroundColor = LightGray100,
    topBar = {
        BaseAppBar(title = stringResource(R.string.login_title))
    },
        content = {
            Column() {
                BaseText(text = "임시텍스트")
            }
        }
        )
}