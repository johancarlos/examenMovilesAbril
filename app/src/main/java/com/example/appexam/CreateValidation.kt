package com.example.appexam

class CreateValidation {
    fun create(name:String,lastname:String, email:String): Boolean = name.toString().length != 0 && lastname.toString().length != 0 && email.toString().length != 0
}