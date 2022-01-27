package com.mariobr.segundaprova.animes

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface AnimeDAO {
    @Insert
    fun inserir(anime: Anime): Long

    @Insert
    fun insereDois(p1:Anime, p2:Anime)

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

    @Query("SELECT * FROM tb_anime")
    fun listAllAdapter(): MutableList<Anime>

    @Query("SELECT * FROM tb_anime WHERE id=:id")
    fun findById(id: Int):Anime

    @Query("SELECT * FROM tb_anime WHERE nome=:nome")
    fun findByName(nome:String):Anime

}