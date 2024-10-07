package com.uvg.javier.States

import com.uvg.javier.dataCharacters.Character

data class CharacterListState(
    val isLoading: Boolean = false,
    val data: List<Character>? = null,
    val hasError: Boolean = false
)