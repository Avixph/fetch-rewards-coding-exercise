package com.example.fetchrewardscodingexercise.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.fetchrewardscodingexercise.R
import com.example.fetchrewardscodingexercise.ui.screens.HomeScreen
import com.example.fetchrewardscodingexercise.ui.viewModel.FetchViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FetchRewardsCodingExerciseApp() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CodingExerciseTopAppBar(scrollBehavior = scrollBehavior)
        },
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            val fetchViewModel: FetchViewModel = viewModel(factory = FetchViewModel.Factory)
            HomeScreen(
                fetchUiState = fetchViewModel.fetchUiState,
                retryAction = fetchViewModel::getFetchLists,
                contentPadding = it,
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CodingExerciseTopAppBar(
    scrollBehavior: TopAppBarScrollBehavior,
    modifier: Modifier = Modifier,
) {
    CenterAlignedTopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            Text(
                text = stringResource(R.string.app_name_alt),
                style = MaterialTheme.typography.displayLarge,
            )
        },
        modifier = modifier.padding(4.dp),
    )
}










