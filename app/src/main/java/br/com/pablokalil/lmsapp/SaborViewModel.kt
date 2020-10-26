package br.com.pablokalil.lmsapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SaborViewModel: ViewModel() {
    val nome = MutableLiveData<String>()
}