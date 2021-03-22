package com.klim.daggersample.data.repository.post

import kotlinx.coroutines.flow.Flow

interface PostDataSourceI {
    fun getAll(): Flow<List<PostDTO>>
}