package com.klim.daggersample.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.klim.daggersample.App
import com.klim.daggersample.R
import com.klim.daggersample.databinding.FragmentHomeBinding
import com.klim.koinsample.ui.home.PostAdapter
import javax.inject.Inject

class HomeFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: HomeViewModel
    lateinit var binding: FragmentHomeBinding

    val adapter: PostAdapter = PostAdapter()
    lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.application as App).appComponent.injectHomeFragment(this)
        viewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        layoutManager = LinearLayoutManager(context)

        binding.rvPosts.adapter = adapter
        binding.rvPosts.layoutManager = layoutManager

        viewModel.posts.observe(viewLifecycleOwner, { list ->
            adapter.data.clear()
            adapter.data.addAll(list)
            adapter.notifyDataSetChanged()
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null) {
            viewModel.updatePosts()
        }
    }
}