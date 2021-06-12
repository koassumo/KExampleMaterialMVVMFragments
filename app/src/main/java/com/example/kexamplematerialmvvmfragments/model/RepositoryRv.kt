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

    fun getListRvSelections () = listNoteRvSelections
    fun getListRvChips () = listNoteRvChips
    fun getListRvConstraintLayout () = listNoteRvConstraintLayout
    fun getListRvBottomNav () = listNoteBottomNav
    fun getListRvBottomAppBar () = listNoteRvBottomAppBar
    fun getListRvDemoRV () = listNoteRvDemoRV
}