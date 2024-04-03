package com.example.moviesapp.movieList.data.mappers

import com.example.moviesapp.movieList.data.local.movie.MovieEntity
import com.example.moviesapp.movieList.data.remote.respond.MovieDto
import com.example.moviesapp.movieList.domain.model.Movie

fun MovieDto.toMovieEntity(category: String): MovieEntity {
    return MovieEntity(
        id ?: -1,
        adult ?: false,
        backdrop_path ?: "",
        genre_ids = try {
            genre_ids?.joinToString(",") ?: "-1,-2"
        } catch (e: Exception) {
            "-1,-2"
        },
        original_language ?: "",
        original_title ?: "",
        overview ?: "",
        popularity ?: 0.0,
        poster_path ?: "",
        release_date ?: "",
        title ?: "",
        video ?: false,
        vote_average ?: 0.0,
        vote_count ?: 0,
        category
    )
}

fun MovieEntity.toMovie(category: String): Movie {
    return Movie(
        id,
        adult,
        backdrop_path,
        genre_ids = try {
            genre_ids.split(",").map { it.toInt() }
        } catch (e: Exception) {
            listOf(-1, -2)
        },
        original_language,
        original_title,
        overview,
        popularity,
        poster_path,
        release_date,
        title,
        video,
        vote_average,
        vote_count,
        category
    )
}