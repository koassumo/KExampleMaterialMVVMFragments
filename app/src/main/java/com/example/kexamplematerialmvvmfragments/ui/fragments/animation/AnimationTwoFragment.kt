package com.example.kexamplematerialmvvmfragments.ui.fragments.animation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.transition.ChangeBounds
import androidx.transition.ChangeImageTransform
import androidx.transition.TransitionManager
import androidx.transition.TransitionSet
import com.example.kexamplematerialmvvmfragments.databinding.AnimationTwoFragmentBinding

class AnimationTwoFragment : Fragment() {

    companion object {
        fun newInstance() = AnimationTwoFragment()
    }

    private lateinit var viewModel: AnimationTwoViewModel
    private var isExpanded = false
    private var _binding: AnimationTwoFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = AnimationTwoFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[AnimationTwoViewModel::class.java]

        binding.ivAnim2.setOnClickListener {
            isExpanded = !isExpanded

            TransitionManager.beginDelayedTransition(
                binding.myContainerAnim2, TransitionSet()
                    .addTransition(ChangeBounds())
                    .addTransition(ChangeImageTransform())
            )

            val params: ViewGroup.LayoutParams = binding.ivAnim2.layoutParams
            params.height = if (isExpanded) ViewGroup.LayoutParams.MATCH_PARENT else ViewGroup.LayoutParams.WRAP_CONTENT
            binding.ivAnim2.layoutParams = params

            binding.ivAnim2.scaleType = if (isExpanded) ImageView.ScaleType.CENTER_CROP else ImageView.ScaleType.FIT_CENTER
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
