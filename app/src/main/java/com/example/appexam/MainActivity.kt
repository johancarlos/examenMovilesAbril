package com.example.appexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.LoginFilter
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var createViewModel: CreateViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createViewModel = CreateViewModel(CreateValidation())
        createViewModel.model.observe(this,Observer(::updateUi))

        btnCreate.setOnClickListener{
            createViewModel.doCreate(nameEditText.text.toString(),lastnameEditText.text.toString(), mailEditText.text.toString())
        }
    }
    private fun updateUi(model: CreateViewModel.UiModel?){
        when(model){
            is CreateViewModel.UiModel.Create -> validarCreate(model.success)
        }
    }

    private fun validarCreate(resp:Boolean){
        if(resp == true){
            Toast.makeText(this,"Creado Exitosamente",Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this,"Error",Toast.LENGTH_LONG).show()
        }
    }

}

