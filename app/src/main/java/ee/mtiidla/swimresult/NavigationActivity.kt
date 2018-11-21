package ee.mtiidla.swimresult

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ee.mtiidla.swimresult.data.network.RestApi
import ee.mtiidla.swimresult.di.Dependencies
import kotlinx.android.synthetic.main.activity_navigation.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class NavigationActivity : AppCompatActivity(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    @Inject
    lateinit var restApi: RestApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        Dependencies.appComponent.inject(this)

        launch(Dispatchers.Main) {

            val meets = restApi.getMeets().await()

            api_dump_view.text = meets.toString()

        }
    }
}
