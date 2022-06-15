package com.example.repositoriosgithub.ui

import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.repositoriosgithub.R
import com.example.repositoriosgithub.core.createDialog
import com.example.repositoriosgithub.core.createProgressDialog
import com.example.repositoriosgithub.core.hideSoftKeyboard
import com.example.repositoriosgithub.databinding.ActivityMainBinding
import com.example.repositoriosgithub.presentation.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private val dialog by lazy { createProgressDialog() }
    private val viewModel by viewModel<MainViewModel>()
    private val adapter by lazy { RepoListAdapter() }
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.rvRepo.layoutManager = LinearLayoutManager(this)
        binding.rvRepo.adapter = adapter

        viewModel.repos.observe(this){
            when(it){
                is MainViewModel.State.Error -> {
                    createDialog {
                        setMessage("Não foi possivel obter os dados.")
//                        setMessage(it.error.message)
                    }.show()
                    dialog.dismiss()
                }
                MainViewModel.State.Loading -> dialog.show()
                is MainViewModel.State.Sucess -> {
                    dialog.dismiss()
                    adapter.submitList(it.list)
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        val searchView = menu.findItem(R.id.action_search).actionView as SearchView
        searchView.setOnQueryTextListener(this)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        query?.let { viewModel.getRepoList(it) }
        binding.root.hideSoftKeyboard()
        return true
    }


    override fun onQueryTextChange(newText: String?): Boolean {
        Log.e(TAG, "onQueryTextChange $newText")
        return false
    }
    companion object{
        private const val TAG = "TAG"
    }
}