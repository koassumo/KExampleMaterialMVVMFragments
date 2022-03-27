package com.example.kexamplematerialmvvmfragments.model

import com.example.kexamplematerialmvvmfragments.model.entity.NoteRv

object RepositoryRv {

    private val listNoteRvSelections: List<NoteRv> = listOf(
        NoteRv("Checkboxes", "rv_checkboxes"),
        NoteRv("Radio Buttons", "rv_radio"),
        NoteRv("Switches", "rv_switches")
    )

    private val listNoteRvChips: List<NoteRv> = listOf(
        NoteRv("Chips1", "rv_chips_1"),
        NoteRv("Chips2", "rv_chips_2"),
        NoteRv("Chips3", "rv_chips_3")
    )

    private val listNoteRvConstraintLayout: List<NoteRv> = listOf(
        NoteRv("ConstraintLayout1", "rv_constraint_layout_1"),
        NoteRv("ConstraintLayout2", "rv_constraint_layout_2"),
        NoteRv("ConstraintLayout3", "rv_constraint_layout_3")
    )

    private val listNoteBottomNav: List<NoteRv> = listOf(
        NoteRv("Bottom Nav 1", "rv_bottom_nav_1"),
        NoteRv("Bottom Nav 2", "rv_bottom_nav_2"),
        NoteRv("Bottom Nav 3", "rv_bottom_nav_3")
    )

    private val listNoteRvBottomAppBar: List<NoteRv> = listOf(
        NoteRv("Bottom App Bar 1", "rv_bottom_app_bar_1"),
        NoteRv("Bottom App Bar 2", "rv_bottom_app_bar_2"),
        NoteRv("Bottom App Bar 3", "rv_bottom_app_bar_3")
    )

    private val listNoteRvDemoRV: List<NoteRv> = listOf(
        NoteRv("Demo Recycler View 1", "rv_demo_rv_1"),
        NoteRv("Demo Recycler View 2", "rv_demo_rv_2"),
        NoteRv("Demo Recycler View 3", "rv_demo_rv_3"),
        NoteRv("Demo Recycler View 4", "rv_demo_rv_4")
    )

    private val listNoteRvTabs: List<NoteRv> = listOf(
        NoteRv("Fixed Tabs", "rv_tabs_fixed"),
        NoteRv("Scrollable Tabs", "rv_tabs_scrollable")
    )


    private val listNoteRvAnimation: List<NoteRv> = listOf(
        NoteRv("Animation 1", "rv_animation_1"),
        NoteRv("Animation 2", "rv_animation_2"),
        NoteRv("Animation 3", "rv_animation_3"),
        NoteRv("Animation 4", "rv_animation_4"),
        NoteRv("Animation 5 Motion", "rv_animation_5")
    )

    fun getListRvSelections () = listNoteRvSelections
    fun getListRvChips () = listNoteRvChips
    fun getListRvConstraintLayout () = listNoteRvConstraintLayout
    fun getListRvBottomNav () = listNoteBottomNav
    fun getListRvBottomAppBar () = listNoteRvBottomAppBar
    fun getListRvDemoRV () = listNoteRvDemoRV
    fun getListRvTabs () = listNoteRvTabs
    fun getListRvAnimation () = listNoteRvAnimation
}