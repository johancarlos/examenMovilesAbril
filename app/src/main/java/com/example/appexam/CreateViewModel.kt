package com.example.appexam

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CreateViewModel(val createValidation: CreateValidation) : ViewModel(){
    val model: LiveData<UiModel>
    get() = _model
    val _model = MutableLiveData<UiModel>()

    sealed class UiModel(){
        class Create(val success:Boolean):UiModel()
    }
    fun doCreate(name:String, lastname:String, email:String){
        _model.value = UiModel.Create(createValidation.create(name,lastname,email))
    }
}