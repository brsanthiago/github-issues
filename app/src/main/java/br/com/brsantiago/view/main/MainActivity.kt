package br.com.brsantiago.view.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import br.com.brsantiago.R
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), LifecycleOwner {

    private lateinit var lifecycleRegistry: LifecycleRegistry
    private val mViewModel: MainViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startView()
    }

    private fun startView() {
        lifecycleRegistry = LifecycleRegistry(this)
        lifecycleRegistry.addObserver(mViewModel)
        lifecycleRegistry.markState(Lifecycle.State.CREATED)
    }

    override fun getLifecycle(): Lifecycle {
        return lifecycleRegistry
    }
}
