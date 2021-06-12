package com.example.kexamplematerialmvvmfragments.ui.fragments.selections

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kexamplematerialmvvmfragments.R
import kotlinx.android.synthetic.main.checkboxes_fragment.*

class CheckboxesFragment : Fragment() {

    companion object {
        fun newInstance() = CheckboxesFragment()
    }

    private lateinit var viewModel: CheckboxesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.checkboxes_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CheckboxesViewModel::class.java)

        checkbox_4.isChecked = true
        //checkbox_2.setSelectAllOnFocus(true)
    }

}