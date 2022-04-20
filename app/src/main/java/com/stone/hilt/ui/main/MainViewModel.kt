package com.stone.hilt.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stone.hilt.data.model.User
import com.stone.hilt.data.repository.MainRepository
import com.stone.hilt.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
):ViewModel(){

     private val _users=MutableLiveData<Resource<List<User>>>()
    val users:LiveData<Resource<List<User>>> = _users

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        //_users.postValue(Resource.loading(null!!))
        CoroutineScope(Dispatchers.IO).launch {



                mainRepository.getUsers().let {
                    if (it.isSuccessful) {
                        _users.postValue(Resource.success(it.body()!!))
                    } else _users.postValue(Resource.error(it.errorBody().toString(), null!!))
                }
            }

    }
}