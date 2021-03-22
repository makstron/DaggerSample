package com.klim.daggersample.domain.useCaseInterface

import com.klim.daggersample.domain.entity.PostEntity
import kotlinx.coroutines.flow.Flow

interface PostUseCaseI {
    fun getAll(): Flow<List<PostEntity>>
}