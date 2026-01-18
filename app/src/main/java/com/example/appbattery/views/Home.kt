package com.example.appbattery.views

import android.content.Context
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appbattery.datasource.Battery
import com.example.appbattery.ui.theme.DarkGray
import com.example.appbattery.ui.theme.LimeGreen
import com.example.appbattery.ui.theme.Red
import com.example.appbattery.ui.theme.White
import com.example.appbattery.ui.theme.Yellow
import kotlinx.coroutines.delay


@Composable
fun Home(context: Context) {

    val battery = Battery()
    val batteryStatus = remember { mutableStateOf(battery.getBatteryInfo(context)) }
    val batteryLevel =batteryStatus.value.batteryLevel.coerceIn(0,100)
    val animatedLevel = animateFloatAsState(targetValue = batteryLevel / 100f)


    val batteryColor = when(batteryStatus.value.batteryLevel) {
        in 0..15 -> Red

        in 16..20 -> Yellow

        else -> LimeGreen

    }

    
    val loadingMessage = when(batteryStatus.value.batteryLevel) {
        in 0..15 -> "Put it on charge!"
        100 -> "Fully charged!"
        else -> ""

    }


    LaunchedEffect(key1 =Unit) {
        while (true){
            batteryStatus.value =battery.getBatteryInfo(context)
            delay(timeMillis = 1000)

        }
    }

    Column(
        modifier = Modifier.fillMaxSize().background(DarkGray),
        verticalArrangement =Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Battery: ${batteryStatus.value.batteryLevel}100%",
            style = MaterialTheme.typography.headlineLarge,
            color = White,
            modifier = Modifier.padding(bottom =16.dp )

        )
        Box (
            modifier = Modifier.padding(16.dp)
                .width(150.dp).height(350.dp)
                .background(
                    color = Color.Gray.copy(alpha = 0.2f),
                    shape = RoundedCornerShape(20.dp)


                )
                .clip(RoundedCornerShape(20.dp))
            ,
            contentAlignment = Alignment.BottomEnd
        ){

            Box(
                modifier = Modifier.fillMaxWidth()
                    .height(350. dp * animatedLevel.value)
                    .background(LimeGreen)
            )
        }
        Text(
            text= loadingMessage,
            color = White,
            fontSize = 18.sp
        )
    }

}

@Preview
@Composable
private fun HomePreview(){
    val context = LocalContext.current
    Home(context =context)
}