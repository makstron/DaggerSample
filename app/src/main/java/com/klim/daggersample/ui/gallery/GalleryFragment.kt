package com.klim.daggersample.ui.gallery

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
import com.klim.daggersample.databinding.FragmentGalleryBinding
import com.klim.daggersample.ui.home.HomeViewModel
import javax.inject.Inject

class GalleryFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: GalleryViewModel
    lateinit var binding: FragmentGalleryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.application as App).appComponent.injectGalleryFragment(this)
        viewModel = ViewModelProvider(this, viewModelFactory).get(GalleryViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_gallery, container, false)

        viewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textGallery.text = it
        })

        return binding.root
    }
}