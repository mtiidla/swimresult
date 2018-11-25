package ee.mtiidla.swimresult.data.network

import android.app.Application
import android.content.res.AssetManager
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import ee.mtiidla.swimresult.data.network.adapter.EventsJsonMapAdapter
import ee.mtiidla.swimresult.di.ApplicationScope

@Module
class NetworkModule {

    @Provides
    @ApplicationScope
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(EventsJsonMapAdapter())
            .build()
    }

    @Provides
    @ApplicationScope
    fun provideAssetManager(application: Application): AssetManager = application.assets

    @Provides
    @ApplicationScope
    fun provideFileDataSource(fileDataSource: AssetFileDataSource): FileDataSource = fileDataSource

    @Provides
    @ApplicationScope
    fun provideRestApi(demoRestApi: DemoRestApi): RestApi = demoRestApi
}