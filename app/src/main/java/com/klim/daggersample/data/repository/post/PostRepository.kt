package com.klim.daggersample.data.repository.post

import com.klim.daggersample.data.repository.mappers.mapToEntity
import com.klim.daggersample.domain.entity.PostEntity
import com.klim.daggersample.domain.repositoryInterface.PostRepositoryI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PostRepository @Inject constructor(private val remote: PostDataSourceI): PostRepositoryI {

    override fun getAll(): Flow<List<PostEntity>> {
        return remote.getAll().map { it.mapToEntity() }
    }

}