package com.example.kexamplematerialmvvmfragments.model

import com.example.kexamplematerialmvvmfragments.model.entity.ItemRV

object ItemRepository {

    private val listItems: List<ItemRV> = listOf(
        ItemRV("11","+", "item One"),
        ItemRV("12","+", "item Two"),
        ItemRV("13","+", "item Three"),
        ItemRV("14","+", "item Four"),
        ItemRV("15","+", "item Five"),
        ItemRV("16","+", "item Six"),
        ItemRV("17","+", "item Seven")
    )

    fun getListItems(): List<ItemRV> {
        return listItems
    }

}