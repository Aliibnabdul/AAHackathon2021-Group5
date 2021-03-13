package com.example.thingder.fragments.likedThings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.thingder.R
import com.example.thingder.databinding.FragmentLikedThingsBinding
import com.example.thingder.fragments.myThings.MyThingsAdapter

class LikedThingsFragment: Fragment(R.layout.fragment_liked_things) {
    private lateinit var binding: FragmentLikedThingsBinding
    private val likedThingsViewModel by viewModels<LikedThingsViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLikedThingsBinding.bind(view)

        likedThingsViewModel.things.observe(viewLifecycleOwner, {
            binding.likedThingsRecycler.adapter = MyThingsAdapter(it)
            binding.likedThingsRecycler.layoutManager = LinearLayoutManager(context,
                LinearLayoutManager.VERTICAL, false)
        })
    }
}