package ee.mtiidla.swimresult.di

import android.app.Application

object Dependencies {

    lateinit var appComponent: AppComponent
        private set

    fun init(application: Application) {
        appComponent = DaggerAppComponent.builder()
            .application(application)
            .build()
    }
}