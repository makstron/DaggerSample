package com.klim.daggersample.ui.home

import android.app.Application
import androidx.lifecycle.*
import com.klim.daggersample.domain.useCase.PostUseCase
import com.klim.daggersample.domain.useCaseInterface.PostUseCaseI
import com.klim.daggersample.ui.home.mappers.mapToPostView
import com.klim.daggersample.ui.home.viewEntity.PostView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(application: Application, val postUseCase: PostUseCaseI) :
    AndroidViewModel(application) {

    private val _posts = MutableLiveData<ArrayList<PostView>>().apply {
        value = ArrayList<PostView>()
    }
    val posts: LiveData<ArrayList<PostView>> = _posts

    fun updatePosts() {
        viewModelScope.launch(Dispatchers.Main) {
            postUseCase.getAll()
                .flowOn(Dispatchers.IO)
                .collect { list ->
                    _posts.value?.apply {
                        clear()
                        addAll(list.mapToPostView())
                    }
                    _posts.value = _posts.value
                }
        }
    }
}