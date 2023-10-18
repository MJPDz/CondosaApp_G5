package com.example.mvvm_condosa.model

import androidx.annotation.StringRes

data class Achievement(
    val amount: Int,
    @StringRes val description: Int
)
