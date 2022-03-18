package com.edumath.mathquiz.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.edumath.mathquiz.R
import com.edumath.mathquiz.databinding.FragmentLawsBinding

class LawsFragment: Fragment() {

    private var _binding: FragmentLawsBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLawsBinding.inflate(inflater, container, false)
        navController = NavHostFragment.findNavController(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonPlay.setOnClickListener {
            findNavController().navigate(R.id.action_rulesFragment_to_gameFragment)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}