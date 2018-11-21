package ee.mtiidla.swimresult.data.network

import java.io.InputStream

interface FileDataSource {

    fun getFileStream(fileName: String): InputStream
}