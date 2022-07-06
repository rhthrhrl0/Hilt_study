package com.example.hilt_lecture.di.qualifier

import javax.inject.Qualifier

@Qualifier //대거 힐트에서 사용하기 위한 어노테이션임을 명시.
@Retention(AnnotationRetention.RUNTIME) // 런타임에도 제공되는 어노테이션이라는 선언.
annotation class AppHash
//자바의 커스텀 어노테이션을 만드는 문법과 유사함.