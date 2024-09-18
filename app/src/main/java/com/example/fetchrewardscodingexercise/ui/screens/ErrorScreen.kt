package com.example.fetchrewardscodingexercise.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.fetchrewardscodingexercise.R

@Composable
fun ErrorScreen(
    retryAction: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.ic_connection_error,
            ),
            contentDescription = "",
        )
        Text(
            text = stringResource(R.string.loading_failed),
            style = MaterialTheme.typography.displaySmall,
            modifier = Modifier.padding(16.dp)
        )
        Button(onClick = retryAction) {
            Text(
                stringResource(R.string.retry),
                style = MaterialTheme.typography.displayMedium,
            )
        }
    }
}