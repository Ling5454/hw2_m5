package com.example.hw2_m5.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.example.hw2_m5.data.local.AppDatabase
import com.example.hw2_m5.data.local.Pref
import com.example.hw2_m5.data.server.LoveApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class LoveAppModule {
    @Provides
    fun provideApi(): LoveApi {
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi::class.java)
    }

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "love-file"
    ).allowMainThreadQueries().build()

    @Provides
    fun provideDao(
        database: AppDatabase
    ) = database.getDao()

    @Provides
    fun provideSharedPreferences(
        @ApplicationContext context: Context
    ): SharedPreferences = context.getSharedPreferences(Pref.PREF_NAME, Context.MODE_PRIVATE)


    @Provides
    fun providePref(sharedPreferences: SharedPreferences): Pref = Pref(sharedPreferences)

}