package com.example.myfirstapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData


/**
 * @author Inés Saint Martin
 */
class ItemViewModel : ViewModel() {

    var itemLiveData: MutableLiveData<ArrayList<Item>> = MutableLiveData()
    private var list = arrayListOf<Item>()

    init {
        populateList()
        itemLiveData.value = list
    }


    private fun populateList() {
        for (i in 0 until 30) {
            list.add(Item("Titulo # $i", "Descripción # $i"))
        }
    }
}