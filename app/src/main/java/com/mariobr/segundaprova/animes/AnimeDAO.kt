package com.mariobr.segundaprova.animes

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface AnimeDAO {
    @Insert
    suspend fun inserir(anime: Anime): Long

    @Delete
    fun delete(anime: Anime): Int

    @Delete
    fun deletarVarios(vararg anime: Anime)

    @Query("DELETE FROM tb_anime")
    fun deletaTodos()

    @Update
    fun atualizar(anime: Anime):Int

    @Query("SELECT * FROM tb_anime")
    fun listAll(): LiveData<List<Anime>>

    @Query("SELECT * from tb_anime where id=:id")
    fun buscarPorId(id:Int):LiveData<Anime>


}