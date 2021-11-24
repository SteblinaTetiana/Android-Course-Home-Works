package com.triare.p091directorysviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MainViewModel: ViewModel() {

     private val repository = Repository()

    val model = MutableLiveData<AnimalsPlants>()

    fun addAnimalPlant(id:Int?){
        val animalsPlants = repository.getAnimalPlantById(id)
        model.value =animalsPlants
    }
}