package com.example.score

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class MyViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {
    val numberA by lazy { savedStateHandle.getStateFlow("numberA", 0) }
    val numberB by lazy { savedStateHandle.getStateFlow("numberB", 0) }
    private var backA = 0
    private var backB = 0

    fun addA(int: Int) {
        backA = numberA.value
        backB = numberB.value
        savedStateHandle["numberA"] = numberA.value + int
    }

    fun addB(int: Int) {
        backA = numberA.value
        backB = numberB.value
        savedStateHandle["numberB"] = numberB.value + int
    }

    fun reset() {
        backA = numberA.value
        backB = numberB.value
        savedStateHandle["numberA"] = 0
        savedStateHandle["numberB"] = 0
    }

    fun undo() {
        savedStateHandle["numberA"] = backA
        savedStateHandle["numberB"] = backB
    }
}