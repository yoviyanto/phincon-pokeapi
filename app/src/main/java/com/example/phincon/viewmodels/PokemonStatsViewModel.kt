package com.example.phincon.viewmodels

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import com.example.phincon.data.repo.PokemonRepository
import com.example.phincon.utils.NetworkResource
import com.example.phincon.utils.extractId
import kotlinx.coroutines.flow.flow
import javax.inject.Inject



@HiltViewModel
class PokemonStatsViewModel @Inject constructor(private val pokemonRepository: PokemonRepository) :
    ViewModel() {

    suspend fun getSinglePokemon(url: String) = flow {
        val id = url.extractId()
        emit(NetworkResource.Loading)
        emit(pokemonRepository.getSinglePokemon(id))
    }

}