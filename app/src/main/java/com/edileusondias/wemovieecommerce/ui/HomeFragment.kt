package com.edileusondias.wemovieecommerce.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.edileusondias.wemovieecommerce.adapter.HomeListAdapter
import com.edileusondias.wemovieecommerce.databinding.FragmentHomeBinding
import com.edileusondias.wemovieecommerce.viewmodel.HomeViewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val emptyHomeCard: CardView = binding.emptyHomeCard
        val recyclerView: RecyclerView = binding.homeList
        homeViewModel.productsListLiveData.observe(viewLifecycleOwner) {
            val adapter = HomeListAdapter(it)
            recyclerView.adapter = adapter
            if(it.products.isNotEmpty()) {
                recyclerView.visibility = View.VISIBLE
                emptyHomeCard.visibility = View.GONE
            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}