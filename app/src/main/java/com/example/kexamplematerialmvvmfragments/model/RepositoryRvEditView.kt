package com.example.kexamplematerialmvvmfragments.model

import com.example.kexamplematerialmvvmfragments.model.entity.NoteRvButton
import com.example.kexamplematerialmvvmfragments.model.entity.NoteRvEditView

object RepositoryRvEditView {
    private val listNoteRvEditView: List<NoteRvEditView> = listOf(
        NoteRvEditView("Outlined\nBox", "rv_outlined_box"),
        NoteRvEditView("Filled\nBox", "rv_filled_box")
    )

    fun getList () = listNoteRvEditView

}