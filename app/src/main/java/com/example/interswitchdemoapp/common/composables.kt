package com.example.interswitchdemoapp.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    title: String,
    enabled: Boolean = true,
    color: Color = Color.Blue,
    roundedCornerShape: () -> RoundedCornerShape = { RoundedCornerShape(10.dp) },
    onClick: () -> Unit
) {

    Button(onClick = onClick,
        enabled = enabled,
        shape = roundedCornerShape.invoke(),
        colors = ButtonDefaults.buttonColors(
            disabledBackgroundColor = Color.LightGray,
            disabledContentColor = Color.White,
            backgroundColor = color,
            contentColor = Color.White
        ),
        modifier = modifier
            .size(50.dp),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 6.dp,
            pressedElevation = 1.dp,
            disabledElevation = 0.dp
        ),
        content = {
            Text(text = title, fontWeight = FontWeight.Bold, fontSize = 18.sp)
        })
}