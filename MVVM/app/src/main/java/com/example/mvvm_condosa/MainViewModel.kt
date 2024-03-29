package com.example.mvvm_condosa

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var showBottomSheet by mutableStateOf(false)
    var showDialogAsignacion by mutableStateOf(false)
    var showDialogCajaChica by mutableStateOf(false)
}