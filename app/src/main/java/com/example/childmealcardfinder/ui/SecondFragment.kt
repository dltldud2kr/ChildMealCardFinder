package com.example.childmealcardfinder.ui

import androidx.fragment.app.viewModels
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.childmealcardfinder.R
import com.example.childmealcardfinder.ShopListViewModel
import com.example.childmealcardfinder.databinding.FragmentSecondBinding
import com.example.childmealcardfinder.widget.ShopListAdapter

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ShopListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val selectedRegion = arguments?.getString("selectedRegion")

        if (selectedRegion == "전체") {
            // 전체를 선택한 경우 API 호출
            viewModel.getShopLists()
        } else {
            // 특정 행정구역을 선택한 경우 해당 행정구역의 가게 리스트 호출
            viewModel.getGugunLists(selectedRegion!!)
        }

        val adapter = ShopListAdapter()
        binding.recyclerView.adapter = adapter
        viewModel.shopList.observe(viewLifecycleOwner, { shopList ->
            if (shopList != null) {
                adapter.updateData(shopList)
            }
        })
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}