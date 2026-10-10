package com.vnteam.kmp_template_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tarasovvp.kmptemplate.SystemInfo
import com.vnteam.kmp_template_android.ui.theme.KMP_template_androidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KMP_template_androidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val systemInfo = SystemInfo()
                    Greeting(
                        name = systemInfo.getInfo(),
                        deviceModel = systemInfo.getDeviceModel(),
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, deviceModel: String, modifier: Modifier = Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = name)
            Text(text = "Device: $deviceModel")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KMP_template_androidTheme {
        Greeting("Android", "Preview device")
    }
}