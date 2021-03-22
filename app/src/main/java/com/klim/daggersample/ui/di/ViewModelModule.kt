package com.klim.daggersample.ui.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.klim.daggersample.domain.useCase.PostUseCase
import com.klim.daggersample.domain.useCaseInterface.PostUseCaseI
import com.klim.daggersample.ui.gallery.GalleryViewModel
import com.klim.daggersample.ui.home.HomeViewModel
import com.klim.daggersample.ui.slideshow.SlideshowViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory


    /*
     * This method basically says
     * inject this object into a Map using the @IntoMap annotation,
     * with the  MovieListViewModel.class as key,
     * and a Provider that will build a MovieListViewModel
     * object.
     *
     * */

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    protected abstract fun movieHomeViewModel(homeViewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(GalleryViewModel::class)
    protected abstract fun movieGalleryViewModel(galleryViewModel: GalleryViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SlideshowViewModel::class)
    protected abstract fun movieSlideshowViewModel(slideshowViewModel: SlideshowViewModel): ViewModel
}