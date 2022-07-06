package com.example.hilt_lecture.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.hilt_lecture.R
import com.example.hilt_lecture.databinding.FragmentSecondBinding
import com.example.hilt_lecture.data.MyRepository
import com.example.hilt_lecture.di.qualifier.AppHash
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

//주의: 모든 클래스에 대해 힐트를 지원하는게 아님. 액티비티, 프래그먼트, 서비스 등... 지원함.
@AndroidEntryPoint //주입 받을 대상들. 즉, 이게 달린 클래스들은 val repository객체를 지닌 놈들임.
class SecondFragment : Fragment() {
    lateinit var binding: FragmentSecondBinding
    private val viewModel: MainViewModel by viewModels() //어떤 뷰모델객체로 받더라도 주입받는건 싱글톤으로 정상적으로 받음.
    //지금 MainFragment가 가진 뷰모델과 뷰모델 객체 자체는 다른 객체임. 하지만 의존성 주입받은 repository는 같음.

    @Inject
    lateinit var repository: MyRepository

    @AppHash
    @Inject
    lateinit var applicationHash: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonBack.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_mainFragment)
        }

        Log.d("SecondFragment", "${applicationHash}")
        Log.d("SeFragmentInViewModel", viewModel.getRepositoryHash())

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SecondFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}