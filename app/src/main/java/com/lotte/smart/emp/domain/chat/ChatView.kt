package com.lotte.smart.emp.domain.chat

import android.text.Layout.Alignment
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lotte.smart.emp.base.widget.BaseBottomButton
import com.lotte.smart.emp.base.widget.BaseOutlinedTextField
import com.lotte.smart.emp.base.widget.BaseScaffold
import com.lotte.smart.emp.ui.theme.DarkBlu700
import com.lotte.smart.emp.ui.theme.DarkBlu800
import com.lotte.smart.emp.ui.theme.LightBlu100

@Composable
fun ChatView() {
    val scrollState = rememberScrollState()
    BaseScaffold(backgroundColor = DarkBlu800) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)) {
            Column(modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .weight(1F)
                .padding(horizontal = 16.dp)) {

            }
            Box(
                Modifier.imePadding()) {
                TextChat()
            }
            Spacer(modifier = Modifier.size(78.dp))
        }



    }
}

@Composable
fun BaseChatList(){

}

@Composable
fun TextChat(){
    Row() {
        BaseOutlinedTextField(modifier = Modifier.weight(1F).height(56.dp))
        Spacer(modifier = Modifier.size(6.dp))
        BaseBottomButton(modifier = Modifier.width(68.dp).height(48.dp))
    }
}