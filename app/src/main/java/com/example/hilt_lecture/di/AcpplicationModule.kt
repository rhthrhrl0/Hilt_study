package com.example.hilt_lecture.di

import android.app.Application
import com.example.hilt_lecture.di.qualifier.AppHash
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class) //전체 앱의 스코프에 해당하는 모듈을 만들겠다
object AcpplicationModule { //object는 스태틱 메소드를 지닌 클래스라고 생각하면 된다

    @AppHash //원래 없는 어노테이션인데 다른 곳에서 구별할 수 있게 하기 위해 만들엇음/
    @Provides
    fun provideHash()=hashCode().toString()
}