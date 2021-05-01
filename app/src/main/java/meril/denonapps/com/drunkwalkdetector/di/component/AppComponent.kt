package meril.denonapps.com.drunkwalkdetector.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import meril.denonapps.com.drunkwalkdetector.DWDApplication
import meril.denonapps.com.drunkwalkdetector.di.module.ActivityModule
import meril.denonapps.com.drunkwalkdetector.di.module.FragmentModule
import meril.denonapps.com.drunkwalkdetector.di.module.ViewModelModule

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityModule::class,
        FragmentModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent : AndroidInjector<DWDApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
}