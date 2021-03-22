package com.klim.daggersample

import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.klim.daggersample.ui.di.AppComponent
import com.klim.daggersample.ui.di.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

/*
 * we use our AppComponent (now prefixed with Dagger)
 * to inject our Application class.
 * This way a DispatchingAndroidInjector is injected which is
 * then returned when an injector for an activity is requested.
 * */
class App : Application() {

    val appComponent: AppComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerAppComponent
            .builder()
            .application(this)
            .build()
    }


    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}