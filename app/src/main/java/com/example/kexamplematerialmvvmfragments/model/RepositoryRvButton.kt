package com.example.kexamplematerialmvvmfragments.model

import com.example.kexamplematerialmvvmfragments.model.entity.NoteRvButton

object RepositoryRvButton {
    private val listNoteRvButton: List<NoteRvButton> = listOf(
        NoteRvButton("Text\nButton", "rv_button_text"),
        NoteRvButton("Toggle\nButton", "rv_button_toggle"),
        NoteRvButton("Gradient\nButton", "rv_button_gradient")
    )

    fun getList () = listNoteRvButton

}