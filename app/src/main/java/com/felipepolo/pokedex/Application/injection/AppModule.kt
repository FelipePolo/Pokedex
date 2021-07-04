package com.felipepolo.pokedex.Application.injection

import android.content.Context
import androidx.room.Room
import com.felipepolo.pokedex.Application.AppConstants.BASE_URL
import com.felipepolo.pokedex.Application.AppConstants.DATABASE_NAME
import com.felipepolo.pokedex.Application.TodoApplication
import com.felipepolo.pokedex.data.local.AppDatabase
import com.felipepolo.pokedex.data.remote.WebService
import com.felipepolo.pokedex.domain.MainRepositoryInterface
import com.felipepolo.pokedex.domain.MainRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideAppContext(app: TodoApplication): Context {
        return  app.applicationContext
    }

    @Provides
    @Singleton
    fun provideRoomInstance(
        context: Context
    ): AppDatabase {
        return Room.databaseBuilder(
            context,AppDatabase::class.java,DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun providePokemonDao(db: AppDatabase) = db.pokemonDao()

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideWebService(retrofit: Retrofit): WebService {
        return retrofit.create(WebService::class.java)
    }
}