package com.klim.daggersample.data.di

import com.klim.daggersample.data._retrofit.RetrofitProvider
import com.klim.daggersample.data._retrofit.apis.feedback.PostApi
import com.klim.daggersample.data.repository.post.PostDataSourceI
import com.klim.daggersample.data.repository.post.PostRepository
import com.klim.daggersample.data.repository.post.dataSources.remote.RemotePostDataSource
import com.klim.daggersample.domain.repositoryInterface.PostRepositoryI
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
internal abstract class DataModule {

    @Binds
    protected abstract fun bindPostRepository(homeViewModel: PostRepository): PostRepositoryI

    @Binds
    protected abstract fun bindPostDataSource(homeViewModel: RemotePostDataSource): PostDataSourceI

}