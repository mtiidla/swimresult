package ee.mtiidla.swimresult

import ee.mtiidla.swimresult.data.network.FileDataSource
import java.io.InputStream

class TestFileDataSource : FileDataSource {

    override fun getFileStream(fileName: String): InputStream {
        return TestFileDataSource::class.java.classLoader?.getResourceAsStream(fileName)
            ?: throw NullPointerException("Failed to read file $fileName for data source");
    }
}