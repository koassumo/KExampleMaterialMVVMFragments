package com.example.kexamplematerialmvvmfragments.model


import com.example.kexamplematerialmvvmfragments.model.entity.NoteRvTypography

object RepositoryRvTypography {
    private val listNoteRvTypography: List<NoteRvTypography> = listOf(
        NoteRvTypography("Headline1", "Light, 96sp, Sentence"),
        NoteRvTypography("Headline2", "Light, 60sp, Sentence"),
        NoteRvTypography("Headline3", "Regular, 48sp, Sentence"),
        NoteRvTypography("Headline4", "Regular, 34sp, Sentence"),
        NoteRvTypography("Headline5", "Regular, 24sp, Sentence"),
        NoteRvTypography("Headline6", "Medium, 20sp, Sentence"),
        NoteRvTypography("Subtitle1", "Regular, 16sp, Sentence"),
        NoteRvTypography("Subtitle2", "Medium, 14sp, Sentence"),
        NoteRvTypography("Body1", "Regular, 16sp, Sentence"),
        NoteRvTypography("Body2", "Regular, 14sp, Sentence"),
        NoteRvTypography("Button", "Medium, 14sp, All Caps"),
        NoteRvTypography("Caption", "Regular, 12sp, Sentence"),
        NoteRvTypography("Overline", "Regular, 10sp, All Caps")
    )

    fun getList () = listNoteRvTypography
}