package com.example.bmicalculator.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmicalculator.R

@Preview(showBackground = true)
@Composable
fun LanderPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column {
            Text(
                "Get your BMI",
                fontSize = 30.sp,
                fontFamily = FontFamily(Font(R.font.playwritemoderna, FontWeight.ExtraBold)),
                color = MaterialTheme.colorScheme.onBackground
            )

        }

        Spacer(modifier = Modifier.padding(20.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.landingpageimg),
                contentDescription = "",
                Modifier.fillMaxSize()
            )
        }

        Spacer(Modifier.padding(40.dp))

        Text(
            "Get started with tracking your health with a BMI Calculator",
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.playwritemoderna, FontWeight.ExtraBold)),
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.width(220.dp)
        )


        Box(modifier = Modifier.padding(top = 20.dp)) {
            OutlinedButton(
                onClick = { "" },
                colors = ButtonColors(
                    contentColor = MaterialTheme.colorScheme.background,
                    containerColor = MaterialTheme.colorScheme.primary,
                    disabledContainerColor = MaterialTheme.colorScheme.surface,
                    disabledContentColor = MaterialTheme.colorScheme.onSurface
                ),
                modifier = Modifier.size(150.dp, 50.dp)
            ) {
                Text("Get Started")
                Spacer(modifier = Modifier.padding(8.dp))
                Icon(
                    painter = painterResource(R.drawable.baseline_keyboard_arrow_right_24),
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.background
                )
            }
        }
    }
}