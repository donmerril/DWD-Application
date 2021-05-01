package meril.denonapps.com.drunkwalkdetector.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import meril.denonapps.com.drunkwalkdetector.ui.home.HomeActivity

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeBaseActivity(): HomeActivity

}