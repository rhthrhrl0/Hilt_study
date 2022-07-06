package com.example.hilt_lecture.ui.main

import androidx.lifecycle.ViewModel
import com.example.hilt_lecture.data.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val repository: MyRepository //이런 식으로 뷰모델에 의존성 주입을 직접 넣어주려면 뷰모델을 생성하는 뷰모델 팩토리가 필요.... 불편.
) : ViewModel() {
    //뷰모델에서 의존성 주입을 받고 싶다면? 즉, MyRepository가 필요하다면?

    fun getRepositoryHash()=repository.toString()
}