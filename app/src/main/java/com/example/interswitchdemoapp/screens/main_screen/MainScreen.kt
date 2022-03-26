package com.example.interswitchdemoapp.screens.main_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.interswitchdemoapp.R
import com.example.interswitchdemoapp.common.CustomButton

@Composable
fun MainScreen(navController: NavController) {
    LazyColumn(modifier = Modifier.fillMaxSize(), userScrollEnabled = true) {

        item {
            Card(modifier = Modifier.fillMaxWidth(), elevation = 4.dp) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp, 20.dp)
                ) {

                    Text(
                        modifier = Modifier.padding(13.dp),
                        text = stringResource(R.string.home),
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        color = MaterialTheme.colors.primary
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    TextField(
                        value = "",
                        onValueChange = { },
                        modifier = Modifier
                            .fillMaxWidth(),
                        label = { Text("Enter fee id") },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Number
                        )
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    CustomButton(
                        modifier = Modifier.fillMaxWidth(),
                        title = stringResource(R.string.search)
                    ) {

                    }

                }
            }
        }

        item {

        }
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen(navController = rememberNavController())
}