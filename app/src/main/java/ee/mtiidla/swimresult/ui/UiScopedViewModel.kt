package ee.mtiidla.swimresult.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

abstract class UiScopedViewModel : ViewModel(), CoroutineScope {

    private val job: Job = Job()

    override val coroutineContext: CoroutineContext = Dispatchers.Main + job

    override fun onCleared() {
        super.onCleared()
        // TODO: Marko 23.11.2018 cancel here does not cancel network request, just mapping and delivery.
        // Observe https://github.com/square/retrofit/pull/2886 for first party support
        job.cancel()
    }

    suspend fun <T> withIO(block: suspend CoroutineScope.() -> T): T =
        withContext(Dispatchers.IO) { block() }

    suspend fun <T> asyncIO(block: suspend CoroutineScope.() -> T): Deferred<T> =
        async(Dispatchers.IO) { block() }
}