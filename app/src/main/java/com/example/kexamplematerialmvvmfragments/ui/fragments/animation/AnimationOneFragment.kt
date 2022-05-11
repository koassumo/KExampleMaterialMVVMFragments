package com.example.kexamplematerialmvvmfragments.ui.fragments.animation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.transition.*
import com.example.kexamplematerialmvvmfragments.R
import kotlinx.android.synthetic.main.animation_one_fragment.*


class AnimationOneFragment : Fragment() {

    companion object {
        fun newInstance() = AnimationOneFragment()
    }

    private lateinit var viewModel: AnimationOneViewModel
    private var textIsVisible = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.animation_one_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AnimationOneViewModel::class.java)
        // TODO: Use the ViewModel

        // анимация! все вьюшки должны иметь id !
        fab_go.setOnClickListener {

            // (1) С сетом - все транзакции разными способами
            // set определяет разные СПОСОБЫ транзакций для разных элементов
            var mySet: TransitionSet = TransitionSet()
                .addTransition(Slide(Gravity.END).addTarget(s_igo_01))
                .addTransition(Slide(Gravity.START).addTarget(s_igo_02))
                .addTransition(Slide(Gravity.END).addTarget(s_igo_03))
                .addTransition(Slide(Gravity.START).addTarget(s_igo_04))
                .addTransition(Slide(Gravity.END).addTarget(s_igo_05))
                .addTransition(Slide(Gravity.START).addTarget(s_igo_06))
                .addTransition(Slide(Gravity.END).addTarget(s_igo_07))
                .addTransition(Slide(Gravity.START).addTarget(s_igo_08))
                .addTransition(Slide(Gravity.END).addTarget(s_igo_09))
                .addTransition(Slide(Gravity.START).addTarget(s_igo_10))
                .addTransition(Slide(Gravity.END).addTarget(s_igo_11))
                .addTransition(Slide(Gravity.START).addTarget(s_igo_12))
                .addTransition(Slide(Gravity.END).addTarget(s_igo_13))
                .addTransition(Slide(Gravity.START).addTarget(s_igo_14))
                .addTransition(Slide(Gravity.END).addTarget(s_igo_15))
                .addTransition(Slide(Gravity.START).addTarget(s_igo_16))
//                .addTransition(Fade().addTarget(tv_1))
//                .addListener(object : TransitionListenerAdapter() {
//                    override fun onTransitionEnd(transition: Transition) { // реакция на завершение
//                        transition.removeListener(this)             // убирает себя (лисенера) !!!
//                        //activity?.onBackPressed()
//
//                    }
//
//                })


            // Пуск после подготовки set
            TransitionManager.beginDelayedTransition(container_anim, mySet)  // layout, в кот. вьюшки для анимации

            // (2) Без сета - все транзакции только одним способом
            // Пуск сразу
//            TransitionManager.beginDelayedTransition(my_transition_container, Slide(Gravity.END))


            // Целевое состояние (для любого способа пуска)
            textIsVisible = !textIsVisible
            s_igo_01.visibility = if (textIsVisible) View.VISIBLE else View.GONE
            s_igo_02.visibility = if (textIsVisible) View.VISIBLE else View.GONE
            s_igo_03.visibility = if (textIsVisible) View.VISIBLE else View.GONE
            s_igo_04.visibility = if (textIsVisible) View.VISIBLE else View.GONE
            s_igo_05.visibility = if (textIsVisible) View.VISIBLE else View.GONE
            s_igo_06.visibility = if (textIsVisible) View.VISIBLE else View.GONE
            s_igo_07.visibility = if (textIsVisible) View.VISIBLE else View.GONE
            s_igo_08.visibility = if (textIsVisible) View.VISIBLE else View.GONE
            s_igo_09.visibility = if (textIsVisible) View.VISIBLE else View.GONE
            s_igo_10.visibility = if (textIsVisible) View.VISIBLE else View.GONE
            s_igo_11.visibility = if (textIsVisible) View.VISIBLE else View.GONE
            s_igo_12.visibility = if (textIsVisible) View.VISIBLE else View.GONE
            s_igo_13.visibility = if (textIsVisible) View.VISIBLE else View.GONE
            s_igo_14.visibility = if (textIsVisible) View.VISIBLE else View.GONE
            s_igo_15.visibility = if (textIsVisible) View.VISIBLE else View.GONE
            s_igo_16.visibility = if (textIsVisible) View.VISIBLE else View.GONE
            //it.visibility =  View.VISIBLE
            //activity?.onBackPressed()

        }
    }

}