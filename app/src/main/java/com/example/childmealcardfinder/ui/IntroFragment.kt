package com.example.childmealcardfinder.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.childmealcardfinder.R
import com.example.childmealcardfinder.ShopListViewModel
import com.example.childmealcardfinder.databinding.FragmentIntroBinding

class IntroFragment : Fragment() {

    private var _binding:FragmentIntroBinding?=null
    private val binding get()= _binding!!
    private lateinit var viewModel: ShopListViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding= FragmentIntroBinding.inflate(inflater, container, false)
        return binding.root    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ShopListViewModel::class.java)


        // 버튼 클릭 시 이벤트 처리
        binding.buttonStart.setOnClickListener {

            // 선택한 지역 값을 가져옴
            val selectedRegion = resources.getStringArray(R.array.region_array)[binding.spinnerRegion.selectedItemPosition]
            val bundle = Bundle()
            bundle.putString("selectedRegion", selectedRegion)

            findNavController().navigate(R.id.action_introFragment_to_secondFragment, bundle)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}