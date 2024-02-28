package com.example.kexamplematerialmvvmfragments.ui.fragments.animation

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.lifecycle.ViewModelProvider
import androidx.transition.ArcMotion
import androidx.transition.ChangeBounds
import androidx.transition.TransitionManager
import com.example.kexamplematerialmvvmfragments.databinding.AnimationThreeFragmentBinding

class AnimationThreeFragment : Fragment() {

    companion object {
        fun newInstance() = AnimationThreeFragment()
    }

    private lateinit var viewModel: AnimationThreeViewModel
    private var toRightAnimation = false
    private var _binding: AnimationThreeFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = AnimationThreeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[AnimationThreeViewModel::class.java]

        binding.btn333.setOnClickListener {
            val changeBounds = ChangeBounds().apply {
                setPathMotion(ArcMotion())
                duration = 5000
            }

            TransitionManager.beginDelayedTransition(binding.myContainerAnim3, changeBounds)

            toRightAnimation = !toRightAnimation
            val params: FrameLayout.LayoutParams = binding.btn333.layoutParams as FrameLayout.LayoutParams
            params.gravity = if (toRightAnimation) Gravity.END or Gravity.BOTTOM else Gravity.START or Gravity.TOP
            binding.btn333.layoutParams = params
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


