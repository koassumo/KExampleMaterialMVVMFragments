package com.example.kexamplematerialmvvmfragments.ui.fragment_main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kexamplematerialmvvmfragments.R
import com.example.kexamplematerialmvvmfragments.ui.fragments_settings.ThemesFragment
import com.example.kexamplematerialmvvmfragments.ui.fragments_settings.TypographyFragment
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }
    // (1) объявляем mViewModel
    private lateinit var viewModel: MainViewModel

    // объявляем adapter-ы
    lateinit var adapterSelections: RvAdapterSelections
    lateinit var adapterButtons: RvAdapterButtons
    lateinit var adapterEditView: RvAdapterEditView
    lateinit var adapterBottomSheet: RvAdapterBottomSheet
    //lateinit var adapterChips: RvAdapterChips
    lateinit var adapterConstraintLayout: RvAdapterConstraintLayout
    lateinit var adapterBottomNav: RvAdapterBottomNav
    lateinit var adapterBottomAppBar: RvAdapterBottomAppBar
    lateinit var adapterDemoRV: RvAdapterDemoRV
    lateinit var adapterTabs: RvAdapterTabs
    lateinit var adapterAnimation: RvAdapterAnimation

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // (2) наполнение mViewModel
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel

        // First adapter
        // подтягиваем rv, кладем layout на rv
        rv_buttons.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        // инициализируем адаптер, кладем его на rv
        adapterButtons = RvAdapterButtons(context!!)
        rv_buttons.adapter = adapterButtons

        // Next adapter
        rv_edit_text.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        adapterEditView = RvAdapterEditView(context!!)
        rv_edit_text.adapter = adapterEditView

        // Next adapter
        rv_bottom_sheet.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        adapterBottomSheet = RvAdapterBottomSheet(context!!)
        rv_bottom_sheet.adapter = adapterBottomSheet

        // Next adapter
        //adapterChips = RvAdapterChips(context!!)
        //rv_chips.adapter = adapterChips
        //rv_chips.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        // Next adapter
        adapterConstraintLayout = RvAdapterConstraintLayout(context!!)
        rv_constraint_layout.adapter = adapterConstraintLayout
        rv_constraint_layout.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        // Next adapter
        adapterBottomNav = RvAdapterBottomNav(context!!)
        rv_bottom_nav.adapter = adapterBottomNav
        rv_bottom_nav.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        // Next adapter
        adapterBottomAppBar = RvAdapterBottomAppBar(context!!)
        rv_bottom_app_bar.adapter = adapterBottomAppBar
        rv_bottom_app_bar.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        // Next adapter
        adapterDemoRV = RvAdapterDemoRV(context!!)
        rv_demo_rv.adapter = adapterDemoRV
        rv_demo_rv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        // Next adapter
        adapterSelections = RvAdapterSelections(context!!)
        rv_selections.adapter = adapterSelections
        rv_selections.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        // Next adapter
        adapterTabs = RvAdapterTabs(context!!)
        rv_tabs.adapter = adapterTabs
        rv_tabs.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        // Next adapter
        adapterAnimation = RvAdapterAnimation(context!!)
        rv_animation.adapter = adapterAnimation
        rv_animation.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

//        card_bottom_sheet.setOnClickListener {
//            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.container, BottomSheetFragment())?.addToBackStack(null)?.commit()
//        }

//        card_chips.setOnClickListener {
//            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.container, ChipsFragment())?.addToBackStack(null)?.commit()
//        }

//        card_constrained_layout.setOnClickListener {
//            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.container, ConstrainedLayoutFragment())?.addToBackStack(null)?.commit()
//        }

//        card_bottom_app_bar.setOnClickListener {
//            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.container, BottomAppBarFragment())?.addToBackStack(null)?.commit()
//        }
//
//        card_bottom_navigation.setOnClickListener {
//            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.container, BottomNavFragment())?.addToBackStack(null)?.commit()
//        }

//        card_recycle_view.setOnClickListener {
//            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.container, RVFragment())?.addToBackStack(null)?.commit()
//        }

        card_typography.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.container, TypographyFragment())?.addToBackStack(null)?.commit()
        }

        card_themes.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.container, ThemesFragment())?.addToBackStack(null)?.commit()
        }

    }

    override fun onStart() {
        super.onStart()
        //ChipsActivity4.start (this)
//    <<<<<<<<<<<<<<<<[[[  2. Подписка на liveData
//    <<<<<<<<<<<<<<<<[[[  *4. И сразу при Подписке описание реакции подписчика, 4ка выполнится позже
        viewModel.liveDataButtons.observe(this, Observer {
            adapterButtons.adapterList = it       // вызов set в адаптере
        })

        viewModel.liveDataEditView.observe(this, Observer {
            adapterEditView.adapterList = it       // вызов set в адаптере
        })

        viewModel.liveDataBottomSheet.observe(this, Observer {
            adapterBottomSheet.adapterList = it       // вызов set в адаптере
        })

//        viewModel.liveDataChips.observe(this, Observer {
//            adapterChips.adapterList = it       // вызов set в адаптере
//        })

        viewModel.liveDataConstraintLayout.observe(this, Observer {
            adapterConstraintLayout.adapterList = it       // вызов set в адаптере
        })

        viewModel.liveDataBottomNav.observe(this, Observer {
            adapterBottomNav.adapterList = it       // вызов set в адаптере
        })

        viewModel.liveDataBottomAppBar.observe(this, Observer {
            adapterBottomAppBar.adapterList = it
        })

        viewModel.liveDataDemoRV.observe(this, Observer {
            adapterDemoRV.adapterList = it
        })

        viewModel.liveDataSelections.observe(this, Observer {
            adapterSelections.adapterList = it
        })

        viewModel.liveDataTabs.observe(this, Observer {
            adapterTabs.adapterList = it
        })

        viewModel.liveDataAnimation.observe(this, Observer {
            adapterAnimation.adapterList = it
        })

    }

//    fun mClickItem (ttt: String) {
//        when (ttt) {
//            "Text\nButton" ->  {
//                Toast.makeText(context, "1-1-1-1-1", Toast.LENGTH_SHORT).show()
//                activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.container, EditTextFragment())?.addToBackStack(null)?.commit()
//            }
//            "2" ->  Toast.makeText(context, "2-2-2-2-2", Toast.LENGTH_SHORT).show()
//            "3" ->  Toast.makeText(context, "3-3-3-3-3", Toast.LENGTH_SHORT).show()
//        }
//    }

}