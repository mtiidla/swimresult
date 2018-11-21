package ee.mtiidla.swimresult.data

import dagger.Module
import ee.mtiidla.swimresult.data.network.NetworkModule

@Module(includes = [NetworkModule::class])
abstract class DataModule {

}
