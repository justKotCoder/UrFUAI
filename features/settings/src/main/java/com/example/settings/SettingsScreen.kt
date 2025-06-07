// SettingsScreen.kt
package com.example.settings

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.settings.notification.FullScreenNotificationDialog

@Composable
fun SettingsScreen(onBackClick: () -> Boolean) {
    var showNotificationDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F6F7)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var fio by remember { mutableStateOf("") }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(30.dp))

            TextField(
                value = fio,
                onValueChange = { newText -> fio = newText },
                modifier = Modifier
                    .width(358.dp)
                    .height(48.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedLabelColor = Color.Transparent,
                    unfocusedLabelColor = Color.Gray
                ),
                label = { Text("ФИО") },
                singleLine = true
            )

            Spacer(modifier = Modifier.height(30.dp))

            var riNumber by remember { mutableStateOf("") }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .width(358.dp)
                    .height(48.dp)
                    .background(Color.White, RoundedCornerShape(4.dp))
            ) {
                Text(
                    text = "РИ-",
                    color = Color.Gray,
                    modifier = Modifier.padding(start = 16.dp)
                )
                BasicTextField(
                    value = riNumber,
                    onValueChange = { newText ->
                        // Фильтруем ввод (только цифры)
                        if (newText.all { it.isDigit() }) {
                            riNumber = newText
                        }
                    },
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 8.dp),
                    singleLine = true,
                    decorationBox = { innerTextField ->
                        if (riNumber.isEmpty()) {
                            Text(
                                text = "230950",  // Плейсхолдер (необязательно)
                                color = Color.LightGray
                            )
                        }
                        innerTextField()
                    }
                )
            }
            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
            ) {
            Button(
                onClick = { /* Действие при нажатии */ },
                modifier = Modifier
                    .width(120.dp)
                    .height(30.dp)
                    .padding(start = 20.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFF97537)
                ),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    text = "ОТПРАВИТЬ",
                    color = Color.White,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            }


            Spacer(modifier = Modifier.height(30.dp))}
            Button(
                onClick = { showNotificationDialog = true },
                modifier = Modifier
                    .width(358.dp)
                    .height(44.dp),
                border = BorderStroke(1.dp, Color(0xFFEF4836)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Icon(
                        painterResource(R.drawable.notification_icon),
                        contentDescription = "",
                        tint = Color(0xFFEF4836)
                    )
                    Text(
                        text = "Уведомления",
                        color = Color(0xFF484C52)
                    )
                    Icon(
                        painterResource(R.drawable.arrow_icon),
                        contentDescription = "",
                        tint = Color(0xFF484C52)
                    )
                }
            }

            Spacer(modifier = Modifier.height(30.dp))
            Button(
                onClick = { showNotificationDialog = true },
                modifier = Modifier
                    .width(358.dp)
                    .height(44.dp),
                border = BorderStroke(1.dp, Color(0xFF484C52)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Icon(
                        painterResource(R.drawable.reverce_ic),
                        contentDescription = "",
                        tint = Color(0xFF484C52)
                    )
                    Text(
                        text = "     Тема    ", //да, колхоз
                        color = Color(0xFF484C52),
                    )
                    Icon(
                        painterResource(R.drawable.arrow_icon),
                        contentDescription = "",
                        tint = Color(0xFF484C52)
                    )
                }
            }




            Spacer(modifier = Modifier.height(30.dp))
            Button(
                onClick = { showNotificationDialog = true },
                modifier = Modifier
                    .width(358.dp)
                    .height(44.dp),
                border = BorderStroke(1.dp, Color(0xFF0ACEB0)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Icon(
                        painterResource(R.drawable.dialog_ic),
                        contentDescription = "",
                        tint = Color(0xFF0ACEB0)
                    )
                    Text(
                        text = "О приложении",
                        color = Color(0xFF484C52)
                    )
                    Icon(
                        painterResource(R.drawable.arrow_icon),
                        contentDescription = "",
                        tint = Color(0xFF484C52)
                    )
                }
            }

        }

    if (showNotificationDialog) {
        FullScreenNotificationDialog(
            onDismiss = { showNotificationDialog = false }
        )
    }
}


@Preview
@Composable
fun SettingsScreenPreview() {
    SettingsScreen( onBackClick = {  true })
}