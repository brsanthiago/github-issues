package br.com.brsantiago.view.main

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import br.com.atech.ecams.base.BaseViewModel
import br.com.brsantiago.network.IssueService
import kotlinx.coroutines.launch

class MainViewModel(private val service: IssueService) : BaseViewModel() {


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun loadIssues() {
        jobs add launch {
            try {
                val list = service.getAll("JetBrains", "Kotlin").await()
                println(list)
            } catch (t: Throwable) {
                println(t.localizedMessage)
            }
        }

    }
}