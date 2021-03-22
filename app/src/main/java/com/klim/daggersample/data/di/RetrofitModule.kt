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
internal class RetrofitModule {

    @Provides
    @Singleton
    fun getRetrofit(): Retrofit {
        return RetrofitProvider().getRetrofit()
    }

    @Provides
    fun getPostApi(retroFit: Retrofit): PostApi {
        return retroFit.create(PostApi::class.java)
    }

}