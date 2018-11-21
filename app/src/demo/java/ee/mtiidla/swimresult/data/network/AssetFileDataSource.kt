package ee.mtiidla.swimresult.data.network

import android.content.res.AssetManager
import java.io.InputStream
import javax.inject.Inject

class AssetFileDataSource @Inject constructor(private val assetManager: AssetManager) :
    FileDataSource {

    override fun getFileStream(fileName: String): InputStream = assetManager.open(fileName)
}