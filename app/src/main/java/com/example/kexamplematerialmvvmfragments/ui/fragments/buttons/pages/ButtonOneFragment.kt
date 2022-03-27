package com.example.kexamplematerialmvvmfragments.ui.fragments.buttons.pages

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.transition.*
import com.example.kexamplematerialmvvmfragments.R
import kotlinx.android.synthetic.main.button_one_fragment.*

class ButtonOneFragment : Fragment() {

    companion object {
        fun newInstance() = ButtonOneFragment()
    }

    private lateinit var viewModel: ButtonOneViewModel
    private var textIsVisible = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.button_one_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ButtonOneViewModel::class.java)
        // TODO: Use the ViewModel


        // анимация!
        btn_1.setOnClickListener {

            // (1) С сетом - все транзакции разными способами
            // set определяет разные СПОСОБЫ транзакций для разных элементов
            var mySet: TransitionSet = TransitionSet()
                .addTransition(Slide(Gravity.END).addTarget(btn_2))
                .addTransition(Slide(Gravity.END).addTarget(btn_3))
                .addTransition(Slide(Gravity.BOTTOM).addTarget(tv_1))
                .addTransition(Fade().addTarget(tv_1))
                .addListener(object : TransitionListenerAdapter() {
                    override fun onTransitionEnd(transition: Transition) { // реакция на завершение
                        transition.removeListener(this)             // убирает себя (лисенера) !!!
                        //activity?.onBackPressed()

                    }

                })
            // Пуск после подготовки set
            TransitionManager.beginDelayedTransition(my_transition_container, mySet)

            // (2) Без сета - все транзакции только одним способом
            // Пуск сразу
//            TransitionManager.beginDelayedTransition(my_transition_container, Slide(Gravity.END))


            // Целевое состояние (для любого способа пуска)
            textIsVisible = !textIsVisible
            btn_2.visibility = if (textIsVisible) View.VISIBLE else View.GONE
            btn_3.visibility = if (textIsVisible) View.VISIBLE else View.GONE
            tv_1.visibility = if (textIsVisible) View.VISIBLE else View.GONE
            //it.visibility =  View.VISIBLE
            activity?.onBackPressed()

        }
    }

}