package com.example.kexamplematerialmvvmfragments.ui.fragments.animation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.transition.ArcMotion
import androidx.transition.ChangeBounds
import androidx.transition.TransitionManager
import com.example.kexamplematerialmvvmfragments.databinding.AnimationFourFragmentBinding

class AnimationFourFragment : Fragment() {
    private var _binding: AnimationFourFragmentBinding? = null
    private val binding get() = _binding!!
    companion object {
        fun newInstance() = AnimationFourFragment()
    }

    private lateinit var viewModel: AnimationFourViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = AnimationFourFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(AnimationFourViewModel::class.java)
        // TODO: Use the ViewModel

        // создание первого состояния - новые вьюшки
        val myTitles: MutableList<String> = ArrayList()
        for (i: Int in 0..444) {
            myTitles.add(String.format("Item %d   ", i+1))
        }
        createViews(binding.myTransitionContainer4, myTitles)


        binding.btn444.setOnClickListener {

            val changeBounds = ChangeBounds()
            changeBounds.setPathMotion (ArcMotion())
            changeBounds.duration = 5000                // скорость перехода !


            //описание перемещения
            TransitionManager.beginDelayedTransition(binding.myTransitionContainer4, changeBounds)

//            вариант без задания начальной ChangeBounds
//            TransitionManager.beginDelayedTransition(my_transition_container_4, ChangeBounds())


            // второе состояние - пересоздание вьюшек
            myTitles.shuffle()
            createViews(binding.myTransitionContainer4, myTitles)
        }
    }

    private fun createViews(layout: ViewGroup, titles: List<String>) {
        layout.removeAllViews()
        for (title in titles) {
            val textView = TextView(context)
            textView.text = title
            textView.gravity = Gravity.CENTER_HORIZONTAL
            ViewCompat.setTransitionName(textView, title)
            layout.addView(textView)
        }
    }
}