package com.example.kexamplematerialmvvmfragments.model

import com.example.kexamplematerialmvvmfragments.model.entity.NoteDemoRV

object RepositoryDemoRV {

    private val listNoteDemoRV: MutableList<NoteDemoRV> = mutableListOf(
        NoteDemoRV("1","Item 1", "This is Element One. Very good element."),
        NoteDemoRV("2","Item 2", "This is Element Two. Very good element."),
        NoteDemoRV("3","Item 3", "This is Element Three. Very good element."),
        NoteDemoRV("4","Item 4", "This is Element Four. Very good element."),
        NoteDemoRV("5","Item 5", "This is Element Five. Very good element."),
        NoteDemoRV("6","Item 6", "This is Element Six. Very good element."),
        NoteDemoRV("7","Item 7","This is description of the element"),
        NoteDemoRV("8","Item 8","This is description of the element"),
        NoteDemoRV("9","Item 9","This is description of the element"),
        NoteDemoRV("10","Item 10","This is description of the element"),
        NoteDemoRV("11","Item 11","This is description of the element"),
        NoteDemoRV("12","Item 12","This is description of the element"),
        NoteDemoRV("13","Item 13","This is description of the element"),
        NoteDemoRV("14","Item 14","This is description of the element"),
        NoteDemoRV("15","Item 15","This is description of the element"),
        NoteDemoRV("16","Item 16","This is description of the element"),
        NoteDemoRV("17","Item 17","This is description of the element"),
        NoteDemoRV("18","Item 18","This is description of the element"),
        NoteDemoRV("19","Item 19","This is description of the element"),
        NoteDemoRV("20","Item 20","This is description of the element"),
        NoteDemoRV("21","Item 21","This is description of the element"),
        NoteDemoRV("22","Item 22","This is description of the element"),
        NoteDemoRV("23","Item 23","This is description of the element"),
        NoteDemoRV("24","Item 24","This is description of the element")
    )

    fun getListNoteDemoRV(): MutableList<NoteDemoRV> {
        return listNoteDemoRV
    }

}