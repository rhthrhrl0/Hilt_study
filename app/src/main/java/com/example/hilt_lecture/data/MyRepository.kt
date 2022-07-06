package com.example.hilt_lecture.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton//이게 있으면 싱글톤으로 의존성주입을 위한 객체가 생성됨. // 의존성 주입하기 위한 객체 생성시 사용할 생성자 지정.
class MyRepository @Inject constructor() { //이 객체를 여기 저기서 사용하고 싶다면?

}