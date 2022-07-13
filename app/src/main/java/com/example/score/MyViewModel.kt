package com.example.score

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.tencent.mmkv.MMKV

class MyViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {
    private val kv by lazy { MMKV.defaultMMKV() }
    private var _numberA
        get() = numberA.value
        set(value) {
            savedStateHandle["numberA"] = value
            kv.encode("numberA", value)
        }
    val numberA by lazy { savedStateHandle.getStateFlow("numberA", kv.decodeInt("numberA")) }
    private var _numberB
        get() = numberB.value
        set(value) {
            savedStateHandle["numberB"] = value
            kv.encode("numberB", value)
        }
    val numberB by lazy { savedStateHandle.getStateFlow("numberB", kv.decodeInt("numberB")) }
    private var backA = 0
    private var backB = 0

    fun addA(int: Int) {
        backA = _numberA
        backB = _numberB
        _numberA += int
    }

    fun addB(int: Int) {
        backA = _numberA
        backB = _numberB
        _numberB += int
    }

    fun reset() {
        backA = numberA.value
        backB = numberB.value
        _numberA = 0
        _numberB = 0
    }

    fun undo() {
        _numberA = backA
        _numberB = backB
    }
}