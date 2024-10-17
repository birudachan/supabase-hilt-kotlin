package app.twentyhours.supabaseprototype.di

import app.twentyhours.supabaseprototype.domain.usecase.CreateProductUseCase
import app.twentyhours.supabaseprototype.domain.usecase.impl.CreateProductUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class UseCaseModule {

    @Binds
    abstract fun bindCreateProductUseCase(createProductUseCaseImpl: CreateProductUseCaseImpl): CreateProductUseCase
}