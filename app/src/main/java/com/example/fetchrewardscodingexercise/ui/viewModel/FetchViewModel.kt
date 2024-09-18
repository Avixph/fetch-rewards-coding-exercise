package com.example.fetchrewardscodingexercise.ui.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.fetchrewardscodingexercise.FetchRewardsCodingExerciseApplication
import com.example.fetchrewardscodingexercise.data.FetchListsRepository
import com.example.fetchrewardscodingexercise.model.FetchListItem
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface FetchUiState {
    data class Success(val lists: List<FetchListItem>) : FetchUiState
    data object Error : FetchUiState
    data object Loading : FetchUiState
}

class FetchViewModel(private val fetchListsRepository: FetchListsRepository) : ViewModel() {
    /** fetchUiState is a mutable state that stores the status of a request. */
    var fetchUiState: FetchUiState by mutableStateOf(FetchUiState.Loading)
        private set

    /** getFetchLists is called on init in order to display the status. */
    init {
        getFetchLists()
    }

    /** getFetchLists retrieves the Fetch Rewards lists info from the json. */
    fun getFetchLists() {
        viewModelScope.launch {
            fetchUiState = FetchUiState.Loading
            fetchUiState = try {
//                val result = fetchListsRepository.getFetchLists()
                FetchUiState.Success(
                    fetchListsRepository.getFetchLists()
                )
            } catch (e: IOException) {
                FetchUiState.Error
            } catch (e: HttpException) {
                FetchUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as FetchRewardsCodingExerciseApplication)
                val fetchListsRepository = application.container.fetchListsRepository
                FetchViewModel(fetchListsRepository = fetchListsRepository)
            }
        }
    }
}