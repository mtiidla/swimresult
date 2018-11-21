package ee.mtiidla.swimresult

import android.app.Application
import ee.mtiidla.swimresult.di.Dependencies
import timber.log.Timber

class SwimApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Dependencies.init(this)

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}