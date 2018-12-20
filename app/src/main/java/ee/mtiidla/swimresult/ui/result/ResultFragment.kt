package ee.mtiidla.swimresult.ui.result

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import ee.mtiidla.swimresult.di.Dependencies
import ee.mtiidla.swimresult.ui.DefaultViewModelFactory
import ee.mtiidla.swimresult.ui.ScreenFragment
import ee.mtiidla.swimresult.util.requireScreenArg
import javax.inject.Inject

class ResultFragment : ScreenFragment<ResultScreen>() {

    @Inject
    lateinit var viewModelFactory: DefaultViewModelFactory<ResultViewModel>

    override fun createScreen(context: Context): ResultScreen = ResultScreen(context)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val screenArgs = requireScreenArg<ResultScreenArgs>()

        Dependencies.appComponent.result()
            .resultScreenArgs(screenArgs)
            .build()
            .inject(this)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ViewModelProviders.of(this, viewModelFactory).get(ResultViewModel::class.java)
            .screenState.observe(viewLifecycleOwner, Observer<ResultState>(screen()::render))

    }



}