package com.example.kexamplematerialmvvmfragments.model

import com.example.kexamplematerialmvvmfragments.model.entity.NoteRvButton

object RepositoryRvButton {
    private val listNoteRvButton: List<NoteRvButton> = listOf(
        NoteRvButton("Single\nButton", "rv_button_text"),
        NoteRvButton("Segmented\nButton", "rv_button_toggle"),
        NoteRvButton("Floating\nAction Button", "rv_button_gradient")
    )

    fun getList () = listNoteRvButton

}