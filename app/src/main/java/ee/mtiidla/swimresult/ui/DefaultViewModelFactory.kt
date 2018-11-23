package ee.mtiidla.swimresult.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class DefaultViewModelFactory<VM : ViewModel> @Inject constructor(
    private val viewModelProvider: Provider<VM>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(viewModelClass: Class<T>): T {
        val viewModel = viewModelProvider.get()
        if (viewModel.javaClass.isAssignableFrom(viewModelClass)) {
            return viewModel as T
        } else {
            throw IllegalArgumentException(
                "ViewModel ${viewModel::class.java.name} is not assignable from requested" +
                    " view model class ${viewModelClass.name}"
            )
        }
    }
}