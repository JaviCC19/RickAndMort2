package com.uvg.javier.States

import com.uvg.javier.dataCharacters.Character

data class CharacterProfileState(
    val isLoading: Boolean = false,
    val data: Character? = null,
    val hasError: Boolean = false
)
