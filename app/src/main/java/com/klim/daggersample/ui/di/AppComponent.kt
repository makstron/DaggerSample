package com.klim.daggersample.ui.di

import android.app.Application
import com.klim.daggersample.App
import com.klim.daggersample.data.di.DataModule
import com.klim.daggersample.data.di.RetrofitModule
import com.klim.daggersample.domain.di.DomainModule
import com.klim.daggersample.ui.MainActivity
import com.klim.daggersample.ui.gallery.GalleryFragment
import com.klim.daggersample.ui.home.HomeFragment
import com.klim.daggersample.ui.slideshow.SlideshowFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/*
 * We mark this interface with the @Component annotation.
 * And we define all the modules that can be injected.
 * Note that we provide AndroidSupportInjectionModule.class
 * here. This class was not created by us.
 * It is an internal class in Dagger 2.10.
 * Provides our activities and fragments with given module.
 * */
@Component(
    modules = [
        ViewModelModule::class,
        DomainModule::class,
        DataModule::class,
        RetrofitModule::class,
    ]
)
@Singleton
interface AppComponent {

    /*
     * We will call this builder interface from our custom Application class.
     * This will set our application object to the AppComponent.
     * So inside the AppComponent the application instance is available.
     * So this application instance can be accessed by our modules
     * such as ApiModule when needed
     *
     * */
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    /*
     * This is our custom Application class
     * */
    fun inject(app: App)

    fun injectHomeFragment(fragment: HomeFragment)

    fun injectGalleryFragment(fragment: GalleryFragment)

    fun injectSlideshowFragment(fragment: SlideshowFragment)
}