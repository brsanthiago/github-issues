package br.com.brsantiago.view.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.brsantiago.R
import br.com.brsantiago.domain.Issue
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel



class MainActivity : AppCompatActivity(), LifecycleOwner {

    private lateinit var lifecycleRegistry: LifecycleRegistry
    private val viewModel: MainViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startView()

        viewModel.issues.observe(this, Observer { issues -> startIssues(issues) })
    }

    private fun startIssues(issues: MutableList<Issue>) {
        val adapter = IssueAdapter(issues)
        val layoutManager = LinearLayoutManager(this)
        recycler_view.layoutManager = layoutManager
        recycler_view.adapter = adapter
    }

    private fun startView() {
        lifecycleRegistry = LifecycleRegistry(this)
        lifecycleRegistry.addObserver(viewModel)
        lifecycleRegistry.markState(Lifecycle.State.CREATED)
        val decoration = DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
        recycler_view.addItemDecoration(decoration)
    }

    override fun getLifecycle(): Lifecycle {
        return lifecycleRegistry
    }
}
