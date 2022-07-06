package com.example.hilt_lecture.ui

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp //일단 힐트 애플리케이션 클래스를 만들어야 함.
class App:Application() {
    //그리고 매니페스트 파일에 android:name=".ui.App" 를 application태그 안에 넣어야 함.
}