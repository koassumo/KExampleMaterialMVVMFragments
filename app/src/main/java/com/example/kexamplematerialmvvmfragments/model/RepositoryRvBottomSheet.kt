package com.example.kexamplematerialmvvmfragments.model

import com.example.kexamplematerialmvvmfragments.model.entity.NoteRvBottomSheet

object RepositoryRvBottomSheet {
    private val listNoteRvBottomSheet: List<NoteRvBottomSheet> = listOf(
        NoteRvBottomSheet("Flex sheet", "rv_bottom_sheet_flex"),
        //NoteRvBottomSheet("Persistent sheet", "rv_bottom_sheet_persistent"),
    )

    fun getList () = listNoteRvBottomSheet
}