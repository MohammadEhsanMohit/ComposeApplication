package com.example.composeapplication.feature.splash.data.repository

import com.example.composeapplication.feature.splash.domain.repository.SplashScreenRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class SplashScreenRepositoryImp : SplashScreenRepository {
    override suspend fun checkAppLastVersion() = flow {
        delay(5000)
        emit(true)
    }

}