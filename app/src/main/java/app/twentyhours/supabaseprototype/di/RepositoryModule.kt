package app.twentyhours.supabaseprototype.di

import app.twentyhours.supabaseprototype.data.remote.repository.impl.ProductRepositoryImpl
import app.twentyhours.supabaseprototype.data.remote.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindProductRepository(productRepositoryImpl: ProductRepositoryImpl): ProductRepository
}