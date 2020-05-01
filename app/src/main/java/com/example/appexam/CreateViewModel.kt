package com.example.appexam

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.os.Handler

class CreateViewModel(val createValidation: CreateValidation) : ViewModel(){
    val model: LiveData<UiModel>
    get() = _model
    val _model = MutableLiveData<UiModel>()

    sealed class UiModel(){
        class Create(val success:Boolean):UiModel()
        object Loading:UiModel()
    }
    fun doCreate(name:String, lastname:String, email:String){
        _model.value = UiModel.Loading
        val runnable = Runnable {
            _model.value = UiModel.Create(createValidation.create(name,lastname,email))
        }
        Handler().postDelayed(runnable, 3000)
    }
}