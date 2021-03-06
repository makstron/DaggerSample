package com.klim.daggersample.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.klim.daggersample.App
import com.klim.daggersample.R
import com.klim.daggersample.databinding.FragmentSlideshowBinding
import com.klim.daggersample.ui.home.HomeViewModel
import javax.inject.Inject

class SlideshowFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: SlideshowViewModel
    lateinit var binding: FragmentSlideshowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.application as App).appComponent.injectSlideshowFragment(this)
        viewModel = ViewModelProvider(this, viewModelFactory).get(SlideshowViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_slideshow, container, false)

        viewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textSlideshow.text = it
        })

        return binding.root
    }
}