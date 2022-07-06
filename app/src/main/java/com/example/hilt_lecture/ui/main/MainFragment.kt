package com.example.hilt_lecture.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.hilt_lecture.R
import com.example.hilt_lecture.databinding.FragmentMainBinding
import com.example.hilt_lecture.data.MyRepository
import com.example.hilt_lecture.di.qualifier.ActivityHash
import com.example.hilt_lecture.di.qualifier.AppHash
import com.example.hilt_lecture.ui.second.SecondActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment() {
    lateinit var binding: FragmentMainBinding
    //여기서 신기한거: 메인액티비티 쪽에서는 뷰모델을 만들지 않음... 얘는 어디서 얻어온 걸까?
    private val activityViewModel:MainViewModel by activityViewModels() //이 프래그먼트가 붙은 액티비티의 뷰모델을 가져옴.
    private val viewModel: MainViewModel by viewModels()
    // 이 두 뷰모델은 타입은 같지만 다른 객체의 뷰모델임.

    @Inject
    lateinit var repository:MyRepository

    @AppHash //구분 시키기 위해서. 지금 의존성 주입 받을 수 있는 스트링 중에서 이 어노테이션이 붙은 놈
    @Inject //타입을 보고 구분함. 지금까지는 String에 대한 주입 가능한 내용은 ApplicationModule의 함수 리턴값이였음.
    lateinit var applicationHash:String
    //근데, 새로운 모듈에 같은 타입을 리턴하는 함수가 생겨서 이제 헷갈리는거임. 즉, 에러가 남. 지정 필요

    @ActivityHash
    @Inject
    lateinit var activityHash:String

    val getActivityResult=registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){
        val result=it.data?.extras?.getString("backKey")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonActivity.setOnClickListener {
            val intent= Intent(context,SecondActivity::class.java)
            getActivityResult.launch(intent)
        }

        binding.buttonFragment.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_secondFragment)
        }

        Log.d("MainFragment","${applicationHash}")
        Log.d("MainFragmentInViewModel",viewModel.getRepositoryHash())
        Log.d("MainAcFragInViewModel",activityViewModel.getRepositoryHash())
        Log.d("testFragment","zz")
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}