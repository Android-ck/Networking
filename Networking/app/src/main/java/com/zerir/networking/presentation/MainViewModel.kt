package com.zerir.networking.presentation

import androidx.lifecycle.*
import com.zerir.networking.domain.Repository
import com.zerir.networking.domain.model.PassengersResponse
import com.zerir.networking.network.NetworkConnection
import com.zerir.networking.network.Resource
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: Repository,
    val passengerAdapter: PassengerAdapter,
    val networkConnection: NetworkConnection,
) : ViewModel() {

    private var planetsJob: Job? = null

    private val _resource = MutableLiveData<Resource<PassengersResponse>?>()
    val resource: LiveData<Resource<PassengersResponse>?> get() = _resource

    init {
        loadPlanet()
    }

    private fun loadPlanet() {
        planetsJob?.cancel()
        planetsJob = viewModelScope.launch {
            _resource.value = Resource.Loading()
            //delay to see loading indicator
            delay(2000)
            _resource.value = repository.getAllPassengers()
        }
    }

    fun clearResource() { _resource.value = null }

    class Factory(
        private val repository: Repository,
        private val passengerAdapter: PassengerAdapter,
        private val networkConnection: NetworkConnection,
    ) : ViewModelProvider.Factory {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainViewModel(repository, passengerAdapter, networkConnection) as T
        }

    }

}