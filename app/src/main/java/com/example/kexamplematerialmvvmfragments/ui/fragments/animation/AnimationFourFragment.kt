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
import com.example.kexamplematerialmvvmfragments.R
import kotlinx.android.synthetic.main.animation_four_fragment.*

class AnimationFourFragment : Fragment() {

    companion object {
        fun newInstance() = AnimationFourFragment()
    }

    private lateinit var viewModel: AnimationFourViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.animation_four_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AnimationFourViewModel::class.java)
        // TODO: Use the ViewModel

        // создание первого состояния - новые вьюшки
        val myTitles: MutableList<String> = ArrayList()
        for (i: Int in 0..444) {
            myTitles.add(String.format("Item %d   ", i+1))
        }
        createViews(my_transition_container_4, myTitles)


        btn_444.setOnClickListener {

            val changeBounds = ChangeBounds()
            changeBounds.setPathMotion (ArcMotion())
            changeBounds.duration = 5000                // скорость перехода !


            //описание перемещения
            TransitionManager.beginDelayedTransition(my_transition_container_4, changeBounds)

//            вариант без задания начальной ChangeBounds
//            TransitionManager.beginDelayedTransition(my_transition_container_4, ChangeBounds())


            // второе состояние - пересоздание вьюшек
            myTitles.shuffle()
            createViews(my_transition_container_4, myTitles)
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