package com.mariobr.segundaprova.animes

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tb_anime")
data class Anime (
    var nome:String,
    var arcos:String,
    var eps:Int,
    var ano:Int,
    var idioma:String,
    var classificacao:Int
){
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0;
}