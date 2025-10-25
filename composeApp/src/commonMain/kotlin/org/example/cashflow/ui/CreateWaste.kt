package org.example.cashflow.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Brush
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview


@Preview(showBackground = true)
@Composable
fun CreateWaste(){
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(0.6f),
            elevation = CardDefaults.cardElevation(4.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFF93737)
            )
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(3.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    IconButton(onClick = {}){
                        Icon(Icons.Default.Close,
                            contentDescription = "close")
                    }
                    IconButton(onClick = {}){
                        Icon(Icons.Default.Done,
                            contentDescription = "close")
                    }
                }
            }
            SingleChoiceSegmentedButton(
                manually = {},
                getPhoto = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(3.dp)
            )
        }
    }
}
@Composable
fun SingleChoiceSegmentedButton(
    modifier: Modifier = Modifier.fillMaxWidth(),
    manually: @Composable () -> Unit,
    getPhoto: @Composable () -> Unit,
) {
    val selectedIndex = remember {
        mutableIntStateOf(0)
    }
    val options = listOf(Icons.Default.Brush, Icons.Default.Camera) // Defines button icons
    Column {
        SingleChoiceSegmentedButtonRow(modifier) {
            options.forEachIndexed { index, icon ->
                SegmentedButton(
                    shape = SegmentedButtonDefaults.itemShape(
                        index = index,
                        count = options.size
                    ), // *Required: Sets button shape based on position
                    onClick = {
                        selectedIndex.intValue = index
                    },
                    selected = index == selectedIndex.intValue,
                    label = { Icon(icon,
                        contentDescription = null) },
                    colors = SegmentedButtonDefaults.colors(
                        activeContainerColor = Color(0xFF9F2222),
                        inactiveContainerColor = Color(0xFFA4A4A4),
                        activeContentColor = Color(0xFFF5F0FF),
                        inactiveContentColor = Color.White
                    )
                )
            }
        }
        AnimatedVisibility(
            visible = selectedIndex.intValue == 0,
            enter = scaleIn(),
            exit = scaleOut(),
        ){
            manually()
        }
        AnimatedVisibility(
            visible = selectedIndex.intValue != 0,
            enter = scaleIn(),
            exit = scaleOut(),
        ){
            getPhoto()
        }

    }
}