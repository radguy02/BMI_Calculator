package com.example.bmicalculator.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bmicalculator.R
import com.yourapp.viewmodel.SharedViewModel

@OptIn(ExperimentalComposeUiApi::class, ExperimentalFoundationApi::class)
@Composable
fun Datapage(navController: NavController, viewModel: SharedViewModel) {
    var showInfo by remember { mutableStateOf(false) }
    var sliderProgressValue by rememberSaveable { mutableIntStateOf(120) }
    var weightint by rememberSaveable { mutableIntStateOf(0) }
    var ageint by rememberSaveable { mutableIntStateOf(0) }

    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(paddingValues)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
                    .padding(horizontal = 8.dp)
            ) {
                Row(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(.7f),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        "Enter your details",
                        fontFamily = FontFamily(Font(R.font.lilitaoneregular)),
                        fontSize = 30.sp,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(7.5f),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(.40f)
                            .background(
                                MaterialTheme.colorScheme.surface, shape = RoundedCornerShape(12.dp)
                            )
                            .border(2.dp, Color(0xFF002D67), RoundedCornerShape(12.dp))
                    ) {
                        Column {
                            Column(
                                modifier = Modifier
                                    .fillMaxHeight(.1f)
                                    .fillMaxWidth()
                                    .padding(8.dp)


                            ) {
                                Text(
                                    "Height",
                                    fontFamily = FontFamily(Font(R.font.lilitaoneregular)),
                                    fontSize = 24.sp,
                                    color = MaterialTheme.colorScheme.onBackground,
                                    modifier = Modifier.align(Alignment.CenterHorizontally)
                                )
                            }
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight()
                                    .padding(8.dp)
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .fillMaxWidth(),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = "$sliderProgressValue",
                                        textAlign = TextAlign.Center,
                                        fontFamily = FontFamily(
                                            Font(
                                                R.font.lilitaoneregular,
                                                FontWeight.Bold
                                            )
                                        ),
                                        fontSize = 32.sp,
                                        modifier = Modifier.fillMaxWidth()
                                    )

                                    Spacer(modifier = Modifier.padding(10.dp))

                                    Card(
                                        modifier = Modifier
                                            .wrapContentSize(),
                                        shape = RoundedCornerShape(30.dp)

                                    ) {
                                        ComposeVerticalSlider(progressValue = sliderProgressValue) {
                                            sliderProgressValue = it
                                        }
                                    }
                                }
                            }
                        }
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(.60f)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f)
                                .background(
                                    MaterialTheme.colorScheme.surface,
                                    shape = RoundedCornerShape(12.dp)
                                )
                                .border(2.dp, Color(0xFF002D67), RoundedCornerShape(12.dp))
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                            ) {
                                Text(
                                    "Age",
                                    fontFamily = FontFamily(Font(R.font.lilitaoneregular)),
                                    fontSize = 24.sp,
                                    color = MaterialTheme.colorScheme.onBackground,
                                    modifier = Modifier.align(Alignment.CenterHorizontally)
                                )
                                Spacer(modifier = Modifier.fillMaxHeight(.2f))
                                Text(
                                    "$ageint",
                                    textAlign = TextAlign.Center,
                                    fontFamily = FontFamily(
                                        Font(
                                            R.font.lilitaoneregular,
                                            FontWeight.Bold
                                        )
                                    ),
                                    fontSize = 42.sp,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .fillMaxHeight(.5f)
                                )
                                Row(
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceEvenly
                                ) {
                                    Box {
                                        Button(
                                            onClick = { ageint += 1 },
                                            shape = CircleShape,
                                            modifier = Modifier
                                                .size(45.dp)
                                                .combinedClickable(
                                                    onClick = { ageint += 1 },
                                                    onLongClick = { ageint += 5 })
                                        ) {
                                        }
                                        Icon(
                                            imageVector = Icons.Default.Add,
                                            contentDescription = "",
                                            modifier = Modifier.size(45.dp)
                                        )
                                    }
                                    Box {
                                        Button(
                                            onClick = {
                                                if (ageint > 0) {
                                                    ageint -= 1
                                                }
                                            },
                                            shape = CircleShape,
                                            modifier = Modifier
                                                .size(45.dp)
                                                .combinedClickable(onClick = {
                                                    if (ageint > 0) {
                                                        ageint -= 1
                                                    }
                                                }, onLongClick = {
                                                    if (ageint >= 5) {
                                                        ageint -= 5
                                                    } else {
                                                        ageint = 0
                                                    }
                                                })
                                        ) {

                                        }
                                        Icon(
                                            painter = painterResource(R.drawable.sub),
                                            contentDescription = "",
                                            modifier = Modifier.size(45.dp)
                                        )
                                    }
                                }
                            }
                        }

                        Spacer(Modifier.size(8.dp))
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f)
                                .background(
                                    MaterialTheme.colorScheme.surface,
                                    shape = RoundedCornerShape(12.dp)
                                )
                                .border(2.dp, Color(0xFF002D67), RoundedCornerShape(12.dp))
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                            ) {
                                Text(
                                    "Weight",
                                    fontFamily = FontFamily(Font(R.font.lilitaoneregular)),
                                    fontSize = 24.sp,
                                    color = MaterialTheme.colorScheme.onBackground,
                                    modifier = Modifier
                                        .align(Alignment.CenterHorizontally)
                                        .fillMaxHeight(.1f)
                                )

                                Spacer(modifier = Modifier.fillMaxHeight(.2f))

                                Text(
                                    "$weightint",
                                    textAlign = TextAlign.Center,
                                    fontFamily = FontFamily(
                                        Font(
                                            R.font.lilitaoneregular,
                                            FontWeight.Bold
                                        )
                                    ),
                                    fontSize = 42.sp,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .fillMaxHeight(.5f)
                                )
                                Row(
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceEvenly
                                ) {
                                    Box {
                                        Button(
                                            onClick = { weightint += 1 },
                                            shape = CircleShape,
                                            modifier = Modifier
                                                .size(45.dp)
                                                .combinedClickable(
                                                    onClick = { weightint += 1 },
                                                    onLongClick = { weightint += 10 })
                                        ) {
                                        }
                                        Icon(
                                            imageVector = Icons.Default.Add,
                                            contentDescription = "",
                                            modifier = Modifier.size(45.dp)
                                        )
                                    }
                                    Box {
                                        Button(
                                            onClick = {
                                                if (weightint > 0) {
                                                    weightint -= 1
                                                }
                                            },
                                            shape = CircleShape,
                                            modifier = Modifier
                                                .size(45.dp)
                                                .combinedClickable(onClick = {
                                                    if (weightint > 0) {
                                                        weightint -= 1
                                                    }
                                                }, onLongClick = {
                                                    if (weightint >= 10) {
                                                        weightint -= 10
                                                    } else {
                                                        weightint = 0
                                                    }
                                                })
                                        ) {

                                        }
                                        Icon(
                                            painter = painterResource(R.drawable.sub),
                                            contentDescription = "",
                                            modifier = Modifier.size(45.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1.5f),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    ElevatedButton(onClick = {
                        viewModel.calculateValue(
                            weight = weightint,
                            height = sliderProgressValue
                        )
                        navController.navigate("screen3")
                    }) {
                        Text(
                            "Calculate",
                            fontFamily = FontFamily(Font(R.font.lilitaoneregular)),
                            fontSize = 24.sp,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                }
            }


            Box(
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

            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .background(Color.Transparent)
                    .size(32.dp)
            ) {
                SmallFloatingActionButton(
                    onClick = { showInfo = !showInfo },
                    containerColor = MaterialTheme.colorScheme.surface
                ) {
                    Icon(
                        painter = painterResource(R.drawable.help),
                        contentDescription = "Help",
                        tint = MaterialTheme.colorScheme.onPrimary

                    )
                }
            }
        }
    }
}

@ExperimentalComposeUiApi
@Composable
fun ComposeVerticalSlider(
    progressValue: Int? = null,
    value: (Int) -> Unit
) {
    val state = rememberComposeVerticalSlider()
    VerticalSlider(
        state = state,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(.6f),
        trackColor = MaterialTheme.colorScheme.secondary,
        progressTrackColor = MaterialTheme.colorScheme.onSecondary,
        onProgressChanged = {
            value(it)
        },
        onStopTrackingTouch = {
            value(it)
        },
        enabled = state.isEnabled.value,
        progressValue = progressValue
    )
}

