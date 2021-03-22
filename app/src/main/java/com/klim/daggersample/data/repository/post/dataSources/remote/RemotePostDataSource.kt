package com.klim.daggersample.data.repository.post.dataSources.remote

import com.klim.daggersample.data._retrofit.apis.feedback.PostApi
import com.klim.daggersample.data.repository.post.PostDTO
import com.klim.daggersample.data.repository.post.PostDataSourceI
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemotePostDataSource @Inject constructor(val postApi: PostApi) : PostDataSourceI {
    override fun getAll() = flow<List<PostDTO>> {
        emit(postApi.getAll().mapToDTO())
    }

}