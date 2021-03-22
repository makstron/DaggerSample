package com.klim.daggersample.domain.di

import com.klim.daggersample.domain.useCase.PostUseCase
import com.klim.daggersample.domain.useCaseInterface.PostUseCaseI
import dagger.Binds
import dagger.Module

@Module
internal abstract class DomainModule {

    @Binds
    protected abstract fun bindPostUseCase(homeViewModel: PostUseCase): PostUseCaseI
}