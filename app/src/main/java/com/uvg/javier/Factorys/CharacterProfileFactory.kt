package com.uvg.javier.Factorys

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.uvg.javier.ViewModels.CharacterProfileViewModel
import com.uvg.javier.dataCharacters.Character

class CharacterProfileViewModelFactory(private val characterId: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CharacterProfileViewModel::class.java)) {
            return CharacterProfileViewModel(characterId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}