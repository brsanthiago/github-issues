package br.com.brsantiago.base

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.Job


open class BaseViewModel : ViewModel(), LifecycleObserver, CoroutineScope {

    override val coroutineContext = Default

    protected val jobs = ArrayList<Job>()

    infix fun ArrayList<Job>.add(job: Job) {
        this.add(job)
    }

    override fun onCleared() {
        super.onCleared()
        jobs.forEach { if (!it.isCancelled) it.cancel() }
    }
}