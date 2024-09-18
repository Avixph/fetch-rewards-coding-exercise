package com.example.fetchrewardscodingexercise.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring.DampingRatioLowBouncy
import androidx.compose.animation.core.Spring.StiffnessVeryLow
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fetchrewardscodingexercise.R
import com.example.fetchrewardscodingexercise.model.FetchListItem
import com.example.fetchrewardscodingexercise.ui.theme.FetchRewardsCodingExerciseTheme

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ListsScreen(
    lists: List<FetchListItem>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    val visibleState = remember {
        MutableTransitionState(false).apply {
            targetState = true
        }
    }
    AnimatedVisibility(
        visibleState = visibleState,
        enter = fadeIn(
            animationSpec = spring(
                dampingRatio = DampingRatioLowBouncy
            )
        ),
        exit = fadeOut(),
        modifier = modifier
    ) {
        LazyColumn(
            contentPadding = contentPadding
        ) {
            items(
               items = lists,
                key = { list ->
                    list.listId
                }
            ) {
                list ->
                ListsItemCard(
                    listItem = list,
                    modifier = Modifier
                        .padding(
                            horizontal = 16.dp,
                            vertical = 8.dp,
                        )
                        .animateEnterExit(
                            enter = slideInVertically(
                                animationSpec = spring(
                                    stiffness = StiffnessVeryLow,
                                    dampingRatio = DampingRatioLowBouncy
                                ),
                                initialOffsetY = { it * (list.listId + 1) } // staggered entrance
                            )
                        )
                )
            }
        }
    }
}

@Composable
fun ListsItemCard(
    listItem: FetchListItem,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(8.dp),
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .sizeIn(minHeight = 72.dp)
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "List ${listItem.listId}",
                    style = MaterialTheme.typography.displayMedium
                )
                Text(
                    text = "${listItem.name}",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}
