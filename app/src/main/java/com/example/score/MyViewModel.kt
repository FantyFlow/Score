package com.example.score

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MyViewModel : ViewModel() {
    private val _numberA by lazy { MutableStateFlow(0) }
    private val _numberB by lazy { MutableStateFlow(0) }
    val numberA: StateFlow<Int> get() = _numberA
    val numberB: StateFlow<Int> get() = _numberB
    private var backA = 0
    private var backB = 0

    fun addA(int: Int) {
        backA = _numberA.value
        backB = _numberB.value
        _numberA.value = _numberA.value.plus(int)
    }

    fun addB(int: Int) {
        backA = _numberA.value
        backB = _numberB.value
        _numberB.value = _numberB.value.plus(int)
    }

    fun reset() {
        backA = _numberA.value
        backB = _numberB.value
        _numberA.value = 0
        _numberB.value = 0
    }

    fun undo() {
        _numberA.value = backA
        _numberB.value = backB
    }
}