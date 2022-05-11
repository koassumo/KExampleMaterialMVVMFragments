package com.example.kexamplematerialmvvmfragments.ui.fragments.animation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.Gravity

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import androidx.transition.ArcMotion
import androidx.transition.ChangeBounds
import androidx.transition.TransitionManager
import com.example.kexamplematerialmvvmfragments.R
import kotlinx.android.synthetic.main.animation_three_fragment.*

class AnimationThreeFragment : Fragment() {

    companion object {
        fun newInstance() = AnimationThreeFragment()
    }

    private lateinit var viewModel: AnimationThreeViewModel
    private var toRightAnimation = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.animation_three_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AnimationThreeViewModel::class.java)
        // TODO: Use the ViewModel

        btn_333.setOnClickListener {
            val changeBounds = ChangeBounds()
            changeBounds.setPathMotion (ArcMotion())
            changeBounds.duration = 5000                // скорость перехода !

            TransitionManager.beginDelayedTransition(
                my_container_anim_3,
                changeBounds
            )

            //
            toRightAnimation = !toRightAnimation

            val params : FrameLayout.LayoutParams = btn_333.layoutParams as FrameLayout.LayoutParams
            params.gravity = if (toRightAnimation) Gravity.END or Gravity.BOTTOM
                             else Gravity.START or Gravity.TOP
            btn_333.layoutParams = params


        }

    }

}