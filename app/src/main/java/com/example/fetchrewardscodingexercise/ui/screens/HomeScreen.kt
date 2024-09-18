package com.example.fetchrewardscodingexercise.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fetchrewardscodingexercise.R
import com.example.fetchrewardscodingexercise.ui.theme.FetchRewardsCodingExerciseTheme
import com.example.fetchrewardscodingexercise.ui.viewModel.FetchUiState

@Composable
fun HomeScreen(
    fetchUiState: FetchUiState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    when (fetchUiState) {
        is FetchUiState.Loading -> LoadingScreen(
            modifier = modifier.fillMaxSize(),
        )
        is FetchUiState.Success -> ListsScreen(
            fetchUiState.lists,
            contentPadding = contentPadding,
            modifier = modifier.fillMaxSize(),
        )
        is FetchUiState.Error -> ErrorScreen(
            retryAction,
            modifier = modifier.fillMaxSize(),
        )
    }
}
