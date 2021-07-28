package com.example.olaystasks.ui.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class NumberViewModel(application: Application): AndroidViewModel(application) {

    private fun setStartingNumbers(max:Int): List<Int>{
        var numbers: List<Int> = mutableListOf()
        var i:Int = 1
        while(i <= max){
            numbers.toMutableList().add(i)
            i++
        }
        return numbers
    }


    private var startingNumbers = setStartingNumbers(10)
    private var _numberList: MutableLiveData<List<Int>> = MutableLiveData(listOf(1,2,3,4,5,6,7,8,9,10))
    val numberList:LiveData<List<Int>> = _numberList

    fun addNextNumber(){
        val nextNumber = numberList.value!!.size + 1
        _numberList.value = _numberList.value!!.plus(listOf(nextNumber))
    }


}