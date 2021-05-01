package meril.denonapps.com.drunkwalkdetector

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import meril.denonapps.com.drunkwalkdetector.di.component.DaggerAppComponent

class DWDApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}