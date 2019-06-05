package br.com.brsantiago

import android.app.Application
import br.com.brsantiago.di.issueModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class IssueApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    fun initKoin() = startKoin {
        androidLogger()
        androidContext(this@IssueApp)
        androidFileProperties()
        modules(issueModule)
    }

}