package com.example.kexamplematerialmvvmfragments.ui.fragments.animation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.transition.*
import com.example.kexamplematerialmvvmfragments.databinding.AnimationOneFragmentBinding


class AnimationOneFragment : Fragment() {

    private var _binding: AnimationOneFragmentBinding? = null
    private val binding get() = _binding!!
    companion object {
        fun newInstance() = AnimationOneFragment()
    }

    private lateinit var viewModel: AnimationOneViewModel
    private var textIsVisible = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = AnimationOneFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(AnimationOneViewModel::class.java)
        // TODO: Use the ViewModel

        // анимация! все вьюшки должны иметь id !
        binding.fabGo.setOnClickListener {

            // (1) С сетом - все транзакции разными способами
            // set определяет разные СПОСОБЫ транзакций для разных элементов
            val mySet: TransitionSet = TransitionSet()
                .addTransition(Slide(Gravity.END).addTarget(binding.sIgo01))
                .addTransition(Slide(Gravity.START).addTarget(binding.sIgo02))
                .addTransition(Slide(Gravity.END).addTarget(binding.sIgo03))
                .addTransition(Slide(Gravity.START).addTarget(binding.sIgo04))
                .addTransition(Slide(Gravity.END).addTarget(binding.sIgo05))
                .addTransition(Slide(Gravity.START).addTarget(binding.sIgo06))
                .addTransition(Slide(Gravity.END).addTarget(binding.sIgo07))
                .addTransition(Slide(Gravity.START).addTarget(binding.sIgo08))
                .addTransition(Slide(Gravity.END).addTarget(binding.sIgo09))
                .addTransition(Slide(Gravity.START).addTarget(binding.sIgo10))
                .addTransition(Slide(Gravity.END).addTarget(binding.sIgo11))
                .addTransition(Slide(Gravity.START).addTarget(binding.sIgo12))
                .addTransition(Slide(Gravity.END).addTarget(binding.sIgo13))
                .addTransition(Slide(Gravity.START).addTarget(binding.sIgo14))
                .addTransition(Slide(Gravity.END).addTarget(binding.sIgo15))
                .addTransition(Slide(Gravity.START).addTarget(binding.sIgo16))
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
            TransitionManager.beginDelayedTransition(binding.containerAnim, mySet)  // layout, в кот. вьюшки для анимации

            // (2) Без сета - все транзакции только одним способом
            // Пуск сразу
//            TransitionManager.beginDelayedTransition(my_transition_container, Slide(Gravity.END))


            // Целевое состояние (для любого способа пуска)
            textIsVisible = !textIsVisible
            binding.sIgo01.visibility = if (textIsVisible) View.VISIBLE else View.GONE
            binding.sIgo02.visibility = if (textIsVisible) View.VISIBLE else View.GONE
            binding.sIgo03.visibility = if (textIsVisible) View.VISIBLE else View.GONE
            binding.sIgo04.visibility = if (textIsVisible) View.VISIBLE else View.GONE
            binding.sIgo05.visibility = if (textIsVisible) View.VISIBLE else View.GONE
            binding.sIgo06.visibility = if (textIsVisible) View.VISIBLE else View.GONE
            binding.sIgo07.visibility = if (textIsVisible) View.VISIBLE else View.GONE
            binding.sIgo08.visibility = if (textIsVisible) View.VISIBLE else View.GONE
            binding.sIgo09.visibility = if (textIsVisible) View.VISIBLE else View.GONE
            binding.sIgo10.visibility = if (textIsVisible) View.VISIBLE else View.GONE
            binding.sIgo11.visibility = if (textIsVisible) View.VISIBLE else View.GONE
            binding.sIgo12.visibility = if (textIsVisible) View.VISIBLE else View.GONE
            binding.sIgo13.visibility = if (textIsVisible) View.VISIBLE else View.GONE
            binding.sIgo14.visibility = if (textIsVisible) View.VISIBLE else View.GONE
            binding.sIgo15.visibility = if (textIsVisible) View.VISIBLE else View.GONE
            binding.sIgo16.visibility = if (textIsVisible) View.VISIBLE else View.GONE
            //it.visibility =  View.VISIBLE
            //activity?.onBackPressed()

        }
    }

}