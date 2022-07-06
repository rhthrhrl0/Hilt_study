package com.example.hilt_lecture.di

import com.example.hilt_lecture.di.qualifier.ActivityHash
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class) //전체 앱의 스코프에 해당하는 모듈을 만들겠다
object ActivityModule {
    @ActivityHash
    @Provides
    fun provideHash()= hashCode().toString()
}