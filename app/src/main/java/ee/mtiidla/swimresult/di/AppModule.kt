package ee.mtiidla.swimresult.di

import dagger.Module
import ee.mtiidla.swimresult.data.DataModule

@Module(includes = [DataModule::class])
abstract class AppModule {

}