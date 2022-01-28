package com.mariobr.segundaprova.animes

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface AnimeDAO {
    @Insert
    fun inserir(anime: Anime): Long

    @Delete
    fun delete(anime: Anime): Int

    @Update
    fun atualizar(anime: Anime):Int

    @Query("SELECT * FROM tb_anime")
    fun listAll(): LiveData<List<Anime>>

    @Query("SELECT * FROM tb_anime WHERE id=:id")
    fun findById(id: Int):Anime

}