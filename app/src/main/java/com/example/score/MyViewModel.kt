package com.example.score

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    private val _numberA = MutableLiveData<Int>().also { it.value = 0 }
    private val _numberB = MutableLiveData<Int>().also { it.value = 0 }
    val numberA: LiveData<Int> = _numberA
    val numberB: LiveData<Int> = _numberB
    private var backA: Int = 0
    private var backB: Int = 0

    fun addA(int: Int) {
        backA = _numberA.value!!
        backB = _numberB.value!!
        _numberA.value = _numberA.value?.plus(int)
    }

    fun addB(int: Int) {
        backA = _numberA.value!!
        backB = _numberB.value!!
        _numberB.value = _numberB.value?.plus(int)
    }

    fun reset() {
        backA = _numberA.value!!
        backB = _numberB.value!!
        _numberA.value = 0
        _numberB.value = 0
    }

    fun undo() {
        _numberA.value = backA
        _numberB.value = backB
    }
}