package br.com.brsantiago.view.main

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import br.com.brsantiago.base.BaseViewModel
import br.com.brsantiago.domain.Issue
import br.com.brsantiago.network.IssueService
import kotlinx.coroutines.launch

class MainViewModel(private val service: IssueService) : BaseViewModel() {

    private var mutableIssues: MutableLiveData<MutableList<Issue>> = MutableLiveData()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun loadIssues() {
        jobs add launch {
            try {
                val list = service.getAll("JetBrains", "Kotlin").await()
                mutableIssues.postValue(list)
            } catch (t: Throwable) {
                println(t.localizedMessage)
            }
        }

    }

    val issues: MutableLiveData<MutableList<Issue>> get() = mutableIssues
}