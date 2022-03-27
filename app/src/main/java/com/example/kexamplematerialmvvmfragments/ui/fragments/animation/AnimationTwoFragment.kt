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
import com.example.kexamplematerialmvvmfragments.R
import kotlinx.android.synthetic.main.animation_two_fragment.*

class AnimationTwoFragment : Fragment() {

    companion object {
        fun newInstance() = AnimationTwoFragment()
    }

    private lateinit var viewModel: AnimationTwoViewModel
    private var isExpanded = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.animation_two_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AnimationTwoViewModel::class.java)
        // TODO: Use the ViewModel

        iv_anim_2.setOnClickListener {
            isExpanded = !isExpanded

            // описание перехода
            TransitionManager.beginDelayedTransition(
                my_container_anim_2, TransitionSet()
                    .addTransition(ChangeBounds())
                    .addTransition(ChangeImageTransform())
            )

            // описание целевого состояния
            val params: ViewGroup.LayoutParams = iv_anim_2.layoutParams

            params.height = if (isExpanded) ViewGroup.LayoutParams.MATCH_PARENT
                            else            ViewGroup.LayoutParams.WRAP_CONTENT

            iv_anim_2.layoutParams = params  // на кой? работает и без

            iv_anim_2.scaleType = if (isExpanded)   ImageView.ScaleType.CENTER_CROP
                                  else              ImageView.ScaleType.FIT_CENTER
        }
    }

}