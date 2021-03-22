package com.klim.daggersample.domain.useCase

import com.klim.daggersample.domain.entity.PostEntity
import com.klim.daggersample.domain.repositoryInterface.PostRepositoryI
import com.klim.daggersample.domain.useCaseInterface.PostUseCaseI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PostUseCase @Inject constructor(private val postRepository: PostRepositoryI) : PostUseCaseI {

    override fun getAll(): Flow<List<PostEntity>> {
        return postRepository.getAll()
    }

}