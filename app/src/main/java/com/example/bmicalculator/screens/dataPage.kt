package com.example.bmicalculator.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmicalculator.R

@Preview(showBackground = true)
@Composable
fun Datapage() {
    Column(modifier = Modifier.fillMaxSize()) {
        var showInfo by remember { mutableStateOf(false) }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        )
        {
            Column(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            ) {

                if (showInfo) {
                    Text(
                        text = """
                        Underweight: BMI < 18.5
                        Healthy weight: BMI 18.5 - 24.9
                        Overweight: BMI 25 - 29.9
                        Obesity: BMI ≥ 30
                          • Class 1: BMI 30 - <35
                          • Class 2: BMI 35 - <40
                          • Class 3: BMI ≥ 40""".trimIndent(),
                        color = MaterialTheme.colorScheme.onSurface,
                        fontSize = 14.sp,
                        modifier = Modifier
                            .background(
                                MaterialTheme.colorScheme.surface.copy(alpha = 0.8f),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(8.dp)
                    )

                    Spacer(modifier = Modifier.height(24.dp))
                }
            }
            Box(modifier = Modifier.align(Alignment.BottomEnd)) {
                SmallFloatingActionButton(
                    onClick = { showInfo = !showInfo },
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = Color(0xffFFFBFE),

                    )
                {
                    Icon(
                        painter = painterResource(R.drawable.help),
                        contentDescription = "",
                        tint = Color(0xff121212)
                    )
                }
            }
        }
    }
}
