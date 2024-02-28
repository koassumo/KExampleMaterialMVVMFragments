package com.example.kexamplematerialmvvmfragments.ui.fragment_main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kexamplematerialmvvmfragments.R
import com.example.kexamplematerialmvvmfragments.ui.fragments_settings.ThemesFragment
import com.example.kexamplematerialmvvmfragments.ui.fragments_settings.TypographyFragment
import com.example.kexamplematerialmvvmfragments.databinding.MainFragmentBinding


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    // (1) объявляем mViewModel
    private lateinit var viewModel: MainViewModel

    private var _binding: MainFragmentBinding? = null
    // Это свойство для удобного доступа к ненулевому биндингу
    private val binding get() = _binding!!

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
        // (2) Инициализация биндинга
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // (2) наполнение mViewModel
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        // First adapter
        // подтягиваем rv, кладем layout на rv
        binding.rvButtons.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        // инициализируем адаптер, кладем его на rv
        adapterButtons = RvAdapterButtons(requireContext())
        binding.rvButtons.adapter = adapterButtons

        // Next adapter
        binding.rvEditText.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        adapterEditView = RvAdapterEditView(requireContext())
        binding.rvEditText.adapter = adapterEditView

        // Next adapter
        binding.rvBottomSheet.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        adapterBottomSheet = RvAdapterBottomSheet(requireContext())
        binding.rvBottomSheet.adapter = adapterBottomSheet

        // Next adapter
        //adapterChips = RvAdapterChips(context!!)
        //rv_chips.adapter = adapterChips
        //rv_chips.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        // Next adapter
        adapterConstraintLayout = RvAdapterConstraintLayout(requireContext())
        binding.rvConstraintLayout.adapter = adapterConstraintLayout
        binding.rvConstraintLayout.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        // Next adapter
        adapterBottomNav = RvAdapterBottomNav(requireContext())
        binding.rvBottomNav.adapter = adapterBottomNav
        binding.rvBottomNav.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        // Next adapter
        adapterBottomAppBar = RvAdapterBottomAppBar(requireContext())
        binding.rvBottomAppBar.adapter = adapterBottomAppBar
        binding.rvBottomAppBar.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        // Next adapter
        adapterDemoRV = RvAdapterDemoRV(requireContext())
        binding.rvDemoRv.adapter = adapterDemoRV
        binding.rvDemoRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        // Next adapter
        adapterSelections = RvAdapterSelections(requireContext())
        binding.rvSelections.adapter = adapterSelections
        binding.rvSelections.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        // Next adapter
        adapterTabs = RvAdapterTabs(requireContext())
        binding.rvTabs.adapter = adapterTabs
        binding.rvTabs.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        // Next adapter
        adapterAnimation = RvAdapterAnimation(requireContext())
        binding.rvAnimation.adapter = adapterAnimation
        binding.rvAnimation.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

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

        binding.cardTypography.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.container, TypographyFragment())?.addToBackStack(null)?.commit()
        }

        binding.cardThemes.setOnClickListener {
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
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
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