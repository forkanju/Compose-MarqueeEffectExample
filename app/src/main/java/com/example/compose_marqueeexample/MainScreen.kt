package com.example.compose_marqueeexample

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.MarqueeAnimationMode
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@ExperimentalFoundationApi
@Composable
fun MainScreen() {

    val focusRequester = remember {
        FocusRequester()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .background(Color.Red)
                .padding(vertical = 10.dp)
                .basicMarquee(
                    iterations = Int.MAX_VALUE,
                    delayMillis = 0,
                    initialDelayMillis = 0,
                    velocity = 100.dp
                ),
            color = Color.White,
            text = "Breaking News !!! -> Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,"
        )

        Spacer(modifier = Modifier.height(15.dp))

        Row(
            modifier = Modifier
                .basicMarquee(
                    animationMode = MarqueeAnimationMode.WhileFocused,
                    velocity = 100.dp
                )
                .focusRequester(focusRequester = focusRequester)
                .focusable()
        ) {
            repeat(20) {
                Image(
                    modifier = Modifier.size(40.dp),
                    painter = painterResource(id = R.drawable.train),
                    contentDescription = "Train"
                )
            }
        }
        Spacer(modifier = Modifier.height(5.dp))
        Button(onClick = { focusRequester.requestFocus() }) {
            Text(text = "Woo-hoo!")
        }
    }
}