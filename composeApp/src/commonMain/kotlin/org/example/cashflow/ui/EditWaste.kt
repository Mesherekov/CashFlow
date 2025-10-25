package org.example.cashflow.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cashflow.composeapp.generated.resources.Res
import cashflow.composeapp.generated.resources.enter_amount
import cashflow.composeapp.generated.resources.enter_position
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun EditWaste(){
    Column {
        LazyColumn {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun SingleEditWaste(){
    Row(modifier = Modifier
        .fillMaxWidth()) {
        var inputPosition by remember { mutableStateOf("") }
        var inputWaste by remember { mutableStateOf("") }
        TextField(
            modifier = Modifier
                .weight(1f)
                .padding(4.dp),
            value = inputPosition,
            onValueChange = { inputPosition = it },
            label = { Text(stringResource(Res.string.enter_position)) },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = ColorsUI.dark_green,
                unfocusedContainerColor = ColorsUI.dark_green,
                unfocusedTextColor = Color.White,
                focusedTextColor = Color.White,
                disabledTextColor = Color.White,
                focusedLabelColor = Color.White,
                disabledLabelColor = Color.White,
                unfocusedLabelColor = Color.White
            ))
        TextField(
            modifier = Modifier
                .weight(1f)
                .padding(4.dp),
            value = inputWaste,
            onValueChange = { inputWaste = it },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = ColorsUI.dark_green,
                unfocusedContainerColor = ColorsUI.dark_green,
                unfocusedTextColor = Color.White,
                focusedTextColor = Color.White,
                disabledTextColor = Color.White,
                focusedLabelColor = Color.White,
                disabledLabelColor = Color.White,
                unfocusedLabelColor = Color.White
            ),
            label = { Text(stringResource(Res.string.enter_amount)) })
    }
}