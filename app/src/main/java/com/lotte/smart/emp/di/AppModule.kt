package com.lotte.smart.emp.di

import com.lotte.smart.emp.repository.login.LoginRepository
import com.lotte.smart.emp.repository.login.LoginRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideLogin(): LoginRepository {
        return LoginRepositoryImpl()
    }
}

