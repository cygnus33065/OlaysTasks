package com.example.olaystasks.ui.viewmodel
import android.app.Application
import android.util.Log
import androidx.core.content.contentValuesOf
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


    private lateinit var startingNumbers:List<Int>
    //    private lateinit var _numberList:MutableLiveData<>
    init {
        startingNumbers = setStartingNumbers(10)
        Log.e("In the init", startingNumbers.toString())
    }
    //    private var startingNumbers = 1..10
//    private var _numberList: MutableLiveData<List<Int>> = MutableLiveData(setStartingNumbers(10))
        private var _numberList: MutableLiveData<IntRange> = MutableLiveData(1..10)
//    private var _numberList: MutableLiveData<List<Int>> = MutableLiveData(1..10)
//    val numberList:LiveData<List<Int>> get() {
////        Log.e("after get", numberList.toString())
//
//        return _numberList
//    }
    val numberList:LiveData<IntRange> = _numberList

    fun addNextNumber(){
        val nextNumber = numberList.value!!.count() + 1
        val newList = numberList.value!!.plus(nextNumber)
        _numberList.value = IntRange(newList.first(), newList.last())
    }


}


