package com.nqmgaming.kotlin.lab6.cinema.core.di

import com.nqmgaming.kotlin.lab6.cinema.data.repository.MovieRepositoryImpl
import com.nqmgaming.kotlin.lab6.cinema.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindMovieRepository(movieRepositoryImpl: MovieRepositoryImpl): MovieRepository
}