package meril.denonapps.com.drunkwalkdetector.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import meril.denonapps.com.drunkwalkdetector.di.ViewModelKey
import meril.denonapps.com.drunkwalkdetector.di.ViewModelProviderFactory
import meril.denonapps.com.drunkwalkdetector.viewmodel.HomeViewModel

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindAuthViewModel(homeViewModel: HomeViewModel): ViewModel

}