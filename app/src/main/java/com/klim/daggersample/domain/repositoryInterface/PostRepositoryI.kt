package com.klim.daggersample.domain.repositoryInterface

import com.klim.daggersample.domain.entity.PostEntity
import kotlinx.coroutines.flow.Flow

interface PostRepositoryI {
    fun getAll(): Flow<List<PostEntity>>
}