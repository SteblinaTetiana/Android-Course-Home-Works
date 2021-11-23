package com.triare.p091directorysviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MainViewModel: ViewModel() {

     private val repository = Repository()

    val animalsModel = MutableLiveData<Animals>()

    fun addAnimals(id:Int?){
        val animal = repository.getAnimalById(id)
        animalsModel.value =animal
    }
}