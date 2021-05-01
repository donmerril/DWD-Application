package meril.denonapps.com.drunkwalkdetector.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import meril.denonapps.com.drunkwalkdetector.ui.home.HomeFragment

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeSignUpFragment(): HomeFragment

}