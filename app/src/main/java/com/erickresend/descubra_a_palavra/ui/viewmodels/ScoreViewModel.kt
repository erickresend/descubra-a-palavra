package com.erickresend.descubra_a_palavra.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.erickresend.descubra_a_palavra.repositories.PlayerRepository

class ScoreViewModel(application: Application): AndroidViewModel(application) {

    private val repository = PlayerRepository(application.applicationContext)
    val getAllPlayers = repository.getAllPlayers
}