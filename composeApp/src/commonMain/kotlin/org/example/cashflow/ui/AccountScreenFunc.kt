package org.example.cashflow.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import org.example.cashflow.navigation.AccountScreenComponent

@Composable
fun AccountScreen(
    component: AccountScreenComponent,
    modifier: Modifier = Modifier
                  ){
    Column {
        Row(modifier = modifier.padding(4.dp),
            verticalAlignment = Alignment.CenterVertically) {
          AsyncImage(
              "https://cdn.mos.cms.futurecdn.net/jsY6AGjmCHSfCnbCCafsvF.jpg",
              contentDescription = "avatar",
              Modifier
                  .size(78.dp)
                  .clip(CircleShape)
          )
        Text("Maxim",
                fontSize = 24.sp,
                fontWeight = FontWeight.W700
                )
        }
    }
}